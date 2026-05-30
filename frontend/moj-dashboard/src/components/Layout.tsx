import { NavLink } from "react-router-dom";

type LayoutProps = {
    children: React.ReactNode;
};

const links = [
    { path: "/kraj", label: "Kraje" },
    { path: "/klient", label: "Klienci" },
    { path: "/jakosc", label: "Jakość danych" },
    { path: "/data", label: "Daty" },
    { path: "/produkt", label: "Produkty" },
    { path: "/zrodlo", label: "Źródła" },
    { path: "/transakcje", label: "Typy transakcji" },
];

export default function Layout({ children }: LayoutProps) {
    return (
        <div className="page">
            <aside className="sidebar">
                <h2>HD Dashboard</h2>
                <p>Hurtownia danych</p>

                <nav>
                    {links.map((link) => (
                        <NavLink
                            key={link.path}
                            to={link.path}
                            className={({ isActive }) =>
                                isActive ? "nav-link active" : "nav-link"
                            }
                        >
                            {link.label}
                        </NavLink>
                    ))}
                </nav>
            </aside>

            <main className="content">
                <header className="topbar">
                    <div>
                        <h1>Panel hurtowni danych</h1>
                        <span>Spring Boot + SQL Server + React</span>
                    </div>
                </header>

                {children}
            </main>
        </div>
    );
}