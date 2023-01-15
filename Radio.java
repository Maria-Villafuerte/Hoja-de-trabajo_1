public class Radio implements IRadio{

    private boolean turnOn; 
    public String frequence; 
    
    @Override
    public void on() {
        turnOn = true; 
    }

    @Override
    public void off() {
        turnOn = false; 
    }

    @Override
    public boolean isOn() {
        return turnOn;
    }

    @Override
    public void setFrequence(String freq) throws Exception {
        
        if (freq.equalsIgnoreCase("AM") || freq.equalsIgnoreCase("FM")){
            frequence = freq; 

        } else { 
            throw new Exception("¡Por favor solamente seleccione entre AM o FM!"); 
        }
    
    }

    @Override
    public String getFrequence() {
        return frequence;
    }

    @Override
    public void Forward() {
  
        
    }

    @Override
    public void Backward() {

        
    }

    @Override
    public double getFMActualStation() {

        return 0;
    }

    @Override
    public int getAMActualStation() {

        return 0;
    }

    @Override
    public void setFMActualStation(double actualStation) {

        
    }

    @Override
    public void setAMActualStation(int actualStation) {

        
    }

    @Override
    public void saveFMStation(double actualStation, int slot) {
    
        
    }

    @Override
    public void saveAMStation(int actualStation, int slot) {
        
        
    }

    @Override
    public double getFMSlot(int slot) {
      
        return 0;
    }

    @Override
    public int getAMSlot(int slot) {
       
        return 0;
    }

    
}
