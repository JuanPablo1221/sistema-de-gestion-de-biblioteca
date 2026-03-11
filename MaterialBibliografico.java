
public abstract class MaterialBibliografico {
    private String id;
    private String titulo;
    private int fechaPublicacion;
    private boolean prestado;
    
    public MaterialBibliografico(String id, String titulo, int fechaPublicacion) {
        this.id = id;
        setTitulo(titulo);
        setfechaPublicacion(fechaPublicacion);
        this.prestado = false;
    }
    
    public String getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
    }
    
    public int getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    public void setfechaPublicacion(int fechaPublicacion) {
        if (fechaPublicacion <= 0) {
            throw new IllegalArgumentException("La fecha de publicacion debe ser positiva");
        }
        if (fechaPublicacion > 2026) {
            throw new IllegalArgumentException("La fecha de publicacion no puede ser futura");
        }
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public boolean isPrestado() {
        return prestado;
    }
    
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    
    public abstract double calcularMulta(int diasRetraso);
    
    public abstract void mostrarInformacion();
    
    public abstract int getDiasMaximosPrestamo();
    
    public abstract double getMultaPorDia();
}