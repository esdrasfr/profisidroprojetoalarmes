package br.com.isidrocorp.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.dashboard.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer>{

}
