import java.util.Random;

public class GenerteBattleGround {
    int lenghtOfShip = 3; //todo этот параметр может менятся, а может и нет
    private String alphabet = "A B C D E F G H"; //Задаем алфавит
    private String cellLetter;
    boolean leftEnable = false;
    boolean rightEnable = false;
    boolean upEnable = false;
    boolean downEnable = false;

    public void generateeBattleGround(int quantity){
        generateFirstCell();
        buildShip();
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
        checkHorisontal(number); // то же самое для буквы number
        cellLetter = letter+number; // объявляем первую ячейку, от которой будет весить построение
    }

    //todo Тестовый класс, можно удалать
    public void getCellLetter(){
        System.out.println(this.cellLetter);
        System.out.println("UpEnable: " + upEnable + "; DownEnable " + downEnable);
        System.out.println("LeftEnable: " + leftEnable + " RightEnable: " + rightEnable);
    }
    private void checkVertical(String generatedLetter){ //Проверка можно ли стоить вверх и вниз
        String [] massStr = alphabet.split(" ");
        int lenghtOfMass = massStr.length-1;
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
        int lengtOfBattle = this.alphabet.split(" ").length;

        if((lengtOfBattle-1) - generateNumber + lenghtOfShip <= lengtOfBattle){
            leftEnable = true;
        }

        if ((lengtOfBattle-1) - generateNumber >= lenghtOfShip-1){
            rightEnable = true;
        }


    }

    private void buildShip (){
        if (leftEnable && rightEnable && upEnable && downEnable){
            allWay();
        }

        if (leftEnable && !rightEnable && upEnable && downEnable){
            upDownLeft();
        }
        if (!leftEnable && rightEnable && upEnable && downEnable){
            upDownRight();
        }
        if (leftEnable && rightEnable && !downEnable && upEnable){
            leftRightUp();
        }
        if (leftEnable && rightEnable && downEnable && !upEnable){
            leftRightDown();
        }

        if (!leftEnable && rightEnable && downEnable && !upEnable){
            rightAndDown();
        }
        if (leftEnable && !rightEnable && downEnable && !upEnable){
            rightAndDown();
        }
        if (!leftEnable && rightEnable && !downEnable && upEnable){
            rightAndUp();
        }
        if (leftEnable && !rightEnable && !downEnable && upEnable){
            leftAndUp();
        }

    }

    private void rightAndDown(){
        System.out.println("RnD");
    }
    private void leftAndDown(){
        System.out.println("LnD");
    }
    private void rightAndUp(){
        System.out.println("RnU");
    }
    private void leftAndUp(){
        System.out.println("LnU");
    }

    private void upDownRight(){
        System.out.println("UDR");
    }
    private void upDownLeft(){
        System.out.println("UDL");
    }
    private void leftRightDown(){
        System.out.println("LRD");
    }
    private void leftRightUp(){
        System.out.println("LRU");
    }
    private void allWay(){
        Random rnd = new Random();
        int choiceWay = rnd.nextInt(4)+1;
        switch (choiceWay){
            case 1: System.out.println("Choice 1, Left");
                break;
            case 2: System.out.println("Choice 2, Right");
                break;
            case 3: System.out.println("Choice 3, Up");
                break;
            case 4: System.out.println("Choice 4, Down");
                break;
        }
    }
}
