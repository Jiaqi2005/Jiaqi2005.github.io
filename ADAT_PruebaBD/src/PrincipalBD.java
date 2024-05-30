import java.util.Scanner;

public class PrincipalBD {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        AccesoBD miAcceso = new AccesoBD();
        boolean seguir = true;

        while (seguir) {
            System.out.println("Introduce: \n 1 para insertar \n 2 para modificar \n 3 para borrar \n 4 para leer "
                    + "\n 5 para busqueda por id \n 6 para busqueda por campo y valor \n 7 para busqueda por valor en cualquier campo \n 8 para finalizar");
            int opcion = teclado.nextInt();
            teclado.nextLine(); 

            if (opcion == 1) {
                System.out.println("Introduce el id");
                int id = teclado.nextInt();
                teclado.nextLine();

                System.out.println("Introduce el nombre");
                String nombre = teclado.nextLine();

                System.out.println("Introduce una descripcion");
                String descripcion = teclado.nextLine();

                System.out.println("Introduce la caracteristica");
                String caracteristica = teclado.nextLine();

                System.out.println("Introduce la edad");
                int edad = teclado.nextInt();
                Jugador jugador = new Jugador(id, nombre, descripcion, caracteristica, edad);

                miAcceso.pruebaInsert(jugador);
                miAcceso.pruebaRead();
                
            } else if (opcion == 2) {
                System.out.println("Introduce el id a modificar");
                int id = teclado.nextInt();
                teclado.nextLine();

                System.out.println("Introduce el nombre");
                String nombre = teclado.nextLine();

                System.out.println("Introduce una descripcion");
                String descripcion = teclado.nextLine();

                System.out.println("Introduce la caracteristica");
                String caracteristica = teclado.nextLine();

                System.out.println("Introduce la edad");
                int edad = teclado.nextInt();
                Jugador jugador = new Jugador(id, nombre, descripcion, caracteristica, edad);

                miAcceso.pruebaUpdate(jugador);
                miAcceso.pruebaRead();
                
            } else if (opcion == 3) {
                System.out.println("Introduce el id a borrar");
                int id = teclado.nextInt();
                Jugador jugador = new Jugador(id);

                miAcceso.pruebaBorrar(jugador);
                miAcceso.pruebaRead();
                
            } else if (opcion == 4) {
                miAcceso.pruebaRead();
                
            } else if (opcion == 5) {
                System.out.println("Introduce el ID a buscar");
                int id = teclado.nextInt();
                miAcceso.buscarPorId(id);
                
            } else if (opcion == 6) {
                System.out.println("Introduce el campo a buscar");
                String campo = teclado.nextLine();
                System.out.println("Introduce el valor a buscar");
                String valorCampo = teclado.nextLine();
                miAcceso.buscarPorCampoYValor(campo, valorCampo);
                
            } else if (opcion == 7) {
                System.out.println("Introduce el valor a buscar en cualquier campo");
                String valorCualquierCampo = teclado.nextLine();
                miAcceso.buscarPorValorEnCualquierCampo(valorCualquierCampo);
                
            } else if (opcion == 8) {
                seguir = false;
                System.out.println("Adios");
            } else {
                System.out.println("Opción no válida. Por favor, introduce un número entre 1 y 8.");
            }

            if (seguir && opcion != 8) {
                System.out.println("¿Quieres seguir preguntando? Si o No");
                String respuesta = teclado.next();
                teclado.nextLine();

                if (!respuesta.equalsIgnoreCase("Si")) {
                    seguir = false;
                    System.out.println("Adios");
                }
            }
        }
        teclado.close();
    }
}
