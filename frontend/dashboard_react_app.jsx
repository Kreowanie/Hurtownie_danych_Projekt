import React, { useEffect, useMemo, useRef, useState } from "react";

const API_BASE = "";

const tables = [
  {
    key: "data",
    title: "Data",
    description: "Tabela DimDate",
    endpoint: "/data",
    icon: "📅",
  },
  {
    key: "jakosc",
    title: "Jakość danych",
    description: "Tabela DimDataQuality",
    endpoint: "/jakosc",
    icon: "✅",
  },
  {
    key: "produkt",
    title: "Produkty",
    description: "Tabela DimProduct",
    endpoint: "/produkt",
    icon: "📦",
  },
  {
    key: "klient",
    title: "Klienci",
    description: "Tabela DimCustomer",
    endpoint: "/klient",
    icon: "👤",
  },
  {
    key: "kraj",
    title: "Kraje",
    description: "Tabela DimCountry",
    endpoint: "/kraj",
    icon: "🌍",
  },
  {
    key: "zrodlo",
    title: "Źródła",
    description: "Tabela DimSource",
    endpoint: "/zrodlo",
    icon: "🗂️",
  },
  {
    key: "transakcje",
    title: "Typy transakcji",
    description: "Tabela DimTransactionType",
    endpoint: "/transakcje",
    icon: "🔁",
  },
];

function formatValue(value) {
  if (value === null || value === undefined) {
    return <span className="null-value">NULL</span>;
  }

  if (typeof value === "boolean") {
    return value ? "Tak" : "Nie";
  }

  return String(value);
}

