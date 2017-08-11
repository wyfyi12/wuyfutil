package common.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DoJson {
		public static JSONObject getJSONObjectfromString(String str) {
			JSONObject myJsonObject = new JSONObject();
			myJsonObject = JSONObject.fromObject(str);
			return myJsonObject;
		}

		public static JSONArray getJSONArrayfromJSONObject(String str, String str1) {
			JSONObject jsonObjSplit = new JSONObject();
			jsonObjSplit = JSONObject.fromObject(str);
			JSONArray ja = jsonObjSplit.getJSONArray(str1);
			return ja;
		}

		public static JSONObject getJSONObject(JSONArray ja, int i) {
			JSONObject jo = (JSONObject) ja.get(i);
			return jo;
		}
}
