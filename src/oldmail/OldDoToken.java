package oldmail;

import java.util.HashMap;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class OldDoToken {
	public static JSONObject gettoken(String client_id,String client_secret){
		String rs=null;
		try {
		String url="https://exmail.qq.com/cgi-bin/token";	
		HttpsUtil.getconnbypost(url);
		HashMap<String, String> key=new HashMap<>();
		key.put("client_id", client_id);
		key.put("client_secret", client_secret);
		key.put("grant_type", "client_credentials");
		rs=HttpsUtil.getrsbypost(GetData.getData(key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
}
