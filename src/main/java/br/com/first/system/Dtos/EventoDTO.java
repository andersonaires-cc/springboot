package br.com.first.system.Dtos;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import br.com.first.system.Models.Evento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Component
@Scope("prototype")
public class EventoDTO {

    @NotBlank
    String nomeEvento;
    
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    Date diaEvento;

    @NotBlank
    String senhaEntrada;

    public Evento build(){        
        Evento resp = new Evento();
        resp.setNomeEvento(nomeEvento);
        resp.setDiaEvento(diaEvento);
        resp.setSenhaEntrada(senhaEntrada);
        
        return resp;
    }

    public static EventoDTO of(Evento evento){
        EventoDTO resp = new EventoDTO();
        resp.setNomeEvento(evento.getNomeEvento());
        resp.setDiaEvento(evento.getDiaEvento());
        resp.setSenhaEntrada(evento.getSenhaEntrada());
        return resp;
    }
}
