package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.model.EleccionInfo;

public interface EleccionRepository extends JpaRepository<EleccionInfo, Long> {

}
