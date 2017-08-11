package oldmail;

import java.util.HashMap;

import common.http.HttpUtil;

/**
 * @author -_-
 *
 */
public class OldMailMod {
	
	/**
	 * @param alias
	 * @param slavealias
	 * @param Authorization
	 * @return
	 */
	public static String swapalias(String alias,String slavealias,String Authorization){
		String rs=null;
		try {
			HashMap<String, String> tokenjob=new HashMap<String, String>();
			tokenjob.put("Authorization", "Bearer "+Authorization);
			HashMap<String , String> swapuser=new HashMap<>();
			swapuser.put("alias", alias);
			swapuser.put("slavealias", slavealias);
			String url="http://openapi.exmail.qq.com:12211/openapi/user/swapalias";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(tokenjob);
			rs=HttpUtil.getrsbypost(GetData.getData(swapuser));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
}
