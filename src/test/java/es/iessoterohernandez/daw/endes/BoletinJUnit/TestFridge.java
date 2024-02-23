package es.iessoterohernandez.daw.endes.BoletinJUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


public class TestFridge 
{
	static Stream<Arguments> food() {
        return Stream.of(
                Arguments.of("Manzana"),
                Arguments.of("Plátano"),
                Arguments.of("Mandarina"),
                Arguments.of("Pepino"),
                Arguments.of("Huevo")
        );
    }

    @ParameterizedTest
    @MethodSource("food")
    public void testPutAndContains(String food) {
        Fridge fridge = new Fridge();
        assertTrue(fridge.put(food));
        assertTrue(fridge.contains(food));
    }

    @ParameterizedTest
    @MethodSource("food")
    public void testTake(String food) {
        Fridge fridge = new Fridge();
        assertTrue(fridge.put(food));
        assertTrue(fridge.contains(food));

        try {
            fridge.take(food);
            assertFalse(fridge.contains(food));
        } catch (NoSuchItemException e) {
            fail(e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("food")
    public void testNoSuchItemException(String food) {
        Fridge fridge = new Fridge();
        assertFalse(fridge.contains(food));

        try {
            fridge.take(food);
            fail("Se lanza la excepción");
        } catch (NoSuchItemException e) {
            assertEquals(food + " no está en la nevera", e.getMessage());
        }
    }
	
	
}

