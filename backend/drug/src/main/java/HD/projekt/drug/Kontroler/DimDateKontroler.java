package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimDateRepository;
import HD.projekt.drug.dto.DimDateDTO;
import HD.projekt.drug.entity.DimDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DimDateKontroler {

    private final DimDateRepository dimDateRepository;

    public DimDateKontroler(DimDateRepository dimDateRepository) {
        this.dimDateRepository = dimDateRepository;
    }

    @GetMapping
    public List<DimDateDTO> getAllDate() {
        return dimDateRepository.findAllProjectedOrderByIdDesc();
    }
}