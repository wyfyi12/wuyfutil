package test;

import java.util.HashMap;

import common.json.DoJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oldmail.OldDoToken;
import oldmail.OldDoUser;
import oldmail.OldMailMod;

public class testmoddomain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject token=OldDoToken.gettoken("nwf.cn","75d03b8ff5f99f45d04598e7ee5754a2");
		String tokens=token.getString("access_token");
		HashMap<String, String> tokenjob=new HashMap<String, String>();
		tokenjob.put("Authorization", "Bearer "+tokens);
		HashMap<String, String> user=new HashMap<String, String>();
		user.put("Ver", "0");
		JSONObject rs=OldDoUser.getuserlist(user, tokenjob);
		JSONArray userja=DoJson.getJSONArrayfromJSONObject(rs.toString(), "List");
		for(int i=0;i<userja.size();i++){
			JSONObject userjob=userja.getJSONObject(i);
			String userid=userjob.getString("Alias");
			String alias=userid.split("@")[0];
			String newuserid=alias+"@l.eexmail.xyz";
			HashMap<String, String> moduser=new HashMap<>();
			moduser.put("Action", "3");
			moduser.put("Alias", userid);
			moduser.put("slave", newuserid);
			String addslavers=OldDoUser.moduser(moduser, tokenjob);
			System.out.println(i+"添加别名:"+newuserid+"rs:"+addslavers);
			String swaprs=OldMailMod.swapalias(userid, newuserid,tokens);
			System.out.println("切换主账号:"+userid+"rs:"+swaprs);
		}
	}

}
