package generic;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/17
 * @Description
 */
public class Order<E1,E2,E3> {
    E1 e1;
    E2 e2;
    E3 e3;

    public Order(E1 e1, E2 e2, E3 e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    public E1 getE1() {
        return e1;
    }

    public void setE1(E1 e1) {
        this.e1 = e1;
    }

    public E2 getE2() {
        return e2;
    }

    public void setE2(E2 e2) {
        this.e2 = e2;
    }

    public E3 getE3() {
        return e3;
    }

    public void setE3(E3 e3) {
        this.e3 = e3;
    }

    @Override
    public String toString() {
        return "Order{" +
                "e1=" + e1 +
                ", e2=" + e2 +
                ", e3=" + e3 +
                '}';
    }
}
