import { useEffect, useMemo, useState } from "react";

type Column = {
    key: string;
    label: string;
};

type DataTableProps = {
    title: string;
    endpoint: string;
    columns: Column[];
};

type TableRow = Record<string, string | number | boolean | null | undefined>;

function formatValue(value: string | number | boolean | null | undefined): string {
    if (value === null || value === undefined) {
        return "NULL";
    }

    if (typeof value === "boolean") {
        return value ? "Tak" : "Nie";
    }

    return String(value);
}

export default function DataTable({ title, endpoint, columns }: DataTableProps) {
    const [data, setData] = useState<TableRow[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [search, setSearch] = useState("");

    useEffect(() => {
        setLoading(true);
        setError("");

        fetch(endpoint)
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Błąd pobierania danych z endpointu: " + endpoint);
                }

                return response.json();
            })
            .then((jsonData: TableRow[]) => {
                setData(jsonData);
                setLoading(false);
            })
            .catch((err: Error) => {
                setError(err.message);
                setData([]);
                setLoading(false);
            });
    }, [endpoint]);

    const filteredData = useMemo(() => {
        const text = search.toLowerCase();

        return data.filter((row) =>
            Object.values(row).some((value) =>
                String(value ?? "").toLowerCase().includes(text)
            )
        );
    }, [data, search]);

    return (
        <section className="table-card">
            <div className="table-header">
                <div>
                    <h2>{title}</h2>
                    <p>Endpoint: <strong>{endpoint}</strong></p>
                </div>

                <input
                    className="search-input"
                    type="text"
                    placeholder="Szukaj..."
                    value={search}
                    onChange={(event) => setSearch(event.target.value)}
                />
            </div>

            {loading && <div className="info-box">Ładowanie danych...</div>}

            {error && <div className="error-box">Błąd: {error}</div>}

            {!loading && !error && (
                <>
                    <div className="stats">
                        <div>
                            <span>Wszystkie rekordy</span>
                            <strong>{data.length}</strong>
                        </div>

                        <div>
                            <span>Wyświetlane</span>
                            <strong>{filteredData.length}</strong>
                        </div>
                    </div>

                    <div className="table-wrapper">
                        <table>
                            <thead>
                                <tr>
                                    {columns.map((column) => (
                                        <th key={column.key}>{column.label}</th>
                                    ))}
                                </tr>
                            </thead>

                            <tbody>
                                {filteredData.map((row, index) => (
                                    <tr key={String(row.id ?? index)}>
                                        {columns.map((column) => (
                                            <td key={column.key}>
                                                {formatValue(row[column.key])}
                                            </td>
                                        ))}
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </>
            )}
        </section>
    );
}