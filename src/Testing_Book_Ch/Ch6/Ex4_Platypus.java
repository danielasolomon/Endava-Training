package Testing_Book_Ch.Ch6;

class Ex4_Mamal {
    private void sneeze(){}
    public Ex4_Mamal(int age){
        System.out.println("Mamal Constructor");
    }
}

public class Ex4_Platypus extends Ex4_Mamal {
    int sneeze(){return 1;}
    public Ex4_Platypus(){
        super(5); //pt ca clasa extinde cosntructor care are parametru
        System.out.println("Platypus Constructor");
    }
    public static void main(String[] args) {
        new Ex4_Mamal(5);
    }
}
