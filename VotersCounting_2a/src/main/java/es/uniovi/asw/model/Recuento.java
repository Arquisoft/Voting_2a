package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "recuento")
public class Recuento extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	// private static final Logger log = LoggerFactory.getLogger(Eleccion.class);
	// @OneToMany(fetch = FetchType.EAGER)
	// private Eleccion eleccion;

	@Column(nullable = false)
	private Long idEleccion;

	@Column(nullable = false)
	private String opcion;

	@Column(nullable = false)
	private Long total;

	public Recuento() {

	}
	
	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		if(opcion != null && !opcion.isEmpty())
		   this.opcion = opcion;
	}
	
	public Long getIdEleccion() {
		return idEleccion;
	}

	public void setIdEleccion(Long idEleccion) {
		if(idEleccion != null && idEleccion > 0)
		   this.idEleccion = idEleccion;
	}
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		if(total != null && total >= 0)
	        this.total = total;
	}
}
