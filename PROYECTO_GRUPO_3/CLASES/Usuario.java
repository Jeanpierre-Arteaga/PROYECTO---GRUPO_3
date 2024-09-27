package PROYECTO_GRUPO_3.CLASES;
public class Usuario{
    // ATRIBUTOS
    private String nombres;
    private String apellidos;
    private double saldo;
    private String email;
    private int edad;
    private String distrito;
    private String ID;
    private String contraseña;
    
    // CONSTRUCTORES
    public Usuario(){
    }
    public Usuario(String nombres,String apellidos,String email,int edad,String distrito,String ID,String contraseña){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.saldo = 0.0;
        this.email = email;
        this.edad = edad;
        this.distrito = distrito;
        this.ID = ID;
        this.contraseña = contraseña;
    }

    // METODOS SETTERS
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setDistrito(String distrito){
        this.distrito = distrito;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    // METODOS GETTERS
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getEmail(){
        return email;
    }
    public int getEdad(){
        return edad;
    }
    public double getSaldo(){
        return saldo;
    }
    public String getDistrito(){
        return distrito;
    }
    public String getID(){
        return ID;
    }
    public String getContraseña(){
        return contraseña;
    }

    // METODO PARA CENTRAR LA INFORMACION AL MOMENTO DE IMPRIMIR
    private String centrarTexto(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto.substring(0, ancho);
        }
        int espaciosTotal = ancho - texto.length();
        int izquierda = espaciosTotal / 2;
        int derecha = espaciosTotal - izquierda;
        return " ".repeat(izquierda) + texto + " ".repeat(derecha);
    }

    // METODO PARA MOSTRAR DATOS DEL USUARIO EN UN FORMATO DE TABLA
    public String mostrarDatos(){
        // Utilizamos una instancia de la clase StringBuilder
        // Para facilitar el agregado de informacion a la tabla de salida
        StringBuilder tabla = new StringBuilder();

        tabla.append("+-----------------+------------------------------------------+\n");
        tabla.append("|     Dato        |               Información                |\n");
        tabla.append("+-----------------+------------------------------------------+\n");

        // Filas de la tabla con los datos centrados
        tabla.append(String.format("| %s | %s |\n", 
                centrarTexto("Apellidos", 15), 
                centrarTexto(apellidos, 40)));
        tabla.append("+-----------------+------------------------------------------+\n");

        tabla.append(String.format("| %s | %s |\n", 
                centrarTexto("Nombres", 15), 
                centrarTexto(nombres, 40)));
        tabla.append("+-----------------+------------------------------------------+\n");

        tabla.append(String.format("| %s | %s |\n", 
                centrarTexto("Edad", 15), 
                centrarTexto(String.valueOf(edad), 40)));
        tabla.append("+-----------------+------------------------------------------+\n");

        tabla.append(String.format("| %s | %s |\n", 
                centrarTexto("Email", 15), 
                centrarTexto(email, 40)));
        tabla.append("+-----------------+------------------------------------------+\n");

        tabla.append(String.format("| %s | %s |\n", 
                centrarTexto("Distrito", 15), 
                centrarTexto(distrito, 40)));
        tabla.append("+-----------------+------------------------------------------+\n");

        return tabla.toString();
    }
}