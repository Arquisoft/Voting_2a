package es.uniovi.asw.writereport;

/**
 * Interfaz para el uso de log
 * @author censuses2a
 *
 */
public interface WriteReport {
	
	public void createLog();
	
	public void updateLog(String error,String nuevo);
	
	public void closeLog();
	
}
