package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "voto")
public class Voto extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	//private static final Logger log = LoggerFactory.getLogger(Voto.class);
	// @OneToMany(fetch = FetchType.EAGER)
	// private Eleccion eleccion;

	@Column(nullable = false)
	private Long idEleccion;
	
	// @OneToMany(fetch = FetchType.EAGER)
	// private ColegioElectoral colegioElectoral;

	@Column(nullable = false)
	private Long idColegio;
	
	@Column(nullable = false)
	private String opcion;

	@Column(nullable = false)
	private boolean online;

	public Voto() {

	}
	
	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		if(opcion != null && !opcion.isEmpty())
		   this.opcion = opcion;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	public Long getIdEleccion() {
		return idEleccion;
	}

	public void setIdEleccion(Long idEleccion) {
		if(idEleccion != null && idEleccion > 0)
		   this.idEleccion = idEleccion;
	}
	
	public Long getIdColegio() {
		return idColegio;
	}

	public void setIdColegio(Long idColegio) {
		if(idColegio != null && idColegio > 0)
		   this.idColegio = idColegio;
	}

}
