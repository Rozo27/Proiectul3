import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println(FormaPostFixata.generate("3+(2+1)*2^3^2-8/(5-1*2/2)"));
        }catch (InvalidExpressionException e){
            System.out.println(e.getCause());
        }
        try{
            System.out.println(FormaPostFixata.evaluate("3 2 1 + 2 3 2 ^ ^ * + 8 5 1 2 * 2 / - / -"));
        }catch (InvalidExpressionException e){
            System.out.println(e.getCause());
        } catch (ArithmeticException e){
            System.out.println(e.getCause());
        }
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(1000);a.add(4);a.add(25);a.add(319);a.add(88);a.add(51);a.add(3430);a.add(8471);a.add(701);a.add(1);
        a.add(2989);a.add(657);a.add(713);
        a=RadixSort.radix(a);
        for(int i=0;i<a.size();i++)
            System.out.print(a.get(i)+" ");

    }
}
