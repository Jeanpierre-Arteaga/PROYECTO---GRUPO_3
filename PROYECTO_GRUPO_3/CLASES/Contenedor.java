package PROYECTO_GRUPO_3.CLASES;
public class Contenedor {
    // ATRIBUTOS
    private String tipo; 
    private int capacidadActual;
    private int capacidadMaxima;
    private Producto_Reciclable[] productos;

    // CONSTRUCTOR
    public Contenedor(String tipo, int capacidadMaxima) {
        this.tipo = tipo; 
        this.capacidadActual = 0;
        this.capacidadMaxima = capacidadMaxima;
        this.productos = new Producto_Reciclable[capacidadMaxima];
    }

    // SETTERS
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setCapacidadActual(int capacidadActual){
        this.capacidadActual = capacidadActual;
    }
    public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
    }

    // GETTERS
    public String getTipo(){
        return tipo;
    }
    public int getCapacidadActual(){
        return capacidadActual;
    }
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }

    // METODO PARA AGREGAR UN PRODUCTO AL CONTENEDOR
    public boolean agregar(Producto_Reciclable producto) {
        if (!producto.getTipo().equalsIgnoreCase(tipo)) {
            System.out.println("Este contenedor solo acepta productos de tipo: " + tipo);
            return false;
        }
    
        int espacioDisponible = capacidadMaxima - capacidadActual;  
    
        if (espacioDisponible >= producto.getCantidad()) {
            productos[capacidadActual] = producto;
            capacidadActual += producto.getCantidad();
            return true;
        } else if (espacioDisponible > 0) {
            // Solo se puede agregar una parte de los productos
            System.out.println("Espacio insuficiente. Solo se agregaron " + espacioDisponible +
            " productos de " + producto.getCantidad() + ".");
            
            // Crear un nuevo producto con la cantidad que puede ser agregada
            Producto_Reciclable productoParcial = new Producto_Reciclable(producto.getTipo(), espacioDisponible);
            productos[capacidadActual] = productoParcial;
            capacidadActual += espacioDisponible; // Actualizamos la capacidad ocupada
            
            return true;
        } else {
            // No hay espacio disponible
            System.out.println("No hay espacio suficiente en el contenedor para agregar más productos.");
            return false;
        }
    }

    // METODO PARA CENTRAR LA INFORMACION AL MOMENTO DE MOSTRAR
    private String centrarTexto(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto.substring(0, ancho);
        }
        int espaciosTotal = ancho - texto.length();
        int izquierda = espaciosTotal / 2;
        int derecha = espaciosTotal - izquierda;
        return " ".repeat(izquierda) + texto + " ".repeat(derecha);
    }

    // METODO PARA MOSTRAR LOS PRODUCTOS RECICLABLES QUE HAY EN EL CONTENEDOR
    public void mostrarContenedor(){
        System.out.printf("CONTENEDOR DE %s DE CAPACIDAD %d/%d%n",
                          tipo.toUpperCase(),capacidadActual,capacidadMaxima);
        
        // Utilizamos una instancia de la clase StringBuilder
        // Para facilitar el agregado de informacion a la tabla de salida
        StringBuilder tabla = new StringBuilder();

        tabla.append("+----------------------+---------------+----------------+---------------+\n");
        tabla.append("|         Tipo         |     Valor     |    Cantidad    |     Total     |\n");
        tabla.append("+----------------------+---------------+----------------+---------------+\n");
        for(int i=0;i<capacidadActual;i++){
            if (productos[i] != null) {
                // Filas de la tabla con los datos centrados
                tabla.append(String.format("| %s | %s | %s | %s |\n", 
                    centrarTexto(productos[i].getTipo(), 20), 
                    centrarTexto(String.format("%.2f",productos[i].getValor()), 13),
                    centrarTexto(String.valueOf(productos[i].getCantidad()), 14),
                    centrarTexto(String.format("%.2f",productos[i].calcularValor()), 13)));
                tabla.append("+----------------------+---------------+----------------+---------------+\n");
            }
        }
        System.out.println(tabla.toString());
    }
}