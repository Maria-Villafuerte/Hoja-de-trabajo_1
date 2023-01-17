public class Radio implements IRadio {

    private boolean turnOn;
    public String Frequence;
    private Double[] FMStations = new Double[12];
    private Integer[] AMStations = new Integer[12];
    private int AM_actualStation;
    private double FM_actualStation;

    @Override
    public void on() {
        turnOn = true;
        setAMActualStation(530);
        setFMActualStation(87.9);
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
            Frequence = freq;

        } else {
            throw new Exception("¡Por favor solamente seleccione entre AM o FM!");
        }

    }

    @Override
    public String getFrequence() {
        return Frequence;
    }

    // AM frequencies can be represented by multiples of 10 in the range 530 to
    // 1610.
    // FM frequencies are found at multiples of 0.2 in the range 87.9 to 107.9.”

    @Override
    public void Forward() {
        if (Frequence.equals("AM")) {
            setAMActualStation(AM_actualStation + 10);
            if (AM_actualStation > 1610) {
                setAMActualStation(530);
            }
        }
        if (Frequence.equals("FM")) {
            setFMActualStation(FM_actualStation + 0.2);
            if (FM_actualStation > 107.9) {
                setFMActualStation(87.9);
            }
        }

    }

    @Override
    public void Backward() {
        if (Frequence.equals("AM")) {
            setAMActualStation(AM_actualStation - 10);
            if (AM_actualStation < 530) {
                setAMActualStation(1610);
            }
        }
        if (Frequence.equals("FM")) {
            setFMActualStation(FM_actualStation - 0.2);
            if (FM_actualStation > 87.9) {
                setFMActualStation(107.9);
            }
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

    // Naho
    @Override
    public void setAMActualStation(int actualStation) {
        AM_actualStation = actualStation;

    }

    @Override
    public void saveFMStation(double actualStation, int slot) {
        FMStations[slot - 1] = actualStation;

    }

    @Override
    public void saveAMStation(int actualStation, int slot) {
        AMStations[slot - 1] = actualStation;
    }

    @Override
    public double getFMSlot(int slot) {
        Double fmSlot = 87.9;
        if (FMStations[slot - 1] != null) {
            fmSlot = FMStations[slot - 1];
        }

        return fmSlot;
    }

    @Override
    public int getAMSlot(int slot) {
        int amSlot = 530;
        if (AMStations[slot - 1] != null) {
            amSlot = AMStations[slot - 1];
        }

        return amSlot;
    }
}
