public class Radio implements IRadio {

    private boolean turnOn;
    public String frequence;
    private Double[] FMStations = new Double[12];
    private int[] AMStations = new int[12];
    private int AM_actualStation;

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
