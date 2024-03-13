import java.util.Stack;

public class Condition<T> implements InterfaceFactory<T>{

    private final SetQ<T> setQInstance;

    public Condition(SetQ<T> setQInstance) {
        this.setQInstance = setQInstance;
    }

    Comparator<T> verificar = new Comparator<T>();
    @Override
    public void execute(String exp) {
        // Expression<T> expressionChecker=new Expression<>();
        String innerExpression = exp.substring(6, exp.length() - 1).trim();
        if (setQInstance.variableValues.containsKey(innerExpression)) {
            System.out.println("T");
        }
        Stack<Character> stack = new Stack<>();
        String[] expStr = exp.split("");
        StringBuilder partes = new StringBuilder();
        String cadenaFinal="";
        try{
            for (String character : expStr) {
                for (char ch : character.toCharArray()){
                    switch (ch) {
                        case '(':
                            stack.push(ch);
                            break;
                        case ')':
                            stack.pop();
                        default:
                            if (String.valueOf(ch)!="("){
                                    partes.append(ch);
                                    String partes2=partes.toString();
                                    cadenaFinal=partes2.replace(")","");
                                    
                            }
                            break;
                    }
                    
        }
    }
            String[] palabras = cadenaFinal.split(" ");
            String condicion = palabras[1];
            String resultado = palabras[2];
            System.out.println(cond(condicion,resultado));

    }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    
    public String cond(String condicion,String resultado){
        if (verificar.evaluateComparison(condicion)) {
            return ("Es "+ resultado);
        }
        else{
            return "Es Falso";
        }
}
}