package br.com.isidrocorp.dashboard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.dashboard.dao.EventoDAO;
import br.com.isidrocorp.dashboard.dto.IntervaloDatas;
import br.com.isidrocorp.dashboard.dto.VolumeAlarmes;
import br.com.isidrocorp.dashboard.model.Evento;

@CrossOrigin("*")
@RestController
public class EventoController {
	
	@Autowired
	EventoDAO dao;
	
	@GetMapping("/eventos")
	public ArrayList<Evento> recuperarTudao(){
		ArrayList<Evento> lista;
		lista = (ArrayList<Evento>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/eventos/intervalo")
	public ArrayList<Evento> encontrarTodosPeloIntervalo(@RequestBody IntervaloDatas intervalo){
		ArrayList<Evento> lista;
		lista = dao.findAllByDataBetween(intervalo.getDataInicio(), intervalo.getDataFim());
		return lista;
	}
	
	@GetMapping("/eventos/{id}")
	public Evento exibirPeloId(@PathVariable int id) {
		Evento evt = dao.findById(id).get();
		return evt;
	}
	
	@GetMapping("/eventos/consolidado/todos")
	public ArrayList<VolumeAlarmes> recuperarConsolidado(){
		return dao.getAllVolumes();
	}

	@PostMapping("/eventos/consolidado/intervalo")
	public ArrayList<VolumeAlarmes> recuperarConsolidadoPeloIntervalo(@RequestBody IntervaloDatas intervalo){
		return dao.getAllByDatas(intervalo.getDataInicio(), intervalo.getDataFim());
	}
}
