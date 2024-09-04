package cuentas;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente("100", 11111);
            nuevaCuentaCorriente.abonar(500);
            nuevaCuentaCorriente.cargar(200);

            nuevaCuentaCorriente.mostrar();

            System.out.println(nuevaCuentaCorriente);
        }
}
