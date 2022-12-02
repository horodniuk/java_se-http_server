package lecture11_unit_test_mockito.lecture2.users_program.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class User {
    Integer id;
    String username;
    String password;

}
