package test;

import common.json.DoJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import newmail.DoParty;
import newmail.DoToken;

public class testnewdropoff {
	public static void main(String[] args) {
		String token =DoToken.gettoken("wm714ea8cd6bcdb5b1", "xwSMBSC5kVUzQFzs3CP5OO-kXvvRF-uByr4uhSw6v2s");
		while(true){
		delallparty(token);
		}
	}
	
	public static void delallparty(String token){
		JSONObject rsjob=DoParty.getpartylist(token, "4681602092521118201");
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
