import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Defun<T> implements InterfaceFactory<T> {

    public final Map<String, Function> funciones = new HashMap<>();

    @Override
    public void execute(String exp) {
        String expression = evaluateExpression(exp);

        String[] partes = expression.split("\\s"); 
        String nameFunction = partes[0];
        List<String> args = List.of(partes[1]);
        String instruction = partes[2];
        funciones.put(nameFunction,new Function(args, instruction));

    }   
    

    public String evaluateExpression(String expresion){
        expresion = expresion.replace("(", "").replace(")", "");
        expresion = expresion.replaceFirst("^defun\\s", "");   // quitar la palabra reservada defun y el espacio que sigue
        return expresion;
    }


}


