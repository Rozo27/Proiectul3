import java.util.ArrayDeque;
import java.util.Deque;

public class FormaPostFixata {
    static char[] op={'+','-','*','/','^'};
    private static boolean contains(char c){
        for(int i=0;i<op.length;i++){
            if(c==op[i])
                return true;
        }
        return false;
    }
    private static int getPos(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':return 3;
            default:return -1;

        }
    }
    public static String generate(String s) throws InvalidExpressionException {
        Deque<Character> stack=new ArrayDeque<>();
        StringBuilder rez=new StringBuilder();
        char[] cop=s.toCharArray();
        for(int i=0;i<cop.length;i++){
            if(Character.isDigit(cop[i])){
                rez.append(cop[i]);
            }
            if(contains(cop[i])){
                while(stack.isEmpty()==false && stack.peek()!=')' && ( getPos(cop[i])<getPos(stack.peek()) || (getPos(cop[i])==getPos(stack.peek())&& stack.peek()!='^' )  )  ){
                    rez.append(stack.pop());

                }
                stack.push(cop[i]);
            }
            if(cop[i]=='(')
                stack.push(cop[i]);
            if(cop[i]==')'){
                while(stack.isEmpty()==false && stack.peek()!='(')
                    rez.append(stack.pop());
                if(stack.isEmpty()==true)
                    throw new InvalidExpressionException("Aceasta expresie este invalida");
                stack.pop();
            }
        }
        while(stack.isEmpty()==false){
            char op=stack.pop();
            rez.append(op);
            if(op=='(')
                throw new InvalidExpressionException("Aceasta expresie este invalida");

        }

        return rez.toString();
    }
    private static int operation(int op1,int op2,char c) throws ArithmeticException{
        switch (c){
            case'+':return op1+op2;
            case'-':return op1-op2;
            case'*':return op1*op2;
            case'/':
                if(op2==0)
                    throw new ArithmeticException();
                return op1/op2;
            case'^': int p=1;
            for(int i=1;i<=op2;i++)
                p=p*op1;
            return p;
            default:return 0;
        }
    }
    public static int evaluate(String s) throws InvalidExpressionException,ArithmeticException{
        char[] c=s.toCharArray();
        int rezultat;
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i])){
                stack.push(c[i]-'0');
            }
            if(contains(c[i])){
                int op1=-1,op2=-1;
                if(!stack.isEmpty()){
                    op1=stack.pop();
                    if(!stack.isEmpty())
                        op2=stack.pop();
                }
                if(op1==-1 || op2==-1){
                    System.out.println("Expresia nu este corecta");
                    return -1;
                }
                try {
                rezultat=operation(op2,op1,c[i]);
                stack.push(rezultat);
                } catch (ArithmeticException e){
                    throw new ArithmeticException();
                }

            }
        }
        rezultat=stack.pop();
        if(!stack.isEmpty()){
            throw new InvalidExpressionException("Aceasta expresie este invalida");
        }
        return rezultat;
    }

}
