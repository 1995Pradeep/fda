package fda.fda.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class foodControll {
    @GetMapping("/")
    public String list(){
        return "foods";
    }
}
