package modulos.cliente;

public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String telefono;

    public Cliente(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // VALIDACIONES
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty() && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]+")) {
            this.nombre = nombre;
        } else {
            System.out.println("ERROR: Nombre inválido. Debe contener solo letras.");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("ERROR: Email inválido. Debe contener @ y punto.");
        }
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{8}")) {
            this.telefono = telefono;
        } else {
            System.out.println("ERROR: Teléfono inválido. Debe tener 8 dígitos.");
        }
    }

    // NUEVO MÉTODO: Validar cliente completo
    public boolean esClienteValido() {
        return nombre != null && !nombre.isEmpty() &&
                email != null && email.contains("@") &&
                telefono != null && telefono.matches("\\d{8}") &&
                id >= 1;
    }

    // NUEVO MÉTODO: Obtener dominio del email
    public String obtenerDominioEmail() {
        if (email != null && email.contains("@")) {
            return email.substring(email.indexOf("@"));
        }
        return "Sin email";
    }
}