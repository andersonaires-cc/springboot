package br.com.first.system.Controllers;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.first.system.Dtos.ConviteDTO;
import br.com.first.system.Models.Convite;
import br.com.first.system.Repositories.ConvitesRepository;
import br.com.first.system.routes.Routes.Reuniao;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(Reuniao.BASE)
@RequiredArgsConstructor
public class ReuniaoController {

    final ConvitesRepository repository;

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("formAction", Reuniao.BASE);
    }

    @GetMapping(Reuniao.FORM)
    public String form( @ModelAttribute("convite") ConviteDTO convite ){
        return "reuniao/form";
    }

    @GetMapping(Reuniao.UPDATE)
    public String update( @PathVariable int id, RedirectAttributes ra ){

        Optional<Convite> toupdate = 
            repository.findById(id);

        if( toupdate.isPresent() ){


            ra.addFlashAttribute(
                "convite", 
                ConviteDTO.of(
                    toupdate.get()
                ) 
            );
            return "redirect:" + Reuniao.BASE + Reuniao.FORM;
        }

        return "redirect:" + Reuniao.BASE;
    }

    @GetMapping
    public String listAll(Model model){
            model.addAttribute("convites", repository.findAll());
            return "/reuniao/listall";
    }

    @PostMapping
    public String form(@Valid @ModelAttribute("convite") ConviteDTO convite, BindingResult br){
        
        if( br.hasErrors() )
        {
            return "/reuniao/form";
        }

        Optional<Convite> currentOpt =
        repository.findById(convite.getId());

        if ( currentOpt.isPresent() ){
            Convite current = currentOpt.get();
            current.setNome(convite.getNome());
            current.setCpf(convite.getCpf());
            current.setEmail(convite.getEmail());
            current.setNomeEvento(convite.getNomeEvento());
        }else {
            repository.save(convite.Build());
        }

        return "redirect:/reuniao";
    }
}
