package utilidades;

public class Validaciones {
    
    public static boolean esEmailValido(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    public static boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{8}");
    }
    
    public static boolean esMontoValido(double monto) {
        return monto > 0;
    }
    
    public static boolean esNombreValido(String nombre) {
        return nombre != null && nombre.length() > 0 && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]+");
    }
}
