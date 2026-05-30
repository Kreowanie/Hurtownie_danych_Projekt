package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.dto.DimDataQualityDTO;
import HD.projekt.drug.entity.DimDataQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimDataQualityRepository extends JpaRepository<DimDataQuality, Integer> {

    @Query("""
           SELECT new HD.projekt.drug.dto.DimDataQualityDTO(
               d.dataQualityKey,
               d.dataQualityFlag
           )
           FROM DimDataQuality d
           ORDER BY d.dataQualityKey DESC
           """)
    List<DimDataQualityDTO> findAllProjectedOrderByIdDesc();
}