public class TestClass {
    public static void main (String[ ] args){
        GenerteBattleGround gbg = new GenerteBattleGround();
        gbg.generateeBattleGround(3);
        gbg.getCellLetter();

        String[] testedCross = new String[3];

        testedCross[0] = "B6";
        testedCross[1] = "B5";
        testedCross[2] = "B4";

        TestForMethods tFm = new TestForMethods();
        Boolean ttt = tFm.checkCrossfire(testedCross);
        System.out.println("Проверка на пересечение " + ttt);
    }
}
