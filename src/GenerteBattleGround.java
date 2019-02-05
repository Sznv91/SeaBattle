import java.util.Random;

public class GenerteBattleGround {
    private String alphabet = "A B C D E F G H"; //Задаем алфавит
    private String cellLetter;
    boolean leftEnable = false;
    boolean rightEnable = false;
    boolean upEnable = false;
    boolean downEnable = false;

    public void generateeBattleGround(int quantity){
        generateFirstCell();
    }
    private void generateFirstCell(){
        //String alphabet = "A B C D E F G";
        String[] massStr = this.alphabet.split(" ");
        Random rnd = new Random();
        int rndForChice = rnd.nextInt(massStr.length); //выбираем случайную букву
        String letter = massStr[rndForChice]; // -||- продолжение
        try {
            Thread.sleep(251);
        } catch (InterruptedException e) {  //Для более случайных чисел
            e.printStackTrace();
        }
        int number = rnd.nextInt(massStr.length); //выбор случайного числа
        checkVertical(letter); // проверка буквы, куда массив сможет строится дальше letter
        checkHorisontal(number); // то же самое для буквы
        cellLetter = letter+number; // объявляем первую ячейку, от которой будет весить построение
    }

    //todo Тестовый класс, можно удалать
    public void getCellLetter(){
        System.out.println(this.cellLetter + " UpEnable: " + upEnable + "; DownEnable " + downEnable);
    }
    private void checkVertical(String generatedLetter){ //Проверка можно ли стоить вверх и вниз
        String [] massStr = alphabet.split(" ");
        int lenghtOfMass = massStr.length-1;
        int lenghtOfShip = 3; //todo этот параметр может менятся, а может и нет
        int numInMass = 0;
        for (int i = 0; i < massStr.length; i++){
            if (massStr[i].equals(generatedLetter)){
                numInMass = i;
                System.out.println("Ячейка имеет номер " + numInMass);
                break;
            }
        } //Определяем где в какой порядк. № имеет бука в массиве
        if (lenghtOfMass - numInMass >= lenghtOfShip-1){
            upEnable = true;
        }
        if (lenghtOfMass - (lenghtOfMass - numInMass) >= lenghtOfShip - 1){
            downEnable = true;
        }

        //todo динна масс. 7яч. Н-Р текущая ячейка F6; 7-6=1, одна ячейка осталась до конца массив. Можно только вниз.
        //todo если н-р B1 -> 7-1 = 6 (3(длинна ячейки)-1(сама сгенерованная яч)=2 -> 7-6=1 -> 1<2) вниз двигатся нельзя
    }
    private void checkHorisontal(Integer generateNumber){ // Проверка можно ли строить влево и вправо

    }
}
