package format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class FormatMatcheUtil {
	//判断是否是3位数字
	public static boolean isNumberic(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]{3}"); 
	    return pattern.matcher(str).matches();  
	 }
	
	//判断是否为日期类型
	public static boolean isValidDate(String str) {
		boolean convertSuccess=true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
		// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
//		    System.out.println("date========="+format.parse(str));
		} catch (ParseException e) {
		// e.printStackTrace();
		// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess=false;
		}
			return convertSuccess;
	}
	
	public static void regex () {
		Pattern memberChangePattern = Pattern.compile("[A-Za-z0-9]*_GPRS800_BBOSS_[0-9]{14}.[0-9]{3}.txt");
		Pattern superpositionPattern = Pattern.compile("[A-Za-z0-9]*_GPRSADD_BBOSS_[0-9]{14}.[0-9]{3}.txt");
		String filename = "WSDFRE_GPRS800_BBOSS_20150121171505.000.txt";
		System.out.println(memberChangePattern.matcher(filename).matches());
	}

	public static void main(String[] args) {
//		System.out.println(isNumberic("000"));
//		System.out.println(isValidDate("20150122095522"));
		regex();
	}
}
