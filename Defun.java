import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*La clase {Defun} implementa la interfaz para definir y almacenar funciones personalizadas. 
Permite la creación dinámica de funciones a través de expresiones pasadas como argumentos a su método {execute}.*/
public class Defun<T> implements InterfaceFactory<T> {

    //Almacena las funciones definidas por el usuario, indexadas por su nombre.
    public final Map<String, Function> functions = new HashMap<>();

    /*Interpreta y almacena una definición de función dada por la expresión. La expresión debe contener
    el nombre de la función, los argumentos y la instrucción a ejecutar. */
    @Override
    public void execute(String exp) {
        String expression = evaluateExpression(exp);

        String[] partes = expression.split("\\s",3); 
        String nameFunction = partes[0];
        List<String> args = Arrays.asList(partes[1].split(","));
        String instruction = partes[2];
        functions.put(nameFunction,new Function(args, instruction));
    }   
    

    //Normaliza la expresión eliminando paréntesis y la palabra reservada inicial "defun" y el espacio que sigue.
    public String evaluateExpression(String expresion){
        expresion = expresion.replace("(", "").replace(")", "");
        expresion = expresion.replaceFirst("^defun\\s", ""); 
        return expresion;
    }

    //Verifica si una función ya ha sido definida.
    public boolean isDefine(String functionName) {
        return functions.containsKey(functionName);
    }

}