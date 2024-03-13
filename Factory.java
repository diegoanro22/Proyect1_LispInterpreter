
public class Factory<T> {
    private final SetQ<T> setQInstance;
    private final Defun<T> defunInstance;

    public Factory(){
        this.setQInstance = new SetQ<>();
        this.defunInstance = new Defun<>();
    }

    public InterfaceFactory<T> createStack(String reservedWord) {
        switch (reservedWord ) {
            case "setq":
                return setQInstance;
            case "defun":
                return  defunInstance;
            case "list":
                return new List<>();
            case "equal":
                return new Equal<>();
            case "quote":
                return new Quote<>();
                case "atom":
                return new Atom<>(setQInstance);
            case "cond":
                return new Condition<>();
            case "princ":
                return new Princ<>(setQInstance);
            case "operation":
                return new Operation<>();
            case "comparator":
                return new Comparator<>();
            case "callerFunction":
                return new CallFunction<>(defunInstance);
            default:
                throw new IllegalArgumentException("Palabra reservada no válida: " + reservedWord);
        }
    }

    public boolean functionDefine(String functionName) {
        return defunInstance.isDefine(functionName);
    }
}
