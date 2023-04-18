package br.com.first.system.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Evento {
    
    @Id
    String nomeEvento;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    Date diaEvento;
    
    @Column(nullable = false)
    String senhaEntrada;
}
