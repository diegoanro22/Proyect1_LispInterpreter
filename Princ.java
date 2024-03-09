import java.util.HashMap;
import java.util.Map;

public class Princ<T> implements InterfaceFactory<T> {

    private SetQ setq ;

    public Princ() {
        this.setq = SetQ.getInstance(); // Obtener la instancia única
    }

    @Override
    public void execute(String exp) {
        Map<String,T> variableValues = setq.variableValues;
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                String[] parts = exp.split(" ");
                if (parts.length < 2) {
                    System.out.println("Faltan argumentos para 'princ'");
                    return;
                }

                String variable = parts[1];

                T value = variableValues.get(variable);
                if (value != null) {
                    System.out.println(value);
                } else {
                    System.out.println("Variable '" + variable + "' no encontrada.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

