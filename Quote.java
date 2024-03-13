/*La clase {Quote} implementa la interfaz para procesar y mostrar expresiones literales, 
tal como se ingresan, sin realizar ninguna evaluación o transformación sobre ellas.*/
public class Quote<T> implements InterfaceFactory<T> {

    //Ejecuta la operación de "quote", extrayendo y mostrando la expresión literal.
    @Override
    public void execute(String exp) {
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                exp = exp.trim();
                if (exp.charAt(exp.length() - 1) == ')') {
                    exp = exp.substring(6, exp.length() - 1);
                } else {
                    exp = exp.substring(6);
                }

                System.out.println(exp);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}