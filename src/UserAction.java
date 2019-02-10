import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserAction {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public String userAction(String messageToUser) throws IOException {
        System.out.println(messageToUser);
        String userInput = bufferedReader.readLine();
        return userInput;
    }
}
