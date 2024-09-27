package PROYECTO_GRUPO_3.CLASES;
import java.util.Scanner;

public class Usuarios {
    // ATRIBUTOS
    private Usuario[] usuarios;
    private Contenedores Contenedores_1;
    private Contenedores Contenedores_2;
    private Contenedores Contenedores_3;
    private Contenedores Contenedores_4;
    private Scanner entrada;

    // CONSTRUCTOR
    public Usuarios(){
        usuarios = new Usuario[0];
        Contenedores_1 = new Contenedores("Contenedor 1","Santa Anita");
        Contenedores_2 = new Contenedores("Contenedor 2","Surco");
        Contenedores_3 = new Contenedores("Contenedor 3","Miraflores");
        Contenedores_4 = new Contenedores("Contenedor 4","San Miguel");
        entrada = new Scanner(System.in);
    }

    // METODO PARA REGISTRAR UN USUARIO
    private Usuario leerUsuario(){
        int n;
        while(true){
            System.out.print("Ingrese su edad: ");
            n = entrada.nextInt();
            entrada.nextLine();
            if(n>=18){
                String a,b,c,x,y,z;
                System.out.print("Ingrese sus nombres: ");
                a = entrada.nextLine();
                System.out.print("Ingrese sus apellidos: ");
                b = entrada.nextLine();
                System.out.print("Ingrese su email: ");
                c = entrada.nextLine();
                System.out.print("Ingrese su distrito: ");
                x = entrada.nextLine();
                System.out.print("\nIngrese un ID: ");
                y = entrada.nextLine();
                System.out.print("Ingrese una contraseña: ");
                z = entrada.nextLine();
                Usuario nuevoUsuario = new Usuario(a,b,c,n,x,y,z);
                System.out.println("REGISTRO EXITOSO.");
                return nuevoUsuario;
            }
            else if(n>0&&n<18){
                System.out.println("EL REGISTRO ES SOLO PARA MAYORES DE EDAD.");
                break;
            }
            else if(n<=0){
                System.out.println("EDAD INEXISTENTE");
            }
        }
        return null;
    }

    // METODO PARA INCREMENTAR EN UNO EL TAMAÑO DEL ARRAY DE USUARIOS
    private void primeraRedimension(){
        Usuario[] x=new Usuario[usuarios.length+1];
        for(int i=0;i<usuarios.length;i++){
            x[i]=usuarios[i];
        }
        usuarios=x;
    }

    // METODO PARA DECREMENTAR EN UNO EL TAMAÑO DEL ARRAY DE USUARIOS
    public void segundaRedimension(){
        Usuario[] x=new Usuario[usuarios.length-1];
        for(int i=0;i<usuarios.length-1;i++){
            x[i]=usuarios[i];
        }
        usuarios=x;
    }

    // METODO PARA AGREGAR UN USUARIO AL ARRAY DE USUARIOS
    public void registrar(){
        primeraRedimension();
        Usuario x=leerUsuario();
        if (x != null) {
            usuarios[usuarios.length-1]=x;
        } 
        else {
            segundaRedimension();
        }
    }

    // METODO PARA INICIAR SESION
    public boolean iniciar(String a, String b){
        for(int i=0;i<usuarios.length;i++){
            if(usuarios[i].getID().equals(a) && usuarios[i].getContraseña().equals(b)){
                return true;
            }
        }
        return false;
    }

    // METODO PARA IDENTIFICAR EL USUARIO QUE INICIO SESION
    private Usuario identificar(String a, String b){
        Usuario x = new Usuario();
        for(int i=0;i<usuarios.length;i++){
            if(usuarios[i].getID().equals(a) && usuarios[i].getContraseña().equals(b)){
                x = usuarios[i];
                break;
            }
        }
        return x;
    }

    // METODO PARA DAR EL MENSAJE DE BIENVENIDA
    public String bienvenida(String a, String b){
        Usuario x = identificar(a,b);
        return "BIENVENIDO SEÑOR "+primerApellido(x.getApellidos()).toUpperCase();
    }

