package Testing_Book_Ch.Ch9;

public record Ex5<T>(T t) {
    public Ex5(T t) {
        this.t = t;
    }
    private <T> void println(T mesage){
        System.out.println(t+"-"+mesage);
    }

    public static void main(String[] args) {
        new Ex5<String>("hi").println(1);
        new Ex5("hola").println(true);
    }
}
