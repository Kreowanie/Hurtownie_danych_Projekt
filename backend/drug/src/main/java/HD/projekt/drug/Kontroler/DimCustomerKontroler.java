package HD.projekt.drug.Kontroler;

import HD.projekt.drug.Repozytorium.DimCustomerRepository;

import HD.projekt.drug.dto.DimCustomerDTO;
import HD.projekt.drug.entity.DimCustomer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/klient")
public class DimCustomerKontroler {


    private  final DimCustomerRepository dimCustomerRepository;

    public DimCustomerKontroler(DimCustomerRepository dimCustomerRepository) {
        this.dimCustomerRepository = dimCustomerRepository;
    }




    @GetMapping
    public List<DimCustomerDTO> getAllCustomer() {
        return dimCustomerRepository.findAllProjectedOrderByIdDesc();
    }
}