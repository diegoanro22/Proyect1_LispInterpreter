import java.util.Stack;

public class Expression {

    Stack<String> stack = new Stack<>();    

    
    public boolean checkParen(String exp) {
        stack.clear();
        String [] expStr = exp.split("");

        if (!expStr[0].equals("(")){
            throw new IllegalArgumentException("Error, debe empezar con un '('");
        }
        if (!expStr[expStr.length - 1].equals(")")){
            throw new IllegalArgumentException("Error, debe terminar con un ')'");
        }
        
        for (String  character : expStr){
            if (character.equals("(")){
                stack.push(character);
            }
            if (character.equals(")")){
                if (stack.isEmpty()){
                    throw new IllegalArgumentException("Error de paréntesis, se cierra de mas");
                }else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()){
            throw new IllegalArgumentException("Error de paréntesis, no se cerró signo");
        }else{
            return true;
        }
    }
}
