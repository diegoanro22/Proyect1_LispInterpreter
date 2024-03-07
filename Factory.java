import java.util.Map;

public class Factory<T> {

    public InterfaceFactory<T> createStack(String reservedWord, Map<String, T> variableValues) {
        switch (reservedWord) {
            case "setq":
                return new SetQ<>(variableValues);
            case "defun":
                return new Defun<>();
            case "list":
                return new List<>();
            case "equal":
                return new Equal<>();
            case "quote":
                return new Quote<>();
            case "atom":
                return new Atom<>();
            case "princ":
                return new Princ<>(variableValues);
            default:
                throw new IllegalArgumentException("Palabra reservada no válida: " + reservedWord);
        }
    }
}
