package biblioteca;

public abstract class MaterialBibliografico {

    private String titulo;
    private String anoDePublicacion;
    private String autor;
    private int numeroDePaginas;

    public MaterialBibliografico(String titulo, String anoDePublicacion, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.anoDePublicacion = anoDePublicacion;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoDePublicacion() {
        return anoDePublicacion;
    }

    public void setAnoDePublicacion(String anoDePublicacion) {
        this.anoDePublicacion = anoDePublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
