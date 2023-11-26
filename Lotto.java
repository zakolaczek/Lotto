import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.Scanner;
public class Lotto {
    public static void main(String[] args) {
        Methods lotto = new Methods();
        Scanner ask = new Scanner(System.in);
        System.out.print("How many times do you want to roll? ");
        int max  = ask.nextInt();
        lotto.main(max);
    }
}
class Methods{
    List<Integer> generate(){
        Random generator = new Random();
        List<Integer> array = new ArrayList<>();
        int currentNum;
        for(int i = 0 ; i< 7; i++) {
            currentNum = generator.nextInt(43) + 1;
            while (array.contains(currentNum)) {
                currentNum = generator.nextInt(43) + 1;
            }
            array.add(currentNum);
        }
        return array;
    }

    void main(int max){
        List<Integer> current;
        int number;
        float percent;
        int[] howMuch = new int[43];
        Arrays.fill(howMuch, 0);
        for(int i = 0; i < max; i++){
            current = generate();
            for(int j = 0; j < 7; j++){
                number = current.get(j);
                howMuch[number - 1] ++;
            }
            System.out.printf("%d)  ", i+1);
            System.out.println(current);
        }
        System.out.println("");
        for(int i = 0; i < howMuch.length; i++){
            int sth = howMuch[i];
            if(sth != 0){
                System.out.printf("Number (%d), is (%d) times so ", i+1, sth);
                percent = (float) sth / (float) (max * 7) * 100;
                System.out.printf("%.2f", percent);
                System.out.println(" %");
            }
        }
    }
}