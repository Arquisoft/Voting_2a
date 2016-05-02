package es.uniovi.asw.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.model.EleccionInfo;
import es.uniovi.asw.repository.EleccionRepository;
import es.uniovi.asw.service.EleccionService;

@Service
@Transactional
public class EleccionServiceImpl implements EleccionService {

	@Autowired
	private EleccionRepository eleccionRepository;

	public EleccionServiceImpl() {
	}

	@Override
	public List<EleccionInfo> getAll() {

		return this.eleccionRepository.findAll();
	}

}
