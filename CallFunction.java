import java.util.HashMap;
import java.util.Map;

public class CallFunction<T> implements InterfaceFactory<T> { 
    
    private final Defun<T> defunInstance;
    public Operation<T> operation = new Operation<>();

    public CallFunction(Defun<T> defunInstance) {
        this.defunInstance = defunInstance;
    }

    @Override
    public void execute(String exp) {
        String expression = evaluateExpression(exp);
        String[] partes = expression.split("\\s",2);
        String nameFunction = partes[0];
        String[] parameters = partes[1].split(",") ;


        Function funcion = getFunction(nameFunction);

        if (parameters.length != funcion.getArguments().size()) {
            System.out.println("Número incorrecto de argumentos para la función: " + nameFunction);
            return;
        }
        
        Map<String, Integer> arguments = new HashMap<>();
        for (int i = 0; i < funcion.getArguments().size(); i++) {
            arguments.put(funcion.getArguments().get(i), Integer.parseInt(parameters[i]));
        }

        
        String result = funcion.execute(arguments);

        if (result.contains(nameFunction)){
            int num = Integer.parseInt(result.split(" ")[1]);

            String expressionfunction = result.substring(result.indexOf('-')).trim();
            String[] partes2 = expressionfunction.split("\\s", 3);
            double resultado = num;

            while (num > 1 ){
                String nuevaExpresion = partes2[0] + " " + num + " " + partes2[2];
                resultado*= operation.execute2(nuevaExpresion);
                num-=1;
            }
            System.out.println(resultado);

        }
        else{
            char firstChar = result.charAt(0);
            if (firstChar == '+' || firstChar == '-' || firstChar == '*' || firstChar == '/') {
                operation.execute(result);
            } else {
                System.out.println("El resultado es: " + result);
            }
        }

        
        
    }

    public String evaluateExpression(String expresion){
        expresion = expresion.replace("(", "").replace(")", "");
        return expresion;
    }

    public Function getFunction(String nameFunction){
        return defunInstance.functions.get(nameFunction);
    }

}
