package test;

import common.datetime.DoDate;
import comwx.WXDoJssdk;
import comwx.WXDoToken;

public class testgetticket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String token=WXDoToken.gettoken("wwcb74a7ccfe39ba43", "YXXkVz0V6QhFwtkGosQJ53bkynPmRCs8jz_N0XKWqmY");
		System.out.println(token);
		String ticket=WXDoJssdk.getjsticket(token);
		System.out.println(ticket);
		String time=DoDate.gettimestamp();
		System.out.println(time);
		String noncestr="kjadhkj213dad";
		String url="http://119.29.56.97";
		String sig=WXDoJssdk.getsig(noncestr, ticket, time, url);
		System.out.println(sig);
	}

}
