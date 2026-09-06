package utilidades;

public class Validaciones {

    // VALIDACIÓN DE EMAIL (mejorada)
    public static boolean esEmailValido(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Debe tener @ y punto
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }

        // @ no puede estar al principio ni al final
        int posArroba = email.indexOf("@");
        if (posArroba == 0 || posArroba == email.length() - 1) {
            return false;
        }

        // No puede haber varios @
        if (email.indexOf("@") != email.lastIndexOf("@")) {
            return false;
        }

        return true;
    }

    // VALIDACIÓN DE TELÉFONO (mejorada)
    public static boolean esTelefonoValido(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            return false;
        }

        // Debe tener exactamente 8 dígitos
        return telefono.matches("\\d{8}");
    }

    // VALIDACIÓN DE MONTO
    public static boolean esMontoValido(double monto) {
        return monto > 0;
    }

    // VALIDACIÓN DE NOMBRE (mejorada)
    public static boolean esNombreValido(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre.length() < 2) {
            return false;
        }

        // Solo letras, espacios y acentos
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚ\\s]+");
    }

    // NUEVAS VALIDACIONES

    // Validar URL
    public static boolean esURLValida(String url) {
        if (url == null || url.isEmpty()) {
            return false;
        }

        return url.startsWith("http://") || url.startsWith("https://");
    }

    // Validar código postal (formato: 12345)
    public static boolean esCodigoPostalValido(String codigoPostal) {
        if (codigoPostal == null || codigoPostal.isEmpty()) {
            return false;
        }

        return codigoPostal.matches("\\d{5}");
    }

    // Validar cantidad (número entero positivo)
    public static boolean esCantidadValida(int cantidad) {
        return cantidad > 0;
    }

    // Validar descripción (mínimo 10 caracteres)
    public static boolean esDescripcionValida(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            return false;
        }

        return descripcion.length() >= 10;
    }

    // MÉTODOS UTILITARIOS

    // Limpiar espacios en blanco excesivos
    public static String limpiarEspacios(String texto) {
        if (texto == null) {
            return "";
        }

        // Quitar espacios al inicio y final
        texto = texto.trim();

        // Quitar espacios múltiples
        texto = texto.replaceAll("\\s+", " ");

        return texto;
    }

    // Formatear teléfono (12345678 → 1234-5678)
    public static String formatearTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{8}")) {
            return "Teléfono inválido";
        }

        return telefono.substring(0, 4) + "-" + telefono.substring(4);
    }

    // Convertir a mayúsculas de forma segura
    public static String aTextoMayuscula(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        return texto.toUpperCase();
    }

    // Convertir a minúsculas de forma segura
    public static String aTextoMinuscula(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        return texto.toLowerCase();
    }

    // Capitalizar (primera letra mayúscula, resto minúscula)
    public static String capitalizarTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    // Obtener mensaje de error descriptivo
    public static String obtenerMensajeError(String tipoDato, String valor) {
        switch(tipoDato.toLowerCase()) {
            case "email":
                return esEmailValido(valor) ? "OK" : "Email inválido. Debe contener @ y punto.";
            case "telefono":
                return esTelefonoValido(valor) ? "OK" : "Teléfono inválido. Debe tener 8 dígitos.";
            case "nombre":
                return esNombreValido(valor) ? "OK" : "Nombre inválido. Solo se permiten letras y espacios.";
            case "monto":
                try {
                    double monto = Double.parseDouble(valor);
                    return esMontoValido(monto) ? "OK" : "Monto inválido. Debe ser mayor a 0.";
                } catch (NumberFormatException e) {
                    return "Monto inválido. Debe ser un número.";
                }
            case "url":
                return esURLValida(valor) ? "OK" : "URL inválida. Debe comenzar con http:// o https://";
            default:
                return "Tipo de dato desconocido.";
        }
    }

    // Validar que una contraseña sea fuerte (mínimo requisitos)
    public static boolean esContraseñaFuerte(String contrasena) {
        if (contrasena == null || contrasena.length() < 8) {
            return false;
        }

        // Debe tener al menos: mayúscula, minúscula y número
        boolean tieneMayuscula = contrasena.matches(".*[A-Z].*");
        boolean tieneMinuscula = contrasena.matches(".*[a-z].*");
        boolean tieneNumero = contrasena.matches(".*\\d.*");

        return tieneMayuscula && tieneMinuscula && tieneNumero;
    }

    // Validar ID o Cédula (formato simple)
    public static boolean esIDValido(String id) {
        if (id == null || id.isEmpty()) {
            return false;
        }

        // Acepta números y guiones (ej: 12345-6789)
        return id.matches("\\d{5}-\\d{4}");
    }

    // Validar color hexadecimal (#RGB o #RRGGBB) — agregado por Estudiante 2
    public static boolean esColorHexValido(String color) {
        if (color == null || color.isEmpty()) {
            return false;
        }
        return color.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
    }

    // Validar número de tarjeta de crédito (algoritmo de Luhn) — agregado por Estudiante 2
    public static boolean esNumeroTarjetaValido(String numero) {
        if (numero == null || numero.isEmpty()) {
            return false;
        }

        // Quitar espacios y guiones antes de validar
        String limpio = numero.replaceAll("[\\s-]", "");

        // Debe tener entre 13 y 19 dígitos
        if (!limpio.matches("\\d{13,19}")) {
            return false;
        }

        // Algoritmo de Luhn
        int suma = 0;
        boolean alternar = false;
        for (int i = limpio.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(limpio.charAt(i));
            if (alternar) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
                  suma += digito;
            alternar = !alternar;
        }

        return suma % 10 == 0;
    }
}

        return suma % 10 == 0;
    }
