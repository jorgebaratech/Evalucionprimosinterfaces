package org.example;

import java.util.Scanner;

public class NumerosPrimos{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número inicial del intervalo: ");
        int inicio = scanner.nextInt();

        System.out.print("Introduce el número final del intervalo: ");
        int fin = scanner.nextInt();

        if (inicio <= 1 || fin <= 1 || fin <= inicio) {
            System.out.println("Por favor, ingresa un intervalo válido.");
        } else {
            int totalPrimos = 0;

            System.out.println("Números primos en el intervalo [" + inicio + ", " + fin + "]:");
            for (int num = inicio; num <= fin; num++) {
                if (esPrimo(num)) {
                    System.out.print(num + " ");
                    totalPrimos++;
                }
            }

            System.out.println("\nTotal de números primos encontrados: " + totalPrimos);
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
