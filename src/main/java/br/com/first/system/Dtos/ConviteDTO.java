package br.com.first.system.Dtos;


import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.first.system.Models.Convite;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ConviteDTO{

    @NotBlank
    String nome;
    
    @NotBlank
    @Email
    String email;

    @CPF
    String cpf;

    @NotBlank
    String nomeEvento;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    Date dtEvento;


    public Convite Build(){
        Convite convite = new Convite();

        convite.setNome(nome);
        convite.setEmail(email);
        convite.setCpf(cpf);

        return convite;
    }
}

