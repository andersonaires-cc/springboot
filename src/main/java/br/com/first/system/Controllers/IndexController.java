package br.com.first.system.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; //Anotação para mapear GETsolicitações HTTP em métodos de manipulador específicos.
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    
    @GetMapping
    public String index(){
        return "reuniao/listAll";
    } 
}

