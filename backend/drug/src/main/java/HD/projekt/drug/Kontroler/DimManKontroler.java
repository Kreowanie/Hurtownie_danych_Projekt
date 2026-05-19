package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimManRepository;
import HD.projekt.drug.entity.DimMan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/man")
public class DimManKontroler {
    private final DimManRepository dimManRepository;

    public DimManKontroler(DimManRepository dimManRepository){
        this.dimManRepository = dimManRepository;
}

@GetMapping
public List<DimMan> getAllMan(){
    return  dimManRepository.findAll();
}
}


