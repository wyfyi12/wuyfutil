package test;

import net.sf.json.JSONObject;
import newmail.DoLog;
import newmail.DoToken;

public class testlog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String token=DoToken.gettoken("wm714ea8cd6bcdb5b1", "hAfGD7Ye2O2lEBd_YGJUXjzg4BSGm2f-cyCh-0EUPaI");
		JSONObject mail=new JSONObject();
		mail.element("begin_date", "2017-08-21");
		mail.element("end_date", "2017-08-21");
		mail.element("mailtype", "0");
		mail.element("userid", "test1@yzsmarts.xyz");
		JSONObject rs=DoLog.getmail(token, mail);
		System.out.println(rs.toString());
	}

}
