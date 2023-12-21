class StringTest {
    public static void main(String[] args) {
        String a="a";
        String b="a";

        System.out.println("Results of =="+a==b);
        //check for string interning
        String c="a";
        System.out.println("is c interned:"+c.intern());

    }
}