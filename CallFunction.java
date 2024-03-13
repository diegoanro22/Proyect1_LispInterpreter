import java.util.HashMap;
import java.util.Map;

/* La clase {CallFunction} es responsable de ejecutar funciones definidas por el usuario a través de la instancia 
{Defun}. Esta ejecución se realiza interpretando una expresión y llamando a la función correspondiente 
con los argumentos proporcionados.*/

public class CallFunction<T> implements InterfaceFactory<T> { 
    
    // Instancia de {Defun} utilizada para acceder a las funciones definidas por el usuario.
    private final Defun<T> defunInstance;
    // Instancia de {Operation} utilizada para realizar operaciones.
    public Operation<T> operation = new Operation<>();

    /*Construye una instancia de {CallFunction} asociada con una instancia específica de {Defun}.
    La instancia que contiene las definiciones de las funciones.*/
    public CallFunction(Defun<T> defunInstance) {
        this.defunInstance = defunInstance;
    }

    //Interpreta y ejecuta una expresión dada como una llamada a función definida por el usuario.
    @Override
    public void execute(String exp) {
        String expression = evaluateExpression(exp);
        String[] partes = expression.split("\\s",2);
        String nameFunction = partes[0];
        String[] parameters = partes.length > 1 ? partes[1].split(",") : new String[0];


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

    //Evalúa y normaliza una expresión eliminando paréntesis.
    public String evaluateExpression(String expresion){
        expresion = expresion.replace("(", "").replace(")", "");
        return expresion;
    }

    //Obtiene una función por nombre a partir de las funciones definidas en {Defun}.
    public Function getFunction(String nameFunction){
        return defunInstance.functions.get(nameFunction);
    }

}