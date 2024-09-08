package cuentas;

public class CuentaCorriente {
    private String titular;
    private int Saldo;
    private int NroCuenta;
    private Movimiento[] movimientos;
    private int numMovimiento;

    // Constructor
    public CuentaCorriente(String titular, int Saldo, int NroCuenta) {
        this.titular = titular;
        this.Saldo = Saldo;
        this.NroCuenta = NroCuenta;
        this.movimientos = new Movimiento[10];  // Inicializa el array en el constructor
    }

    // Constructor con saldo por defecto
    public CuentaCorriente(String titular, int NroCuenta) {
        this.titular = titular;
        this.Saldo = 0;  // Saldo por defecto es 0
        this.NroCuenta = NroCuenta;
        this.movimientos = new Movimiento[10];  // Inicializa el array en el constructor
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

    // Métodos de la clase
    public void cargar(String montoStr, String fecha) {
        try { // Validar y convertir monto
            int monto = validarMonto(montoStr);
            // Validar y convertir monto
            this.Saldo -= monto;
            if (this.Saldo < 0) {
                this.Saldo = 0;
            }
            Movimiento movimientoCargar = new Movimiento(2, monto, fecha);
            registrarMovimiento(movimientoCargar);

        } catch (NumberFormatException e) {
            // Capturar excepción de formato de monto
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void abonar(String montoStr, String fecha) {
        try { // Validar y convertir monto
            int monto = validarMonto(montoStr);
            this.Saldo += monto;
            Movimiento movimientoAbonar = new Movimiento(1, monto, fecha);
            registrarMovimiento(movimientoAbonar);

        } catch (NumberFormatException e) {
            // Capturar excepción de formato de monto
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método privado para validar y convertir monto
    private int validarMonto(String montoStr) throws NumberFormatException {
        if (montoStr == null || montoStr.trim().isEmpty()) {
            throw new NumberFormatException("El monto no puede ser nulo o vacío.");
            // Validar si el monto es nulo o vacío
        }
        try {
            // Convertir monto a entero
            int monto = Integer.parseInt(montoStr);
            if (monto < 0) {
                // Validar si el monto es negativo
                throw new NumberFormatException("El monto no puede ser negativo.");
            }
            return monto;
        } catch (NumberFormatException e) {
            // Capturar excepción de formato de monto
            throw new NumberFormatException("El monto debe ser un número entero positivo.");
        }
    }

    // Método privado para registrar movimientos en el array con validaciones
    private void registrarMovimiento(Movimiento movimiento) {
        try {
            // Validar si el arreglo está inicializado
            if (movimientos == null) {
                throw new NullPointerException("El arreglo de movimientos no está inicializado.");
            }

            // Validar si el índice numMovimiento está dentro de los límites del arreglo
            if (numMovimiento >= movimientos.length) {
                throw new ArrayIndexOutOfBoundsException("El arreglo de movimientos está lleno.");
            }

            // Registrar el movimiento
            movimientos[numMovimiento++] = movimiento;

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
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




