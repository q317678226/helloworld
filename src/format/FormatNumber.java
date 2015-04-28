package format;

import java.text.DecimalFormat;

public class FormatNumber {
		
	    public static void main(String args[]){
	        format1("###,###.###",111222.34567) ;  
	        format1("######.##",111222.34567);  
	        format1("000,000.000",11222.34567) ;  
	        format1("###,###.###￥",111222.34567) ;  
	        format1("000,000.000￥",11222.34567) ;  
	        format1("##.###%",0.345678) ;  
	        format1("00.###%",0.0345678) ;  
	        format1("###.###\u2030",0.345678) ;  
	    } 
	    
	    public static void format1(String pattern,double value){   // 此方法专门用于完成数字的格式化显示  
	        DecimalFormat df = null ;           // 声明一个DecimalFormat类的对象  
	        df = new DecimalFormat(pattern) ;   // 实例化对象，传入模板  
	        String str = df.format(value) ;     // 格式化数字  
	        System.out.println("使用" + pattern  
	            + "格式化数字" + value + "：" + str) ;  
	    }  
}
