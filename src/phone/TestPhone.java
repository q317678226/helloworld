package phone;

import com.aspire.gentox.phonesect.model.GetPhone;


public class TestPhone {
	public static void main(String[] args) {
		String mb = "13740399565";
		int provinceid=GetPhone.getInstance().getProv_id(mb);
		String cityName = GetPhone.getInstance().getCityName(mb);
		System.out.println(provinceid);
		System.out.println(cityName);
	}
}
