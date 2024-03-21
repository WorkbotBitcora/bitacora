package co.uco.bitacora.services;

// Clase ObservacionesService que encapsula la funcionalidad de descripción de problemas y mejoras realizadas
public class ObservacionesService {
    // Clase interna para la descripción de problemas
    public static class DescripcionProblemas {
        private String descripcion;

        // Método para que el técnico registre la descripción de los problemas encontrados
        public void registrarDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        // Método para obtener la descripción de los problemas encontrados
        public String obtenerDescripcion() {
            return descripcion;
        }
    }

    // Clase interna para las mejoras realizadas
    public static class MejorasRealizadas {
        private String mejoras;

        // Método para que el técnico registre las mejoras realizadas
        public void registrarMejoras(String mejoras) {
            this.mejoras = mejoras;
        }

        // Método para obtener las mejoras realizadas
        public String obtenerMejoras() {
            return mejoras;
        }
    }

    // Método main para probar las clases DescripcionProblemas y MejorasRealizadas
    public static void main(String[] args) {
        DescripcionProblemas descripcion = new DescripcionProblemas();
        MejorasRealizadas mejoras = new MejorasRealizadas();

        // El técnico llena la descripción de problemas
        descripcion.registrarDescripcion("El equipo no enciende.");
        // El técnico llena las mejoras realizadas
        mejoras.registrarMejoras("Se reemplazó la fuente de alimentación.");

        // Imprimir la descripción de problemas y las mejoras realizadas
        System.out.println("Descripción de los problemas encontrados:");
        System.out.println(descripcion.obtenerDescripcion());
        System.out.println("Mejoras realizadas:");
        System.out.println(mejoras.obtenerMejoras());
    }
}
