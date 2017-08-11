package test;

import common.csv.CsvUtil;
import common.txt.DoTxt;
import net.sf.json.JSONObject;
import newmail.DoToken;
import newmail.DoUser;

public class testdelnjdx {

	public static void main(String[] args) throws Exception {
		CsvUtil cu=new CsvUtil("d://njdxdel.csv");
		String token=DoToken.gettoken("wma1cf2f625b012e46", "JpBVLUEfWpvmkrxG_d4l8o228uAgCmzin8NbPQNEjniHn_hgOnSa0-r3pYL2ucZm");
		DoTxt.createtxt("d://", "delnjdxlog.txt");
		for(int i=19451;i<cu.getRowNum();i++){
			String userid=cu.getString(i, 0);
			JSONObject user=new JSONObject();
			user.element("userid", userid);
			user.element("enable", "0");
			String rs=DoUser.moduser(user, token);
//			JSONObject rs=DoUser.deluser(userid, token);
			System.out.println(userid+" "+rs);
			DoTxt.writetxt(userid+" "+rs, "d://delnjdxlog.txt");
		}
	}
}
