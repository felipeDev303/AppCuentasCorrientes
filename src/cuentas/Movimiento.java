package cuentas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Movimiento {
    private int tipoMovimiento;
    private int monto;
    private LocalDate fecha;

    // Constructor
    public Movimiento(int tipoMovimiento, int monto, String fechaStr) {
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fecha = LocalDate.parse(fechaStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Fecha inválida. Utiliza el formato DD/MM/YYYY.");
            this.fecha = LocalDate.now();  // Asignamos la fecha actual en caso de error
        }
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
