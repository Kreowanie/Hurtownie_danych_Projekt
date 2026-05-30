import DataTable from "../components/DataTable";

export default function DatePage() {
    return (
        <DataTable
            title="DimDate"
            endpoint="/data"
            columns={[
                { key: "id", label: "DateKey" },
                { key: "fullDate", label: "Pełna data" },
                { key: "dayNumber", label: "Dzień" },
                { key: "monthNumber", label: "Numer miesiąca" },
                { key: "monthName", label: "Miesiąc" },
                { key: "quarterNumber", label: "Kwartał" },
                { key: "yearNumber", label: "Rok" },
                { key: "isWeekend", label: "Weekend" },
            ]}
        />
    );
}