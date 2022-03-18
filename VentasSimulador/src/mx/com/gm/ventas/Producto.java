package mx.com.gm.ventas;

public class Producto {
    private final int idProducto;
    private String nombre;
    private double precio;
    private static int contadorProductos; //Esta variable se relaciona con la clase y NO con el objeto.
    
    /*Constructor encargado de inicilizar la var idProducto
        se incrementa cada que creemos un nuevo objeto*/
    private Producto(){ //private para que no se modifique
        this.idProducto = ++contadorProductos;
    }

    public Producto(String nombre, double suledo) {
        this(); //mandamos llamar el constructor vacio para que se inicialize. Tiene que ser la primera linea de codigo.(dentro de este constructor)
        this.nombre = nombre;
        this.precio = suledo;
    }

    public int getIdProducto() {
        return idProducto;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double suledo) {
        this.precio = suledo;
    }    

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
}