export default function App() {
  const carouselRef = useRef(null);
  const [activeKey, setActiveKey] = useState(tables[0].key);
  const [cache, setCache] = useState({});
  const [currentData, setCurrentData] = useState([]);
  const [counts, setCounts] = useState({});
  const [search, setSearch] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const activeTable = useMemo(
    () => tables.find((table) => table.key === activeKey) ?? tables[0],
    [activeKey]
  );

  const filteredData = useMemo(() => {
    const query = search.toLowerCase().trim();

    if (!query) {
      return currentData;
    }

    return currentData.filter((row) =>
      Object.values(row).some((value) =>
        String(value ?? "")
          .toLowerCase()
          .includes(query)
      )
    );
  }, [currentData, search]);

  const columns = useMemo(() => {
    if (!filteredData.length) {
      return [];
    }

    return Object.keys(filteredData[0]);
  }, [filteredData]);

  async function fetchTableData(table, forceReload = false) {
    setLoading(true);
    setError("");

    try {
      if (!forceReload && cache[table.key]) {
        setCurrentData(cache[table.key]);
        setLoading(false);
        return;
      }

      const response = await fetch(API_BASE + table.endpoint);

      if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
      }

      const data = await response.json();

      setCache((previousCache) => ({
        ...previousCache,
        [table.key]: data,
      }));

      setCounts((previousCounts) => ({
        ...previousCounts,
        [table.key]: `${data.length} rekordów`,
      }));

      setCurrentData(data);
    } catch (fetchError) {
      setCurrentData([]);
      setError(
        `Nie udało się pobrać danych z endpointu ${table.endpoint}. Szczegóły: ${fetchError.message}`
      );

      setCounts((previousCounts) => ({
        ...previousCounts,
        [table.key]: "Błąd",
      }));
    } finally {
      setLoading(false);
    }
  }

  async function preloadCounts() {
    for (const table of tables) {
      try {
        const response = await fetch(API_BASE + table.endpoint);

        if (!response.ok) {
          throw new Error(`HTTP ${response.status}`);
        }

        const data = await response.json();

        setCache((previousCache) => ({
          ...previousCache,
          [table.key]: data,
        }));

        setCounts((previousCounts) => ({
          ...previousCounts,
          [table.key]: `${data.length} rekordów`,
        }));
      } catch {
        setCounts((previousCounts) => ({
          ...previousCounts,
          [table.key]: "Błąd",
        }));
      }
    }
  }

  function selectTable(key) {
    setActiveKey(key);
    setSearch("");
  }

  function scrollCarousel(direction) {
    carouselRef.current?.scrollBy({
      left: direction * 280,
      behavior: "smooth",
    });
  }

  function reloadCurrent() {
    setCache((previousCache) => {
      const updatedCache = { ...previousCache };
      delete updatedCache[activeTable.key];
      return updatedCache;
    });

    fetchTableData(activeTable, true);
  }

  useEffect(() => {
    fetchTableData(activeTable);
  }, [activeKey]);

  useEffect(() => {
    preloadCounts();
  }, []);

  return (
    <div className="dashboard-page">
      <style>{styles}</style>

      <main className="app">
        <section className="hero">
          <div className="hero-title">
            <h1>Hurtownia danych Dashboard</h1>
            <p>Interaktywny panel wymiarów z hurtowni SQL Server + Spring Boot</p>
          </div>

          <div className="status-box">
            <span className="status-dot" />
            Backend: <strong>Spring Boot 8088</strong>
          </div>
        </section>

        <div className="carousel-buttons">
          <button className="btn" type="button" onClick={() => scrollCarousel(-1)}>
            ← Poprzednie
          </button>
          <button className="btn" type="button" onClick={() => scrollCarousel(1)}>
            Następne →
          </button>
          <button className="btn" type="button" onClick={reloadCurrent}>
            Odśwież dane
          </button>
        </div>

        <section className="carousel-wrapper">
          <div className="carousel" ref={carouselRef}>
            {tables.map((table) => (
              <button
                type="button"
                key={table.key}
                className={`card ${activeTable.key === table.key ? "active" : ""}`}
                onClick={() => selectTable(table.key)}
              >
                <div className="card-icon">{table.icon}</div>
                <h3>{table.title}</h3>
                <p>{table.description}</p>
                <span className="count">{counts[table.key] ?? "Ładowanie..."}</span>
              </button>
            ))}
          </div>
        </section>

        <section className="panel">
          <div className="panel-header">
            <div className="panel-title">
              <h2>{activeTable.title}</h2>
              <span>
                {activeTable.description} • {activeTable.endpoint}
              </span>
            </div>

            <input
              className="search-box"
              type="text"
              value={search}
              placeholder="Szukaj w aktualnej tabeli..."
              onChange={(event) => setSearch(event.target.value)}
            />
          </div>

          <div className="table-wrapper">
            <table>
              <thead>
                {!!columns.length && (
                  <tr>
                    {columns.map((column) => (
                      <th key={column}>{column}</th>
                    ))}
                  </tr>
                )}
              </thead>

              <tbody>
                {loading && (
                  <tr>
                    <td className="loading" colSpan="20">
                      Ładowanie danych...
                    </td>
                  </tr>
                )}

                {!loading && error && (
                  <tr>
                    <td className="error" colSpan="20">
                      {error}
                    </td>
                  </tr>
                )}

                {!loading && !error && !filteredData.length && (
                  <tr>
                    <td className="empty" colSpan="20">
                      Brak danych do wyświetlenia
                    </td>
                  </tr>
                )}

                {!loading &&
                  !error &&
                  filteredData.map((row, rowIndex) => (
                    <tr key={row.id ?? row.dateKey ?? rowIndex}>
                      {columns.map((column) => (
                        <td key={column}>{formatValue(row[column])}</td>
                      ))}
                    </tr>
                  ))}
              </tbody>
            </table>
          </div>

          <div className="footer-info">
            {error ? (
              "Sprawdź, czy Spring Boot działa i czy endpoint istnieje."
            ) : (
              <>
                Wyświetlono <span className="highlight">{filteredData.length}</span> z{" "}
                <span className="highlight">{currentData.length}</span> rekordów.
              </>
            )}
          </div>
        </section>
      </main>
    </div>
  );
}

