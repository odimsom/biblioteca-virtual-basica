package biblioteca;

import java.util.*;

public class BibliotecaVirtual {
    private Scanner scan;
    private List<MaterialBibliografico> materialBibliograficos;

    protected BibliotecaVirtual() {
        this.materialBibliograficos = new ArrayList<>();
        this.scan = new Scanner(System.in);
    }

    public void menu() {
        int opcion;
        do {
            limpiarConsola();
            System.out.println("=== Menú Biblioteca Virtual ===");
            System.out.println("1. Agregar material");
            System.out.println("2. Eliminar material");
            System.out.println("3. Mostrar información de materiales");
            System.out.println("4. Prestar material");
            System.out.println("5. Devolver material");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    agregarMaterial();
                    break;
                case 2:
                    System.out.print("Ingrese el título del material a eliminar: ");
                    String tituloEliminar = scan.nextLine();
                    eliminarMaterial(tituloEliminar);
                    break;
                case 3:
                    mostrarInformacionMateriales();
                    break;
                case 4:
                    System.out.print("Ingrese el título del material a prestar: ");
                    String tituloPrestar = scan.nextLine();
                    prestamo(tituloPrestar);
                    break;
                case 5:
                    System.out.print("Ingrese el título del material a devolver: ");
                    String tituloDevolver = scan.nextLine();
                    devolucion(tituloDevolver);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        } while (opcion != 6);
    }


    private void agregarMaterial() {
        System.out.print("Ingrese el tipo de material (libro, revista, dvd): ");
        String tipo = scan.nextLine();
        System.out.print("Ingrese el título: ");
        String titulo = scan.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        String anoDePublicacion = scan.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scan.nextLine();
        System.out.print("Ingrese el número de páginas: ");
        int numeroDePaginas = scan.nextInt();
        scan.nextLine();

        switch (tipo.toLowerCase()) {
            case "libro":
                System.out.print("Ingrese la editorial: ");
                String editorial = scan.nextLine();
                agregarMaterial(new Libro(titulo, anoDePublicacion, autor, numeroDePaginas, editorial));
                break;
            case "revista":
                System.out.print("Ingrese el ISSN: ");
                String issn = scan.nextLine();
                agregarMaterial(new Revista(titulo, anoDePublicacion, autor, numeroDePaginas, issn));
                break;
            case "dvd":
                System.out.print("Ingrese la duración: ");
                String duracion = scan.nextLine();
                agregarMaterial(new DVD(titulo, anoDePublicacion, autor, numeroDePaginas, duracion));
                break;
            default:
                System.out.println("Tipo de material no válido.");
        }
    }

    public void eliminarMaterial(String titulo) {
        Iterator<MaterialBibliografico> iterator = materialBibliograficos.iterator();
        while (iterator.hasNext()) {
            MaterialBibliografico material = iterator.next();
            if (material.getTitulo().equalsIgnoreCase(titulo)) {
                iterator.remove();
                System.out.println("Material eliminado: " + titulo);
                return;
            }
        }
        System.out.println("Material no encontrado: " + titulo);
    }

    public void mostrarInformacionMateriales() {
        if (materialBibliograficos.isEmpty()) {
            System.out.println("No hay materiales en la biblioteca.");
            return;
        }

        for (MaterialBibliografico material : materialBibliograficos) {
            System.out.println("Título: " + material.getTitulo());
            System.out.println("Autor: " + material.getAutor());
            System.out.println("Año de publicación: " + material.getAnoDePublicacion());
            System.out.println("Número de páginas: " + material.getNumeroDePaginas());

            if (material instanceof Prestable) {
                System.out.println("Estado: " + ((Prestable) material).getEstado());
            }
            System.out.println();
        }
    }

    public void prestamo(String titulo) {
        for (MaterialBibliografico material : materialBibliograficos) {
            if (material instanceof Prestable && material.getTitulo().equals(titulo)) {
                ((Prestable) material).prestar();
                return;
            }
        }
        System.out.println("Material no disponible para préstamo: " + titulo);
    }

    public void devolucion(String titulo) {
        for (MaterialBibliografico material : materialBibliograficos) {
            if (material instanceof Prestable && material.getTitulo().equals(titulo)) {
                ((Prestable) material).devolver();
                return;
            }
        }
        System.out.println("Material no encontrado para devolución: " + titulo);
    }

    private void agregarMaterial(MaterialBibliografico material) {
        materialBibliograficos.add(material);
        System.out.println("Material agregado: " + material.getTitulo());
    }

    private void limpiarConsola() {
        // Limpiar la consola en sistemas Windows
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else { // Limpiar la consola en sistemas Unix/Linux/Mac
            try {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}