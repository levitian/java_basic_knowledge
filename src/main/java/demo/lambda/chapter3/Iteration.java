package demo.lambda.chapter3;

import com.sun.istack.internal.NotNull;
import demo.lambda.chapter1.Artist;
import demo.lambda.chapter1.SampleData;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 迭代
 * @author: tianli170405
 * @time: 2020/9/18 15:30
 */
public class Iteration {

    /**
     * 外部迭代
     * @param allArtists
     * @param nationality
     * @return
     */
    private static long outIteration(List<Artist> allArtists, String nationality){
        long count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()){
            Artist artist = iterator.next();
            if(artist.isFrom(nationality)){
                count++;
            }
        }
        return count;
    }

    /**
     * 内部迭代
     * Stream 是用函数式编程方式在集合类上进行复杂操作的工具
     * @param allArtists
     * @param nationality
     * @return
     */
    private static long inIteration(List<Artist> allArtists, String nationality){
        long count = 0;
        count = allArtists.stream()
                .filter(artist -> artist.isFrom(nationality))  //惰性求值方法
                .count(); //及早求值方法
        return count;
    }

    //由于使用了惰性求值，没有输出艺术家的名字
    private static void inIteration2(List<Artist> allArtists, String nationality){
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom(nationality);
                });  //惰性求值方法

    }

    //输出艺术家的名字
    private static long inIteration3(List<Artist> allArtists, String nationality){
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom(nationality);
                })
                .count();
        return count;
    }
/*
        判断一个操作是惰性求值还是及早求值很简单：只需看它的返回值。如果返回值是 Stream，
    那么是惰性求值；如果返回值是另一个值或为空，那么就是及早求值。使用这些操作的理
    想方式就是形成一个惰性求值的链，最后用一个及早求值的操作返回想要的结果，这正是
    它的合理之处。计数的示例也是这样运行的，但这只是最简单的情况：只含两步操作。

        整个过程和建造者模式有共通之处。建造者模式使用一系列操作设置属性和配置，最后调
    用一个 build 方法，这时，对象才被真正创建。
        读者一定会问：“为什么要区分惰性求值和及早求值？”只有在对需要什么样的结果和操
    作有了更多了解之后，才能更有效率地进行计算。例如，如果要找出大于 10 的第一个数
    字，那么并不需要和所有元素去做比较，只要找出第一个匹配的元素就够了。这也意味着
    可以在集合类上级联多种操作，但迭代只需一次。
    */
    public static void main(String[] args) {
        List<Artist> allArtists = new ArrayList<>();
        allArtists.add(SampleData.johnColtrane);
        allArtists.add(SampleData.georgeHarrison);
        allArtists.add(SampleData.johnLennon);

        System.out.println("outIteration------------:" + outIteration(allArtists, "UK"));
        System.out.println("---------------------------------------------");
        System.out.println("inIteration------------:" + inIteration(allArtists, "UK"));
        System.out.println("---------------------------------------------");
        System.out.println("inIteration2------------");
        inIteration2(allArtists, "UK");
        System.out.println("---------------------------------------------");
        System.out.println("inIteration3------------:" + inIteration3(allArtists, "UK"));

    }
}
