package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
* 使用dom4j生成xml文档
*/
public class Dom4jBuildXmlDemo {
    public void build01(){
        try {
            //DocumentHelper提供了创建Document对象的方法
            Document document = DocumentHelper.createDocument();
            //添加节点信息
            Element rootElement = document.addElement("modules");
            //这里可以继续添加子节点，也可以指定内容
            rootElement.setText("这个是module标签的文本信息");
            Element element = rootElement.addElement("module");
            
            Element nameElement = element.addElement("name");
            Element valueElement = element.addElement("value");
            Element descriptionElement = element.addElement("description");
            nameElement.setText("名称");
            nameElement.addAttribute("language", "java");//为节点添加属性值
            valueElement.setText("值");
            valueElement.addAttribute("language", "c#");
            descriptionElement.setText("描述");
            descriptionElement.addAttribute("language", "sql server");
            System.out.println(document.asXML()); //将document文档对象直接转换成字符串输出
            Writer fileWriter = new FileWriter("D:/xml/module.xml");
            //dom4j提供了专门写入文件的对象XMLWriter
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
            System.out.println("xml文档添加成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
                 
    //生成xml
    public void createApplicationConfigXML(){  
        //建立document对象  
        try {  
                Document document = DocumentHelper.createDocument();  
                Element root = document.addElement("root");//添加文档根  
                root.addComment("这个一个注释");//加入一行注释  
                Element request = root.addElement("request"); //添加root的子节点  
                request.addAttribute("type", "cat");  
                request.addAttribute("flow", "tong");  
                request.addAttribute("time", "2009");  
                Element pro = request.addElement("pro");  
                pro.addAttribute("type", "att");  
                pro.addAttribute("name", "附件");  
                pro.addText("测试哈子");  
                  
                Element cd = request.addElement("pro");  
                cd.addAttribute("type", "cd");  
                cd.addAttribute("name", "特殊字符过滤");  
                cd.addCDATA("特殊字符");  
                  
                //输出全部原始数据，在编译器中显示  
                OutputFormat format = OutputFormat.createPrettyPrint();  
                format.setEncoding("UTF-8");//根据需要设置编码  
                XMLWriter writer = new XMLWriter(System.out, format);  
                document.normalize();  
                writer.write(document);    
                writer.close();  
                // 输出全部原始数据，并用它生成新的我们需要的XML文件  
                XMLWriter writer2 = new XMLWriter(new FileWriter(new File(  
                "D:/ec/test.xml")), format);  
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
    
    //生成xml
    public void createSuperpositionXML(){  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //建立document对象  
        try {  
                Document document = DocumentHelper.createDocument();  
                Element interboss = document.addElement("InterBoss");//添加文档根  
                Element additioninfo = interboss.addElement("AdditionInfo"); //添加root的子节点  
                Element productid = additioninfo.addElement("ProductID");
                productid.addText("9003259383"); 
                Element userdata = additioninfo.addElement("UserData");
                Element mobnum = userdata.addElement("MobNum");
                mobnum.addText("18701058605");
                Element userPackage = userdata.addElement("UserPackage");
                userPackage.addText("10");
                
                //输出全部原始数据，在编译器中显示  
                OutputFormat format = OutputFormat.createPrettyPrint();  
                format.setEncoding("UTF-8");//根据需要设置编码  
                XMLWriter writer = new XMLWriter(System.out, format);  
                document.normalize();  
                writer.write(document);    
                writer.close();  
                // 输出全部原始数据，并用它生成新的我们需要的XML文件  
                XMLWriter writer2 = new XMLWriter(new FileWriter(new File(  
                "D:/ec/ecincoming1/WSDFRE_GPRSADD_BBOSS_"+sdf.format(new Date())+".001.txt")), format);  
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
        Dom4jBuildXmlDemo demo = new Dom4jBuildXmlDemo();
//        demo.build01();
        demo.createChangeXML();
        demo.createSuperpositionXML();
    }
}