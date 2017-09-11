package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import common.csv.CsvUtil;
import net.sf.json.JSONObject;
import oldmail.OldDoToken;
import oldmail.OldMailMod;

public class testmodalias {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url = "http://211.87.178.243/gettoken/gettoken";
		String result = sendPost(url, "");
		JSONObject temp = JSONObject.fromObject(result);
		String Authorization =temp.getString("token");
//		JSONObject token=OldDoToken.gettoken("sdshunjing","282cd01b53405b4ceb1cd73fab1fcefb");
//		System.out.println(token.toString());
//		String Authorization =token.getString("access_token");
//		CsvUtil cu=new CsvUtil("d://12346.csv");
//		for(int i=0;i<cu.getRowNum();i++){
//			String userid=cu.getString(i, 0);
//			String slave=cu.getString(i, 1);
//			System.out.println(userid+","+slave);
//			String rs=OldMailMod.swapalias(userid, slave, Authorization);
//			System.out.println(rs);
//		}
		
		String rs=OldMailMod.swapalias("ccupc@upc.edu.cn", "19870047@upc.edu.cn", Authorization);
		System.out.println(rs);
	}

	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	public static String sendPost(String url,String param){
		String result="";
		PrintWriter out=null;
		BufferedReader in=null;
		
		try{
			//����URL������
			URL realUrl=new URL(url);
			URLConnection conn=realUrl.openConnection();
			//����ͨ�õ���������
			conn.setRequestProperty("accept","*/*");
			conn.setRequestProperty("connection","Keep-Alive");
			//��������������post�����
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			//�������out����post��ݷ�ֹ��������
			out=new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
			//out=new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			
			//��������in��ȡ��Ӧ�����
			//in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line="";
			while((line=in.readLine())!=null){
				result+=line;
			}
		}
		catch(Exception e){
			result="url_error";
			//e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
			if(in!=null){
				out.close();
			}
		}
		
		return result;
		
	}
}
