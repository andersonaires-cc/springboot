package br.com.first.system.Dtos;

import br.com.first.system.Models.Convite;
import lombok.Data;

@Data
public class ConviteDTO{
    String nome;
    String email;
    String cpf;
    String nomeEvento;

    public Convite Build(
    ){
        Convite convite = new Convite();
        convite.setNome(nome);
        convite.setEmail(email);
        convite.setCpf(cpf);

        return convite;
    }

}