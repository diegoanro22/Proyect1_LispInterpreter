import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SetQ<T> implements StackInterface<T> {
    private Map<String, T> variableValues;
    private Scanner scanner;

    public SetQ() {
        this.variableValues = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        while (true) {
            String command = scanner.next();

            if (command.equals("setq")) {
                String variable = scanner.next();
                T value = (T) scanner.next();
                setq(variable, value);
            } else if (command.equals("princ")) {
                String variable = scanner.next();
                princ(variable);
            } else {
                System.out.println("Comando no reconocido.");
            }
        }
    }

    private void setq(String variable, T value) {
        variableValues.put(variable, value);
    }

    private void princ(String variable) {
        T value = variableValues.get(variable);
        if (value != null) {
            System.out.println(value);
        } else {
            System.out.println("Variable '" + variable + "' no encontrada.");
        }
    }
}