public class Main {
    public static void main(String[] args) {
        // ======= Клас Book =======
        Book book1 = new Book("Майстер і Маргарита", "Михайло Булгаков", 1967);
        book1.printInfo();

        System.out.println();

        book1.setYear(1968);
        book1.printInfo();

        System.out.println();
        Account acc1 = new Account("UA1234567890", 1000.0);

        acc1.checkBalance();
        acc1.deposit(500.0);
        acc1.withdraw(200.0);
        acc1.checkBalance();
        acc1.withdraw(2000.0);
    }
}
