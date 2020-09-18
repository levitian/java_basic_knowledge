package demo.lambda.chapter2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * @description: 辨别Lambda表达式
 * @author: tianli170405
 * @time: 2020/9/7 11:04
 */
public class DistinguishLambda {

    Runnable noArguments = () -> System.out.println("Hello World");

    ActionListener oneArgument = event -> System.out.println("button clicked");


    Runnable multiStatement = () -> {
        System.out.print("Hello");
        System.out.println(" World");
    };

    BinaryOperator<Long> add = (x, y) -> x + y + 1;

//    jdk8中使用了::的用法。就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下，
//     双冒号运算就是Java中的[方法引用],[方法引用]的格式是：
//    类名：：方法名
    BinaryOperator<Long> addExplicit = Long::sum;

    public static void main(String[] args) {
        DistinguishLambda dl = new DistinguishLambda();
        dl.noArguments.run();

        ActionEvent event = new ActionEvent("abc", 1, "click");
        dl.oneArgument.actionPerformed(event);
        dl.multiStatement.run();
        System.out.println(dl.add.apply(1L, 2L));
        System.out.println(dl.addExplicit.apply(3L, 4L));


    }
}
