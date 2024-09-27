package PROYECTO_GRUPO_3.PRUEBAS;
import PROYECTO_GRUPO_3.CLASES.Contenedor;
import PROYECTO_GRUPO_3.CLASES.Producto_Reciclable;

public class PruebaContenedor {
    public static void main(String[] args) {
        // INSTANCIANDO UN OBJETO DE LA CLASE CONTENEDOR
        Contenedor contenedorVidrio = new Contenedor("envase de vidrio", 100);

        // INSTANCIANDO DOS OBJETOS DE LA CLASE PRODUCTO RECICLABLE
        Producto_Reciclable producto1 = new Producto_Reciclable("envase de vidrio", 60);
        Producto_Reciclable producto2 = new Producto_Reciclable("envase de vidrio", 50);

        // UTILIZANDO EL METODO AGREGAR DE LA CLASE CONTENEDOR
        // PARA AGREGAR CADA UNO DE LOS PRODUCTOS
        contenedorVidrio.agregar(producto1);
        contenedorVidrio.agregar(producto2); 

        // MOSTRANDO EL CONTENDOR CON LOS PRODUCTOS INGRESADOS
        contenedorVidrio.mostrarContenedor();
    }
}