package interfaz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE GESTIÓN DE TIENDA          ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();
        
        while (!salir) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    System.out.println("[Gestionar Clientes]");
                    break;
                case 2:
                    System.out.println("[Gestionar Productos]");
                    break;
                case 3:
                    System.out.println("[Gestionar Pedidos]");
                    break;
                case 4:
                    System.out.println("[Ver Inventario]");
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
    
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Gestionar Clientes");
        System.out.println("2. Gestionar Productos");
        System.out.println("3. Gestionar Pedidos");
        System.out.println("4. Ver Inventario");
        System.out.println("5. Salir");
    }
}
