public class Libro{
    private String titulo;
    private String autor;
    private String codigo;
    private boolean disponible;

    public Libro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponible = true;
    }
    public void mostrarDatos(){
        System.out.println("Código: " + codigo + " | Título: " + titulo + " | Autor: " + autor + " | Disponible: " + disponible);
    }
    public void marcarPrestado(){
        disponible = false;
    }
    public void marcarDisponible(){
        disponible = true;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
}