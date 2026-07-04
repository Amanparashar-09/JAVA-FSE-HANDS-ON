import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<String> users = new ArrayList<>();

    public void addUser(String username) {
        users.add(username);
    }

    public boolean userExists(String username) {
        return users.contains(username);
    }

    public int getUserCount() {
        return users.size();
    }

    public void clear() {
        users.clear();
    }
}
