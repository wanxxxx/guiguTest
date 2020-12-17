import java.util.Arrays;

/**
 * @author f
 * @return void
 */
public class CompareToThis {
    public static void main(String[] args) {
        Goods[] goods = new Goods[2];
        goods[0] = new Goods("1", 100L);
        goods[1] = new Goods("2", 10L);
        Arrays.sort(goods);
        System.out.println(System.getProperty("user.name"));
    }
}
