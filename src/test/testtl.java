package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import common.txt.DoTxt;
import comwx.WXDoToken;
import comwx.WXDoUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class testtl {

	public static void main(String[] args) throws ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		String token =WXDoToken.gettoken("wx33aab90c288c4bab", "F111ETPsMjh4AvJP25FTXryWPvxoiQgLKqjWbzHFcTuCRTSgQmrv7Gn0g43H_Qa-");
		DoTxt.createtxt("d://", "tllog.txt");
		String url = "jdbc:mysql://localhost:3306/weixin?characterEncoding=utf8";
		String alias = "root";
		String password = "123456";
		Connection conn;
		ResultSet rs;
		Statement st;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, alias, password);
		String sql = "select * from	tl";
		st = (Statement) conn.createStatement();
		rs = st.executeQuery(sql);
		int i=1;
		while(rs.next()){
			String userid="tesiro-"+rs.getString("id");
			String phone=rs.getString("phone");
	    	JSONObject user=new JSONObject();
	    	JSONObject extattr=new JSONObject();
	   		JSONArray attrs=new JSONArray();
	   		JSONObject phonejob=new JSONObject();
	   		phonejob.element("name", "座机");
	   		phonejob.element("value", phone);
	   		attrs.add(phonejob);
	   		extattr.element("attrs", attrs);
	    	user.element("userid", userid);
	    	user.element("extattr", extattr);
	    	String rs1=WXDoUser.moduser(user, token);
	    	DoTxt.writetxt(i+"."+rs1, "d://tllog.txt");
	    	i++;
		}
	}

}
