
public abstract class FabricaDeProductos {
    
    public static Productos crearProducto(String tipo, String nombre, double precio, String descripcion) {
        switch (tipo.toLowerCase()) {
            case "Cárnicos":
                return new Carnicos(nombre, precio, descripcion);
            case "Ropa":
                return new Ropa(nombre, precio, descripcion);
            case "Empaquetados":
                return new Empaquetados(nombre, precio, descripcion);
            case "Dulces":
                return new Dulces(nombre, precio, descripcion);
            case "Bebidas":
                return new Bebidas(nombre, precio, descripcion);
            default:
                throw new IllegalArgumentException("Tipo de producto no reconocido: " + tipo);
        }
    }
}
