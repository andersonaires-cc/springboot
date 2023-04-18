package br.com.first.system.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.first.system.Dtos.EventoDTO;
import br.com.first.system.Repositories.EventoRepository;
import br.com.first.system.routes.Routes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(Routes.Evento.BASE)
@RequiredArgsConstructor
public class EventoController {

    final EventoRepository eventoRepository;

    @ModelAttribute
    public void addAttributes(Model model)
    {
        model.addAttribute("formAction", Routes.Evento.BASE);
    }

    @GetMapping
    public String listAll(Model model){
        List<EventoDTO> eventos = new ArrayList<>();
        eventoRepository.findAll().forEach( (i) -> eventos.add( EventoDTO.of(i) ));

        model.addAttribute("eventos", eventos);
        return "/evento/listall";
    }

    @GetMapping(Routes.Evento.FORM)
    public String form( 
        @ModelAttribute("evento") EventoDTO eventoDTO,
        Model model){

        return "/evento/form";
    }   

    @PostMapping
    public String createOrUpdate(
        @Valid @ModelAttribute("evento") EventoDTO evento,
        BindingResult br
    ){
        if( br.hasErrors() )
        {
            return "/evento/form";
        }

        eventoRepository.save(evento.build());
        return "redirect:" + Routes.Evento.BASE;
    }



}
