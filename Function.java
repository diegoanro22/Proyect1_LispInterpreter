import java.util.List;

public class Function {
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
    



}
