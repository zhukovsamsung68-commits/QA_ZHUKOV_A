public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов Иван Иванович");
        phoneBook.add("Иванов Иван Иванович");

        phoneBook.add("Иванов Иван Андреевич");
        phoneBook.add("Иванов Иван Андреевич");

        phoneBook.add("Петров Петр Сергеевич");
        phoneBook.add("Сидорова Мария Алексеевна");

        System.out.println("Телефоны Иванов Иван Иванович:");
        System.out.println(phoneBook.get("Иванов Иван Иванович"));

        System.out.println("\nТелефоны Иванов Иван Андреевич:");
        System.out.println(phoneBook.get("Иванов Иван Андреевич"));

        System.out.println("\nТелефоны Петров Петр Сергеевич:");
        System.out.println(phoneBook.get("Петров Петр Сергеевич"));

        System.out.println("\nТелефоны Сидорова Мария Алексеевна:");
        System.out.println(phoneBook.get("Сидорова Мария Алексеевна"));
    }
}
