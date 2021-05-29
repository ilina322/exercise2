package callback;

import callback.model.User;

import java.util.ArrayList;
import java.util.List;

public record UserRemoteSource(UsersCallback callback) {

    public void obtainUsers() {
        new Thread(() -> {
            try {
                //starting slow operation
                List<User> users = getUsersFromServer();
                //when users are obtained, do something with them
                callback.onUsersObtained(users);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private List<User> getUsersFromServer() throws InterruptedException {
        Thread.sleep(3000);

        User user1 = new User(10, "Jack", 0);
        User user2 = new User(28, "John", 1200.80);
        User user3 = new User(70, "Gilbert", 700.20);
        User user4 = new User(13, "Anna", 20.10);
        User user5 = new User(40, "Elsa", 2100.0);
        User user6 = new User(17, "Victoria", 100.90);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        return users;
    }
}
