import java.util.ArrayList;

//La clase {List} implementa la interfaz para convertir una expresión dada en una lista de elementos. 
public class List<T> implements InterfaceFactory<T> {

    //Ejecuta la conversión de la expresión dada en una lista de elementos.
    public void execute(String exp) {
        java.util.List<T> list = listConversion(exp);
        System.out.println(list);
    }

    //Convierte una expresión dada en una lista de elementos de tipo {T}.
    public java.util.List<T> listConversion(String exp) {
        String[] tokens = exp.substring(0, exp.length() - 1).split("\\s+");
        java.util.List<T> result = new ArrayList<>();

        for (int i = 1; i < tokens.length; i++) {
            try {
                @SuppressWarnings("unchecked")
                T value = (T) tokens[i];
                result.add(value);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }
}