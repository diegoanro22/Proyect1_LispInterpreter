import java.util.HashMap;
import java.util.Map;

//La clase {SetQ} implementa la interfaz para asignar valores a variables y almacenarlos en un mapa.
public class SetQ<T> implements InterfaceFactory<T> {

    //Almacena los valores de las variables, con el nombre de la variable como clave y el valor de la variable como valor.
    public final Map<String, T> variableValues = new HashMap<>();

    /*Ejecuta la operación de asignación de valor a una variable dada una expresión que contiene el nombre de la variable 
    y el valor a asignar.*/
    @Override
    public void execute(String exp) {
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                exp = exp.substring(0, exp.length() - 1);

                String[] parts = exp.split(" ");
                if (parts.length < 3) {
                    System.out.println("Faltan argumentos para 'setq'");
                    return;
                }

                String variable = parts[1];
                @SuppressWarnings("unchecked")
                T value = (T) parts[2];

                setq(variable, value);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /*Asigna un valor a una variable identificada por su nombre. Si la variable ya existe, su valor es actualizado; 
    de lo contrario, se crea una nueva entrada en el mapa de valores de variables. */
    private void setq(String variable, T value) {
        variableValues.put(variable, value);
    }
}