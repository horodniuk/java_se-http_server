package lecture11_unit_test_mockito.lecture2.users_program.service;

import lecture11_unit_test_mockito.lecture2.users_program.dto.User;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class UserService {
    private final List<User> users  = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }

    public void add(User... user) {
        this.users.addAll(Arrays.asList(user));
    }

    public Optional<User> login(String username, String password) {
        if (username == null || password == null){
            throw new IllegalArgumentException("user or password is null");
        }
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }

    public Map<Integer, User> getAllConvertedById() {
        return users.stream().collect(toMap(User::getId, Function.identity()));
    }
}
