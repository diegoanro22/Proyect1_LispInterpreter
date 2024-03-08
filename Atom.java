import java.util.Scanner;

public class Atom<T> implements InterfaceFactory<T> {

    private static Scanner scanner = new Scanner(System.in);
    private T value;

    public Atom(T value) {
        this.value = value;
    }

    // Marcado para futura implementación
    @Override
    public void execute(String exp) {
        // TODO: Implementar este método de acuerdo con las especificaciones de InterfaceFactory.
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    public void execute() {
        while (true) {
            System.out.println("Introduce un comando:");
            String command = scanner.next();

            if (command.equals("Atom")) {
                System.out.println("Esta implementación simplificada no permite la creación dinámica de Atom con tipos genéricos desde la entrada del usuario debido a limitaciones de tipo en tiempo de ejecución.");
            } else if (command.equals("princ")) {
                princ();
            } else {
                System.out.println("Comando no reconocido.");
            }
        }
    }

    private void princ() {
        System.out.println("Detalles del Atom: " + this);
    }

    public T getValue() {
        return this.value;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public String printTypeIndicator() {
        if (isNumber()) {
            return "Número";
        } else {
            return "nill";
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}