import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class GenerteBattleGround {
    private ArrayList <String[]> allShips = new ArrayList<>();
    int lenghtOfShip = 3; //todo этот параметр может менятся, а может и нет
    private String alphabet = "A B C D E F G H"; //Задаем алфавит
    private String cellLetter;
    private String generatedLetter = "";
    private int generateNumber = 0;
    private boolean leftEnable = false;
    private boolean rightEnable = false;
    private boolean upEnable = false;
    private boolean downEnable = false;

    private String[] shipBody = new String[3];

    public void generateeBattleGround(int quantity){
        System.out.println("       Welcome to SeaBattle!\nThe First project of Mikhail Sazonov\n");
        String[] massAlph = alphabet.split(" ");
        for (int i = massAlph.length -1; i >= 0; i--){  //Отображение матрицы
            for (int w = 0; w < massAlph.length;w++){
                System.out.print(massAlph[i]+w+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < quantity; i++){
            generateFirstCell();
            buildShip();
        }
    }
    private void generateFirstCell(){
        //String alphabet = "A B C D E F G";
        String[] massStr = this.alphabet.split(" ");
        Random rnd = new Random();
        int rndForChice = rnd.nextInt(massStr.length); //выбираем случайную букву
        String letter = massStr[rndForChice]; // -||- продолжение
        try {
            Thread.sleep(23);
        } catch (InterruptedException e) {  //Для более случайных чисел
            e.printStackTrace();
        }
        int number = rnd.nextInt(massStr.length); //выбор случайного числа
        checkVertical(letter); // проверка буквы, куда массив сможет строится дальше letter
        checkHorisontal(number); // то же самое для буквы number
        this.generatedLetter = letter;
        this.generateNumber = number;
        cellLetter = letter+number; // объявляем первую ячейку, от которой будет весить построение
    }

    public ArrayList <String[]> getBattleGround(){
        return allShips;
    }

    private void checkVertical(String generatedLetter){ //Проверка можно ли стоить вверх и вниз
        String [] massStr = alphabet.split(" ");
        int lenghtOfMass = massStr.length-1;
        int numInMass = 0;
        for (int i = 0; i < massStr.length; i++){
            if (massStr[i].equals(generatedLetter)){
                numInMass = i;
                //System.out.println("Ячейка имеет номер " + numInMass);
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
            leftAndDown();
        }
        if (!leftEnable && rightEnable && !downEnable && upEnable){
            rightAndUp();
        }
        if (leftEnable && !rightEnable && !downEnable && upEnable){
            leftAndUp();
        }

    }

    private void rightAndDown(){
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen <=10) {
                Random rnd = new Random();
                int randomChoise = rnd.nextInt(2) + 1;
                if (randomChoise == 1) {
                    genRight();
                } else {
                    genDown();
                }

                crossFire = checkCrossfire(shipBody); //проверка на пересечение
            }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }
        crossFire = true;
    }
    private void leftAndDown(){
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen <=10){
            Random rnd = new Random();
            int randomChoise = rnd.nextInt(2) + 1;
            if (randomChoise == 1) {
                genLeft();
            } else {genDown();}

            crossFire = checkCrossfire(shipBody);
        }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }
        crossFire = true;
    }
    private void rightAndUp(){
        int counterGen = 0;
        boolean crossFire = true;

        while (crossFire) {
            counterGen++;
            if (counterGen <= 10) {
                Random rnd = new Random();
                int randomChoise = rnd.nextInt(2) + 1;
                if (randomChoise == 1) {
                    genRight();
                } else {
                    genUp();
                }

                crossFire = checkCrossfire(shipBody);
            }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }
        crossFire = true;
    }
    private void leftAndUp(){
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen <= 10) {
                Random rnd = new Random();
                int randomChoise = rnd.nextInt(2) + 1;
                if (randomChoise == 1) {
                    genLeft();
                } else {
                    genUp();
                }
                crossFire = checkCrossfire(shipBody);
            }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }

        crossFire = true;
    }

    private void upDownRight() {
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen<= 10) {
                Random rnd = new Random();
                int rndChoice = rnd.nextInt(3) + 1;
                switch (rndChoice) {
                    case 1:
                        genUp();
                        break; //Up
                    case 2:
                        genDown();
                        break; //Down
                    case 3:
                        genRight();
                        break; //Right
                }

                crossFire = checkCrossfire(shipBody);
            }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }
        crossFire = true;
    }
    private void upDownLeft(){
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen <= 10) {
                Random rnd = new Random();
                int rndChoice = rnd.nextInt(3) + 1;
                switch (rndChoice) {
                    case 1:
                        genUp();
                        break; //Up
                    case 2:
                        genDown();
                        break; //Down
                    case 3:
                        genLeft();
                        break; //Left
                }

                crossFire = checkCrossfire(shipBody);
            }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }
        crossFire = true;
    }
    private void leftRightDown(){
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen <= 10) {
                Random rnd = new Random();
                int rndChoice = rnd.nextInt(3) + 1;
                switch (rndChoice) {
                    case 1:
                        genLeft();
                        break; //Left
                    case 2:
                        genDown();
                        break; //Down
                    case 3:
                        genRight();
                        break; //Right
                }
                crossFire = checkCrossfire(shipBody);
            }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }
        /*if (crossFire == true){
            leftRightDown();  // расписать для каждого способ перезапуска метода. Переделать через Do While
        }*/
        crossFire = true;
    }
    private void leftRightUp() {
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen <= 10) {
                Random rnd = new Random();
                int rndChoice = rnd.nextInt(3) + 1;
                switch (rndChoice) {
                    case 1:
                        genLeft();
                        break; //Left
                    case 2:
                        genUp();
                        break; //UP
                    case 3:
                        genRight();
                        break; //Right
                }

                crossFire = checkCrossfire(shipBody);
            }
            else {
                counterGen=0;
                generateFirstCell();
                buildShip();
                break;
            }
        }
        crossFire = true;
    }
    private void allWay(){
        int counterGen = 0;
        boolean crossFire = true;
        while (crossFire) {
            counterGen++;
            if (counterGen <= 10) {
                Random rnd = new Random();
                int choiceWay = rnd.nextInt(4) + 1;
                switch (choiceWay) {
                    case 1:
                        genUp();
                        break; //UP
                    case 2:
                        genRight();
                        break; //RIGHT
                    case 3:
                        genDown();
                        break; //DOWN
                    case 4:
                        genLeft();
                        break; //LEFT
                }

                crossFire = checkCrossfire(shipBody);
            }
            else {
                counterGen = 0;
                generateFirstCell();
                buildShip();
                break;
            }
        }

        crossFire = true;
    }

    private void genUp(){
        String [] shipBody = new String[lenghtOfShip];
        String[] alphabetMass = alphabet.split(" ");
        int letterPosition = 0;
        for (int i = 0; i <= alphabetMass.length; i++){
            if (generatedLetter.equals(alphabetMass[i])){
                letterPosition = i;
                break;
            }
        }
        for (int i = 0; i < shipBody.length; i++){
            shipBody[i] = alphabetMass[letterPosition]+generateNumber;
            letterPosition ++;
        }
        this.shipBody = shipBody;
    }
    private void genDown(){
        String [] shipBody = new String[lenghtOfShip];
        String[] alphabetMass = alphabet.split(" ");
        int letterPosition = 0;
        for (int i = 0; i < alphabetMass.length; i++){
            if (generatedLetter.equals(alphabetMass[i])){
                letterPosition = i;
                break;
            }
        }
        for (int i = 0; i < shipBody.length; i++){  //менял на +1
            shipBody[i] = alphabetMass[letterPosition] + generateNumber;
            letterPosition --;
        }
        this.shipBody = shipBody;
    }
    private void genRight(){
        String [] shipBody = new String[this.lenghtOfShip];
        int currentCount = generateNumber;
        for (int i = 0; i < shipBody.length; i++){
            shipBody[i] = generatedLetter + currentCount;
            currentCount++;
        }
        this.shipBody = shipBody;

    }
    private void genLeft(){
        String [] shipBody = new String[this.lenghtOfShip];
        int currentCount = generateNumber;
        for (int i = 0; i < shipBody.length; i++){
            shipBody[i] = generatedLetter + currentCount;
            currentCount--;  //Ошибка была тут
        }
        this.shipBody = shipBody;
    }

    private boolean checkCrossfire(String [] shipBody){

        //System.out.println();
        for (String pring : shipBody){
            //System.out.print(pring + " ");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (String [] ships : allShips){
            for (String ship : ships){
                for (String currentShip: shipBody){
                    if (currentShip.equals(ship)){
                        return true;
                    }
                }
            }
        }
        allShips.add(shipBody);
        leftEnable =false;
        rightEnable =false;
        upEnable =false;
        downEnable = false;
        return false;
    }
}
