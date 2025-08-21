import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro registrado.");
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado.");
    }

    public void prestarLibro(String codigoLibro, String idUsuario) {
        Libro libro = buscarLibro(codigoLibro);
        Usuario usuario = buscarUsuario(idUsuario);

        if (libro != null && usuario != null) {
            if (libro.isDisponible() && usuario.puedePrestar()) {
                libro.marcarPrestado();
                usuario.agregarPrestamo(libro);
                LocalDate hoy = LocalDate.now();
                LocalDate fechaLimite = hoy.plusDays(7);
                prestamos.add(new Prestamo(libro, usuario, hoy, fechaLimite));
                System.out.println("Préstamo realizado. Fecha límite: " + fechaLimite);
            } else {
                System.out.println("No se puede prestar el libro (no disponible o límite de libros alcanzado).");
            }
        } else {
            System.out.println("Libro o usuario no encontrado.");
        }
    }

    public void devolverLibro(String codigoLibro, String idUsuario) {
        Prestamo prestamoEncontrado = null;

        for (Prestamo p : prestamos) {
            if (p.getLibro().getCodigo().equals(codigoLibro) &&
                p.getUsuario().getIdUsuario().equals(idUsuario)) {
                prestamoEncontrado = p;
                break;
            }
        }

        if (prestamoEncontrado != null) {
            Libro libro = prestamoEncontrado.getLibro();
            Usuario usuario = prestamoEncontrado.getUsuario();
            libro.marcarDisponible();
            usuario.devolverLibro(libro);

            LocalDate hoy = LocalDate.now();
            long diasRetraso = ChronoUnit.DAYS.between(prestamoEncontrado.getFechaLimite(), hoy);
            if (diasRetraso > 0) {
                long multa = diasRetraso * 500;
                System.out.println("Libro devuelto con retraso de " + diasRetraso + " días. Multa: $" + multa);
            } else {
                System.out.println("Libro devuelto a tiempo. Sin multa.");
            }
            prestamos.remove(prestamoEncontrado);
        } else {
            System.out.println("No se encontró el préstamo.");
        }
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        for (Libro l : libros) {
            if (l.isDisponible()) {
                l.mostrarDatos();
            }
        }
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (Usuario u : usuarios) {
            u.mostrarDatos();
        }
    }

    public void mostrarHistorialPrestamos() {
        System.out.println("Historial de préstamos:");
        for (Prestamo p : prestamos) {
            p.mostrarDatos();
        }
    }

    private Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(String idUsuario) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(idUsuario)) {
                return u;
            }
        }
        return null;
    }
}
