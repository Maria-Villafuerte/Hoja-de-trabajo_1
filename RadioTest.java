import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    /**
     * Prueba para obtener la frecuencia de la radio
     * @throws Exception Mensaje de error al no seleccionar AM o FM
     */
    @Test
    public void PruebaSet_GetFrequence() throws Exception {
        radio.setFrequence("AM");
        assertEquals("AM", radio.getFrequence());    }

    /**
     * Test en base a obtener la frecuencia de radio obtenida al avanzar en modo AM 
     * @throws Exception Mensaje de error al no seleccionar AM o FM
     */
    @Test
    public void PruebaForward() throws Exception {
        radio.setFrequence("AM");
        radio.setAMActualStation(530);
        radio.Forward();
        assertEquals(540, radio.getAMActualStation());
    }

    /**
     * Test en base a obtener la frecuencia de radio obtenida al retroceder en modo FM
     * @throws Exception Mensaje de error al no seleccionar AM o FM
     */
    @Test
    public void PruebaBackward() throws Exception {
        radio.setFrequence("FM");
        radio.setFMActualStation(87.9);
        radio.Backward();
        assertEquals(107.9, radio.getFMActualStation());
    }

    /**
     * Test en base a obtener un contenido en un slot 
     */
    @Test
    public void Prueba_getSlot(){
        assertEquals(87.9, radio.getFMSlot(12));
    }


}
