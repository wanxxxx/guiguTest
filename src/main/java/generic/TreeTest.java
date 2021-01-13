package generic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/17
 * @Description
 */
public class TreeTest {


    public static void main(String[] args) {
        TreeSet<Employee> treeSet = new TreeSet<Employee>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        treeSet.add(new Employee("a", 23, new MyDate(1995, 5, 5)));
        treeSet.add(new Employee("b", 22, new MyDate(1995, 5, 3)));
        treeSet.add(new Employee("c", 24, new MyDate(1995, 5, 3)));

        Iterator<Employee> iterator = treeSet.iterator();
        iterator.forEachRemaining(System.out::println);
    }

    public void test(){
        Employee<Integer> e1=new Employee<>("a", 23, new MyDate(1995, 5, 5),5);

    }

}
