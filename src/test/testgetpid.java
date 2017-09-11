package test;

import newmail.DoToken;
import newmail.NewMailMod;

public class testgetpid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String token=DoToken.gettoken("wm714ea8cd6bcdb5b1", "xwSMBSC5kVUzQFzs3CP5OO-kXvvRF-uByr4uhSw6v2s");
		System.out.println(token);
		NewMailMod.getpartyid("教职工/公共卫生学院/流行病与卫生统计学", token);
		String rs=NewMailMod.addparty("教职工/公共卫生学院/流行病与卫生统计学", token);
		System.out.println(rs);
	}

}
