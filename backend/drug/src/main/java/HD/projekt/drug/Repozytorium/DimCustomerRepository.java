package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.dto.DimCustomerDTO;
import HD.projekt.drug.entity.DimCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimCustomerRepository extends JpaRepository<DimCustomer, Integer> {

    @Query("""
           SELECT new HD.projekt.drug.dto.DimCustomerDTO(
               c.customerKey,
               c.customerNo,
               c.isCustomerKnown,
               c.customerType
           )
           FROM DimCustomer c
           ORDER BY c.customerKey DESC
           """)
    List<DimCustomerDTO> findAllProjectedOrderByIdDesc();
}