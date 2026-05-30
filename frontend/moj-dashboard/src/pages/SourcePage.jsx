import DataTable from "../components/DataTable";

export default function SourcePage() {
    return (
        <DataTable
            title="DimSource"
            endpoint="/zrodlo"
            columns={[
                { key: "id", label: "ID" },
                { key: "sourceDataset", label: "Źródło danych" },
            ]}
        />
    );
}