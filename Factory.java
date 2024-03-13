/*La clase {Factory} es responsable de crear instancias de {InterfaceFactory} basadas en palabras reservadas específicas. 
Facilita la creación dinámica de objetos que se implementan en {InterfaceFactory}*/
public class Factory<T> {
    private final SetQ<T> setQInstance;
    private final Defun<T> defunInstance;

    //Construye una instancia de {Factory} inicializando las instancias de {SetQ} y {Defun}.
    public Factory(){
        this.setQInstance = new SetQ<>();
        this.defunInstance = new Defun<>();
    }

    //Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra reservada proporcionada.
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

    //Verifica si una función está definida en la instancia de {Defun}.
    public boolean functionDefine(String functionName) {
        return defunInstance.isDefine(functionName);
    }
}