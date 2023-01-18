public class Radio implements IRadio {

 
    private boolean turnOn;
    public String Frequence;
    private Double[] FMStations = new Double[12];
    private Integer[] AMStations = new Integer[12];
    private int AM_actualStation;
    private double FM_actualStation;

    
    /* 
     * Enciende la radio, ingresa a la variable un booleano "True"
     */
    @Override
    public void on() {
        turnOn = true;
        setAMActualStation(530);
        setFMActualStation(87.9);
    }

    /* 
     * Apaga la radio, ingresa a la variable un booleano "False" 
     */
    @Override
    public void off() {
        turnOn = false;
    }

    /* 
     * Verifica si la radio se encuentra encendida. 
     * @return la variable booleana turn on. (True = Encendida ; False = Apagada)
     */
    @Override
    public boolean isOn() {
        return turnOn;
    }

    /* 
     * Establece la frecuencia de la radio 
     * @param freq La frecuencia la cual varia entre AM y FM 
     * @throws: Cuando no se ingresa AM o FM, lanza un mensaje de error. 
     */
    @Override
    public void setFrequence(String freq) throws Exception {

        if (freq.equalsIgnoreCase("AM") || freq.equalsIgnoreCase("FM")) {
            Frequence = freq;

        } else {
            throw new Exception("¡Por favor solamente seleccione entre AM o FM!");
        }

    }

    /* 
     * Obtener la frecuencia en la que se encuentra la radio (AM o FM)
     * @return AM o FM
     */
    @Override
    public String getFrequence() {
        return Frequence;
    }

    /* 
     *Avanza entre las estaciones de radio dependiendo de su frecuencia 
     */
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

    /* 
     * Retrocede entre las estaciones de radio dependiendo de su frecuencia 
     */
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
            if (FM_actualStation < 87.9) {
                setFMActualStation(107.9);
            }
        }

    }

    /* 
     * Obtiene la estacion de frecuencia FM actual 
     * @return Estacion actual 
     */
    @Override
    public double getFMActualStation() {
        return FM_actualStation;
    }

    /* 
     * Obtiene la estacion de frecuencia AM actual 
     * @return Estacion actual 
     */
    @Override
    public int getAMActualStation() {
        return AM_actualStation;
    }

    /* 
     * Establecer estacion en la frecuencia FM
     * @param actualStation Estacion actual 
     */
    @Override
    public void setFMActualStation(double actualStation) {
        FM_actualStation = actualStation;

    }
    
    /* 
     * Establecer estacion en la frecuencia AM
     * @param actualStation Estacion actual 
     */
    @Override
    public void setAMActualStation(int actualStation) {
        AM_actualStation = actualStation;

    }

    /* 
     * Guardar una estacion en frecuencia FM
     * @param actualStation Estacion actual
     * @param slot Espacio disponible dentro de lista  
     */
    @Override
    public void saveFMStation(double actualStation, int slot) {
        FMStations[slot - 1] = actualStation;

    }

    /* 
     * Guardar una estacion en frecuencia AM
     * @param actualStation Estacion actual
     * @param slot Espacio disponible dentro de lista  
     */
    @Override
    public void saveAMStation(int actualStation, int slot) {
        AMStations[slot - 1] = actualStation;
    }

    /* 
     * Obtiene el espacio disponible de las listas de frecuencia FM
     * @param slot Espacio  
     * @return Espacio disponible 
     */
    @Override
    public double getFMSlot(int slot) {
        Double fmSlot = 87.9;
        if (FMStations[slot - 1] != null) {
            fmSlot = FMStations[slot - 1];
        }

        return fmSlot;
    }

    /* 
     * Obtiene el espacio disponible de las listas de frecuencia AM
     * @param slot Espacio  
     * @return Espacio disponible 
     */
    @Override
    public int getAMSlot(int slot) {
        int amSlot = 530;
        if (AMStations[slot - 1] != null) {
            amSlot = AMStations[slot - 1];
        }

        return amSlot;
    }
}