    // METODO PARA OBTENER EL PRIMER APELLIDO
    private String primerApellido(String apellido){
        String b="";
        for(int i=0;i<apellido.length();i++){
            if(apellido.charAt(i)==' '){
                break;
            }
            else{
                b=b+apellido.charAt(i);
            }
        }
        return b;
    }

    // METODO PARA MOSTRAR LOS DATOS PERSONALES DEL USUARIO QUE INICIO SESION
    public String datos(String a, String b){
        Usuario x = identificar(a,b);
        return "\n"+x.mostrarDatos();
    }

    // METODO PARA MOSTRAR SALDO DEL USUARIO 
    public double mostrarSaldo(String a,String b){
        Usuario Usuario = identificar(a,b);
        return Usuario.getSaldo();
    }

    // METODO PARA AGREGAR PRODUCTOS A LOS CONTENEDORES
    public void agregar_1(String a,String b){
        int opc;
        Usuario z = identificar(a,b);
        do{
            System.out.println("\nCONTENEDORES DISPONIBLES (DISTRITOS):");
            System.out.println(" 1. Santa Anita");
            System.out.println(" 2. Surco");
            System.out.println(" 3. Miraflores");
            System.out.println(" 4. San Miguel");
            System.out.println(" 5. Salir");
            System.out.print(" Ingrese una opción: ");
            opc = entrada.nextInt();
            switch(opc){
                case 1: agregar_2(Contenedores_1,z); break;
                case 2: agregar_2(Contenedores_2,z); break;
                case 3: agregar_2(Contenedores_3,z); break;
                case 4: agregar_2(Contenedores_4,z); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        }while(opc!=5);  
    }

    // METODO PARA FACILITAR EL AGREGADO A CADA UNO DE LOS CONTENEDORES
    public void agregar_2(Contenedores y, Usuario z){
        int opc,n;
        Producto_Reciclable x;
        do{
            System.out.println("\n ELEGIR PRODUCTOS RECICLABLES:");
            System.out.println(" 1. Envases de vidrios");
            System.out.println(" 2. Envases de plasticos");
            System.out.println(" 3. Envases de latas");
            System.out.println(" 4. Salir");
            System.out.print(" Ingrese una opción: ");
            opc = entrada.nextInt();
            switch(opc){
                case 1: System.out.print(" Ingrese la cantidad: ");
                        n = entrada.nextInt();
                        x = new Producto_Reciclable("envase de vidrio", n);
                        y.agregarProducto(0, x);
                        z.setSaldo(z.getSaldo()+x.calcularValor());
                        System.out.println("Productos reciclables agregados."); 
                        break;
                case 2: System.out.print(" Ingrese la cantidad: ");
                        n = entrada.nextInt();
                        x = new Producto_Reciclable("envase de plastico", n);
                        y.agregarProducto(1, x);
                        z.setSaldo(z.getSaldo()+x.calcularValor());
                        System.out.println("Productos reciclables agregados."); 
                        break;
                case 3: System.out.print(" Ingrese la cantidad: ");
                        n = entrada.nextInt();
                        x = new Producto_Reciclable("envase de lata", n);
                        y.agregarProducto(2, x);
                        z.setSaldo(z.getSaldo()+x.calcularValor());
                        System.out.println("Productos reciclables agregados."); 
                        break;
                case 4: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        }while(opc!=4);
    }

    // METODO PARA MOSTRAR EL ESTADO DE LOS CONTENEDORES
    public void estadoContenedores(){
        int opc;
        do{
            System.out.println("\nCONTENEDORES DISPONIBLES (DISTRITOS):");
            System.out.println(" 1. Santa Anita");
            System.out.println(" 2. Surco");
            System.out.println(" 3. Miraflores");
            System.out.println(" 4. San Miguel");
            System.out.println(" 5. Salir");
            System.out.print(" Ingrese una opción: ");
            opc = entrada.nextInt();
            switch(opc){
                case 1: Contenedores_1.mostrarContenedores(); break;
                case 2: Contenedores_2.mostrarContenedores(); break;
                case 3: Contenedores_3.mostrarContenedores(); break;
                case 4: Contenedores_4.mostrarContenedores(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        }while(opc!=5);  
    }
    
    // METODO PARA ACTUALIZAR DATOS PERSONALES DEL USUARIO
    public void actualizar_1(String p,String q){
        int opc,n;
        String a,b,c,x;
        Usuario Usuario = identificar(p,q);
        do{
            System.out.println("\n Posibles datos a actualizar:");
            System.out.println(" 1. Nombres");
            System.out.println(" 2. Apellidos");
            System.out.println(" 3. Edad");
            System.out.println(" 4. Email");
            System.out.println(" 5. Distrito");
            System.out.println(" 6. Salir");
            System.out.print(" Elija una opción: ");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch(opc){
                case 1: System.out.print(" Ingrese el/los nuevo(s) nombre(s): ");
                        a = entrada.nextLine(); Usuario.setNombres(a);
                        System.out.println(" Nombre(s) actualizados."); break;
                case 2: System.out.print(" Ingrese los nuevos apellidos: ");
                        b = entrada.nextLine(); Usuario.setApellidos(b);
                        System.out.println(" Apellidos actualizados."); break;
                case 3: System.out.print(" Ingrese su edad actual: ");
                        n = entrada.nextInt(); Usuario.setEdad(n);
                        System.out.println(" Edad actualizada."); break;
                case 4: System.out.print(" Ingrese el nuevo email: ");
                        c = entrada.nextLine(); Usuario.setEmail(c);
                        System.out.println(" Email actualizado."); break;
                case 5: System.out.print(" Ingrese el nuevo distrito: ");
                        x = entrada.nextLine(); Usuario.setDistrito(x);
                        System.out.println(" Distrito actualizado."); break;
                case 6: System.out.println("Saliendo de la actualización de datos..."); break;
                default: System.out.println("Opción no valida.");
            }
        }while(opc!=6);
    }

    // METODO PARA ACTUALIZAR EL ID O CONTRASEÑA DEL USUARIO
    public void actualizar_2(String p,String q){
        int opc;
        String a,b;
        Usuario Usuario = identificar(p,q);
        System.out.println(" 1. Actualizar ID");
        System.out.println(" 2. Actualizar contraseña");
        System.out.print(" Elija una opción: ");
        opc = entrada.nextInt();
        entrada.nextLine();
        switch(opc){
            case 1: System.out.print(" Ingrese el nuevo ID: ");
                    a = entrada.nextLine(); Usuario.setID(a);
                    System.out.println(" ID actualizado.\nRegresando al inicio..."); break;
            case 2: System.out.print(" Ingrese la nueva contraseña: ");
                    b = entrada.nextLine(); Usuario.setContraseña(b);
                    System.out.println(" Contraseña actualizada.\nRegresando al inicio..."); break;
            default: System.out.println("Opción no valida.");
        }
    }

    // METODO PARA ELIMINAR UNA CUENTA
    public void eliminar(String a,String b){
        String p;
        do{
            System.out.print("¿Estas seguro que quieres eliminar tu cuenta permanentemente? (SI o NO): ");
            p = entrada.next(); p.toUpperCase();
            if(p.equals("SI")){
                int x=0;
                for(int i=0;i<usuarios.length;i++){
                    if(usuarios[i].getID().equals(a) && usuarios[i].getContraseña().equals(b)){
                        x = i; break;
                    }
                }
                for (int i = x; i < usuarios.length - 1; i++) {
                    usuarios[i] = usuarios[i + 1];
                }
                segundaRedimension();
                System.out.println("Eliminación exitosa.\nRegresando al inicio...");
            }
            else if(p.equals("NO")){
                System.out.println("No se procedió con la eliminación.\nRegresando al inicio...");
            }
            else{
                System.out.println("Opcion no valida, ingrese nuevamente.");
            }
        }while(!p.equals("SI") && !p.equals("NO"));    
    }
}