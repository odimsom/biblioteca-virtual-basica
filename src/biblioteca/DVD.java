package biblioteca;

public class DVD extends Prestable {
    private String duracion;

    public DVD(String titulo, String anoDePublicacion, String autor, int numeroDePaginas, String duracion) {
        super(titulo, anoDePublicacion, autor, numeroDePaginas, "disponible"); // Estado inicial disponible
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }
}
