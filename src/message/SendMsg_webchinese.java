package message;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese {

	public static void main(String[] args) throws Exception {

		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", "wander"),
				new NameValuePair("Key", "bce3887147f6ada41240"),
				new NameValuePair("smsMob", "18701058605"),
				new NameValuePair("smsText", "烦恼时，笑一笑，笑来顺心把你绕；失意时，笑一笑，笑出顺利伴你跑；无奈时，笑一笑，笑出舒心美好罩。世界微笑日，愿你多笑笑，开心乐逍遥！") };
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes(
				"utf-8"));
		System.out.println(result); // 打印返回消息状态

		post.releaseConnection();

	}

}
