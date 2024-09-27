package PROYECTO_GRUPO_3.CLASES;
public class Producto_Reciclable {
    // ATRIBUTOS
    private String tipo;
    private double valor;
    private int cantidad;

    // CONSTRUCTOR
    public Producto_Reciclable(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        // SEGUN EL TIPO SE ASIGNARA UN VALOR PREESTABLECIDO
        switch (tipo) {
            case "envase de vidrio":
                this.valor = 0.30;
                break;
            case "envase de plastico":
                this.valor = 0.20;
                break;
            case "envase de lata":
                this.valor = 0.10;
                break;
            default:
                this.valor = 0.0;
                System.out.println("Tipo de reciclaje no permitido: " + tipo);
                break;
        }
    }

    // GETTERS
    public String getTipo() {
        return tipo;
    }
    public double getValor(){
        return valor;
    }
    public int getCantidad() {
        return cantidad;
    }

    // METODO PARA CALCULAR EL VALOR
    public double calcularValor() {
        return cantidad * valor;
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

    // METODO PARA MOSTRAR UN PRODUCTO RECICLABLE
    public void mostrarProducto(){
        System.out.println("+----------------------+---------------+----------------+---------------+");
        System.out.println("|         Tipo         |     Valor     |    Cantidad    |     Total     |");
        System.out.println("+----------------------+---------------+----------------+---------------+");
        System.out.printf("| %s | %s | %s | %s |\n",
        // Utilizamos el siguiente metodo para centrar cada informacion
        centrarTexto(tipo,20),
        centrarTexto(String.format("%.2f",valor),13),
        centrarTexto(String.valueOf(cantidad),14),
        centrarTexto(String.format("%.2f",calcularValor()),13));
        System.out.println("+----------------------+---------------+----------------+---------------+");
    }
}