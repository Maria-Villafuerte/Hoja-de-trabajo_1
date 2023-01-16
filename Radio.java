public class Radio implements IRadio {

    private boolean turnOn;
    public String frequence;
    private Double[] FMStations = new Double[12];
    private int[] AMStations = new int[12];
    public int AM_actualStation;
    private double FM_actualStation;

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

        if (freq.equalsIgnoreCase("AM") || freq.equalsIgnoreCase("FM")) {
            frequence = freq;

        } else {
            throw new Exception("¡Por favor solamente seleccione entre AM o FM!");
        }

    }

    @Override
    public String getFrequence() {
        return frequence;
    }

    //AM frequencies can be represented by multiples of 10 in the range 530 to 1610. 
    //FM frequencies are found at multiples of 0.2 in the range 87.9 to 107.9.”

    private void Checkeo(){
        if (frequence.equalsIgnoreCase("AM")){
            setAMActualStation(530);
        }
        else if (frequence.equalsIgnoreCase("FM")){
            setFMActualStation(87.9);
        }
    }


    @Override
    public void Forward() {
        Checkeo();
        if (frequence.equals("AM")){
            setAMActualStation(AM_actualStation+10); 
            if(AM_actualStation==1610){
                setAMActualStation(530);
            }
            System.out.println("Radio actual:"+ AM_actualStation);
        }
        if (frequence.equals("FM")){
            setFMActualStation(FM_actualStation + 0.2);
            if(FM_actualStation==107.9){
                setFMActualStation(87.9);
            }
            System.out.println("Radio actual:"+ FM_actualStation);
        }
        
    }

    @Override
    public void Backward() {
        Checkeo();
        if (frequence.equals("AM")){
            setAMActualStation(AM_actualStation-10); 
            if(AM_actualStation==1610){
                setAMActualStation(530);
            }
            System.out.println("Radio actual:"+ AM_actualStation);
        }
        if (frequence.equals("FM")){
            setFMActualStation(FM_actualStation - 0.2);
            if(FM_actualStation==107.9){
                setFMActualStation(87.9);
            }
            System.out.println("Radio actual:"+ FM_actualStation);
        }

    }

    @Override
    public double getFMActualStation() {
        return FM_actualStation;
    }

    @Override
    public int getAMActualStation() {
        return AM_actualStation;
    }

    @Override
    public void setFMActualStation(double actualStation) {
        FM_actualStation = actualStation;

    }

    //Naho
    @Override
    public void setAMActualStation(int actualStation) {
        this.AM_actualStation = actualStation;

    }

    @Override
    public void saveFMStation(double actualStation, int slot) {
        FMStations[slot] = actualStation;

    }

    @Override
    public void saveAMStation(int actualStation, int slot) {
        AMStations[slot] = actualStation;
    }

    @Override
    public double getFMSlot(int slot) {
        Double fmSlot = FMStations[slot];
        return fmSlot;
    }

    @Override
    public int getAMSlot(int slot) {
        int amSlot = AMStations[slot];
        return amSlot;
    }
}
