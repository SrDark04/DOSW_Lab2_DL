import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.*;

public class Reto1TiendaDonPepe {

    private static ArrayList<Productos> productos = new ArrayList<>();
    private static ManejoDeTienda manejo = new ManejoDeTienda();
    private static String cliente;
    private static Scanner scn = new Scanner(System.in);

    public static void ejecutar(){
        System.out.println(ManejoDeTienda.BIENVENIDA);
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
        boolean tiendaAbierta = true;
        cliente = scn.nextLine();
        while(tiendaAbierta){
            System.out.println(ManejoDeTienda.MENU);
            int opcion = scn.nextInt();
            scn.nextLine(); // ✅ LIMPIA EL BUFFER

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    iniciarCompra();
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println(ManejoDeTienda.OPCION_INVALIDA);
                    return;
            }
        }
    }

    
    public static void mostrarProductos(){
        System.out.println(ManejoDeTienda.MUESTRA_PRODUCTOS);
        int limite = productos.size();
        String productosDisponibles = IntStream.range(0, limite)
                    .mapToObj(i -> (i + 1) + ". " + productos.get(i).getNombre() +
                    " - $" + productos.get(i).getPrecio() + " - " +
                    productos.get(i).getDescripcion())
                .reduce("", (a, b) -> a + b + "\n");
        System.out.println(productosDisponibles);
    }

    public static void iniciarCompra(){
        System.out.println(ManejoDeTienda.SELECCIONAR_PRODUCTO);
        FacturaDeCompra factura = new FacturaDeCompra();
        entradaDeProductos(factura);
        factura.mostrarFactura(cliente);
    }
        
    public static void entradaDeProductos(FacturaDeCompra factura){
        boolean comprando = true;
        while(comprando){
            String entrada = scn.nextLine();

            if(entrada.equals("0")){
                comprando = false;
                continue;
            }

            String[] partes = entrada.split(",");
            if(partes.length == 2){
                factura.agregarAlCarrito(
                    productos.get(Integer.parseInt(partes[0]) - 1),
                    Integer.parseInt(partes[1])
                );
            }
        }
    }

    public static void main(String[] args) {
        ejecutar();
    }
}