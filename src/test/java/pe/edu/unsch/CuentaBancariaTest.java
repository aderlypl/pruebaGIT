package pe.edu.unsch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    @Test
    void depositoDebeIncrementarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.depositar(50);
        assertEquals(150, cuenta.obtenerSaldo());
    }

    @Test
    void retiroConSaldoSuficienteDebeDisminuirSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(40);
        assertEquals(60, cuenta.obtenerSaldo());
    }

    @Test
    void transferenciaValidaDebeMoverDineroEntreCuentas() {
        CuentaBancaria origen = new CuentaBancaria(200);
        CuentaBancaria destino = new CuentaBancaria(50);

        boolean resultado = origen.transferir(destino, 80);

        assertTrue(resultado);
        assertEquals(120, origen.obtenerSaldo());
        assertEquals(130, destino.obtenerSaldo());
    }

    @Test
    void transferenciaConSaldoInsuficienteNoDebeRealizarse() {
        CuentaBancaria origen = new CuentaBancaria(30);
        CuentaBancaria destino = new CuentaBancaria(0);

        boolean resultado = origen.transferir(destino, 100);

        assertFalse(resultado);
        assertEquals(30, origen.obtenerSaldo());
        assertEquals(0, destino.obtenerSaldo());
    }

    @Test
    void transferenciaConMontoNegativoNoDebeRealizarse() {
        CuentaBancaria origen = new CuentaBancaria(100);
        CuentaBancaria destino = new CuentaBancaria(100);

        boolean resultado = origen.transferir(destino, -20);

        assertFalse(resultado);
        assertEquals(100, origen.obtenerSaldo());
        assertEquals(100, destino.obtenerSaldo());
    }
}

