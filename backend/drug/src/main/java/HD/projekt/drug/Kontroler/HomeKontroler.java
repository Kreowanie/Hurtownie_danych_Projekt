package HD.projekt.drug.Kontroler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeKontroler {

    @GetMapping("/")
    public String home(){
        return  "redirect:/frontend/index.html";
    }
}