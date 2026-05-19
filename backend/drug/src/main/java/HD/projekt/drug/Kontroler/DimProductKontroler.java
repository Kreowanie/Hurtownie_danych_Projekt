package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimProductRepository;
import HD.projekt.drug.entity.DimProduct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produkt")
public class DimProductKontroler {

 private  final DimProductRepository dimProductRepository;


    public DimProductKontroler(DimProductRepository dimProductRepository) {
        this.dimProductRepository = dimProductRepository;
    }

       @GetMapping
       public List<DimProduct> getAllProducts(){
           return dimProductRepository.findAll();
        }
    }

