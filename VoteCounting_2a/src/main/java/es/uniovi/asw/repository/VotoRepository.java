package es.uniovi.asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	
	List<Voto> findByIdEleccion(Long idEleccion);
}
