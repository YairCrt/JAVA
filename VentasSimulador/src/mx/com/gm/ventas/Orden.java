package mx.com.gm.ventas;

public class Orden {
    private int idOrden;
    private Producto productos[];
    private static int contadorOrdenes;
    private int contadorProductos; //var para saber cuantos obj de tipo Productos se han agregado al objeto Orden.
    private static final int MAX_PRODUCTOS = 10; //Si se sobrepasan 10 productos ya no se puede agregar mas
    
    public Orden(){
        this.idOrden = ++contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS]; //Inicializa el arreglo de productos para poder agregar elementos al arreglo.
    }
    
    //Metodo para agregar un nuevo producto al arreglo de productos.
    public void agregarProducto(Producto producto){
        if(this.contadorProductos < Orden.MAX_PRODUCTOS){
            this.productos[this.contadorProductos++] = producto;
        }
        else{
            System.out.println("Se ha superado el máximo de productos: " + Orden.MAX_PRODUCTOS);
        }
    }
    //Metodo para iterar los elementos del arreglo que contienen un valor distinto de null:
    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++) { //Para valores distintos de null utilizamos contadorProductos, que son los que ya se inicializaron.
            Producto producto = this.productos[i];
            //total += producto.getPrecio(); Alternativa 1
            total += this.productos[i].getPrecio(); //Alternativa 2: Estamos obteniendo el precio de c producto para obtener el total
        }
        return total;
    }
    
    public void mostrarOrden(){
        System.out.println("Id Orden: " + this.idOrden);
        double totalOrden = this.calcularTotal();
        System.out.println("Total de la Orden: $" + totalOrden);
        System.out.println("Productos de la Orden: ");
        for (int i = 0; i < this.contadorProductos; i++) {
            System.out.println(this.productos[i]);//Se imprime el objeto de tipo producto. Se llama al metodo toString de forma autom.
        }
    }
    
    
}
