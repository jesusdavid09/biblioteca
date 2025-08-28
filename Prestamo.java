import java.time.LocalDate;

public class Prestamo {
   private Libro lib;
   private Usuario usu;
   private LocalDate fIni;
   private LocalDate fLim;

   public Prestamo(Libro l, Usuario u, LocalDate ini, LocalDate lim) {
      this.lib = l;
      this.usu = u;
      this.fIni = ini;
      this.fLim = lim;
   }

   public Libro getLibro() {
      return lib;
   }

   public Usuario getUsuario() {
      return usu;
   }

   public LocalDate getFechaLimite() {
      return fLim;
   }

   public void mostrarDatos() {
      System.out.println("Prestamo -> Libro: " + lib.getTitulo() + 
                         " | User: " + usu.getIdUsuario() +
                         " | desde: " + fIni + 
                         " | hasta: " + fLim);
   }
}