const styles = `
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  min-height: 100vh;
  font-family: Arial, Helvetica, sans-serif;
  background:
    radial-gradient(circle at top left, #3b82f6 0, transparent 35%),
    radial-gradient(circle at bottom right, #9333ea 0, transparent 35%),
    #0f172a;
  color: #e5e7eb;
}

button,
input {
  font: inherit;
}

.dashboard-page {
  min-height: 100vh;
  padding: 30px;
}

.app {
  max-width: 1300px;
  margin: 0 auto;
}

.hero {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 20px;
  margin-bottom: 30px;
}

.hero-title h1 {
  font-size: 42px;
  margin-bottom: 8px;
  background: linear-gradient(90deg, #38bdf8, #a78bfa, #f472b6);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.hero-title p {
  color: #cbd5e1;
  font-size: 16px;
}

.status-box {
  padding: 16px 22px;
  border-radius: 20px;
  background: rgba(15, 23, 42, 0.75);
  border: 1px solid rgba(148, 163, 184, 0.25);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.25);
  backdrop-filter: blur(14px);
}

.status-dot {
  display: inline-block;
  width: 10px;
  height: 10px;
  background: #22c55e;
  border-radius: 50%;
  margin-right: 8px;
  box-shadow: 0 0 15px #22c55e;
}

.carousel-wrapper {
  position: relative;
  margin-bottom: 30px;
}

.carousel {
  display: flex;
  gap: 18px;
  overflow-x: auto;
  scroll-behavior: smooth;
  padding: 10px 4px 22px;
}

.carousel::-webkit-scrollbar {
  height: 8px;
}

.carousel::-webkit-scrollbar-thumb {
  background: #475569;
  border-radius: 999px;
}

.card {
  min-width: 220px;
  text-align: left;
  color: inherit;
  padding: 22px;
  border-radius: 26px;
  background: rgba(15, 23, 42, 0.82);
  border: 1px solid rgba(148, 163, 184, 0.25);
  cursor: pointer;
  transition: 0.25s ease;
  box-shadow: 0 20px 60px rgba(0, 0, 0, 0.25);
  backdrop-filter: blur(12px);
}

.card:hover {
  transform: translateY(-6px) scale(1.02);
  border-color: #38bdf8;
  box-shadow: 0 25px 70px rgba(56, 189, 248, 0.2);
}

.card.active {
  border-color: #a78bfa;
  background: linear-gradient(145deg, rgba(59, 130, 246, 0.35), rgba(147, 51, 234, 0.35));
}

.card-icon {
  font-size: 34px;
  margin-bottom: 15px;
}

.card h3 {
  font-size: 20px;
  margin-bottom: 8px;
}

.card p {
  color: #cbd5e1;
  font-size: 14px;
  margin-bottom: 14px;
}

.count {
  display: inline-block;
  padding: 6px 12px;
  border-radius: 999px;
  background: rgba(56, 189, 248, 0.15);
  color: #7dd3fc;
  font-size: 13px;
}

.carousel-buttons {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
  margin-bottom: 20px;
}

.btn {
  border: none;
  padding: 11px 17px;
  border-radius: 14px;
  color: white;
  background: linear-gradient(135deg, #2563eb, #7c3aed);
  cursor: pointer;
  font-weight: bold;
  transition: 0.2s;
}

.btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 30px rgba(59, 130, 246, 0.35);
}

.panel {
  background: rgba(15, 23, 42, 0.84);
  border: 1px solid rgba(148, 163, 184, 0.25);
  border-radius: 28px;
  padding: 24px;
  box-shadow: 0 25px 70px rgba(0, 0, 0, 0.35);
  backdrop-filter: blur(15px);
}

.panel-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 18px;
  margin-bottom: 22px;
}

.panel-title h2 {
  font-size: 28px;
  margin-bottom: 5px;
}

.panel-title span {
  color: #94a3b8;
}

.search-box {
  min-width: 300px;
  padding: 14px 18px;
  border-radius: 16px;
  border: 1px solid rgba(148, 163, 184, 0.35);
  background: rgba(2, 6, 23, 0.7);
  color: white;
  outline: none;
  font-size: 15px;
}

.search-box:focus {
  border-color: #38bdf8;
  box-shadow: 0 0 0 4px rgba(56, 189, 248, 0.12);
}

.table-wrapper {
  overflow-x: auto;
  border-radius: 20px;
  border: 1px solid rgba(148, 163, 184, 0.2);
}

table {
  width: 100%;
  border-collapse: collapse;
  min-width: 700px;
}

thead {
  background: rgba(30, 41, 59, 0.95);
}

th {
  text-align: left;
  padding: 16px;
  color: #bae6fd;
  font-size: 14px;
  letter-spacing: 0.4px;
}

td {
  padding: 15px 16px;
  border-top: 1px solid rgba(148, 163, 184, 0.15);
  color: #e5e7eb;
}

tr:hover td {
  background: rgba(59, 130, 246, 0.08);
}

.empty,
.loading,
.error {
  padding: 35px;
  text-align: center;
  color: #cbd5e1;
}

.error {
  color: #fca5a5;
}

.footer-info {
  margin-top: 18px;
  color: #94a3b8;
  font-size: 14px;
}

.highlight {
  color: #67e8f9;
  font-weight: bold;
}

.null-value {
  color: #64748b;
}

@media (max-width: 800px) {
  .dashboard-page {
    padding: 18px;
  }

  .hero {
    flex-direction: column;
    align-items: flex-start;
  }

  .hero-title h1 {
    font-size: 32px;
  }

  .panel-header {
    flex-direction: column;
    align-items: stretch;
  }

  .search-box {
    min-width: 100%;
  }
}
`;
