package callback;

public class UiManager {
    public static void main(String[] args) {
        //printGreetings();
        printAdults();
    }

    private static void printAdults() {
        //indicate that slow operation will be performed
        System.out.println("loading adults...");
        AgeChecker ac = new AgeChecker();
        UserRemoteSource ageCheckerSrc = new UserRemoteSource(ac);
        //slow operation -> when users are obtained onUsersObtained from
        //AgeChecker will be called
        ageCheckerSrc.obtainUsers();
    }

    private static void printGreetings() {
        //indicate that slow operation will be performed
        System.out.println("loading greetings...");
        UserFormatter uf = new UserFormatter();
        UserRemoteSource userFormatterSrc = new UserRemoteSource(uf);
        //slow operation -> when users are obtained onUsersObtained from
        //UserFormatter will be called
        userFormatterSrc.obtainUsers();
    }
}
