package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "VOTACIONES")
public class EleccionInfo extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String definicion;

	public EleccionInfo() {

	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	};

}
