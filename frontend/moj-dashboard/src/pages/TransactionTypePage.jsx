import DataTable from "../components/DataTable";

export default function TransactionTypePage() {
    return (
        <DataTable
            title="DimTransactionType"
            endpoint="/transakcje"
            columns={[
                { key: "id", label: "ID" },
                { key: "transactionType", label: "Typ transakcji" },
                { key: "isCancelled", label: "Anulowana" },
                { key: "isReturn", label: "Zwrot" },
            ]}
        />
    );
}