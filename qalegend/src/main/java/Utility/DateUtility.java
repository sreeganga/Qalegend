package Utility;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class DateUtility {
	public static  String getUserLoginDate(String Format)
	{
		DateFormat  dateformat=new SimpleDateFormat(Format);                                        //inteface
		Date currentdate=new Date();
		return dateformat.format(currentdate);
	}

}
