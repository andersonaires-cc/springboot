package br.com.first.system.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Convite {

    @Id @GeneratedValue
    int id = 0;

    String nome;
    String email;
    boolean vaiParticipar = false;
    String cpf;
    String nomeEvento;
}
