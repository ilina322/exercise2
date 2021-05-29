package stream;

import callback.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        User user1 = new User(10, "Jack", 0);
        User user2 = new User(28, "John", 1200.80);
        User user3 = new User(70, "Gilbert", 700.20);
        User user4 = new User(13, "Anna", 10.10);
        User user5 = new User(40, "Elsa", 2100.0);
        User user6 = new User(17, "Victoria", 100.90);
        User user7 = new User(32, "Jack", 1300.20);
        User user8 = new User(12, "Anna", 0);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);

        Stream<User> usersStream = users.stream();

//        findUnderage(users.stream());
//        findUsersWithSalariesBiggerThan(users.stream(), 1000.0);
//        findUsersWithName(users.stream(), "Anna");
//        findDistinctNames(users.stream());
//        findAverageSalary(users.stream());
//        findIfThereIsUser(users.stream(), "Anna");
//        findIfAllUsersHaveSalary(users.stream());
        //TODO: implement
        findAverageAge(users.stream());
//        findAverageSalaries(users.stream());
//        findAverageAges(users.stream());
//        findUsersOlderThan(users.stream(), 20);
//        findDistinctSalaries(users.stream());
//        findDistinnctAges(users.stream());

        for (String name:
             findNames(usersStream)) {
            System.out.println(name);
        }
    }

    private static boolean findIfAllUsersHaveSalary(Stream<User> users) {
        return users.allMatch(user -> user.salary() > 0);
    }

    private static boolean findIfThereIsUser(Stream<User> users, String name) {
        return users.anyMatch(user -> user.name().equals(name));
    }

    private static double findAverageAge(Stream<User> users) {
        //TODO: implement
        return 0;
    }

    private static double findAverageSalary(Stream<User> users) {
        DoubleStream salaries = users.mapToDouble(User::salary);
        return salaries.sum() / salaries.count();
    }

    private static List<User> findUsersWithName(Stream<User> users, String name) {
        return users.filter(user -> user.name().equals(name))
                .collect(Collectors.toList());
    }

    private static List<String> findDistinctNames(Stream<User> users) {
        return users.map(User::name).distinct().collect(Collectors.toList());
    }

    private static List<User> findUsersWithSalariesBiggerThan(Stream<User> users, double salary) {
        return users.filter(user -> user.salary() > salary)
                .collect(Collectors.toList());
    }

    private static List<User> findUnderage(Stream<User> users) {
        return users.filter(user -> user.age() < 18).collect(Collectors.toList());
    }

    private static List<String> findNames(Stream<User> users) {
        return users.map(user -> "my name is " +
                user.name()).collect(Collectors.toList());
    }
}
