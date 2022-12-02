package lecture11_unit_test_mockito.lecture2.users_program.service;

import lecture11_unit_test_mockito.lecture2.users_program.dto.User;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiseTest {
    private static final User IVAN = User.of(1, "Ivan", "123");
    private static final User PETR = User.of(2, "PETR", "111");
    UserService userService;
    
    @BeforeAll
    static void init(){
        System.out.println("Before all:");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("AfterEach" + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNoUserAdded(){
        System.out.println("Test 1" + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty(), () -> "User list should be empty");
    }

    @Test
    void userSizeIfUserAdded(){
        System.out.println("Test 2" + this);
        userService.add(IVAN);
        userService.add(PETR);

        var users = userService.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void loginSuccessIfUserExists(){
        userService.add(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals(IVAN, user));
    }

    @Test
    void logicFailIfPasswordIsNotCorrect(){
        userService.add(IVAN);
        var maybeUser = userService.login(IVAN.getUsername(), "dummy");
        assertTrue(maybeUser.isEmpty());
    }

    @Test
    void logicFailIfUserDoesNotExist(){
        userService.add(IVAN);
        var maybeUser = userService.login("TTTT", IVAN.getPassword());
        assertTrue(maybeUser.isEmpty());
    }

    @AfterEach
    void afterEach(){
        System.out.println("AfterEach" + this);
        System.out.println();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all:");
    }
}
















