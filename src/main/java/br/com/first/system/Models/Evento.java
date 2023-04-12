package br.com.first.system.Models;

import java.util.Date;

import lombok.Data;

@Data
public class Evento {
    int id;
    String nomeEvento;
    Date diaEvento;
    String senhaEntrada;
}
