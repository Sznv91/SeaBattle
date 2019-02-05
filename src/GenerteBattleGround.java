import java.util.Random;

public class GenerteBattleGround {
    private String cellLetter;

    public void generateeBattleGround(){
        String alphabet = "a b c d e f g";
        String[] massStr = alphabet.split(" ");
        Random rnd = new Random();
        int rndForChice = rnd.nextInt(massStr.length);
        cellLetter = massStr[rndForChice];

    }
    //todo Тестовый класс, можно удалать
    public void getCellLetter(){
        System.out.println(this.cellLetter);
    }
}
