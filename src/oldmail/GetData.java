package oldmail;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

public class GetData {
	public static String getData(Map<String, String> paraMap)
			throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = paraMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = paraMap.get(key);
			sb.append(key).append("=").append(value).append("&");
		}
		return sb.toString().substring(0, sb.length());
	}
}
