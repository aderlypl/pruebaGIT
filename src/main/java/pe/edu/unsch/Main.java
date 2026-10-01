package pe.edu.unsch;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        System.out.println("Saldo inicial: " + cuenta.obtenerSaldo());

        cuenta.depositar(50);
        System.out.println("Saldo después de depositar 50: " + cuenta.obtenerSaldo());

        CuentaBancaria otra = new CuentaBancaria(0);
        cuenta.transferir(otra, 30);
        System.out.println("Saldo cuenta origen: " + cuenta.obtenerSaldo());
        System.out.println("Saldo cuenta destino: " + otra.obtenerSaldo());
    }
}

