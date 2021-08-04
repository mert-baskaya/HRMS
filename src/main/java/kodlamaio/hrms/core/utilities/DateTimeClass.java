package kodlamaio.hrms.core.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeClass {
    public static String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();

        return dateFormat.format(date);
    }
}
