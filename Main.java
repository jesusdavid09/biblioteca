import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios");
            System.out.println("7. Mostrar historial de préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    biblioteca.registrarLibro(new Libro(titulo, autor, codigo));
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("ID Usuario: ");
                    String idUsuario = sc.nextLine();
                    biblioteca.registrarUsuario(new Usuario(nombre, idUsuario));
                    break;

                case 3:
                    System.out.print("Código libro: ");
                    String codPrestamo = sc.nextLine();
                    System.out.print("ID usuario: ");
                    String idPrestamo = sc.nextLine();
                    biblioteca.prestarLibro(codPrestamo, idPrestamo);
                    break;

                case 4:
                    System.out.print("Código libro: ");
                    String codDevolucion = sc.nextLine();
                    System.out.print("ID usuario: ");
                    String idDevolucion = sc.nextLine();
                    biblioteca.devolverLibro(codDevolucion, idDevolucion);
                    break;

                case 5:
                    biblioteca.mostrarLibrosDisponibles();
                    break;

                case 6:
                    biblioteca.mostrarUsuarios();
                    break;

                case 7:
                    biblioteca.mostrarHistorialPrestamos();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
