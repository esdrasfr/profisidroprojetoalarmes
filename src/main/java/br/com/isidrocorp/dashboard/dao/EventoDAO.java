package br.com.isidrocorp.dashboard.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.isidrocorp.dashboard.dto.VolumeAlarmes;
import br.com.isidrocorp.dashboard.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer>{
	
	public ArrayList<Evento> findAllByDataBetween(LocalDate inicio, LocalDate fim);

	
	/*
	 * select nome, count(itmn_evento.id_alarme)
       from itmn_evento inner join itmn_alarme on itmn_evento.id_alarme = itmn_alarme.id_alarme
       group by itmn_evento.id_alarme;
	 * 
	 */
	@Query("SELECT new br.com.isidrocorp.dashboard.dto.VolumeAlarmes(evt.alarme.nome, count(evt.alarme.id)) "
			+ " FROM Evento evt GROUP BY evt.alarme.id ")
	public ArrayList<VolumeAlarmes> getAllVolumes();
	
	
	/* agora vamos fazer a mesma consulta do método anterior, só que com filtro de datas
	 * 
	 *  select nome, count(itmn_evento.id_alarme)
        from itmn_evento inner join itmn_alarme on itmn_evento.id_alarme = itmn_alarme.id_alarme
        group by itmn_evento.id_alarme;
	 */
	
	@Query("SELECT new br.com.isidrocorp.dashboard.dto.VolumeAlarmes(evt.alarme.nome, count(evt.alarme.id)) "
			+ " FROM Evento evt "
			+ " WHERE evt.data >= :dataInicio AND evt.data <= :dataFim"
			+ " GROUP BY evt.alarme.id ")
	public ArrayList<VolumeAlarmes> getAllByDatas(@Param("dataInicio") LocalDate dataInicio, 
			                                      @Param("dataFim") LocalDate dataFim);
	
}
