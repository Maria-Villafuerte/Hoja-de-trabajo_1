/**
 * @author moises.alonso
 * @category Ejercicio #1 
 * Interfaz para ejercicio de Radio 
 * @date 17/01/2023
 */
public interface IRadio {
	
	public void on();
	
	public void off();
	
	/***
	 * Este metodo nos indica si la radio esta encendida o apagada
	 * @return true si la radio esta encendida y false cuando la radio este apagada
	 */
	public boolean isOn();

	//True encendido, False apagado 
	
	/***
	 * Este metodo nos ayuda a establecer la frecuencia, recibe un parametro llamado freq que puede "AM" o "FM"
	 * @param freq La frecuencia la cual puede ser AM o FM, de lo contrario error.
	 */
	//En este es string pero solo se puede colocar Am y Fm pero podemos hacer algo con Boolean 
	public void setFrequence(String freq) throws Exception;
	//Si no va Am o Fm que mande un error 
	
	public String getFrequence();
	
	public void Forward();
	
	public void Backward();
	
	public double getFMActualStation();
	
	public int getAMActualStation();
	
	public void setFMActualStation(double actualStation);
	
	public void setAMActualStation(int actualStation); 
	
	public void saveFMStation(double actualStation, int slot);
	
	public void saveAMStation(int actualStation, int slot);
	
	public double getFMSlot(int slot);
	
	public int getAMSlot(int slot);
}
