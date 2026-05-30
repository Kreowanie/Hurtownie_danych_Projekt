package HD.projekt.drug.dto;

import java.time.LocalDate;

public record DimDateDTO(
        Integer id,
        LocalDate fullDate,
        Integer dayNumber,
        Integer monthNumber,
        String monthName,
        Integer quarterNumber,
        Integer yearNumber,
        Boolean isWeekend
) {
}