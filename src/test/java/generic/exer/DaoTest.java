package generic.exer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

class DaoTest {
    public static void main(String[] args) {
        Dao dao = new Dao<>();
        Map<String, User> userMap = new HashMap<>();
        dao.save("0001", new User(1, 23, "Alan"));
        dao.save("0002", new User(2, 11, "Ad"));
        dao.save("0003", new User(3, 33, "b"));
        dao.save("0004", new User(4, 26, "c"));
        System.out.println("******save*****");
        dao.save("0005", new User(5, 26, "c"));
        List<User> list=dao.list();
        for (User u:
                list) {
            System.out.println(u);
        }
        System.out.println("******get*****");
        System.out.println(dao.get("0004"));
        System.out.println("******update*****");
        dao.update("0004", new User(44444, 26, "c"));
        list=dao.list();
        for (User u:
             list) {
            System.out.println(u);
        }
        System.out.println("******delete*****");
        dao.delete("0004");
        list=dao.list();
        for (User u:
                list) {
            System.out.println(u);
        }

    }

}