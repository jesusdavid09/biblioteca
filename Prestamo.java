import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaInicio, LocalDate fechaLimite) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void mostrarDatos() {
        System.out.println("Libro: " + libro.getTitulo() + " | Usuario: " + usuario.getIdUsuario() +
                " | Inicio: " + fechaInicio + " | Límite: " + fechaLimite);
    }
}
