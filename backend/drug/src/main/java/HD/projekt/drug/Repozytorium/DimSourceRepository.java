package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.dto.DimSourceDTO;
import HD.projekt.drug.entity.DimSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimSourceRepository extends JpaRepository<DimSource, Integer> {

    @Query("""
           SELECT new HD.projekt.drug.dto.DimSourceDTO(
               s.sourceKey,
               s.sourceDataset
           )
           FROM DimSource s
           ORDER BY s.sourceKey DESC
           """)
    List<DimSourceDTO> findAllProjectedOrderByIdDesc();
}