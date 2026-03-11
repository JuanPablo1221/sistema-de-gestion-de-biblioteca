
public class Pelicula extends MaterialBibliografico {
    private int duracionMinutos;
    private String director;
    
    public Pelicula(String id, String titulo, int añoPublicacion, int duracionMinutos, String director) {
        super(id, titulo, añoPublicacion);
        setDuracionMinutos(duracionMinutos);
        setDirector(director);
    }
    
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    
    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duracion debe ser positiva");
        }
        this.duracionMinutos = duracionMinutos;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        if (director == null || director.trim().isEmpty()) {
            throw new IllegalArgumentException("El director no puede estar vacio");
        }
        this.director = director;
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
        System.out.println("===== PELICULA =====");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Fecha: " + getFechaPublicacion());
        System.out.println("Director: " + director);
        System.out.println("Duracion: " + duracionMinutos + " minutos");
        System.out.println("Estado: " + (isPrestado() ? "Prestado" : "Disponible"));
        System.out.println("Dias maximos de prestamo: " + getDiasMaximosPrestamo());
        System.out.println("Multa por dia: $" + getMultaPorDia());
    }
    
    @Override
    public int getDiasMaximosPrestamo() {
        return 3;
    }
    
    @Override
    public double getMultaPorDia() {
        return 10000;
    }
}
