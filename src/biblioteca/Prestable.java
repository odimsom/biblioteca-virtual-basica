package biblioteca;

public abstract class Prestable extends MaterialBibliografico implements IPrestable {

    private String estado; // "disponible" o "no disponible"

    public Prestable(String titulo, String anoDePublicacion, String autor, int numeroDePaginas, String estado) {
        super(titulo, anoDePublicacion, autor, numeroDePaginas);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void prestar() {
        if (estado.equals("disponible")) {
            estado = "no disponible";
            System.out.println("Material prestado: " + getTitulo());
        } else {
            System.out.println("Material no disponible para prestar: " + getTitulo());
        }
    }

    @Override
    public void devolver() {
        if (estado.equals("no disponible")) {
            estado = "disponible";
            System.out.println("Material devuelto: " + getTitulo());
        } else {
            System.out.println("El material ya está disponible: " + getTitulo());
        }
    }
}
