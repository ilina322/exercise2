package callback;

import callback.model.User;

import java.util.List;

public class AgeChecker implements UsersCallback {

    @Override
    public void onUsersObtained(List<User> users) {
        List<User> adults = users.stream().filter(user -> user.age() > 18).toList();
        System.out.println("Adults are: ");
        for (User adult :
                adults) {
            System.out.println(adult.name() + " with age of " + adult.age());
        }
    }
}
