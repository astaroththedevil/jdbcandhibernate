package hibernate;

import hibernate.config.UserTableAddOperation;
import hibernate.entities.User;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        UserTableAddOperation userTableAddOperation = new UserTableAddOperation();
        userTableAddOperation.addUsersTable(user);
    }
}
