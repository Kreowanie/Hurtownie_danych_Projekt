package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimSourceRepository;
import HD.projekt.drug.dto.DimSourceDTO;
import HD.projekt.drug.entity.DimSource;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zrodlo")
public class DimSourceKontroler {

    private final DimSourceRepository dimSourceRepository;


    public DimSourceKontroler(DimSourceRepository dimSourceRepository) {
        this.dimSourceRepository = dimSourceRepository;
    }

    @GetMapping
    public List<DimSourceDTO> getAllSource(){
        return  dimSourceRepository.findAllProjectedOrderByIdDesc();
    }
}
