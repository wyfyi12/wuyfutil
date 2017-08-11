package test;

import common.mail.MailUtil;

public class testpoplogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MailUtil.poplogin("wu@njnantu.com", "Nantu123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
