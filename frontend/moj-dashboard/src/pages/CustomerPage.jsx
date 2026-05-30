import DataTable from "../components/DataTable";

export default function CustomerPage() {
    return (
        <DataTable
            title="DimCustomer"
            endpoint="/klient"
            columns={[
                { key: "id", label: "ID" },
                { key: "customerNo", label: "Numer klienta" },
                { key: "isCustomerKnown", label: "Czy znany klient" },
                { key: "customerType", label: "Typ klienta" },
            ]}
        />
    );
}