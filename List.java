import java.util.ArrayList;

public class List<T> implements InterfaceFactory<T> {

    //Metodo para mostrar la lista
    public void execute(String exp) {
        java.util.List<T> list = listConversion(exp);
        System.out.println(list);
    }

    /**Metodo para convertir la expresion en una lista
     * @param exp
     * @return
     */
    private java.util.List<T> listConversion(String exp) {
        String[] tokens = exp.replaceAll("[()]", "").split("\\s+");
        java.util.List<T> result = new ArrayList<>();

        for (int i = 1; i < tokens.length; i++) {
            try {
                T value = (T) tokens[i];
                result.add(value);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }
}
