package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimCountryRepository;
import HD.projekt.drug.dto.DimCountryDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/kraj")
public class DimCountryKontroler {

    private final DimCountryRepository dimCountryRepository;

    public DimCountryKontroler(DimCountryRepository dimCountryRepository) {
        this.dimCountryRepository = dimCountryRepository;
    }

    @GetMapping
    public List<DimCountryDTO> getAllKraje() {
        return dimCountryRepository.findAllProjectedOrderByIdDesc();
    }
}