package br.com.first.system.Dtos;

import java.util.Date;

import lombok.Data;

@Data
public class ConviteDTO{
    String nome;
    String email;
    String cpf;
    Date diaEvento;
    String nomeEvento;
}