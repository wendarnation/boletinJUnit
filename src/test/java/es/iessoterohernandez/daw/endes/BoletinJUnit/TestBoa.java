package es.iessoterohernandez.daw.endes.BoletinJUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


public class TestBoa 
{
	static Stream<Arguments> boaElements() {
        return Stream.of(
                Arguments.of("Pepe", 10, "granola bars", true),
                Arguments.of("Ana", 8, "granola bars", true),
                Arguments.of("Paco", 8, "granola bars", true),
                Arguments.of("Laura", 15, "cerezas", false)
        );
    }

    @ParameterizedTest
    @MethodSource("boaElements")
    public void testIsHealthy(String name, int length, String favoriteFood, boolean expected) {
        Boa boa = new Boa(name, length, favoriteFood);
        assertEquals(expected, boa.isHealthy());
    }

    @ParameterizedTest
    @MethodSource("boaElements")
    public void testFitsInCage(String name, int length, String favoriteFood, boolean expected) {
        Boa boa = new Boa(name, length, favoriteFood);
        assertEquals(expected, boa.fitsInCage(12)); 
    }
	
	
}

