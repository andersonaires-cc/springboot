package br.com.first.system.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.first.system.Repositories.ConvitesRepository;
import org.springframework.ui.Model;


@Controller

public class EventoController {
    
    @Autowired ConvitesRepository repository;

    @GetMapping
    public String specificEmail(Model model){
        model.addAttribute("convites", repository.convites);
        return "/reuniao/viewEvento";
    }
}
