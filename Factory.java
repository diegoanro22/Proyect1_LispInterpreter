import java.util.Map;

public class Factory<T> {

    public InterfaceFactory<T> createStack(String reservedWord) {
        switch (reservedWord) {
            case "setq":
                return SetQ.getInstance();
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
                return new Princ<>();
            default:
                throw new IllegalArgumentException("Palabra reservada no válida: " + reservedWord);
        }
    }
}
