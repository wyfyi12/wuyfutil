package test;

import common.xml.DoXml;
import comwx.WXDoToken;
import comwx.WXDoUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class testxml {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		       JSONArray xml=DoXml.getxml("d://rtx.xml", "Item");
		       int a=1;
		       String token =WXDoToken.gettoken("wx33aab90c288c4bab", "F111ETPsMjh4AvJP25FTXryWPvxoiQgLKqjWbzHFcTuCRTSgQmrv7Gn0g43H_Qa-");
		       for(int i=0;i<xml.size();i++){
		    	JSONObject userjob=xml.getJSONObject(i);
		    	JSONObject user=new JSONObject();
		    	JSONObject extattr=new JSONObject();
		   		JSONArray attrs=new JSONArray();
		   		JSONObject phone=new JSONObject();
		   		phone.element("name", "座机");
		   		phone.element("value", userjob.getString("Phone"));
		   		attrs.add(phone);
		   		extattr.element("attrs", attrs);
		    	user.element("userid", userjob.getString("UserName"));
		    	user.element("extattr", extattr);
		   		if(userjob.getString("UserName").contains("tl")){
		   			System.out.println(userjob.getString("UserName"));
		   			String rs=WXDoUser.moduser(user, token);
		   			if(rs.contains("updated")){
		   				System.out.println(a+"."+rs);
		   				a++;
		   			}
		   		}
		   		
		       }
	}

}
