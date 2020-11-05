package br.com.isidrocorp.dashboard.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.dashboard.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer>{
	
	public ArrayList<Evento> findAllByDataBetween(LocalDate inicio, LocalDate fim);

}
