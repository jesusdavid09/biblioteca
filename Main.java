import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Biblioteca biblio = new Biblioteca();
      Scanner sc = new Scanner(System.in);
      int op;

      do{
         System.out.println("\nMenu biblio");
         System.out.println("1. agregar libro");
         System.out.println("2. agregar usuario");
         System.out.println("3. prestar libro");
         System.out.println("4. devolver libro");
         System.out.println("5. ver libros");
         System.out.println("6. ver usuarios");
         System.out.println("7. ver prestamos");
         System.out.println("0. salir");
         System.out.print("elige opcion: ");

         op = sc.nextInt();
         sc.nextLine(); // limpiar buffer

         switch(op){
            case 1:
               System.out.print("titulo: ");
               String tit = sc.nextLine();
               System.out.print("autor: ");
               String au = sc.nextLine();
               System.out.print("codigo: ");
               String cod = sc.nextLine();
               biblio.registrarLibro(new Libro(tit, au, cod));
               break;

            case 2:
               System.out.print("nombre: ");
               String nom = sc.nextLine();
               System.out.print("id: ");
               String usuId = sc.nextLine();
               biblio.registrarUsuario(new Usuario(nom, usuId));
               break;

            case 3:
               System.out.print("codigo libro: ");
               String codL = sc.nextLine();
               System.out.print("id usuario: ");
               String idU = sc.nextLine();
               biblio.prestarLibro(codL, idU);
               break;

            case 4:
               System.out.print("codigo libro: ");
               String codD = sc.nextLine();
               System.out.print("id usuario: ");
               String idD = sc.nextLine();
               biblio.devolverLibro(codD, idD);
               break;

            case 5:
               biblio.mostrarLibrosDisponibles();
               break;

            case 6:
               biblio.mostrarUsuarios();
               break;

            case 7:
               biblio.mostrarHistorialPrestamos();
               break;

            case 0:
               System.out.println("saliendo... chaooo");
               break;

            default:
               System.out.println("opcion mala, intenta de nuevo");
         }
      }while(op != 0);

      sc.close();
   }
}
