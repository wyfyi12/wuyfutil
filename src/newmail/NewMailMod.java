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
	
	public static long getpartyid(String party,String token){
		long pid=0L;
		String[] partys=party.split("/");
		JSONObject partyjob=new JSONObject();
		partyjob.element("name", partys[partys.length-1]);
		partyjob.element("fuzzy", 1);
		JSONObject rs=DoParty.searchparty(token, partyjob);
		for(int i=0;i<rs.getJSONArray("department").size();i++){
			if(rs.getJSONArray("department").getJSONObject(i).getString("path").contains(party)){
				pid=Long.parseLong(rs.getJSONArray("department").getJSONObject(i).getString("id")); 
			}
		}
		return pid;
	}
	
	public static String addparty(String party,String token){
		String rs="";
		String[] partys=party.split("/");
		JSONObject partyjob=new JSONObject();
		if(partys.length<2){
			partyjob.element("name", party);
			partyjob.element("parentid", 1L);
			rs=DoParty.createparty(token, partyjob);
		}else{
			String pparty="";
			for(int i=0;i<partys.length-1;i++){
				pparty=pparty+partys[i]+"/";
			}
			pparty=pparty.substring(0, pparty.length()-1);
			System.out.println(pparty);
			long pid=getpartyid(pparty, token);
			if(pid==0){
				addparty(pparty, token);
				pid=getpartyid(pparty, token);
			}
			partyjob.element("name", partys[partys.length-1]);
			partyjob.element("parentid", pid);
			System.out.println(partyjob.toString());
			rs=DoParty.createparty(token, partyjob);
		}
		return rs;
	}
}
