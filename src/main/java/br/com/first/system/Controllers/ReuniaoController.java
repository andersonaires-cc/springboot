package br.com.first.system.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.first.system.Dtos.ConviteDTO;
import br.com.first.system.Repositories.ConvitesRepository;
import jakarta.validation.Valid;
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
    public String form(@Valid ConviteDTO convite, BindingResult br){

        if( br.hasErrors() )
        {
            return "redirect:/reuniao/form";
        }

        repository.convites.add(convite.Build());
        return "redirect:/reuniao";
    }
}
