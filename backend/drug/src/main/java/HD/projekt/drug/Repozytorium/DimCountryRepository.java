package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.dto.DimCountryDTO;
import HD.projekt.drug.entity.DimCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimCountryRepository extends JpaRepository<DimCountry, Integer> {

    @Query("""
           SELECT new HD.projekt.drug.dto.DimCountryDTO(
               c.countryKey,
               c.country,
               c.countryGroup,
               c.isUnitedKingdom
           )
           FROM DimCountry c
           ORDER BY c.countryKey DESC
           """)
    List<DimCountryDTO> findAllProjectedOrderByIdDesc();
}