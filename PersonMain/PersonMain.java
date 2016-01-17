public class PersonMain {
    @Rep Person man;
    @Rep Person woman;

    void Demo() {
        man = new Person();
        woman = new Person();
        man.spouse = woman;
        woman.spouse = man;

        Account account_man = man.account;
        Account account_woman = woman.account;
        account_man.value = 50;
        account_woman.value += 20;
        try {
            if (account_man.value > 0)
                throw new Throwable();  // test throw
        }
        catch (Throwable t) {
            t.toString();
        }
        account_woman.value = 20;
    }
}
