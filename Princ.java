
public class Princ<T> implements InterfaceFactory<T> {

    private final SetQ<T> setQInstance;

    public Princ(SetQ<T> setQInstance) {
        this.setQInstance = setQInstance;
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

                T value = setQInstance.variableValues.get(variable);
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

