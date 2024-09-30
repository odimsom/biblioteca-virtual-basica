package biblioteca;

public class Revista extends Prestable {
    private String issn;

    public Revista(String titulo, String anoDePublicacion, String autor, int numeroDePaginas, String issn) {
        super(titulo, anoDePublicacion, autor, numeroDePaginas, "disponible"); // Estado inicial disponible
        this.issn = issn;
    }

    public String getIssn() {
        return issn;
    }
}
