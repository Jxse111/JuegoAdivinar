/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class_1.java to edit this template
 */
package juegoadivinar.pruebas;

/**
 *
 * @author José
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import juegoadivinar.JuegoAdivinar;

public class main {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        JuegoAdivinar juego1, juego2, juego3, juego4;
        // Variables de salida

        // Variables auxiliares
        //para calculos intermedios
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("¡ADIVINA NUMERO!");
        System.out.println("----------------------");
        System.out.println(" ");
        try {
            juego1 = new JuegoAdivinar(41, 10);
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error. %s \n", ex.getMessage());

        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        try {
            juego2 = new JuegoAdivinar(11);
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error. %s \n", ex.getMessage());

        }
        try {
            juego3 = new JuegoAdivinar(0);
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error. %s \n", ex.getMessage());

        }

        juego4 = new JuegoAdivinar();
        System.out.println("Te quedan: " + juego4.getIntentosRestantes()
                + " intentos restantes, para averiguar un numero entre 0 y "
                + juego4.getMaxValorPosible());
        while (juego4.getIntentosRestantes() > 0) {
            System.out.print("Ingresa un número para intentar adivinar: ");
            try {
                int numeroUsuario = teclado.nextInt();
                int resultado = juego4.adivinarNumero(numeroUsuario);
                switch (resultado) {
                    case 0 ->
                        System.out.println("¡Correcto! Has adivinado el número secreto.");
                    case 1 ->
                        System.out.println("El número que buscas es menor que " + numeroUsuario);
                    case -1 ->
                        System.out.println("El número que buscas es mayor que " + numeroUsuario);
                }
                System.out.println("Intentos restantes: " + juego4.getIntentosRestantes());
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingresa un número válido.");
                teclado.nextLine(); // Limpiar el buffer de entrada
            }
        }
        System.out.println("Fin del programa.");
    }
}
