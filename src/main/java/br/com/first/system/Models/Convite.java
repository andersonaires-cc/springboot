package br.com.first.system.Models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class Convite {
    int id = 0;
    String nome;
    String email;
    String cpf;
    boolean vaiParticipar = false;
}
