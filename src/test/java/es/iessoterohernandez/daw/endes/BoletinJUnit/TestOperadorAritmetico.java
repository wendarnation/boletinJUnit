package es.iessoterohernandez.daw.endes.BoletinJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestOperadorAritmetico 
{
	
	 
	    @Test
	    public void testSuma() {
	        assertEquals(8, OperadorAritmetico.suma(5, 3));
	        assertEquals(-1, OperadorAritmetico.suma(-4, 3));
	        assertEquals(0, OperadorAritmetico.suma(0, 0));
	    }

	    @Test
	    public void testDivision() {
	        try {
	            assertEquals(2, OperadorAritmetico.division(6, 3));
	            assertEquals(3, OperadorAritmetico.division(9, 3));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testDivisionPorCero() {
	        try {
	            OperadorAritmetico.division(6, 0);
	            assert false : "Se lanzaría excepción si se intenta dividir por 0";
	        } catch (Exception e) {
	        }

	        try {
	            OperadorAritmetico.division(-4, 0);
	            assert false : "Se lanzaría excepción si se intenta dividir por 0";
	        } catch (Exception e) {
	        }
	    }
	
	
}

