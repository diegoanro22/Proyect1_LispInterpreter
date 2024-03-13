/*La clase {Equal} implementa la interfaz para evaluar si dos expresiones son iguales. Esta evaluación se 
realiza sobre las expresiones pasadas como argumento al método {execute}.*/
public class Equal<T> implements InterfaceFactory<T> {

    //Ejecuta la lógica de comparación de igualdad para dos partes de una expresión dada. 
    @Override
    public void execute(String exp) {
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                exp = exp.substring(0, exp.length() - 1);

                String[] parts = exp.split(" ");
                if (parts.length < 3) {
                    System.out.println("Faltan argumentos para 'equal'");
                    return;
                }

                String entrada1 = parts[1];
                String entrada2 =  parts[2];

                System.out.println(equal(entrada1, entrada2));
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la expresión: " + e.getMessage());
        }
    }

    /*Compara dos entradas para determinar si son iguales.R etorna "T" si ambas entradas son iguales, "Nil" si no lo son.
    Retorna error en caso de que algo salga mal en el proceso*/
    public String equal(String entrada1, String entrada2) {
        try {
            if (entrada1.equals(entrada2)) {
                return "T";
            }
            else{
                return "Nil";
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al procesar los valores");
        }
        return "Error";
    }   
}