import java.util.HashMap;

public class HashmapTest {
    public static void main(String[] args) {
        HashMap<String, Book> books = new HashMap<>();
        books.put("0593189647", new Book("James Clear", "Atomic Habits"));
        books.put("0503930234", new Book("Rick Riordan", "Percy Jackson and the Lightning Thief"));
        books.put("0550301923", new Book("E. B. White", "Charlotte's Web"));
    }
}
