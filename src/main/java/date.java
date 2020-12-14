import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String str="20-12-14 上午3:57";
        try {
            System.out.println(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
