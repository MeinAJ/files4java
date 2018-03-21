import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestTime {

    public static void main(String[] args) throws ParseException {
        System.out.println("奥克兰="+ getTime("Pacific/Auckland"));
        System.out.println("澳大利亚="+ getTime(null));
        System.out.println("中国="+getTime("Asia/Chongqing"));
        System.out.println((getTime("Pacific/Auckland").getTime() - getTime(null).getTime())/1000);
    }

    public static int getHour(String timeZone) {
        Calendar now = Calendar.getInstance();
        if (timeZone != null){
            now = Calendar.getInstance(TimeZone.getTimeZone(timeZone));
        }
        // Calendar now = Calendar.getInstance();
        return now.get(Calendar.HOUR_OF_DAY);
    }

    public static Date getTime(String timeZones) throws ParseException {
        if (timeZones == null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(new Date());
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(format);
        }
        TimeZone timeZone = TimeZone.getTimeZone(timeZones);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(new Date());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(format);
    }
}
