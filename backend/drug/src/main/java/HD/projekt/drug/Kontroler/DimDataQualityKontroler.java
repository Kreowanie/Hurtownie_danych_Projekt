package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimDataQualityRepository;
import HD.projekt.drug.entity.DimDataQuality;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jakosc")
public class DimDataQualityKontroler {

    private final DimDataQualityRepository dimDataQualityRepository;

    public DimDataQualityKontroler(DimDataQualityRepository dimDataQualityRepository) {
        this.dimDataQualityRepository = dimDataQualityRepository;
    }

    @GetMapping
    public List<DimDataQuality> getAllQuality() {
        return dimDataQualityRepository.findAll();
    }
}