import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Modificacionficheros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaArchivo = "F:/Programacion ciclo superior/carpeta codigos python/usuarios.txt";
        String opcion = "";

        while (!opcion.equals("4")) {
            System.out.println("\n////////Bienvenido al menú de modificación de ficheros/////////\n");
            System.out.println("Elige la opción que desees dependiendo de tu necesidad:");
            System.out.println("1) Buscar el DNI");
            System.out.println("2) Agregar un nuevo usuario a la lista");
            System.out.println("3) Eliminar un usuario de la lista 😈");
            System.out.println("4) Salir del menú :(");

            System.out.print("\nElige la opción que quieras: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el DNI que desea buscar: ");
                    String dniBuscado = scanner.nextLine();
                    buscarDni(rutaArchivo, dniBuscado);
                    break;
                case "2":
                    System.out.print("Ingrese los datos del usuario que desea agregar: ");
                    String usuario = scanner.nextLine();
                    agregarUsuario(rutaArchivo, usuario);
                    System.out.println("Usuario agregado correctamente.");
                    break;
                case "3":
                    System.out.print("Ingrese el DNI del usuario que desea eliminar: ");
                    String usuarioEliminar = scanner.nextLine();
                    eliminarUsuario(rutaArchivo, usuarioEliminar);
                    System.out.println("Usuario eliminado correctamente.");
                    break;
                case "4":
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción inválida, elige otra.");
                    break;
            }
        }
        scanner.close();
    }

    public static void buscarDni(String rutaArchivo, String dniBuscado) {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.contains(dniBuscado)) {
                    System.out.println("DNI encontrado: " + linea);
                    scanner.close();
                    return;
                }
            }
            scanner.close();
            System.out.println("DNI no encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void agregarUsuario(String rutaArchivo, String usuario) {
        try {
            FileWriter writer = new FileWriter(rutaArchivo, true);
            writer.write(usuario + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarUsuario(String rutaArchivo, String dniUsuarioEliminar) {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));
            StringBuilder nuevosDatos = new StringBuilder();
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (!linea.contains(dniUsuarioEliminar)) {
                    nuevosDatos.append(linea).append("\n");
                }
            }
            scanner.close();

            FileWriter writer = new FileWriter(rutaArchivo);
            writer.write(nuevosDatos.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
