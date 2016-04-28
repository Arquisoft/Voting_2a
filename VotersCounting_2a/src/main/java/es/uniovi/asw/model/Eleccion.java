package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "eleccion")
public class Eleccion extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	// private static final Logger log =
	// LoggerFactory.getLogger(Eleccion.class);

	@Column(nullable = false, unique = true)
	private String nombre;

	public Eleccion() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null && !nombre.isEmpty())
		   this.nombre = nombre;
	}
}
