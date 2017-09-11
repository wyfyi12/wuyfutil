package test;

import common.csv.CsvUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import newmail.DoToken;
import newmail.DoUser;

public class addslave {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String token=DoToken.gettoken("wmb2549c958240b8f1", "qLHOPn7CkaM2T13Z4or_28YHNrlCRMXz9DvkmymiXLSI1zCtNYxLrXc8iV2aXkyc");
		CsvUtil cu=new CsvUtil("d://siit.csv");
		//JSONObject users=DoUser.getpartyuser("1", "1", token);
		//System.out.println(users);
		for(int i=0;i<cu.getRowNum();i++){
			JSONObject user=new JSONObject();
			JSONArray slaveja=new JSONArray();
			String userid=cu.getString(i, 0);
			String slave1=cu.getString(i, 1);
			String slave2=cu.getString(i, 2);
			String slave3=cu.getString(i, 3);
			slaveja.add(slave1);
			slaveja.add(slave2);
			slaveja.add(slave3);
			user.element("userid", userid);
			user.element("slaves", slaveja);
			System.out.println("user:"+user.toString());
			String rs=DoUser.moduser(user, token);
			System.out.println(rs);
		}
	}

}
