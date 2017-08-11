package test;

import comwx.WXDoMedia;
import comwx.WXDoToken;

public class testdomedia {
	public static void main(String[] args) {
		String token=WXDoToken.gettoken("wwcb74a7ccfe39ba43", "YXXkVz0V6QhFwtkGosQJ53bkynPmRCs8jz_N0XKWqmY");
		boolean rs=WXDoMedia.httpDownload(token, "1rLFJeBSXAWqSYHrt-gcfn-SzxYjOYLNlL2kIqWrWeW6nRhoLbzY0eq_ysj6YQelT", "d://2017072501.jpg");
		System.out.println(rs);
	}
}
