package br.com.first.system.Repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.first.system.Models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {
}
