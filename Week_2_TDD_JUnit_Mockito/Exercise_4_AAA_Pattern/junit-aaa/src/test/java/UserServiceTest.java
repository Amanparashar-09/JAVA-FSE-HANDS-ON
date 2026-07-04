import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
        userService.addUser("existingUser");
    }

    @AfterEach
    public void tearDown() {
        userService.clear();
    }

    @Test
    public void testAddUser() {
        String newUser = "john";

        userService.addUser(newUser);

        assertTrue(userService.userExists(newUser));
    }

    @Test
    public void testUserCount() {
        userService.addUser("alice");
        userService.addUser("bob");

        int count = userService.getUserCount();

        assertEquals(3, count);
    }

    @Test
    public void testUserExists() {
        String username = "existingUser";

        boolean exists = userService.userExists(username);

        assertTrue(exists);
    }

    @Test
    public void testUserDoesNotExist() {
        String username = "unknownUser";

        boolean exists = userService.userExists(username);

        assertFalse(exists);
    }
}
