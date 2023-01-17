import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio1 radio = new Radio1();

    @Test
    public void PruebaSet_GetFrequence() throws Exception {
        radio.setFrequence("AM");
        assertEquals("AM", radio.getFrequence());    }

    @Test
    public void PruebaForward() throws Exception {
        radio.setFrequence("AM");
        radio.setAMActualStation(530);
        radio.Forward();
        assertEquals(540, radio.getAMActualStation());
    }

    @Test
    public void PruebaBackward() throws Exception {
        radio.setFrequence("FM");
        radio.setFMActualStation(87.9);
        radio.Backward();
        assertEquals(107.9, radio.getFMActualStation());
    }

    @Test
    public void Prueba_getSlot(){
        assertEquals(87.9, radio.getFMSlot(12));
    }


}