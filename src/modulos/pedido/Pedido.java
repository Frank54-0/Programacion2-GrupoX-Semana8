package modulos.pedido;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private int idCliente;
    private double total;
    private LocalDate fecha;
    private String estado;
    
    public Pedido(int id, int idCliente, double total) {
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
        this.estado = estado;
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
