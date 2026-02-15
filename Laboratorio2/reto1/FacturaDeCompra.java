import java.util.Arrays;

public class FacturaDeCompra {

    private static String[][] productosComprados;
    private static int indice = 0;

    public FacturaDeCompra() {
        productosComprados = new String[100][3];
    }

    public void agregarAlCarrito(Productos producto, int cantidad){
        productosComprados[indice][0] = producto.getNombre();
        productosComprados[indice][1] = String.valueOf(producto.getPrecio());
        productosComprados[indice][2] = String.valueOf(cantidad);
        indice++;
    }

    public static void mostrarFactura(String cliente){
        System.out.println("--- Factura de Compra ---");
        System.out.println("Cliente: " + cliente);
        System.out.println("Productos Comprados:");

        Arrays.stream(productosComprados)
            .filter(fila -> fila != null && fila[0] != null)
            .forEach(fila -> 
                System.out.println(fila[0] + " x" + fila[2] + " - $" + fila[1])
            );

        double subtotal = Arrays.stream(productosComprados)
            .filter(fila -> fila != null && fila[0] != null)
            .mapToDouble(fila -> 
                Double.parseDouble(fila[1]) * Integer.parseInt(fila[2])
            )
            .sum();

        double descuento = 0;
        if(cliente.equalsIgnoreCase("nuevo")){
            descuento = subtotal * 0.05;
        } else if(cliente.equalsIgnoreCase("frecuente")){
            descuento = subtotal * 0.10;
        }
        double total = subtotal - descuento;

        System.out.println("● Subtotal: $" + String.format("%,.0f", subtotal));
        System.out.println("● Descuento aplicado: $" + String.format("%,.0f", descuento));
        System.out.println("● Total a pagar: $" + String.format("%,.0f", total));
    }

}
