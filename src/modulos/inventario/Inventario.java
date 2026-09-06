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

    // ==========================================
    // MÉTODOS DE ANÁLISIS Y REPORTES (Estudiante 2)
    // ==========================================

    public void setCantidadMinima(int cantidadMinima) {
        if (cantidadMinima >= 0) {
            this.cantidadMinima = cantidadMinima;
        } else {
            System.out.println("ERROR: La cantidad mínima no puede ser negativa.");
        }
    }

    // NUEVO MÉTODO: Verificar si el stock supera la capacidad máxima
    public boolean estaEnExceso(int cantidadMaxima) {
        return cantidadMaxima > 0 && this.cantidad > cantidadMaxima;
    }

    // NUEVO MÉTODO: Calcular índice de rotación según unidades vendidas
    public double calcularIndiceRotacion(int unidadesVendidas) {
        if (this.cantidad <= 0 || unidadesVendidas <= 0) {
            return 0.0;
        }
        return (double) unidadesVendidas / this.cantidad;
    }

    // NUEVO MÉTODO: Clasificación del nivel de rotación
    public String clasificarRotacion(int unidadesVendidas) {
        double rotacion = calcularIndiceRotacion(unidadesVendidas);
        if (rotacion >= 3.0) {
            return "ALTA ROTACIÓN";
        } else if (rotacion >= 1.0) {
            return "ROTACIÓN MEDIA";
        } else {
            return "BAJA ROTACIÓN";
        }
    }

    // NUEVO MÉTODO: Generar reporte consolidado de inventario
    public String generarReporteConsolidado(int cantidadMaxima, int unidadesVendidas) {
        return "=== REPORTE DE INVENTARIO ===\n" +
                obtenerInformacionDetallada() + "\n" +
                "Capacidad máxima: " + cantidadMaxima + "\n" +
                "Ocupación: " + String.format("%.2f", calcularPorcentajeStock(cantidadMaxima)) + "%\n" +
                "Faltante para mínimo: " + calcularFaltanteParaMinimo() + "\n" +
                "Rotación: " + clasificarRotacion(unidadesVendidas) + " (Índice: " + String.format("%.2f", calcularIndiceRotacion(unidadesVendidas)) + ")\n" +
                "Exceso de stock: " + (estaEnExceso(cantidadMaxima) ? "SÍ" : "NO") + "\n" +
                "=============================";
    }
}