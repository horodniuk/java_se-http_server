package lecture11_unit_test_mockito.lecture2.users_program.service;

import lecture11_unit_test_mockito.lecture2.users_program.dto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {
    private final List<User> users  = new ArrayList<>();

    public List<User> getAll() {
        return Collections.emptyList();
    }

    public boolean add(User user) {
        return users.add(user);
    }
}
