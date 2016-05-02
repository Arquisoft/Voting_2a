package es.uniovi.asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.model.VotoInfo;

public interface VotoRepository extends JpaRepository<VotoInfo, Long> {
	
	List<VotoInfo> findByIdEleccion(Long idEleccion);
}
