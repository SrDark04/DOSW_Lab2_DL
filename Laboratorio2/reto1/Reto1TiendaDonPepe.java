import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Reto1TiendaDonPepe {

    private static ArrayList<Productos> productos = new ArrayList<>();
    private ManejoDeTienda manejo = new ManejoDeTienda();

    public static void ejecutar(){
        System.out.println("Bienvenido a la tienda de Don Pepe");
        cargarProductos();
        mostrarMenu();
    }

    public static void cargarProductos(){
        System.out.println("Cargando productos...");
        
        try (BufferedReader br = new BufferedReader(new FileReader("reto1/productos.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                String tipo = datos[0];
                String nombre = datos[1];
                double valor = Double.parseDouble(datos[2]);
                String descripcion = datos[3];

                Productos p = FabricaDeProductos.crearProducto(
                        tipo, nombre, valor, descripcion);

                productos.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarMenu(){
        
    }
    
}