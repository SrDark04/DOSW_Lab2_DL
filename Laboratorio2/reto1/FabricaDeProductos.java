
public abstract class FabricaDeProductos {
    
    public static Productos crearProducto(String tipo, String nombre, double precio, String descripcion) {
        switch (tipo.toLowerCase()) {
            case "cárnicos":
                return new Carnicos(nombre, precio, descripcion);
            case "ropa":
                return new Ropa(nombre, precio, descripcion);
            case "empaquetados":
                return new Empaquetados(nombre, precio, descripcion);
            case "dulces":
                return new Dulces(nombre, precio, descripcion);
            case "bebidas":
                return new Bebidas(nombre, precio, descripcion);
            default:
                throw new IllegalArgumentException("Tipo de producto no reconocido: " + tipo);
        }
    }
}
