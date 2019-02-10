import java.io.IOException;
import java.util.ArrayList;

public class Fight {
    private ArrayList <ArrayList<String>> worksheetList = new ArrayList<>();
    private int missCounter = 0;

    public void startFight (ArrayList<String[]> incomingArraay){
        this.worksheetList = rebildList(incomingArraay);
        toPlay();

    }

    private void toPlay() {
        UserAction user = new UserAction();
        boolean gameNotEnd = true;
        while (gameNotEnd) {
            try {
                String userAction = user.userAction("Please enter № of cell");
                checkHit(userAction);
                for (ArrayList<String> list : worksheetList){
                    if (list.isEmpty()){
                        System.out.println("Корабль потоплен!");
                        worksheetList.remove(list);
                        break;
                    }
                }
                if (worksheetList.isEmpty()){
                    gameNotEnd = false;
                    System.out.println("Все корабли уничтожены! Количество промахов: " +missCounter);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkHit(String userAct) {
         boolean hit = false;
        for (ArrayList<String> list1 : worksheetList){
            for (String ship : list1){
                if (ship.equals(userAct)){
                    list1.remove(ship);
                    hit = true;
                    break;
                }
            }
        }
        if (hit){
            System.out.println("Есть попадан\n");
        }
        else {
            System.out.println("Не поппал\n");
            missCounter++;
        }
    }

    private ArrayList<ArrayList<String>> rebildList(ArrayList<String[]> oldList){
        for (int i = 0; i < oldList.size(); i++){
            ArrayList <String> listForAdd = new ArrayList<String>();
            for (int q = 0; q < oldList.get(i).length; q++){
                listForAdd.add(oldList.get(i)[q]);
            }
            this.worksheetList.add(listForAdd);
        }
     return this.worksheetList;
    }
}
