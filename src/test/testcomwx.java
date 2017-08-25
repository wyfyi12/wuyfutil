package test;

import comwx.WXDoParty;
import comwx.WXDoToken;
import net.sf.json.JSONObject;

public class testcomwx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String wxtoken=WXDoToken.gettoken("ww7797f15081472cb7", "dMOrf65rq-FUd8gTtOgLw_wHobbPixa8GSTNxZSCG8o");
		System.out.println(wxtoken);
		JSONObject rs=WXDoParty.getpartylist(wxtoken, "7121273");
		//System.out.println(rs.toString());
	}
}
