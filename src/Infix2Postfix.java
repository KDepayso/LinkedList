import netscape.security.UserTarget;

import java.util.Scanner;

public class Infix2Postfix {
    public static void main(String[] args){

        Infix2Postfix main = new Infix2Postfix();
        main.main();
    }

    public void main(){
        Stack<Character> stack = new Stack<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an infix expression (no spaces) > ");
        String infix = input.nextLine();
        System.out.println("Postfix is :" + infix2postfix(infix));
        System.out.println("Result is " + evaluatePostfix(infix2postfix(infix)));
    }

     public int Prec(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }


    public String infix2postfix(String expression) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char charAt = expression.charAt(i);

            if (Character.isLetterOrDigit(charAt)) result += charAt;
            else if (charAt == '(')
                stack.push(charAt);
            else if (charAt == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
                stack.pop();

            } else {
                while (!stack.isEmpty() && Prec(charAt) <= Prec(stack.peek())) {
                    result += stack.peek();
                    stack.pop();
                }
                stack.push(charAt);
            }

        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }
        return result;

    }


    static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();

        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
                stack.push(c - '0');

                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        return stack.pop();
    }


}


