package lecture11_unit_test_mockito.lecture2.users_program.service;

import lecture11_unit_test_mockito.lecture2.users_program.dto.User;
import lecture11_unit_test_mockito.lecture2.users_program.extension.GlobalExtension;
import lecture11_unit_test_mockito.lecture2.users_program.extension.PostProcessingExtension;
import lecture11_unit_test_mockito.lecture2.users_program.extension.UserServiceParamResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({
        UserServiceParamResolver.class,
        GlobalExtension.class,
        PostProcessingExtension.class
})
public class UserServiseTest {
    private static final User IVAN = User.of(1, "Ivan", "123");
    private static final User PETR = User.of(2, "Petr", "111");
    UserService userService;

    UserServiseTest(TestInfo info){
        System.out.println("Info---!!!");
    }

    @BeforeAll
    static void init(){
        System.out.println("Before all:");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(UserService userService){
        System.out.println("BeforeEach" + this);
        this.userService = new UserService(null);
    }

    @Test
    void shouldDeleteExistedUser(){
        userService.add(IVAN);
        userService.delete(IVAN.getId());
    }

    @Test
    void usersEmptyIfNoUserAdded(){
        System.out.println("r.Test 1" + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty(), () -> "User list should be empty");
    }

    @Test
    void userSizeIfUserAdded(){
        System.out.println("r.Test 2" + this);
        userService.add(IVAN);
        userService.add(PETR);

        var users = userService.getAll();
      //  assertEquals(2, users.size());
        assertThat(users).hasSize(2);
    }

    @Test
    void usersConvertedToMapById(){
        userService.add(IVAN, PETR);
        Map <Integer, User> users = userService.getAllConvertedById();
        assertAll(
                () -> assertThat(users).containsKeys(IVAN.getId(), PETR.getId()),
                () ->  assertThat(users).containsKeys(IVAN.getId(), PETR.getId())
        );
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

    @Nested
    @Tag("login")
    @DisplayName("LOGIN TESTING")
    @Timeout(value = 200, unit = MILLISECONDS)
    class UserLoginTest{

        @Test
        @Tag ("login")
        void logicFailIfPasswordIsNotCorrect(){
            userService.add(IVAN);
            var maybeUser = userService.login(IVAN.getUsername(), "dummy");
            assertThat(maybeUser).isEmpty();
            //   assertTrue(maybeUser.isEmpty());
        }

        @Test
        @Disabled("flacky test")
        void throwExceptionIfUserOrPasswordIsNull(){
            assertAll(
                    () -> assertThrows(IllegalArgumentException.class, () -> userService.login(null, "plug")),
                    () -> assertThrows(IllegalArgumentException.class, () -> userService.login("plug", null))
            );
        }

        @Test
        @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
        void loginSuccessIfUserExists(){
            userService.add(IVAN);
            Optional<User> maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());
            assertThat(maybeUser).isPresent();
            //  assertTrue(maybeUser.isPresent());
            maybeUser.ifPresent(user -> assertEquals(IVAN, user));
        }

        @Test
        void logicFailIfUserDoesNotExist(){
            userService.add(IVAN);
            var maybeUser = userService.login("TTTT", IVAN.getPassword());
            assertTrue(maybeUser.isEmpty());
        }
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/login-test-data.csv", numLinesToSkip = 1)
    void loginParametrizedTestByCSVFile(String username, String password){
        userService.add(IVAN, PETR);
        var maybeUser = userService.login(username, password);
        assertThat(maybeUser).isNotNull();
    }

    @ParameterizedTest
    //  @ArgumentsSource()
    //  @NullSource
    //  @EmptySource
    //  @NullAndEmptySource
    //  @ValueSource (strings = {"Petr", "Ivan"})
    @MethodSource("getArgumentsForLoginTest")
    void loginParametrizedTest(String username, String password, Optional<User> user){
      userService.add(IVAN, PETR);
      var maybeUser = userService.login(username, password);
      assertThat(maybeUser).isEqualTo(user);
    }

    static Stream<Arguments>getArgumentsForLoginTest(){
        return Stream.of(
                Arguments.of("Ivan", "123", Optional.of(IVAN)),
                Arguments.of("Petr", "111", Optional.of(PETR)),
                Arguments.of("Petr", "plug", Optional.empty()),
                Arguments.of("Petr", "123", Optional.empty())
        );
    }
}
















