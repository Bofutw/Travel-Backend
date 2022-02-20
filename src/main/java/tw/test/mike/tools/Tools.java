package tw.test.mike.tools;

import org.json.JSONObject;
import tw.test.mike.bean.MemberBean;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;


public class Tools {
    public static Integer age(MemberBean bean){
        Integer result;
        Date birthtime = bean.getMemberbirth();

        Calendar membercalendar = Calendar.getInstance();
        try{
            membercalendar.setTime(birthtime);
            Integer memberbirthyear = membercalendar.get(Calendar.YEAR);

            Calendar nowcalendar = Calendar.getInstance();
            nowcalendar.setTime(new Date());
            Integer year = nowcalendar.get(Calendar.YEAR);

            result = year-memberbirthyear;
        }catch (NullPointerException e){
            result = null;
        }

        return result;
    }

    public static JSONObject agerange(Integer age){
        JSONObject result = new JSONObject();
        Integer value;
        String range;
        try{
            switch (age<14?0:(age-5)/10){
                case 0:
                    range="0-14";
                    value=0;
                    break;
                case 1:
                    range="15-24";
                    value=1;
                    break;
                case 2:
                    range="25-34";
                    value=2;
                    break;
                case 3:
                    range="35-44";
                    value=3;
                    break;
                case 4:
                    range="45-54";
                    value=4;
                    break;
                case 5:
                    range="55-64";
                    value=5;
                    break;
                default:
                    range="65以上";
                    value=6;
            }
            result.put("range",range);
            result.put("value",value);
        }catch (NullPointerException e){

        }
        return result;
    }

    public static int randomAgeYear(int topage){

        int age = (int)(Math.random()*topage+1);
        Calendar cal = Calendar.getInstance();
        int nowyear = cal.get(Calendar.YEAR);
        int year = nowyear-age;

        return year;
    }

    public static int randomBetween(int start, int end){
        return (int)(Math.random()*(end-start) + start);
    }


    public static Date randomBirthday(){

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(gc.YEAR, randomAgeYear(81));

        return null;
    }

}