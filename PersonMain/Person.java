public class Person {
    @Rep Account account;
    @Peer Person spouse;

    Person() {
        account = new Account();
        spouse = null;
    }
}

