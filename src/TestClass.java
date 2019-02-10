import java.util.ArrayList;

public class TestClass {
    public static void main (String[ ] args){
        GenerteBattleGround gbg = new GenerteBattleGround();
        gbg.generateeBattleGround(3);
        ArrayList<String[]> bg = gbg.getBattleGround();

        for (String[] one : bg){
            for (String two : one){
                System.out.print(two + " ");
            }
            System.out.println();
        }
        Fight fight = new Fight();
        fight.startFight(bg);

        //TestForMethods tst = new TestForMethods();
        //tst.startTest();
    }
}
