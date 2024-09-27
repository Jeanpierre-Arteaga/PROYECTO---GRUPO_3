package PROYECTO_GRUPO_3.PRUEBAS;

import PROYECTO_GRUPO_3.CLASES.Usuarios;
import java.util.Scanner;
public class PruebaUsuarios {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        String ID,contraseña;
        int opc,n;
        Usuarios Usuarios = new Usuarios();
        do{
            System.out.println("\n1. Registrarse");
            System.out.println("2. Iniciar Sesion");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch(opc){
                case 1: System.out.println("--------------------------------");
                        System.out.println("REGISTRO DE SESION:");
                        Usuarios.registrar();
                        break;
                case 2: if (Usuarios == null) {
                            System.out.println("Primero debe registrarse.");
                            break;
                        }
                        System.out.println("--------------------------------");
                        System.out.println("INICIO DE SESION:");
                        System.out.print("Ingrese su ID: ");
                        ID = entrada.nextLine();
                        System.out.print("Ingrese su contraseña: ");
                        contraseña = entrada.nextLine();
                        if(Usuarios.iniciar(ID,contraseña)){
                            System.out.println("Inicio de sesión correcto.");
                            System.out.println("--------------------------------");
                            System.out.println(Usuarios.bienvenida(ID,contraseña));
                            System.out.println("--------------------------------");
                            do{
                                System.out.println("\nMENU DE OPCIONES:");
                                System.out.println("1. Mostrar datos personales");
                                System.out.println("2. Mostrar saldo en la cuenta");
                                System.out.println("3. Agregar productos reciclables a un contenedor");
                                System.out.println("4. Mostrar estado de un contenedor");
                                System.out.println("5. Actualizar datos personales");
                                System.out.println("6. Actualizar ID o contraseña");
                                System.out.println("7. Eliminar cuenta");
                                System.out.println("8. Salir");
                                System.out.print("Ingrese una opción: ");
                                n = entrada.nextInt();
                                switch(n){
                                    case 1: System.out.println(Usuarios.datos(ID,contraseña)); break;
                                    case 2: System.out.println("EL SALDO ACTUAL DE USTED ES: "+
                                            Usuarios.mostrarSaldo(ID,contraseña));
                                            break;
                                    case 3: Usuarios.agregar_1(ID,contraseña); break;
                                    case 4: Usuarios.estadoContenedores(); break;
                                    case 5: Usuarios.actualizar_1(ID,contraseña); break;
                                    case 6: Usuarios.actualizar_2(ID,contraseña); break;
                                    case 7: Usuarios.eliminar(ID,contraseña); break;
                                    case 8: System.out.println("Saliendo de la cuenta..."); break;
                                    default: System.out.println("Opción no valida");
                                }
                            }while(n!=6 && n!=7 && n!=8);
                            break;
                        }
                        else{
                            System.out.println("ID o contraseña incorrectos.");
                        }
                        break;
                case 3: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción no valida.");
            }
        }while(opc!=3);
        entrada.close();
    }
}