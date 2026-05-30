package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.dto.DimProductDTO;
import HD.projekt.drug.entity.DimProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimProductRepository extends JpaRepository<DimProduct, Integer> {

    @Query("""
           SELECT new HD.projekt.drug.dto.DimProductDTO(
               p.productKey,
               p.productNo,
               p.productName,
               p.productCategory
           )
           FROM DimProduct p
           ORDER BY p.productKey DESC
           """)
    List<DimProductDTO> findAllProjectedOrderByIdDesc();
}