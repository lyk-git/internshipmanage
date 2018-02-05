
package Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.format.Formatter;
import java.lang.IllegalArgumentException;


public class DateFormatter implements Formatter<Date>{
    private String datePattern;
    private SimpleDateFormat dateFormat;
    public DateFormatter(String datePattern){
        this.datePattern=datePattern;
        dateFormat=new SimpleDateFormat(datePattern);
        dateFormat.setLenient(false);
    }
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }

    public Date parse(String string, Locale locale) throws ParseException {
        try{
            return dateFormat.parse(string);
        }catch(ParseException e){
            throw new IllegalArgumentException("invalid date format.Please use this pattern\""+datePattern+"\"");
        }
    }

}
