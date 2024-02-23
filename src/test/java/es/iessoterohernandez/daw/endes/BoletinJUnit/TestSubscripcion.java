package es.iessoterohernandez.daw.endes.BoletinJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestSubscripcion 
{
	private Subscripcion subscripcion;
	
	
	@BeforeEach
    public void init() {
        subscripcion = new Subscripcion(480, 6); 
    }

    @Test
    public void testPrecioPorMes() {
        assertEquals(80.0, subscripcion.precioPorMes()); 
    }

    @Test
    public void testPrecioPorMesPeriodoCero() {
        subscripcion.cancel();
        assertEquals(0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesCero() {
        subscripcion = new Subscripcion(0, 12);
        assertEquals(0, subscripcion.precioPorMes());
    }

    @Test
    public void testPrecioPorMesPeriodoPrecioCero() {
        subscripcion = new Subscripcion(0, 0);
        assertEquals(0, subscripcion.precioPorMes());
    }
	
	
}

