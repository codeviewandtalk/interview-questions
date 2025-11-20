package ScenarioBased;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomJavaClassInHashMap {
    public static void main(String[] args) {
        HashMap<Book, String> bookMap = new HashMap<>();
        Book book1 = new Book(1, "The Great Gatsby");
        Book book2 = new Book(2, "The Empires");
        Book book3 = new Book(3, "The Great Gatsby");
        bookMap.put(book1,"Welcome to the world of books");
        bookMap.put(book2,"Welcome to the world");
        System.out.println(bookMap);

        Map<BadHash, String> map = new HashMap<>();
        map.put(new BadHash(1), "One");
        map.put(new BadHash(2), "Two");
        map.put(new BadHash(3), "Three");
        System.out.println(new BadHash(1).hashCode());
        System.out.println(new BadHash(2).hashCode());
        System.out.println(new BadHash(3).hashCode());
        System.out.println(map);
        System.out.println(map.get(new BadHash(1)));
    }
}

class Book {
    private int id;
    private String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

class BadHash {
    int value;

    public BadHash(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value); // Bad: constant hash code
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BadHash && ((BadHash) obj).value == this.value;
    }
}