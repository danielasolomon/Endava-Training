package Testing_Book_Ch.Ch11;

import java.io.Closeable;

public class Ex18_FamilyCar {
    static class Door implements AutoCloseable {
        public void close() {
            System.out.print("D");
        }
    }

    static class Window implements Closeable {
        public void close() {
            System.out.print("W");
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        var d = new Door();
        try (d; var w = new Window()){
            System.out.println("T");
        }catch (Exception e){
            System.out.println("E");
        }finally {
            System.out.println("F");
        }
    }
}
