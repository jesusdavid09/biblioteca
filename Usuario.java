import java.util.ArrayList;
import java.util.List;

public class Usuario {
   private String nom;
   private String id;
   private List<Libro> prestados;

   public Usuario(String n, String i) {
      this.nom = n;
      this.id = i;
      this.prestados = new ArrayList<>();
   }

   public void mostrarDatos() {
      System.out.println("user: " + nom + " | id: " + id + " | prestados: " + prestados.size());
   }

   public boolean agregarPrestamo(Libro l) {
      if (prestados.size() < 3) {
         prestados.add(l);
         return true;
      }
      return false;
   }

   public boolean devolverLibro(Libro l) {
      return prestados.remove(l);
   }

   public boolean puedePrestar() {
      return prestados.size() < 3;
   }

   public String getIdUsuario() {
      return id;
   }
}
