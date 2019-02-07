import java.util.ArrayList;

public class TestForMethods {
     static ArrayList <String []> allShips = new ArrayList<>();
    static String [] ship1 = new String[3];
    static String [] ship2 = new String[3];
    static {
        ship1 [0] = "D6";
        ship1 [1] = "C6";
        ship1 [2] = "B6";

        ship2 [0] = "H1";
        ship2 [1] = "H2";
        ship2 [2] = "H3";

        allShips.add(ship1);
        allShips.add(ship2);
    }


    public boolean checkCrossfire(String [] shipBody){
        for (String [] ships : allShips){
            for (String ship : ships){
                for (String currentShip: shipBody){
                    if (currentShip.equals(ship)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
