package br.com.first.system.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.first.system.Dtos.ConviteDTO;
import br.com.first.system.Repositories.ConvitesRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reuniao")
@RequiredArgsConstructor
public class ReuniaoController {

    final ConvitesRepository repository;

    @GetMapping("/form")
    public String form(){
        return "reuniao/form";
    }

    @GetMapping
    public String listAll(Model model){
            model.addAttribute("convites", repository.convites);
            return "/reuniao/listAll";
    }

    @PostMapping
    public String form(ConviteDTO convite){
        repository.convites.add(convite.Build());
        return "redirect:/reuniao";
    }
}
