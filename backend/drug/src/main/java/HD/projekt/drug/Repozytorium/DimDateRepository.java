package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.dto.DimDateDTO;
import HD.projekt.drug.entity.DimDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimDateRepository extends JpaRepository<DimDate, Integer> {

    @Query("""
           SELECT new HD.projekt.drug.dto.DimDateDTO(
               d.dateKey,
               d.fullDate,
               d.dayNumber,
               d.monthNumber,
               d.monthName,
               d.quarterNumber,
               d.yearNumber,
               d.isWeekend
           )
           FROM DimDate d
           ORDER BY d.dateKey DESC
           """)
    List<DimDateDTO> findAllProjectedOrderByIdDesc();
}