package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import common.json.DoJson;
import common.txt.DoTxt;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import newmail.DoParty;
import newmail.DoToken;
import newmail.DoUser;

public class testmoduserinfo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String corpid="wm31d9e71a4dadfdd9";
		String corpsecret="aCR90HV9X8uTMvJBa32HmIAYdVql4l8DOJwhcqmu-848NxKKU5puA60G5QVn0ESQ";
		String token=DoToken.gettoken(corpid, corpsecret);
		DoTxt.createtxt("d://", "ntlog8.txt");
		String url = "jdbc:mysql://localhost:3306/comwx?characterEncoding=utf8";
		String alias = "root";
		String password = "123456";
		Connection conn;
		ResultSet rs;
		Statement st;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, alias, password);
		String sql = "select * from	ntdx";
		st = (Statement) conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()){
			String userid=rs.getString("userid");
			String name=rs.getString("name");
			String position=rs.getString("position");
			String mobile=rs.getString("mobile");
			if(mobile.contains("t")){
				mobile="";
			}
			String extid=rs.getString("extid");
			String party=rs.getString("party");
			System.out.println(party);
			String i=rs.getString("no");
			String[] p=party.split("/");
			String pt=p[p.length-1];
			if(pt.length()>14){
			pt=pt.substring(0,15);
			}
			System.out.println(pt);
			long pid=0;
			JSONObject pjob=new JSONObject();
			pjob.element("name", pt);
			pjob.element("fuzzy", "1");
			JSONObject prs=DoParty.searchparty(token, pjob);
			JSONArray ptja=DoJson.getJSONArrayfromJSONObject(prs.toString(), "department");
			for(int a=0;a<ptja.size();a++){
				if(ptja.getJSONObject(a).toString().contains(party)){
					pid=ptja.getJSONObject(a).getLong("id");
					System.out.println(pid);
				}
			}
			JSONObject user=new JSONObject();
			JSONArray pja=new JSONArray();
			pja.add(pid);
			user.element("userid", userid);
			user.element("name", name);
			user.element("department", pja);
			user.element("position", position);
			user.element("mobile", mobile);
			user.element("extid", extid);
			String urs=DoUser.moduser(user, token);
			System.out.println(i+"."+urs);
			DoTxt.writetxt(i+"."+urs, "d://ntlog8.txt");
		}
//		JSONObject user=new JSONObject();
//		user.put("", "");
//		String rs=DoUser.moduser(user, token);
//		System.out.println(rs);
	}

}
