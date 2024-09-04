package cuentas;

import java.util.ArrayList;

public class CuentaCorriente {
    private String titular;
    private int Saldo;
    private int NroCuenta;
    private Movimiento[] movimientos;
    private int numMovimiento;

    public CuentaCorriente(String titular, int Saldo, int NroCuenta) {
        this.titular = titular;
        this.Saldo = Saldo;
        this.NroCuenta = NroCuenta;
        this.movimientos = new Movimiento[10];
    }

    public CuentaCorriente(String titular, int NroCuenta) {
        this.titular = titular;
        this.Saldo = 0;  // Saldo por defecto es 0
        this.NroCuenta = NroCuenta;
        this.movimientos = new Movimiento[10];
    }

    // Métodos Get y Set
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public int getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(int NroCuenta) {
        this.NroCuenta = NroCuenta;
    }

    public void cargar(int monto) {
        if (monto > 0) {
            this.Saldo -= monto;
            if (this.Saldo < 0) {
                this.Saldo = 0;
            }
            Movimiento movimientoCargar = new Movimiento(2, monto);
            registrarMovimiento(movimientoCargar);
        }
    }

    public void abonar(int monto) {
        if (monto > 0) {
            this.Saldo += monto;
            Movimiento movimientoAbonar = new Movimiento(1, monto);
            registrarMovimiento(movimientoAbonar);
        }
    }

    // Método privado para registrar movimientos en el array
    private void registrarMovimiento(Movimiento movimiento) {
        if (numMovimiento == movimientos.length) {
            // Si el array está lleno, desplaza los movimientos
            System.arraycopy(movimientos, 1, movimientos, 0, movimientos.length - 1);
            numMovimiento--;
        }
        movimientos[numMovimiento++] = movimiento;
    }

    // Mostrar movimientos
    public void mostrar() {
        System.out.println("Movimientos de la cuenta: " + this.NroCuenta);
        for (int i = 0; i < this.numMovimiento; i++) {
            System.out.println("Tipo Movimiento: " + movimientos[i].getTipoMovimiento() + ", Monto: " + movimientos[i].getMonto());
        }
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "Titular='" + titular + '\'' +
                ", Saldo=" + Saldo +
                ", NroCuenta=" + NroCuenta +
                '}';
    }
}

