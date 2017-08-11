package newmail;

import common.json.DoJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NewMailMod {
	public static JSONObject dropoffuser(String token){
		JSONObject temp = new JSONObject();
		try {
			String rs=DoUser.getpartyuser("1", "1", token).toString();
			JSONArray userja=DoJson.getJSONArrayfromJSONObject(rs, "userlist");
			System.out.println(userja.size());
			for(int i=0;i<userja.size();i++){
				String userid=userja.getJSONObject(i).getString("userid");
				rs=DoUser.deluser(userid, token).getString("errmsg");
				System.out.println("delete "+userid+",rs:"+rs);
				temp.element(userid, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
}
