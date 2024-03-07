import java.util.Map;

public class Princ<T> implements InterfaceFactory<T> {

    private final Map<String, T> variableValues;

    public Princ(Map<String, T> variableValues) {
        this.variableValues = variableValues;
    }

    @Override
    public void execute(String exp) {
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
