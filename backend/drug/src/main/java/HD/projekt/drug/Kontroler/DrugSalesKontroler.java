package HD.projekt.drug.Kontroler;

//nie używany

import HD.projekt.drug.Repozytorium.DrugSalesRepository;
import HD.projekt.drug.entity.DrugSales;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sprzedaz")
public class DrugSalesKontroler {
        private final DrugSalesRepository drugSalesRepository;

    public DrugSalesKontroler(DrugSalesRepository drugSalesRepository) {
        this.drugSalesRepository = drugSalesRepository;
    }

    @GetMapping
    public List<DrugSales> getAllWyprzedaze(){
        return drugSalesRepository.findAll();
    }
}
