package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimTransactionTypeRepository;
import HD.projekt.drug.dto.DimTransactionTypeDTO;
import HD.projekt.drug.entity.DimTransactionType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transakcje")
public class DimTransactionTypeKontroler {

    private final DimTransactionTypeRepository dimTransactionTypeRepository;

    public DimTransactionTypeKontroler(DimTransactionTypeRepository dimTransactionTypeRepository) {
        this.dimTransactionTypeRepository = dimTransactionTypeRepository;
    }

    @GetMapping
    public List<DimTransactionTypeDTO> getAllTransactions() {
        return dimTransactionTypeRepository.findAllProjectedOrderByIdDesc();
    }
}