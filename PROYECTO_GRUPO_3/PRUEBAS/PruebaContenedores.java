package PROYECTO_GRUPO_3.PRUEBAS;
import PROYECTO_GRUPO_3.CLASES.Contenedores;
import PROYECTO_GRUPO_3.CLASES.Producto_Reciclable;

public class PruebaContenedores {
    public static void main(String[] args){
        // INSTANCIANDO DOS OBJETOS DE LA CLASE CONTENEDORES
        Contenedores contenedores_1 = new Contenedores("1", "Santa Anita");
        Contenedores contenedores_2 = new Contenedores("2", "Surco");

        // INSTANCIANDO SEIS OBJETOS DE LA CLASE PRODUCTO
        Producto_Reciclable Producto_1 = new Producto_Reciclable("envase de lata", 20);
        Producto_Reciclable Producto_2 = new Producto_Reciclable("envase de vidrio", 30);
        Producto_Reciclable Producto_3 = new Producto_Reciclable("envase de plastico", 15);
        Producto_Reciclable Producto_4 = new Producto_Reciclable("envase de plastico", 20);
        Producto_Reciclable Producto_5 = new Producto_Reciclable("envase de lata", 45);
        Producto_Reciclable Producto_6 = new Producto_Reciclable("envase de plastico", 35);

        // UTILIZANDO EL METODO AGREGAR PRODUCTO DE LA CLASE CONTENEDORES
        // PARA INGRESAR LOS PRODUCTOS A CADA UNO DE LOS CONTENEDORES QUE LO CONFORMAN
        // YA SEA PARA EMBASES DE VIDRIO, PLASTICO O LATA
        contenedores_1.agregarProducto(2,Producto_1);
        contenedores_1.agregarProducto(0,Producto_2);
        contenedores_1.agregarProducto(1,Producto_3);
        contenedores_2.agregarProducto(1,Producto_4);
        contenedores_2.agregarProducto(2,Producto_5);
        contenedores_2.agregarProducto(1,Producto_6);

        // MOSTRANDO AMBOS CONTENEDORES CREADOS
        contenedores_1.mostrarContenedores();
        System.out.println();
        contenedores_2.mostrarContenedores();
    }
}
