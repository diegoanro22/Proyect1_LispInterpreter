import java.util.List;
import java.util.Map;

public class Function{
    private List<String> arguments;
    private String instruction;


    public Function(List<String> arguments, String instruction) {
        this.arguments = arguments;
        this.instruction = instruction;
    }


    public List<String> getArguments() {
        return this.arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    

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
