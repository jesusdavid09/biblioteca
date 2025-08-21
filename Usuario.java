import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String idUsuario;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.librosPrestados = new ArrayList<>();
    }

    public void mostrarDatos() {
        System.out.println("Usuario: " + nombre + " | ID: " + idUsuario + " | Libros prestados: " + librosPrestados.size());
    }

    public boolean agregarPrestamo(Libro libro) {
        if (librosPrestados.size() < 3) {
            librosPrestados.add(libro);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {
        return librosPrestados.remove(libro);
    }

    public boolean puedePrestar() {
        return librosPrestados.size() < 3;
    }

    public String getIdUsuario() {
        return idUsuario;
    }
}
