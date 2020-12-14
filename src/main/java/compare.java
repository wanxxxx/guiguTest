import java.util.Arrays;

class Goods implements  Comparable{

    private String name;
    private double price;

    //指明商品比较大小的方式:照价格从低到高排序,再照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
//        System.out.println("**************");
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return -this.name.compareTo(goods.name);
            }
            //方式二：
//           return Double.compare(this.price,goods.price);
        }
//        return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }
    // getter、setter、toString()、构造器：省略
}
public class compare {
    public static void main(String[] args) {
        Goods[] goods=new Goods[2];
        goods[0] = new Goods("1", 100L);
        goods[1] = new Goods("2", 10L);
        Arrays.sort(goods);
        System.out.println(System.getProperty("user.name"));
    }
}
