package callback;

import callback.model.User;

import java.util.List;

public interface UsersCallback {
    void onUsersObtained(List<User> users);
}
