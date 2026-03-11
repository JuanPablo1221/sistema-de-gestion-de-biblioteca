import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<MaterialBibliografico> materiales;
    private Scanner scanner;
    
    public Menu() {
        this.materiales = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        agregarMaterialesEjemplo();
    }
    
    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    mostrarSubMenuAgregar();
                    break;
                case 2:
                    listarMateriales();
                    break;
                case 3:
                    simularPrestamo();
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el sistema de biblioteca!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 4);
        
        scanner.close();
    }
    
    private void mostrarMenuPrincipal() {
        System.out.println("\n=== BIBLIOTECA - MENU PRINCIPAL ===");
        System.out.println("1. Agregar material");
        System.out.println("2. Listar materiales");
        System.out.println("3. Simular prestamo (mostrar multa por retraso)");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion (1-4): ");
    }
    
    private int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (Exception e) {
            scanner.nextLine();
            return 0;
        }
    }
    
    private void mostrarSubMenuAgregar() {
        System.out.println("\n--- AGREGAR MATERIAL ---");
        System.out.println("Tipo de material:");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Pelicula");
        System.out.println("4. Cancelar");
        System.out.print("Seleccione tipo (1-4): ");
        
        int tipo = leerOpcion();
        
        if (tipo == 4) {
            System.out.println("Operacion cancelada.");
            return;
        }
        
        switch (tipo) {
            case 1:
                agregarLibro();
                break;
            case 2:
                agregarRevista();
                break;
            case 3:
                agregarPelicula();
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
    
    private void agregarLibro() {
        System.out.println("\n--- NUEVO LIBRO ---");
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Titulo: ");
            String titulo = scanner.nextLine();
            
            System.out.print("Fecha de publicacion: ");
            int fecha = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Numero de paginas: ");
            int paginas = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Autor: ");
            String autor = scanner.nextLine();
            
            materiales.add(new Libro(id, titulo, fecha, paginas, autor));
            System.out.println("Libro agregado exitosamente.");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Entrada no valida. Verifique los datos.");
            scanner.nextLine();
        }
    }
    
    private void agregarRevista() {
        System.out.println("\n--- NUEVA REVISTA ---");
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Titulo: ");
            String titulo = scanner.nextLine();
            
            System.out.print("Fecha de publicacion: ");
            int fecha = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Periodicidad (mensual/semanal/quincenal): ");
            String periodicidad = scanner.nextLine();
            
            System.out.print("Numero de edicion: ");
            int edicion = scanner.nextInt();
            scanner.nextLine();
            
            materiales.add(new Revista(id, titulo, fecha, periodicidad, edicion));
            System.out.println("Revista agregada exitosamente.");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Entrada no valida. Verifique los datos.");
            scanner.nextLine();
        }
    }
    
    private void agregarPelicula() {
        System.out.println("\n--- NUEVA PELICULA ---");
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Titulo: ");
            String titulo = scanner.nextLine();
            
            System.out.print("Fecha de publicacion: ");
            int fecha = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Duracion (minutos): ");
            int duracion = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Director: ");
            String director = scanner.nextLine();
            
            materiales.add(new Pelicula(id, titulo, fecha, duracion, director));
            System.out.println("Pelicula agregada exitosamente.");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Entrada no valida. Verifique los datos.");
            scanner.nextLine();
        }
    }
    
    private void listarMateriales() {
        System.out.println("\n--- LISTADO DE MATERIALES ---");
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
        
        System.out.println("Total de materiales: " + materiales.size());
        System.out.println("─────────────────────────────────");
    
        for (int i = 0; i < materiales.size(); i++) {
            System.out.println("\n" + (i + 1) + ". ");
            materiales.get(i).mostrarInformacion();
            System.out.println("─────────────────────────────────");
        }
    }
    
    private void simularPrestamo() {
        System.out.println("\n--- SIMULAR PRESTAMO ---");
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
    
        System.out.println("Materiales disponibles:");
        for (int i = 0; i < materiales.size(); i++) {
            MaterialBibliografico m = materiales.get(i);
            System.out.printf("%d. %s (%s) - %s%n", 
                (i + 1), 
                m.getTitulo(), 
                m.getClass().getSimpleName(),
                m.isPrestado() ? "PRESTADO" : "DISPONIBLE");
        }
        
        System.out.print("\nSeleccione el numero del material (0 para cancelar): ");
        int seleccion;
        try {
            seleccion = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada no valida.");
            scanner.nextLine();
            return;
        }
        
        if (seleccion == 0) {
            System.out.println("Operacion cancelada.");
            return;
        }
        
        if (seleccion < 1 || seleccion > materiales.size()) {
            System.out.println("Seleccion no valida.");
            return;
        }
        
        MaterialBibliografico material = materiales.get(seleccion - 1);
        
        mostrarDetallePrestamo(material);
    }
    
    private void mostrarDetallePrestamo(MaterialBibliografico material) {
        System.out.println("\nDETALLE DEL MATERIAL SELECCIONADO:");
        material.mostrarInformacion();
        
        System.out.print("\nDias de retraso en la devolucion: ");
        int diasRetraso;
        try {
            diasRetraso = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada no valida.");
            scanner.nextLine();
            return;
        }
        
        double multa = material.calcularMulta(diasRetraso);
        
        System.out.println("\nRESULTADO DEL PRESTAMO");
        System.out.println("──────────────────────────");
        System.out.printf("Material: %s%n", material.getTitulo());
        System.out.printf("Dias maximos de prestamo: %d dias%n", material.getDiasMaximosPrestamo());
        System.out.printf("Dias de retraso: %d%n", Math.max(0, diasRetraso));
        System.out.printf("Valor multa por dia: $%.0f%n", material.getMultaPorDia());
        System.out.printf("TOTAL MULTA: $%.0f%n", multa);
        
        if (diasRetraso > material.getDiasMaximosPrestamo()) {
            System.out.println("ADVERTENCIA: Se ha excedido el tiempo maximo de prestamo.");
        }
        
        System.out.print("\n¿Desea marcar este material como prestado? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            material.setPrestado(true);
            System.out.println("Material marcado como PRESTADO.");
        }
    }
    
    private void agregarMaterialesEjemplo() {
        try {
            materiales.add(new Libro("L001", "Cien años de soledad", 1967, 471, "Gabriel Garcia Marquez"));
            materiales.add(new Libro("L002", "1984", 1949, 328, "George Orwell"));
            materiales.add(new Revista("R001", "National Geographic", 2023, "mensual", 150));
            materiales.add(new Revista("R002", "Time", 2023, "semanal", 45));
            materiales.add(new Pelicula("P001", "El Padrino", 1972, 175, "Francis Ford Coppola"));
            materiales.add(new Pelicula("P002", "Interestelar", 2014, 169, "Christopher Nolan"));
            System.out.println("Materiales de ejemplo cargados.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear materiales de ejemplo: " + e.getMessage());
        }
    }
}
