package test;

import common.json.DoJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import newmail.DoParty;
import newmail.DoToken;

public class testnewdropoff {
	public static void main(String[] args) {
		String token =DoToken.gettoken("wmff3b20d80406cb2e", "Cdsm_D7RlLXsvL5U9ixZUgM-if5ARtJY323GFcCJrBr-_rNO141vispbp-RKyM_S");
		while(true){
		delallparty(token);
		}
	}
	
	public static void delallparty(String token){
		JSONObject rsjob=DoParty.getpartylist(token, "0");
		JSONArray partyja=DoJson.getJSONArrayfromJSONObject(rsjob.toString(), "department");
		if(partyja.size()>1){
			JSONObject party=partyja.getJSONObject(1);
			String pid=party.getString("id");
			delparty(token,pid);
		}
	}
	
	public static void delparty(String token,String id){
		JSONObject rsjob=DoParty.getpartylist(token, id);
		JSONArray partyja=DoJson.getJSONArrayfromJSONObject(rsjob.toString(), "department");
		if(partyja.size()>1){
			JSONObject party=partyja.getJSONObject(1);
			String pid=party.getString("id");
			delparty(token,pid);
		}else{
			DoParty.delparty(token, id);
			//delallparty(token);
		}
	}
}
