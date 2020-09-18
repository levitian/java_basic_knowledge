package demo.jvm;

public class JVM10Dot8 {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(String.valueOf(System.identityHashCode(c))); //标识哈希码
        System.out.println(String.valueOf(System.identityHashCode(d)));
        System.out.println(e == f);
        System.out.println(String.valueOf(System.identityHashCode(e))); //标识哈希码
        System.out.println(String.valueOf(System.identityHashCode(f)));
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        Integer h = (a + b);
        System.out.println(String.valueOf(System.identityHashCode(g))); //标识哈希码
        System.out.println(String.valueOf(System.identityHashCode(h)));
        System.out.println(g.equals(h));
    }


}

