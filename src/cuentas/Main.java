package cuentas;

public class Main {
    public static void main(String[] args) {
        // Crear una nueva cuenta
        CuentaCorriente cuenta = new CuentaCorriente("Juan Perez", 1000, 12345);

        // Probando validaciones de monto y fecha

        // Caso 1: Abonar con monto válido y fecha válida
        System.out.println("Caso 1: Fecha válida:");
        cuenta.abonar("200", "15/09/2024");  // Fecha válida y monto positivo
        cuenta.mostrar();

        // Caso 2: Abonar con monto válido pero con formato de fecha incorrecto
        System.out.println("\nCaso 2: Formato inválido de fecha:");
        cuenta.abonar("300", "2024/09/15");  // Fecha en formato incorrecto (YYYY/MM/DD)
        cuenta.mostrar();

        // Caso 3: Abonar con monto válido pero con fecha inexistente
        System.out.println("\nCaso 3: Fecha inexistente:");
        cuenta.abonar("100", "31/02/2024");  // Fecha inexistente
        cuenta.mostrar();

        // Caso 4: Abonar con monto negativo
        System.out.println("\nCaso 4: Monto negativo:");
        cuenta.abonar("-50", "15/09/2024");  // Monto negativo
        cuenta.mostrar();

        // Caso 5: Abonar con monto no numérico
        System.out.println("\nCaso 5: Monto no numérico:");
        cuenta.abonar("abc", "15/09/2024");  // Monto no numérico
        cuenta.mostrar();

        // Caso 6: Cargar con monto válido
        System.out.println("\nCaso 6: Cargar monto válido:");
        cuenta.cargar("150", "16/09/2024");  // Monto válido y fecha válida
        cuenta.mostrar();

        // Caso 7: Cargar con monto que lleva el saldo a negativo (se ajusta a 0)
        System.out.println("\nCaso 7: Cargar monto que lleva el saldo a negativo:");
        cuenta.cargar("2000", "17/09/2024");  // Monto mayor que el saldo
        cuenta.mostrar();

        // Caso 8: Cargar con monto negativo
        System.out.println("\nCaso 8: Cargar monto negativo:");
        cuenta.cargar("-100", "18/09/2024");  // Monto negativo
        cuenta.mostrar();

        // Caso 9: Cargar con monto no numérico
        System.out.println("\nCaso 9: Cargar monto no numérico:");
        cuenta.cargar("xyz", "18/09/2024");  // Monto no numérico
        cuenta.mostrar();
    }
}

