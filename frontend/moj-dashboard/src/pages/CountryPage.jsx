import DataTable from "../components/DataTable";

export default function CountryPage() {
    return (
        <DataTable
            title="DimCountry"
            endpoint="/kraj"
            columns={[
                { key: "id", label: "ID" },
                { key: "country", label: "Kraj" },
                { key: "countryGroup", label: "Grupa kraju" },
                { key: "isUnitedKingdom", label: "Czy UK" },
            ]}
        />
    );
}