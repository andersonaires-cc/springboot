package br.com.first.system.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reuniao")
public class ReuniaoController {
    
    @GetMapping
    public String form(){
        return "reuniao/form";
    }

    @PostMapping
    public String form(Convite convite){
        return "redirect:/reuniao/form";
    }
}
