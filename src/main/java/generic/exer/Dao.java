package generic.exer;

import java.util.*;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/17
 * @Description
 */
public class Dao<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    //替换 map 中 key 为 id 的内容,改为 entity 对象
    public void update(String id, T entity) {
        map.put(id, entity);
    }

    //从 map 中获取 id 对应的对象
    public T get(String id) {
        return map.get(id);
    }

    //返回 map 中存放的所有 T 对象
    public List<T> list() {
        return new ArrayList<>(map.values());
    }

    //删除指定 id 对象
    public void delete(String id) {

        map.remove(id);
    }
}
