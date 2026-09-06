package modulos.inventario;

public class Inventario {
    private int idProducto;
    private int cantidad;
    private int cantidadMinima;
    
    public Inventario(int idProducto, int cantidad, int cantidadMinima) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.cantidadMinima = cantidadMinima;
    }
    
    public int getIdProducto() {
        return idProducto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }
    }
    
    public int getCantidadMinima() {
        return cantidadMinima;
    }
    
    public boolean hayDisponible(int cantidad) {
        return this.cantidad >= cantidad;
    }
    
    public void restarStock(int cantidad) {
        if (hayDisponible(cantidad)) {
            this.cantidad -= cantidad;
        }
    }
    
    public void agregarStock(int cantidad) {
        this.cantidad += cantidad;
    }
    
    @Override
    public String toString() {
        return "Inventario{" +
                "idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                ", cantidadMinima=" + cantidadMinima +
                '}';
    }
}
