import DataTable from "../components/DataTable";

export default function DataQualityPage() {
    return (
        <DataTable
            title="DimDataQuality"
            endpoint="/jakosc"
            columns={[
                { key: "id", label: "ID" },
                { key: "dataQualityFlag", label: "Flaga jakości" },
            ]}
        />
    );
}