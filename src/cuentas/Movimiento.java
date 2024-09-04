package cuentas;

import java.time.LocalDateTime;

public class Movimiento {
    private int tipoMovimiento;
    private int monto;
    private LocalDateTime fecha;

    // Constructor
    public Movimiento(int tipoMovimiento, int monto) {
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
        this.fecha = LocalDateTime.now();  // Captura la fecha y hora actuales
    }

    // Métodos Getters y Setters
    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}

