package es.iessoterohernandez.daw.endes.BoletinJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class TestAccount {

    private Account account;

    @BeforeEach
    public void init() {
        account = new Account("Carlos Cortés", 4444, 1000.0f);
    }

    //He cambiado el método withdrawal en la clase ya que no funcionaba correctamente
    @ParameterizedTest
    @MethodSource("withdrawal")
    public void testWithdraw(float withdraw, float fee, boolean resultadoEsperado, float balanceEsperado) {
        boolean resultado = account.withdraw(withdraw, fee);
        assertEquals(resultadoEsperado, resultado);
        assertEquals(balanceEsperado, account.getBalance(), 0.01f);
    }

    private static Stream<Arguments> withdrawal() {
        return Stream.of(
            Arguments.of(500.0f, 0.0f, true, 500.0f), // Suficiente
            Arguments.of(1500.0f, 0.0f, false, 1000.0f), // Insuficiente
            Arguments.of(-100.0f, 0.0f, false, 1000.0f), // Negativo
            Arguments.of(100.0f, -10.0f, false, 1000.0f), // Negativo
            Arguments.of(-100.0f, -10.0f, false, 1000.0f) // Negativo cantidad y tasa
        );
    }
}

