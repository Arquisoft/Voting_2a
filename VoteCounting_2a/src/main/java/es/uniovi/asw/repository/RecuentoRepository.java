package es.uniovi.asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.model.Recuento;

public interface RecuentoRepository extends JpaRepository<Recuento, Long> {

	List<Recuento> findByIdEleccion(Long idEleccion);
}
