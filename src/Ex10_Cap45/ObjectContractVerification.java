package Ex10_Cap45;

import java.util.Objects;

class Book{
    String isbn;
    String title;
    String author;

    public Book(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString(){
        return "Book: isbn = " + isbn + " | title = " + title + " | author = " + author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  Book book)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

public class ObjectContractVerification {
    public static void main(String[] args){
        Book book1 = new Book("123","abc","Ana");
        Book book2 = new Book("1234","alabala","Maria");
        Book book3 = new Book("123","portocala","Daniela");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println();

        System.out.println("book1.equals(book2) ? " + book1.equals(book2));
        System.out.println("book1.equals(book3) ? " + book1.equals(book3));
        System.out.println("book1 == book2 ? " + (book1==book2));
        System.out.println("book1 == book3 ? " + (book1==book3));

    }
}
