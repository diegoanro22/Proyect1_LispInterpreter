import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Expression validate = new Expression();

        String expression = "";

        while (!expression.equals("(exit)")){
            System.out.print("> ");
            expression = input.nextLine();
            try{
                validate.checkParen(expression);
                
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        input.close();
    }
}