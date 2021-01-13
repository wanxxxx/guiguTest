package generic;

import javafx.beans.binding.ObjectExpression;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    class Father {}
    class son extends Father{}
    class grandson extends son{}
    @Test
    public void test1(){
       List<? extends son> list1=null; // (son的)son grandson XXXX Father Obejct
       List<? super son> list2=null;//
       List<Father> list3=null;
       List<son> list4=null;
       List<grandson> list5=null;
//       list1=list3;
       list1=list4;
       list1=list5;
       list2=list3;
       list2=list4;
        //list2=list5;
    }
}