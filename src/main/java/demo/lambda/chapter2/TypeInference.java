package demo.lambda.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @description: 类型推断
 * @author: tianli170405
 * @time: 2020/9/9 11:16
 */
public class TypeInference {
/*
    Java 7 中程序员可省略构造函数的泛型类型，Java 8 更进一步，程序员可省略 Lambda 表达
    式中的所有参数类型。再强调一次，这并不是魔法，javac 根据 Lambda 表达式上下文信息
    就能推断出参数的正确类型。程序依然要经过类型检查来保证运行的安全性，但不用再显
    式声明类型罢了。这就是所谓的类型推断。
    */
    //明确指定了泛型的类型
    Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();

    //使用了菱形操作符。不用明确声明泛型类型，编译器就可以自己推断出来
    Map<String, Integer> diamondWordCounts = new HashMap<>();


    public static void main(String[] args) {
        //使用菱形操作符，根据方法签名做推断
        useHashmap(new HashMap<>());

       /*
           Predicate 也是一个 Lambda 表达式，和前文中 ActionListener 不同的是，它还返回一个值。
           Predicate详解 https://www.jianshu.com/p/b38ff80e3039
           与Predicate<T>相关的接口
            BiPredicate<T, U> 针对两个参数,看两个参数是否符合某个条件表达式
            DoublePredicate 看一个double类型的值是否符合某个条件表达式
            IntPredicate 看一个int类型的值是否符合某个条件表达式
            LongPredicate 看一个long类型的值是否符合某个条件表达式
        */
 /*       var func = function(a){

        }*/

        //Predicate<Integer> atLast5 = (x) -> x > 5 ;
        //Predicate<Integer> atLast5 = x -> x > 5 ;
        Predicate<Integer> atLast4 = x -> true ;
        Predicate<Integer> atLast5 = (x) -> {
            return x > 5;
        } ;
        Predicate<Integer> atLast6 = x -> x > 10;
        System.out.println("----------------------------------");
        //Predicate 接口的源码，接受一个对象，返回一个布尔值
        //Predicate 只有一个泛型类型的参数，Integer 用于其中。Lambda
        //表达式实现了 Predicate 接口，因此它的单一参数被推断为 Integer 类型。javac 还可检查
        //Lambda 表达式的返回值是不是 boolean，这正是 Predicate 方法的返回类型。
        System.out.println(atLast5.test(10));;
        System.out.println(atLast5.negate().test(10));
        System.out.println("----------------------------------");
        System.out.println(atLast5.and(atLast6).test(6));
        System.out.println(atLast5.and(atLast6).test(11));
        System.out.println("----------------------------------");
        System.out.println(atLast5.or(atLast6).test(6));
        System.out.println(atLast5.or(atLast6).test(11));
        System.out.println("----------------------------------");

        Predicate<String>  atLast7 = Predicate.isEqual("abc");
        System.out.println(atLast7.test("123"));
        System.out.println(atLast7.test("ABC".toLowerCase()));
        System.out.println("----------------------------------");

        //略显复杂的函数接口：BinaryOperator。该接口接受两个参数，返回一个值，参数和值的类型均相同。实例中所用的类型是 Long。
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        //BinaryOperator<Long> addLongs = Long::sum;
        System.out.println(addLongs.apply(1L, 3L));

        //没有泛型，代码则通不过编译
        /*
        BinaryOperator 毕竟是一个具有泛型参数的函数
        接口，该类型既是参数 x 和 y 的类型，也是返回值的类型。上面的例子中并没有给出变量
        add 的任何泛型信息，给出的正是原始类型的定义。因此，编译器认为参数和返回值都是
        java.lang.Object 实例。
        */
        //BinaryOperator add = (x, y) -> x + y;

    }


    private static void useHashmap(Map<String, String> values){
    }
}
