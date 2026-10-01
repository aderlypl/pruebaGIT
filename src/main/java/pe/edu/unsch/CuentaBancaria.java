package pe.edu.unsch;

public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
    }
    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        }
    }
    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino == null || monto <= 0 || monto > saldo) {
            return false;
        }
        this.saldo -= monto;
        destino.depositar(monto);
        return true;
    }

    public double obtenerSaldo() {
        return saldo;
    }
}

