import DataTable from "../components/DataTable";

export default function ProductPage() {
    return (
        <DataTable
            title="DimProduct"
            endpoint="/produkt"
            columns={[
                { key: "id", label: "ID" },
                { key: "productNo", label: "Numer produktu" },
                { key: "productName", label: "Nazwa produktu" },
                { key: "productCategory", label: "Kategoria" },
            ]}
        />
    );
}