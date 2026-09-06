package modulos.inventario;

public class Inventario {
    private int idProducto;
    private int cantidad;
    private int cantidadMinima;

    
    public int getIdProducto() {
        return idProducto;
    }
    
    public int getCantidad() {
        return cantidad;
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
    // VALIDACIONES MEJORADAS

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("ERROR: Cantidad no puede ser negativa.");
        }
    }

    // MEJORA: agregar validación en constructor
    public Inventario(int idProducto, int cantidad, int cantidadMinima) {
        if (idProducto < 1) {
            System.out.println("ERROR: ID de producto debe ser mayor a 0.");
            this.idProducto = 1; // valor por defecto
        } else {
            this.idProducto = idProducto;
        }

        this.cantidad = cantidad >= 0 ? cantidad : 0;
        this.cantidadMinima = cantidadMinima >= 0 ? cantidadMinima : 0;
    }

    // NUEVO MÉTODO: Verificar si necesita reorden
    public boolean necesitaReorden() {
        return this.cantidad <= this.cantidadMinima;
    }

    // NUEVO MÉTODO: Obtener estado del stock
    public String obtenerEstadoStock() {
        if (necesitaReorden()) {
            return "BAJO - REORDEN URGENTE";
        } else if (this.cantidad < this.cantidadMinima * 2) {
            return "NORMAL";
        } else {
            return "ALTO";
        }
    }

    // NUEVO MÉTODO: Calcular porcentaje de stock
    public double calcularPorcentajeStock(int cantidadMaxima) {
        if (cantidadMaxima <= 0) {
            return 0;
        }
        return (this.cantidad * 100.0) / cantidadMaxima;
    }

    // NUEVO MÉTODO: Cuánto falta para llegar a cantidadMinima
    public int calcularFaltanteParaMinimo() {
        if (this.cantidad < this.cantidadMinima) {
            return this.cantidadMinima - this.cantidad;
        }
        return 0;
    }

    // NUEVO MÉTODO: Información detallada del inventario
    public String obtenerInformacionDetallada() {
        return "Producto ID: " + this.idProducto + "\n" +
                "Cantidad actual: " + this.cantidad + "\n" +
                "Cantidad mínima: " + this.cantidadMinima + "\n" +
                "Estado: " + obtenerEstadoStock() + "\n" +
                "Reorden urgente: " + (necesitaReorden() ? "SÍ" : "NO");
    }
}