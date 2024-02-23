package es.iessoterohernandez.daw.endes.BoletinJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestPila 
{
	private Pila pila;

    @BeforeEach
    public void init() {
        pila = new Pila();
    }

    @Test
    public void testPush() {
        pila.push(3);
        assertFalse(pila.isEmpty());
        assertEquals(3, pila.top());

        pila.push(10);
        assertFalse(pila.isEmpty());
        assertEquals(10, pila.top());

        pila.push(1);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testPop() {
        assertNull(pila.pop());
        pila.push(5);
        pila.push(8);
        assertEquals(8, pila.pop());
        assertEquals(5, pila.pop());
        assertTrue(pila.isEmpty());
        assertNull(pila.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(pila.isEmpty());

        pila.push(7);
        assertFalse(pila.isEmpty()); 

        pila.pop();
        assertTrue(pila.isEmpty()); 
    }

    @Test
    public void testTop() {
        assertNull(pila.top());
        
        pila.push(4);
        assertEquals(4, pila.top());

        pila.push(12);
        assertEquals(12, pila.top());
        
        pila.pop();
        assertEquals(4, pila.top());
    }
	
	
}

