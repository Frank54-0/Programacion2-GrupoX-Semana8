package modulos.cliente;

public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String telefono;

    // --- CONSTRUCTOR ---
    // MEJORA: Se redirigen los parámetros a los setters para asegurar que las validaciones
    // se apliquen desde el momento de la instanciación y evitar datos corruptos.
    public Cliente(int id, String nombre, String email, String telefono) {
        setId(id);
        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
    }

    // --- GETTERS Y SETTERS ---
    public int getId() {
        return id;
    }

    // MEJORA: Se agrega el método setId con validación para asegurar que el ID sea mayor a 0.
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ERROR: El ID debe ser mayor a 0.");
        }
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

    // --- VALIDACIONES DE CAMPOS ---
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty() && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]+")) {
            this.nombre = nombre;
        } else {
            System.out.println("ERROR: Nombre inválido. Debe contener solo letras.");
        }
    }

    // MEJORA: Se implementa expresión regular (Regex) para validar una estructura real de email
    // (usuario@dominio.com), superando la verificación básica anterior.
    public void setEmail(String email) {
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (email != null && email.matches(regexEmail)) {
            this.email = email;
        } else {
            System.out.println("ERROR: Email inválido. Debe contener @ y un dominio válido.");
        }
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{8}")) {
            this.telefono = telefono;
        } else {
            System.out.println("ERROR: Teléfono inválido. Debe tener 8 dígitos.");
        }
    }

    // --- MÉTODOS DE CONSULTA Y ESTADO ---

    // MEJORA: Se actualiza la verificación de email usando Regex para garantizar mayor rigor
    // al determinar la validez del cliente.
    public boolean esClienteValido() {
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return nombre != null && !nombre.trim().isEmpty() &&
                email != null && email.matches(regexEmail) &&
                telefono != null && telefono.matches("\\d{8}") &&
                id >= 1;
    }

    // MEJORA: Se previene un error de índice (IndexOutOfBoundsException) verificando
    // que existan caracteres válidos después del símbolo '@'.
    public String obtenerDominioEmail() {
        if (email != null && email.contains("@")) {
            int posArroba = email.indexOf("@");
            if (posArroba < email.length() - 1) {
                return email.substring(posArroba + 1);
            }
        }
        return "Sin email o formato inválido";
    }

    // Muestra la información estructurada del cliente en formato multilínea
    public String obtenerInfoFormato() {
        return "ID: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Email: " + email + "\n" +
                "Teléfono: " + telefono;
    }

    // --- NUEVOS MÉTODOS UTILITARIOS ---

    /**
     * NUEVA FUNCIONALIDAD: Oculta los primeros dígitos del teléfono para proteger la privacidad.
     * Ejemplo: "77889900" -> "****9900"
     */
    public String obtenerTelefonoOculto() {
        if (telefono != null && telefono.length() == 8) {
            return "****" + telefono.substring(4);
        }
        return "N/A";
    }

    /**
     * NUEVA FUNCIONALIDAD: Extrae y devuelve las iniciales en mayúscula del nombre del cliente.
     * Ejemplo: "Juan Perez" -> "J.P."
     */
    public String obtenerIniciales() {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "";
        }
        String[] partes = nombre.trim().split("\\s+");
        StringBuilder iniciales = new StringBuilder();
        for (String parte : partes) {
            if (!parte.isEmpty()) {
                iniciales.append(Character.toUpperCase(parte.charAt(0))).append(".");
            }
        }
        return iniciales.toString();
    }
}