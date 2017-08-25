package test;

import atg.taglib.json.util.JSONArray;
import comwx.WXDoToken;
import comwx.WXDoUser;
import net.sf.json.JSONObject;
import newmail.DoGroup;
import newmail.DoLogin;
import newmail.DoParty;
import newmail.DoToken;
import newmail.DoUser;
import newmail.DoUserOption;
import newmail.NewMailMod;

public class testnewmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String token=WXDoToken.gettoken("wx33aab90c288c4bab", "F111ETPsMjh4AvJP25FTXryWPvxoiQgLKqjWbzHFcTuCRTSgQmrv7Gn0g43H_Qa-");
		String token=DoToken.gettoken("wm714ea8cd6bcdb5b1", "03-_DX_NFprMvIXcdbA8IWQ247f_-qVDtnjWLQPw4oiQktWvE3nmBU9A6XtCnxha");
		JSONObject loginrs=DoLogin.getloginurl(token, "weida@txmail.xyz");
		System.out.println(loginrs.getString("login_url"));
//JSONObject user=WXDoUser.getuser("tl02507", token);
//System.out.println(user.toString());
		//		JSONObject user=new JSONObject();
//		JSONObject extattr=new JSONObject();
//		JSONArray attrs=new JSONArray();
//		JSONObject phone=new JSONObject();
//		phone.element("name", "座机");
//		phone.element("value", "87227631");
//		attrs.add(phone);
//		extattr.element("attrs", attrs);
//		user.element("userid", "ljj");
//		user.element("extattr", extattr);
//		user.element("email", "wyfyi12@sina.com");
		
//		WXDoUser.moduser(user, token);
//		JSONArray party=new JSONArray();
//		party.add(1L);
//		user.element("userid", "testbyjava12@yzsmarts.xyz");
//		user.element("name", "testbyjava12");
//		user.element("password", "Nantu123");
//		user.element("department", party);
//		String rs=DoUser.adduser(user, token);
//		System.out.println(rs);
		
//		user.element("userid", "testbyjava12@yzsmarts.xyz");
//		user.element("password", "Nantu123");
//		String rs=DoUser.moduser(user, token);
//		System.out.println(rs);
		
//		String rs=DoUser.deluser("testbyjava12@yzsmarts.xyz", token);
//		System.out.println(rs);
		
//		JSONObject rs=DoUser.getuser("testbyjava1@yzsmarts.xyz", token);
//		System.out.println(rs.toString());
		
//		JSONObject rs=DoUser.getpartyuserinfo("1", "1", token);
//		System.out.println(rs.toString());
		
//		JSONArray userlist=new JSONArray();
//		userlist.add("testbyjava12@yzsmarts.xyz");
//		userlist.add("test1@yzsmarts.xyz");
//		JSONObject userlisti=new JSONObject();
//		userlisti.element("userlist", userlist);
//		String rs=DoUser.checkuserlist(userlisti, token);
//		System.out.println(rs);
		
//		JSONObject partyjob=new JSONObject();
//		partyjob.element("name", "javatest1");
//		partyjob.element("parentid", 1);
//		String rs=DoParty.createparty(token, partyjob);
//		System.out.println(rs);
		
//		JSONObject partyjob=new JSONObject();
//		partyjob.element("name", "javatest12");
//		partyjob.element("id", 4681602092521117523L);
//		String rs=DoParty.modparty(token, partyjob);
//		System.out.println(rs);
		
//		String rs=DoParty.delparty(token, "4681602092521117523");
//		System.out.println(rs);
		
//		String rs=DoParty.getpartylist(token, "1");
//		System.out.println(rs);
		
//		JSONObject party=new JSONObject();
//		party.element("name", "javatest1");
//		party.element("fuzzy", "1");
//		rs=DoParty.searchparty(token, party);
//		System.out.println(rs);
		
//		JSONObject group=new JSONObject();
//		JSONArray userlist=new JSONArray();
//		userlist.add("test1@yzsmarts.xyz");
//		userlist.add("test123@yzsmarts.xyz");
//		userlist.add("testbyjava1@yzsmarts.xyz");
//		group.element("groupid", "testgroup1@yzsmarts.xyz");
//		group.element("groupname", "testgroup1");
//		group.element("userlist", userlist);
//		group.element("allow_type", 1);
//		String rs=DoGroup.addgroup(token, group);
//		System.out.println(rs);
		
//		token=DoToken.gettoken("wm714ea8cd6bcdb5b1", "VkTEh4AX8QZz9lMU87sk2DvEaHKToRraHqoz8pZT7esocsyhq1gdhlG6P8ypiTPP");
//		JSONObject option=new JSONObject();
//		JSONArray type=new JSONArray();
//		type.add(1);
//		type.add(2);
//		type.add(3);
//		option.element("userid", "test123@yzsmarts.xyz");
//		option.element("type", type);
//		JSONObject rs=DoUserOption.getusertype(token, option);
//		System.out.println(rs);
		
//		JSONObject rs=NewMailMod.dropoffuser(token);
//		System.out.println(rs.toString());
		}
}
