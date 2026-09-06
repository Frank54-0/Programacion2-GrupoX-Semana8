package modulos.pedido;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private int idCliente;
    private double total;
    private LocalDate fecha;
    private String estado;
    
    public Pedido(int id, int idCliente, double total) {
        if (id < 1) {
            throw new IllegalArgumentException("El id no puede ser menor a 1");
        }
        if (idCliente < 1) {
            throw new IllegalArgumentException("El idCliente no puede ser menor a 1");
        }
        if (total <= 0) {
            throw new IllegalArgumentException("El total debe ser mayor a 0");
        }
        this.id = id;
        this.idCliente = idCliente;
        this.total = total;
        this.fecha = LocalDate.now();
        this.estado = "Pendiente";
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        if (total > 0) {
            this.total = total;
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (esEstadoValido(estado)) {
            this.estado = estado;
        }
    }

    private boolean esEstadoValido(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            return false;
        }
        return estado.equals("Pendiente") || estado.equals("Procesado")
                || estado.equals("Enviado") || estado.equals("Entregado")
                || estado.equals("Cancelado");
    }

    public boolean cambiarEstado(String nuevoEstado) {
        if (esEstadoValido(nuevoEstado)) {
            this.estado = nuevoEstado;
            return true;
        }
        return false;
    }

    public long diasDesdeCompra() {
        return java.time.temporal.ChronoUnit.DAYS.between(fecha, LocalDate.now());
    }

    public boolean cancelarPedido() {
        if (estado.equals("Entregado") || estado.equals("Cancelado")) {
            return false;
        }
        estado = "Cancelado";
        return true;
    }

    public String obtenerEstadoDetallado() {
        return "Pedido #" + id + " - Cliente " + idCliente + " - Estado: " + estado
                + " - Total: " + total + " - Dias desde compra: " + diasDesdeCompra();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", total=" + total +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                '}';
    }
}