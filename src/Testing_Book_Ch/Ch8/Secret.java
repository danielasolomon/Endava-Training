package Testing_Book_Ch.Ch8;

interface Secret {
    String magic(double d);
}

class MySecret implements Secret {
    public String magic(double d) {
        return "Poof";
    }
}

