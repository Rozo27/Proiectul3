import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class RadixSort {
    public static ArrayList<Integer> radix(ArrayList<Integer> a){
        ArrayList<Queue<Integer>> numbers=new ArrayList<>();
        for(int j=0;j<=9;j++){
            numbers.add(new ArrayDeque<Integer>());
        }
        for(int i=1;i<=4;i++){
            for(int k=0;k<=9;k++){
                for(int j=0;j<a.size();j++){
                    int cop=a.get(j);
                    switch (i){
                        case 1:cop=cop%10;
                            break;
                        case 2:cop=cop/10%10;
                            break;
                        case 3:cop=cop/100%10;
                            break;
                        case 4:cop=cop/1000;
                            break;
                    }
                    if(cop==k){
                        numbers.get(k).offer(a.get(j));
                    }
                }
            }
            ArrayList<Integer> b=new ArrayList<>();
            for(int j=0;j<=9;j++){ //pentru a ordona valorile in ordine descrescatoare, va trebui sa scriem acest for de la 9 la 0
                while(numbers.get(j).isEmpty()==false){
                    b.add(numbers.get(j).poll());
                }
            }
            a=b;
        }
        return a;
    }
}
