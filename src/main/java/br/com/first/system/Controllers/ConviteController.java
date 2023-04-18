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
import br.com.first.system.Models.Evento;
import br.com.first.system.Repositories.ConvitesRepository;
import br.com.first.system.Repositories.EventoRepository;
import br.com.first.system.routes.Routes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(Routes.Convite.BASE)
@RequiredArgsConstructor
public class ConviteController {

    final ConvitesRepository repository;
    final EventoRepository eventoRepository;

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("formAction", Routes.Convite.BASE);
    }

    @GetMapping(Routes.Convite.FORM)
    public String form( @ModelAttribute("convite") ConviteDTO convite ){
        return "convite/form";
    }

    @GetMapping(Routes.Convite.UPDATE)
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
            return "redirect:" + Routes.Convite.BASE + Routes.Convite.FORM;
        }

        return "redirect:" + Routes.Convite.BASE;
    }

    @GetMapping
    public String listAll(Model model){
            model.addAttribute("convites", repository.findAll());
            return "/convite/listall";
    }

    @PostMapping
    public String form(@Valid @ModelAttribute("convite") ConviteDTO convite, BindingResult br){
        
        if( br.hasErrors() )
        {
            return "/convite/form";
        }

        Optional<Evento> evento =
        eventoRepository.findById(convite.getNomeEvento());

        
        Optional<Convite> currentOpt =
        repository.findById(convite.getId());

        if ( currentOpt.isPresent() ){
            Convite current = currentOpt.get();
            current.setNome(convite.getNome());
            current.setCpf(convite.getCpf());
            current.setEmail(convite.getEmail());
            current.setNomeEvento(convite.getNomeEvento());
            current.setEvento(evento.get());
            repository.save(current);
        }else {
            Convite toSave = convite.Build();
            toSave.setEvento(evento.get());
            repository.save(toSave);
        }

        return "redirect:/convite";
    }
}
