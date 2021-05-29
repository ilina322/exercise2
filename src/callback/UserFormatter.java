package callback;


import callback.model.User;

import java.util.List;

public class UserFormatter implements UsersCallback {

    @Override
    public void onUsersObtained(List<User> users) {
        //map every user to their greeting
        List<String> greetings = users.stream().map(
                user ->
                        "Hi, my name is " + user.name() +
                                " and I am " + user.age() + " years old!"
        ).toList();

        for (String greeting :
                greetings) {
            System.out.println(greeting);
        }
    }
}
