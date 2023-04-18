package br.com.first.system.Dtos;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import br.com.first.system.Models.Convite;
import br.com.first.system.Validators.EventoExists.EventoExists;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Component
@Scope("prototype")
public class ConviteDTO{

    @NotNull @Min(0)
    Integer id = 0;

    @NotBlank
    String nome;

    @NotBlank
    @Email
    String email;

    @CPF
    String cpf;

    @NotBlank @EventoExists
    String nomeEvento;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    Date dtEvento;

    public Convite Build(
    ){
        Convite convite = new Convite();
        convite.setId(id);
        convite.setNome(nome);
        convite.setEmail(email);
        convite.setCpf(cpf);
        convite.setNomeEvento(nomeEvento);

        return convite;
    }

    public static ConviteDTO of(Convite convite){
        ConviteDTO resp = new ConviteDTO();
        resp.setNome(convite.getNome());
        resp.setEmail(convite.getEmail());
        resp.setCpf(convite.getCpf());
        resp.setId(convite.getId());
        resp.setNomeEvento(convite.getNomeEvento());
        return resp;
    }
}