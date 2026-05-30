package HD.projekt.drug.Repozytorium;

import HD.projekt.drug.dto.DimTransactionTypeDTO;
import HD.projekt.drug.entity.DimTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimTransactionTypeRepository extends JpaRepository<DimTransactionType, Integer> {

    @Query("""
           SELECT new HD.projekt.drug.dto.DimTransactionTypeDTO(
               t.transactionTypeKey,
               t.transactionType,
               t.isCancelled,
               t.isReturn
           )
           FROM DimTransactionType t
           ORDER BY t.transactionTypeKey DESC
           """)
    List<DimTransactionTypeDTO> findAllProjectedOrderByIdDesc();
}