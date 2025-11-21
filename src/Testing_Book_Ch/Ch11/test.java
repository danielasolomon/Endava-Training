package Testing_Book_Ch.Ch11;

public class test {
    <B extends A> B methodA(B b){
        return b;
    }
}

class A {}
class B extends A{}
class C extends B{}