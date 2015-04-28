package message;

import java.io.IOException;  
import java.io.InputStream;  
  
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;  
import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.HttpException;  
import org.apache.commons.httpclient.HttpStatus;  
import org.apache.commons.httpclient.NameValuePair;  
import org.apache.commons.httpclient.methods.GetMethod;  
import org.apache.commons.httpclient.methods.PostMethod;  
import org.apache.commons.httpclient.params.HttpMethodParams;  
import org.junit.Test;  
  
public class TestCase {  
  
    @Test  
    public void testGetRequest() throws IllegalStateException, IOException {  
        HttpClient client = new HttpClient();  
        StringBuilder sb = new StringBuilder();  
        InputStream ins = null;  
        String url = "http://fetionapi.appspot.com/api/?me=18701058605&pw=243503&to=18701058605&msg=短信内容";
        // Create a method instance.  
        GetMethod method = new GetMethod(url);  
        // Provide custom retry handler is necessary  
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,  
                new DefaultHttpMethodRetryHandler(3, false));  
        try {  
            // Execute the method.  
            int statusCode = client.executeMethod(method);  
            System.out.println(statusCode);  
            if (statusCode == HttpStatus.SC_OK) {  
                ins = method.getResponseBodyAsStream();  
                byte[] b = new byte[1024];  
                int r_len = 0;  
                while ((r_len = ins.read(b)) > 0) {  
                    sb.append(new String(b, 0, r_len, method  
                            .getResponseCharSet()));  
                }  
            } else {  
                System.err.println("Response Code: " + statusCode);  
            }  
        } catch (HttpException e) {  
            System.err.println("Fatal protocol violation: " + e.getMessage());  
        } catch (IOException e) {  
            System.err.println("Fatal transport error: " + e.getMessage());  
        } finally {  
            method.releaseConnection();  
            if (ins != null) {  
                ins.close();  
            }  
        }  
        System.out.println(sb.toString());  
    }  
  
    @Test  
    public void testPostRequest() throws HttpException, IOException {  
        HttpClient client = new HttpClient();  
        PostMethod method = new PostMethod("http://www.baidu.com/getValue");  
        method.setRequestHeader("Content-Type",  
                "application/x-www-form-urlencoded;charset=gb2312");  
        NameValuePair[] param = { new NameValuePair("age", "11"),  
                new NameValuePair("name", "jay"), };  
        method.setRequestBody(param);  
        int statusCode = client.executeMethod(method);  
        System.out.println(statusCode);  
        method.releaseConnection();  
    }  
  
}  