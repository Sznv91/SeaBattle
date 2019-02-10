import java.util.ArrayList;

public class TestClass {
    public static void main (String[ ] args){
        GenerteBattleGround gbg = new GenerteBattleGround();
        gbg.generateeBattleGround(3);
        ArrayList<String[]> bg = new ArrayList<>();
        bg = gbg.getBattleGround();

        for (String[] one : bg){
            for (String two : one){
                System.out.print(two + " ");
            }
            System.out.println();
        }
        /*String[] testedCross = new String[3];

        testedCross[0] = "B6";
        testedCross[1] = "B5";
        testedCross[2] = "B4";

        TestForMethods tFm = new TestForMethods();
        Boolean ttt = tFm.checkCrossfire(testedCross);
        System.out.println("Проверка на пересечение " + ttt);*/
    }
}

//todo Если counter > 50, то сгенерировать другую первую ячейку.