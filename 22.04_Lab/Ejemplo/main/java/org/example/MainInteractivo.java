package org.example;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        imprimirOpciones();
        int eleccion = scanner.nextInt();
        switch (eleccion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Elección no válida.");
        }
        scanner.close();
    }
    public static void imprimirOpciones(){
        System.out.println("Elige una comida o bebida:");
        System.out.println("1. Snicker");
        System.out.println("2. Super 8");
        System.out.println("3. Cocacola");
        System.out.println("5. Sprite");
        System.out.println("6. Fanta");
        System.out.print("Ingresa el número de tu elección: ");
    }
}
