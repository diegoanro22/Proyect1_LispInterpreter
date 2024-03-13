/*La clase {Princ} implementa la interfaz para imprimir el valor de una variable especificada en una expresión. 
Utiliza una instancia de {SetQ} para buscar el valor de la variable e imprimirlo.*/
public class Princ<T> implements InterfaceFactory<T> {

    private final SetQ<T> setQInstance;

    /*Construye una instancia de {Princ} con una referencia a una instancia de {SetQ}.
    Esto permite a {Princ} acceder a los valores de las variables almacenadas en {SetQ}.*/
    public Princ(SetQ<T> setQInstance) {
        this.setQInstance = setQInstance;
    }

    /*Ejecuta la operación de impresión para la variable especificada en la expresión. Si la variable
    existe en {SetQ}, imprime su valor; de lo contrario, notifica que la variable no fue encontrada.*/
    @Override
    public void execute(String exp) {
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                exp = exp.substring(0, exp.length() - 1);

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