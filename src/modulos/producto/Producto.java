package modulos.producto;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String descripcion;

    public Producto(int id, String nombre, double precio, String descripcion) {
        this.setId(id);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 1) {
            this.id = id;
        } else {
            System.out.println("ERROR: El ID no puede ser menor a 1.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("ERROR: Nombre no puede estar vacío.");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("ERROR: Precio debe ser mayor a 0.");
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            System.out.println("ERROR: Descripción no puede estar vacía.");
        }
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    // ==========================================
    // MÉTODOS Y VALIDACIONES AGREGADOS
    // ==========================================

    // NUEVO MÉTODO: Calcular precio con descuento
    public double calcularPrecioConDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            System.out.println("ERROR: Porcentaje debe estar entre 0 y 100.");
            return this.precio;
        }
        double descuento = this.precio * (porcentaje / 100);
        return this.precio - descuento;
    }

    // NUEVO MÉTODO: Calcular IVA (13% en El Salvador)
    public double calcularIVA() {
        return this.precio * 0.13;
    }

    // NUEVO MÉTODO: Precio total con IVA
    public double getPrecioConIVA() {
        return this.precio + calcularIVA();
    }

    // NUEVO MÉTODO: Comparar precio con otro producto
    public int compararPrecio(Producto otro) {
        return Double.compare(this.precio, otro.getPrecio());
    }

    // NUEVO MÉTODO: Validar que el nombre no contenga caracteres numéricos
    public boolean validarNombreSinNumeros() {
        if (nombre != null && nombre.matches(".*\\d.*")) {
            System.out.println("ERROR: El nombre no debe contener números.");
            return false;
        }
        return true;
    }

    // NUEVO MÉTODO: Obtener categoría según precio
    public String obtenerCategoria() {
        if (this.precio < 2.00) {
            return "Económico";
        } else if (this.precio < 5.00) {
            return "Estándar";
        } else if (this.precio < 10.00) {
            return "Premium";
        } else {
            return "Lujo";
        }
    }
}