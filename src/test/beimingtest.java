package test;

import net.sf.json.JSONObject;
import newmail.DoToken;
import newmail.DoUnreadMail;

public class beimingtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String token=DoToken.gettoken("wm5974ea3ca013db15", "lws31P6tdbbP52WvaHpzPxD1hgRrfmcMvzqUc6IAmlsD4Fu-ElywCn65kzpofYmR");
		System.out.println(token);
		JSONObject unread=new JSONObject();
		unread.element("type", 0);
		//unread.element("userid", "ruan@wxu.edu.cn");
		unread.element("begin_date", "2017-08-29");
		unread.element("end_date", "2017-08-20");
		JSONObject rs=DoUnreadMail.getunreadmail(token, unread,"ruan@wxu.edu.cn");
		System.out.println(rs.toString());
	}

}
