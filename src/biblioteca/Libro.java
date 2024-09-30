package biblioteca;

public class Libro extends Prestable {
    private String editorial;

    public Libro(String titulo, String anoDePublicacion, String autor, int numeroDePaginas, String editorial) {
        super(titulo, anoDePublicacion, autor, numeroDePaginas, "disponible"); // Estado inicial disponible
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }
}
