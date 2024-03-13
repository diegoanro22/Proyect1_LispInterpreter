import java.util.List;
import java.util.Map;

/*La clase {Function} representa una función definida por el usuario que incluye una lista de argumentos 
y una instrucción a ejecutar.*/
public class Function{
    private List<String> arguments;
    private String instruction;


    //     * Construye una nueva instancia de {Function} con los argumentos y la instrucción especificados.

    public Function(List<String> arguments, String instruction) {
        this.arguments = arguments;
        this.instruction = instruction;
    }


    //Obtiene la lista de argumentos de la función.
    public List<String> getArguments() {
        return this.arguments;
    }

    //Establece los argumentos de la función.
    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    //Obtiene la instrucción de la función.
    public String getInstruction() {
        return this.instruction;
    }

    //Establece la instrucción de la función.
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    

    //Ejecuta la función con un conjunto dado de argumentos.
    public String execute(Map<String, Integer> argumentsHash){
        for (Map.Entry<String, Integer> entry : argumentsHash.entrySet()) {
            String key = entry.getKey(); // Obtiene la clave del mapa argumentsHash
            Integer value = entry.getValue(); // Obtiene el valor correspondiente del mapa argumentsHash

            // Encuentra el índice de la clave en la lista arguments
            int index = arguments.indexOf(key);
            instruction = instruction.replace(key, String.valueOf(value)); // Reemplaza la variable x por el valor numérico
            arguments.set(index, String.valueOf(value));
        }
        return instruction;
    }


}