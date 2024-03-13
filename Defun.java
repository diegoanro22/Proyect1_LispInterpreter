import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Defun<T> implements InterfaceFactory<T> {

    public final Map<String, Function> functions = new HashMap<>();

    @Override
    public void execute(String exp) {
        String expression = evaluateExpression(exp);

        String[] partes = expression.split("\\s",3); 
        String nameFunction = partes[0];
        List<String> args = Arrays.asList(partes[1].split(","));
        String instruction = partes[2];
        functions.put(nameFunction,new Function(args, instruction));
    }   
    

    public String evaluateExpression(String expresion){
        expresion = expresion.replace("(", "").replace(")", "");
        expresion = expresion.replaceFirst("^defun\\s", "");   // quitar la palabra reservada defun y el espacio que sigue
        return expresion;
    }

    public boolean isDefine(String functionName) {
        return functions.containsKey(functionName);
    }

}


