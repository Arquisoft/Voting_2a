package es.uniovi.asw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.controller.exception.NotValidValueException;
import es.uniovi.asw.model.Recuento;
import es.uniovi.asw.repository.RecuentoRepository;
import es.uniovi.asw.service.RecuentoService;

@Service
public class RecuentoServiceImpl implements RecuentoService {

	@Autowired
	private RecuentoRepository recuentoRepository;

	public List<Recuento> publicarRecuento(Long idEleccion) {

		if (idEleccion == null)
			throw new IllegalArgumentException("idEleccion no puede ser nulo");

		List<Recuento> temp = this.recuentoRepository.findByIdEleccion(idEleccion);

		if (temp.isEmpty())
			throw new NotValidValueException("Debe existir al menos un recuento en el repositorio");

		return temp;
	}

}
