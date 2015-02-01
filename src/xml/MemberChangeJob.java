package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class MemberChangeJob {

	Pattern phonePattern = Pattern.compile("[0-9]{11}");
	
	public void parseXML() throws Exception {
		SAXReader reader = new SAXReader();
		File file = new File("D:/test/file/WSDFRE_GPRS800_BBOSS_20150123113936.001.txt");
		Document doc = reader.read(file);
		Element root = doc.getRootElement();
		Element info = root.element("UserInfo");
		@SuppressWarnings("unchecked")
		Iterator<Element> it = info.elementIterator("UserData");

		//正确的文档
        Document doc_s = DocumentHelper.createDocument();  
        Element interboss_s = doc_s.addElement("InterBoss");//添加文档根  
        Element userinfo_s = interboss_s.addElement("UserInfo"); //添加root的子节点  
        Element productid_s = userinfo_s.addElement("ProductID");
        productid_s.addText("9003259383"); 
        Element effRule_s = userinfo_s.addElement("EffRule");
        effRule_s.addText("0");
		//出错的文档
        Document doc_f = DocumentHelper.createDocument();  
        Element interboss_f = doc_f.addElement("InterBoss");//添加文档根  
        Element userinfo_f = interboss_f.addElement("UserInfo"); //添加root的子节点  
        Element productid_f = userinfo_f.addElement("ProductID");
        productid_f.addText("9003259383"); 
        Element effRule_f = userinfo_f.addElement("EffRule");
        effRule_f.addText("0");
        boolean hasFail = false;
		while (it.hasNext()) {
			Element user = it.next();
			Element mob_num = user.element("MobNum");
			Element oprcode = user.element("OprCode");
			Element userpackage = user.element("UserPackage");
			Element validmonths = user.element("ValidMonths");
			Element usageLimit = user.element("UsageLimit");
			if (phonePattern.matcher(mob_num.getText()).matches()) {
				Element userdata = userinfo_s.addElement("UserData");
		        Element mobnum_s = userdata.addElement("MobNum");
		        mobnum_s.addText(mob_num.getText());
		        Element oprcode_s = userdata.addElement("OprCode");
		        oprcode_s.addText(oprcode.getText());
		        Element userPackage_s = userdata.addElement("UserPackage");
		        userPackage_s.addText(userpackage.getText());
		        Element usageLimit_s = userdata.addElement("UsageLimit");
		        usageLimit_s.addText(usageLimit.getText());
		        Element validMonths_s = userdata.addElement("ValidMonths");
		        validMonths_s.addText(validmonths.getText());
			} else {
				hasFail = true;
				Element userdata = userinfo_f.addElement("UserData");
		        Element mobnum_f = userdata.addElement("MobNum");
		        mobnum_f.addText(mob_num.getText());
		        Element oprcode_f = userdata.addElement("OprCode");
		        oprcode_f.addText(oprcode.getText());
		        Element userPackage_f = userdata.addElement("UserPackage");
		        userPackage_f.addText(userpackage.getText());
		        Element usageLimit_f = userdata.addElement("UsageLimit");
		        usageLimit_f.addText(usageLimit.getText());
		        Element validMonths_f = userdata.addElement("ValidMonths");
		        validMonths_f.addText(validmonths.getText());
			}
		}  
        OutputFormat format = OutputFormat.createPrettyPrint();  
        format.setEncoding("UTF-8");//根据需要设置编码    
        writerDoc("D:/test/right/"+file.getName(), format, doc_s);
        if (hasFail) {
            writerDoc("D:/test/error/rsp_"+file.getName(), format, doc_f);
        }
		file.delete();
		System.out.println("执行完毕。。。。。。。");
	}
	
	public void writerDoc (String filePath, OutputFormat format, Document doc) {
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(new File(filePath)), format);
	        writer.write(doc); //输出到文件  
	        writer.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
    //生成xml
    public void createChangeXML(){  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //建立document对象  
        try {  
                Document document = DocumentHelper.createDocument();  
                Element interboss = document.addElement("InterBoss");//添加文档根  
                Element userinfo = interboss.addElement("UserInfo"); //添加root的子节点  
                Element productid = userinfo.addElement("ProductID");
                productid.addText("9003259383"); 
                Element userdata = userinfo.addElement("UserData");
                Element mobnum = userdata.addElement("MobNum");
                mobnum.addText("18701058605");
                Element oprcode = userdata.addElement("OprCode");
                oprcode.addText("1");
                Element userPackage = userdata.addElement("UserPackage");
                userPackage.addText("10");
                Element usageLimit = userdata.addElement("UsageLimit");
                usageLimit.addText("1000");
                Element validMonths = userdata.addElement("ValidMonths");
                validMonths.addText("00");
                Element effRule = userinfo.addElement("EffRule");
                effRule.addText("0");
                
                //输出全部原始数据，在编译器中显示  
                OutputFormat format = OutputFormat.createPrettyPrint();  
                format.setEncoding("UTF-8");//根据需要设置编码  
                XMLWriter writer = new XMLWriter(System.out, format);  
                document.normalize();  
                writer.write(document);    
                writer.close();  
                // 输出全部原始数据，并用它生成新的我们需要的XML文件  
                XMLWriter writer2 = new XMLWriter(new FileWriter(new File(  
                "D:/ec/ecincoming1/WSDFRE_GPRS800_BBOSS_"+sdf.format(new Date())+".NNN.txt")), format);  
                writer2.write(document); //输出到文件  
                writer2.close();  
       } catch (UnsupportedEncodingException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
       } catch (IOException e) {  
           // TODO Auto-generated catch block  
           e.printStackTrace();  
       }  
   }  
	
	public static void main(String[] args) {
		MemberChangeJob memberChangeJob = new MemberChangeJob();
		try {
			memberChangeJob.parseXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
