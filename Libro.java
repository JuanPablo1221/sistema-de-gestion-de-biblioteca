
public class Libro extends MaterialBibliografico {
    private int numeroPaginas;
    private String autor;
    
    public Libro(String id, String titulo, int añoPublicacion, int numeroPaginas, String autor) {
        super(id, titulo, añoPublicacion);
        setNumeroPaginas(numeroPaginas);
        setAutor(autor);
    }
    
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    
    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("El numero de paginas debe ser positivo");
        }
        this.numeroPaginas = numeroPaginas;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacio");
        }
        this.autor = autor;
    }
    
    @Override
    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * getMultaPorDia();
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("===== LIBRO =====");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Fecha: " + getFechaPublicacion());
        System.out.println("Autor: " + autor);
        System.out.println("Paginas: " + numeroPaginas);
        System.out.println("Estado: " + (isPrestado() ? "Prestado" : "Disponible"));
        System.out.println("Dias maximos de prestamo: " + getDiasMaximosPrestamo());
        System.out.println("Multa por dia: $" + getMultaPorDia());
    }
    
    @Override
    public int getDiasMaximosPrestamo() {
        return 14;
    }
    
    @Override
    public double getMultaPorDia() {
        return 5000;
    }
}
