package PROYECTO_GRUPO_3.PRUEBAS;
import PROYECTO_GRUPO_3.CLASES.Usuario;

public class PruebaUsuario {
    public static void main(String[] args) {
        // INSTANCIANDO TRES OBJETOS DE LA CLASE USUARIO
        Usuario Usuario_1 = new Usuario("Jeanpierre Alexander","Arteaga Espinoza",
        "jean2020@gmail.com",19,"Santa Anita","Jean19","jean_alex");
        
        Usuario Usuario_2 = new Usuario("Luis Alonso","Gonzales Estela",
        "luis2005@gmail.com",19,"Villa El Salvador","LuisG","luis_al");
        
        Usuario Usuario_3 = new Usuario("Bryan Stephano","Muñoz Aliaga",
        "bryan2015@gmail.com",20,"San Juan de Lurigancho","Bryan38","muñoz_al");

        // MOSTRANDO LOS TRES USUARIOS CREADOS
        System.out.println(Usuario_1.mostrarDatos());
        System.out.println();
        System.out.println(Usuario_2.mostrarDatos());
        System.out.println();
        System.out.println(Usuario_3.mostrarDatos());
    }
}
