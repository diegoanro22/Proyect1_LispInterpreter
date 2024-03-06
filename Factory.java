public class Factory<T> {

    public InterfaceFactory<T> createStack(String reservedWord) {
        switch (reservedWord) {
            case "setQ":
                return new SetQ<T>();
            case "defun":
                return new Defun<T>();
            case "list":
                return new List<T>();
            case "equal":
                return new Equal<T>();
            case "quote":
                return new Quote<T>();
            case "atom":
                return new Atom<T>();
            default:
                throw new IllegalArgumentException("Palabra reservada no válida: " + reservedWord);
        }
    }
}