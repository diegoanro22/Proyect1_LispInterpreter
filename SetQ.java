import java.util.Map;

public class SetQ<T> implements InterfaceFactory<T> {

    private final Map<String, T> variableValues;

    public SetQ(Map<String, T> variableValues) {
        this.variableValues = variableValues;
    }

    @Override
    public void execute(String exp) {
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                String[] parts = exp.split(" ");
                if (parts.length < 3) {
                    System.out.println("Faltan argumentos para 'setq'");
                    return;
                }
                
                String variable = parts[1];
                T value = (T) parts[2];
                
                setq(variable, value);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setq(String variable, T value) {
        variableValues.put(variable, value);
    }
}
