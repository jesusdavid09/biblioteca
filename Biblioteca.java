import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   private List<Libro> libros;
   private List<Usuario> users;
   private List<Prestamo> prestamos;

   public Biblioteca(){
      libros = new ArrayList<>();
      users = new ArrayList<>();
      prestamos = new ArrayList<>();
   }

   public void registrarLibro(Libro book){
      libros.add(book);
      System.out.println("Libro guardado en la biblio");
   }

   public void registrarUsuario(Usuario usu){
      users.add(usu);
      System.out.println("Se registro el usuario ok");
   }

   public void prestarLibro(String codLibro, String idUsu){
      Libro book = buscarLibro(codLibro);
      Usuario usu = buscarUsuario(idUsu);

      if(book != null && usu != null){
         if(book.isDisponible() && usu.puedePrestar()){
            book.marcarPrestado();
            usu.agregarPrestamo(book);

            LocalDate hoy = LocalDate.now();
            LocalDate limite = hoy.plusDays(7);

            prestamos.add(new Prestamo(book, usu, hoy, limite));
            System.out.println("Préstamo hecho! Devuelve antes de: " + limite);
         }else{
            System.out.println("No se puede prestar :/ (ya está usado o el user no puede)");
         }
      }else{
         System.out.println("No se encontro el libro o el usuario :(");
      }
   }

   public void devolverLibro(String cod, String idUsu){
      Prestamo prest = null;

      for(Prestamo p : prestamos){
         if(p.getLibro().getCodigo().equals(cod) && 
            p.getUsuario().getIdUsuario().equals(idUsu)){
            prest = p;
            break;
         }
      }

      if(prest != null){
         Libro b = prest.getLibro();
         Usuario u = prest.getUsuario();

         b.marcarDisponible();
         u.devolverLibro(b);

         LocalDate hoy = LocalDate.now();
         long retraso = ChronoUnit.DAYS.between(prest.getFechaLimite(), hoy);

         if(retraso > 0){
            long multa = retraso * 500;
            System.out.println("Lo devolviste tarde... " + retraso + " dias. Multa: $" + multa);
         }else{
            System.out.println("Devuelto a tiempo ;) todo bien");
         }

         prestamos.remove(prest);
      }else{
         System.out.println("No se encontro ese prestamo...");
      }
   }

   public void mostrarLibrosDisponibles(){
      System.out.println("Libros que se pueden pedir ahora:");
      for(Libro l : libros){
         if(l.isDisponible()){
            l.mostrarDatos();
         }
      }
   }

   public void mostrarUsuarios(){
      System.out.println("Usuarios registrados:");
      for(Usuario u : users){
         u.mostrarDatos();
      }
   }

   public void mostrarHistorialPrestamos(){
      System.out.println("Prestamos en la lista:");
      for(Prestamo p : prestamos){
         p.mostrarDatos();
      }
   }

   private Libro buscarLibro(String cod){
      for(Libro l : libros){
         if(l.getCodigo().equals(cod)){
            return l;
         }
      }
      return null;
   }

   private Usuario buscarUsuario(String idUsu){
      for(Usuario u : users){
         if(u.getIdUsuario().equals(idUsu)){
            return u;
         }
      }
      return null;
   }
}
