
public class Factory<T> {
    private final SetQ<T> setQInstance;

    public Factory(){
        this.setQInstance = new SetQ<>();
    }

    public InterfaceFactory<T> createStack(String reservedWord) {
        switch (reservedWord) {
            case "setq":
                return setQInstance;
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
                return new Princ<>(setQInstance);
            default:
                throw new IllegalArgumentException("Palabra reservada no válida: " + reservedWord);
        }
    }
}
