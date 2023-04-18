package br.com.first.system.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Convite {
    
    @Id @GeneratedValue
    int id = 0;

    String nome;
    String email;
    String cpf;
    String nomeEvento;
    boolean vaiParticipar = false;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    Evento evento;
}
