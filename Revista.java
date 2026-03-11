
public class Revista extends MaterialBibliografico {
    private String periodicidad;
    private int numeroEdicion;
    
    public Revista(String id, String titulo, int añoPublicacion, String periodicidad, int numeroEdicion) {
        super(id, titulo, añoPublicacion);
        setPeriodicidad(periodicidad);
        setNumeroEdicion(numeroEdicion);
    }
    
    public String getPeriodicidad() {
        return periodicidad;
    }
    
    public void setPeriodicidad(String periodicidad) {
        if (periodicidad == null || periodicidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La periodicidad no puede estar vacia");
        }
        if (!periodicidad.equalsIgnoreCase("mensual") && 
            !periodicidad.equalsIgnoreCase("semanal") &&
            !periodicidad.equalsIgnoreCase("quincenal")) {
            throw new IllegalArgumentException("Periodicidad debe ser mensual, semanal o quincenal");
        }
        this.periodicidad = periodicidad;
    }
    
    public int getNumeroEdicion() {
        return numeroEdicion;
    }
    
    public void setNumeroEdicion(int numeroEdicion) {
        if (numeroEdicion <= 0) {
            throw new IllegalArgumentException("El numero de edicion debe ser positivo");
        }
        this.numeroEdicion = numeroEdicion;
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
        System.out.println("===== REVISTA =====");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Fecha: " + getFechaPublicacion());
        System.out.println("Periodicidad: " + periodicidad);
        System.out.println("Edicion #: " + numeroEdicion);
        System.out.println("Estado: " + (isPrestado() ? "Prestado" : "Disponible"));
        System.out.println("Dias maximos de prestamo: " + getDiasMaximosPrestamo());
        System.out.println("Multa por dia: $" + getMultaPorDia());
    }
    
    @Override
    public int getDiasMaximosPrestamo() {
        return 7;
    }
    
    @Override
    public double getMultaPorDia() {
        return 3000;
    }
}
