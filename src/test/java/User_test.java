import org.example.Model.User;
import org.example.Repository.UserRepoJSON;
import org.example.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class User_test {

    UserRepository userRepository = new UserRepoJSON("userTest.json");

    User newUser = new User("userTest", 100);

    @Test
    public void userExists_returns_true_if_user_exists(){
        userRepository.addUser(newUser);
        Assertions.assertTrue(userRepository.userExists("userTest"));
    }

    @Test
    public void userExists_returns_false_if_user_does_not_exist(){
        userRepository.removeUser(newUser);
        Assertions.assertFalse(userRepository.userExists("userTest"));
    }
    
    @Test
    public void getUser_returns_user_if_user_exists(){
        userRepository.addUser(newUser);
        Assertions.assertEquals(newUser, userRepository.getUser("userTest"));
    }

    @Test
    public void getuser_retun_null_if_user_does_not_exist(){
        userRepository.removeUser(newUser);
        Assertions.assertNull(userRepository.getUser("userTest"));
    }


    @Test
    public void showUser_return_values_if_user_repo_is_not_empty(){
        userRepository.addUser(newUser);
        Assertions.assertNotNull(userRepository.showUser());
    }

    @Test
    public void showUser_return_null_if_user_repo_is_empty(){
        userRepository.removeUser(newUser);
        Assertions.assertTrue(userRepository.showUser().isEmpty());
    }

    @Test
    public void showUserNAme_retun_if_user_repo_is_not_empty(){
        userRepository.addUser(newUser);
        Assertions.assertNotNull(userRepository.showUserName());
    }

    @Test
    public void showUserName_return_null_if_user_repo_is_empty(){
        userRepository.removeUser(newUser);
        Assertions.assertTrue(userRepository.showUserName().isEmpty());
    }

}
