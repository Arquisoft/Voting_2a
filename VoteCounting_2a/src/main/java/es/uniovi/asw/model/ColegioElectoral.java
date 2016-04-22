package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "colegioElectoral")
public class ColegioElectoral extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	// private static final Logger log =
	// LoggerFactory.getLogger(ColegioElectoral.class);

	@Column(nullable = false, unique = true)
	private String nombre;

	public ColegioElectoral() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty())
			this.nombre = nombre;
	}
}
