package br.com.first.system.Models;

import lombok.Data;

@Data
public class Convite {
    int id;
    String nome;
    String email;
    boolean vaiParticipar = false;
    String cpf;
}
