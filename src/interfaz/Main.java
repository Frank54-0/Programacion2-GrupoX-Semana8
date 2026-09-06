package interfaz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        mostrarBienvenida();

        while (!salir) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    System.out.println("═══════════════════════════════════════");
                    System.out.println("       [Gestionar Clientes]");
                    System.out.println("═══════════════════════════════════════");
                    break;
                case 2:
                    System.out.println("═══════════════════════════════════════");
                    System.out.println("       [Gestionar Productos]");
                    System.out.println("═══════════════════════════════════════");
                    break;
                case 3:
                    System.out.println("═══════════════════════════════════════");
                    System.out.println("       [Gestionar Pedidos]");
                    System.out.println("═══════════════════════════════════════");
                    break;
                case 4:
                    System.out.println("═══════════════════════════════════════");
                    System.out.println("       [Ver Inventario]");
                    System.out.println("═══════════════════════════════════════");
                    break;
                case 5:
                    System.out.println("═══════════════════════════════════════");
                    System.out.println("       [Reportes y Análisis]");
                    System.out.println("═══════════════════════════════════════");
                    break;
                case 6:
                    System.out.println("═══════════════════════════════════════");
                    System.out.println("       [Configuración del Sistema]");
                    System.out.println("═══════════════════════════════════════");
                    break;
                case 7:
                    System.out.println("¡Gracias por usar nuestro sistema! ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println(" Opción no válida. Intente nuevamente.");
            }

        }
        scanner.close();

    }
        public static void mostrarBienvenida() {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║                                          ║");
            System.out.println("║            SISTEMA DE GESTIÓN              ║");
            System.out.println("║                DE TIENDAS                ║");
            System.out.println("║                                          ║");
            System.out.println("║              ── Versión 1.0 ──           ║");
            System.out.println("║                                          ║");
            System.out.println("║        ¡Bienvenido(a) al sistema!       ║");
            System.out.println("║                                          ║");
            System.out.println("╚══════════════════════════════════════════╝\n");
        }

    public static void mostrarMenu() {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║           MENÚ PRINCIPAL               ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  1. Gestionar Clientes                 ║");
            System.out.println("║  2. Gestionar Productos                ║");
            System.out.println("║  3. Gestionar Pedidos                  ║");
            System.out.println("║  4. Ver Inventario                     ║");
            System.out.println("║  5. Reportes y Análisis                ║");
            System.out.println("║  6. Configuración                      ║");
            System.out.println("║  7. Salir                              ║");
            System.out.println("╚════════════════════════════════════════╝");
        }

    }

