package Testing_Book_Ch.Ch11;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex7 {
    public void tryAgain(String s) {
        try (FileReader r = null; FileReader p = new FileReader("")) {
           System.out.print("X");
           throw new IllegalArgumentException();
        } catch (Exception e) {
           System.out.print("A");
           throw new RuntimeException();
        } finally {
           System.out.print("O");
        }
    }

}
