import java.util.ArrayList;
import java.util.Random;

public class DotCom {

    private int randomNum = new Random().nextInt(10) + 1;

    private int [] bodyOfDotCom = new int[] {randomNum,randomNum+1,randomNum+2};
    ArrayList <Integer> tryedShoots = new ArrayList<>();


    public void fill(int [] mass) {
        if (bodyOfDotCom.length == mass.length){
            for (int i = 0; i < bodyOfDotCom.length; i++){
                this.bodyOfDotCom[i] = mass[i];
            }
        }
    }

    public Integer getBodySize(){
        return this.bodyOfDotCom.length;
    }

    public String shoot (int userInput) {
        if (tryedShoots.contains(userInput)){
            try {
                throw new Exception();
            }
            catch (Exception e){
                System.out.println("Повтор числа, попытка не засчитана");
                return "Не попал";
            }
        }

        for (int i = 0; i < bodyOfDotCom.length; i++){
            if (bodyOfDotCom[i]==userInput){
                tryedShoots.add(userInput);
                return "Попал";
            }
        }
        return "Не попал";
    }
}
