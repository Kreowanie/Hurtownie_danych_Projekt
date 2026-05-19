package HD.projekt.drug.Kontroler;

import HD.projekt.drug.entity.DimConTh;
import HD.projekt.drug.Repozytorium.DimConThRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typy")
public class DimConThKontroler {

    private final DimConThRepository dimConThRepository;

    public DimConThKontroler(DimConThRepository dimConThRepository) {
        this.dimConThRepository = dimConThRepository;
    }

    @GetMapping
    public List<DimConTh> getAllTypes() {
        return dimConThRepository.findAll();
    }
}