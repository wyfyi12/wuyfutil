package test;

import common.csv.CsvUtil;
import common.txt.DoTxt;
import net.sf.json.JSONObject;
import newmail.DoToken;
import newmail.DoUser;

public class testdelnjdx {

	public static void main(String[] args) throws Exception {
		CsvUtil cu=new CsvUtil("d://njdx//825.csv");
		String token=DoToken.gettoken("wma1cf2f625b012e46", "JpBVLUEfWpvmkrxG_d4l8o228uAgCmzin8NbPQNEjniHn_hgOnSa0-r3pYL2ucZm");
		DoTxt.createtxt("d://njdx//", "delnjdxlog825.txt");
		//DoTxt.createtxt("d://njdx//", "undelnjdxlog825.txt");
		for(int i=0;i<cu.getRowNum();i++){
			//if(!cu.getString(i, 0).contains("deleted")){
				//DoTxt.writetxt(cu.getString(i, 0), "d://undelnjdxlog823.txt");
			String userid=cu.getString(i, 0).split(",")[0].replace("\"", "");
			//JSONObject userinfo=DoUser.getuser(userid, token);
			//System.out.println(i+"."+userid+","+userinfo.toString());
			JSONObject user=new JSONObject();
			user.element("userid", userid);
			user.element("enable", "0");
			String rs=DoUser.moduser(user, token);
			//JSONObject rs=DoUser.deluser(userid, token);
			System.out.println(i+"."+userid+" "+rs);
			DoTxt.writetxt(userid+" "+rs, "d://njdx//delnjdxlog825.txt");
//			try{
//			if(userinfo.getInt("enable")==0){
//				JSONObject rs=DoUser.deluser(userid, token);
//				System.out.println(userinfo+"-----"+rs);
//				if(rs.getInt("errcode")==0){
//					DoTxt.writetxt(userid+" deleted", "d://njdx//delnjdxlog824.txt");
//				}else{
//					DoTxt.writetxt(userid+" "+rs.getInt("errcode"), "d://njdx//undelnjdxlog824.txt");
//				}
//				
//			}else if(userinfo.getInt("enable")==1){
//				DoTxt.writetxt(userid+" unenable", "d://njdx//undelnjdxlog824.txt");
//			}
//			else{
//				DoTxt.writetxt(userid+","+userinfo, "d://njdx//undelnjdxlog824.txt");
//			}
//			}catch(Exception e){
//				DoTxt.writetxt(userid+","+userinfo, "d://njdx//undelnjdxlog824.txt");
//			}
			}
//			JSONObject user=new JSONObject();
//			user.element("userid", userid);
//			user.element("enable", "0");
//			String rs=DoUser.moduser(user, token);
//			JSONObject rs=DoUser.deluser(userid, token);
//			System.out.println(userid+" "+rs);
//			DoTxt.writetxt(userid+" "+rs, "d://njdxlog822.txt");
		//}
	}
}
