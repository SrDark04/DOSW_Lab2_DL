public abstract class Productos {
    protected String nombre;
    protected double precio;
    protected String descripcion;

    public Productos(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() { return this.nombre;}

    public double getPrecio() { return this.precio; }

    public String getDescripcion() { return this.descripcion; }
}
