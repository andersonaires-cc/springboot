package br.com.first.system.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.first.system.Models.Convite;

@Controller
@RequestMapping("/reuniao")
public class ReuniaoController {
    
    @GetMapping("/form")
    public String form(){
        return "reuniao/form";
    }

    @PostMapping
    public String form(Convite convite){
        return "redirect:/reuniao/form";
    }
}
