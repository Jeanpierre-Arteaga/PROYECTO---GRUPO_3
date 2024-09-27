package PROYECTO_GRUPO_3.CLASES;

public class Contenedores {
    // ATRIBUTOS
    private Contenedor[] contenedores;
    private String idContenedor;
    private String ubicacion;
    
    // CONSTRUCTOR
    public Contenedores(String idContenedor,String ubicacion){
        this.idContenedor = idContenedor;
        this.ubicacion = ubicacion;
        contenedores = new Contenedor[3]; 
        contenedores[0] = new Contenedor("envase de vidrio",1000);
        contenedores[1] = new Contenedor("envase de plastico",1000);
        contenedores[2] = new Contenedor("envase de lata",1000);
    }

    // METODO PARA OBTENER UNO DE LOS TRES CONTENEDORES
    public Contenedor getContenedor(int i) {
        if (i >= 0 && i < contenedores.length) {
            return contenedores[i];
        }
        return null; 
    }
    
    // METODO PARA AGREGAR PRODUCTOS RECICLABLES EN UN CONTENEDOR ESPECIFICO
    public boolean agregarProducto(int i, Producto_Reciclable producto) {
        Contenedor contenedor = getContenedor(i);
        if (contenedor == null) {
            System.out.println("Contenedor no encontrado.");
            return false;
        }
        contenedor.agregar(producto);
        return true;
    }

    // METODO PARA MOSTRAR CADA UNO DE LOS CONTENEDORES
    public void mostrarContenedores(){
        System.out.println("CONTENEDOR "+idContenedor+" UBICADO EN "+ubicacion.toUpperCase());
        for(int i=0;i<3;i++){
            contenedores[i].mostrarContenedor();
        }
    }
}