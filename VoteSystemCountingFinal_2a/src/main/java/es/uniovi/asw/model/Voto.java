package es.uniovi.asw.model;

public class Voto {
	
	private Long idOpcion;
	private Long idColElect;
	//private Long numVotos;
	private String opcion;
	
	
	public Voto(){
		
	};
	
	public Voto(Long idOpcion, Long idColElect, String opcion) {

		this.idOpcion = idOpcion;
		this.idColElect = idColElect;
		this.opcion=opcion;
		
	}

	public Long getIdOpcion() {
		
		return idOpcion;
		
	}
	
	public void setIdOpcion(Long idOpcion) {
		
		this.idOpcion = idOpcion;
		
	}
	
	public Long getIdColElect() {
		
		return idColElect;
		
	}
	
	public void setIdColElect(Long idColElect) {
		
		this.idColElect = idColElect;
		
	}

	public String getOpcion() {
		
		return opcion;
	
	}

	public void setOpcion(String opcion) {
		
		this.opcion = opcion;
	
	}
	
	
	
}
