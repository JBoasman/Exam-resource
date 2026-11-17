public class Main {

    public static void main(String[] args) {
        // TODO - Your code starts here {
        User u1 = new User("1");
        NotificationService ABC = new NotificationService("ABC");
        u1.getFavourites().attach(ABC);
        Item item1 = new Item("I1", "Item 1");
        u1.getFavourites().addItem(item1);

        User u2 = new User("2");
        NotificationService DEF = new NotificationService("DEF");
        u2.getFavourites().attach(DEF);
        Item item2 = new Item("I2", "Item 2A");
        Item item3 = new Item("I2", "Item 2B");
        u2.getFavourites().addItem(item1);
        u2.getFavourites().addItem(item2);
        u2.getFavourites().addItem(item3);

        u2.getFavourites().detach(DEF);

        u1.getFavourites().removeItem(item1);
        u2.getFavourites().removeItem(item1);


        // TODO - Your code ends here }
    }
}
