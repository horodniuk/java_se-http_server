package lecture11_unit_test_mockito.lecture2;

import lecture11_unit_test_mockito.lecture2.users_program.dto.User;
import lecture11_unit_test_mockito.lecture2.users_program.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiseTest {
    
    @Test
    void usersEmptyIfNoUserAdded(){
        var userService = new UserService();
        var users = userService.getAll();
        assertTrue(users.isEmpty());
    }
    @Test
    void userSizeIfUserAdded(){
        var userService = new UserService();
        userService.add(new User());
        userService.add(new User());

        var users = userService.getAll();
        assertEquals(2, users.size());
    }
}
