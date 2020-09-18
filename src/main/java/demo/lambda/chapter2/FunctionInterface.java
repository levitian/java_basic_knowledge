package demo.lambda.chapter2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 函数接口
 * @author: tianli170405
 * @time: 2020/9/9 11:04
 */
public class FunctionInterface {
/*
    函数接口是只有一个抽象方法的接口，用作 Lambda 表达式的类型。

    Java中重要的函数接口
    Predicate<T>
    Consumer<T>
    Function<T,R>
    Supplier<T>
    UnaryOperator<T>
    BinaryOperator<T>
    */
    public static void main(String[] args) {

        List<String> lists = Arrays.asList("ABC","SDFSDF","1");
        //传统排序
        Collections.sort(lists, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(lists);

        //Lambda排序
        Collections.sort(lists, (a, b)->{ return a.length() + b.length();});
        System.out.println(lists);

        //List Lambda排序
        lists.sort((a, b) ->{return b.length() - a.length();});
        System.out.println(lists);
    }
}
