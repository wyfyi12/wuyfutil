package common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


public class HttpsUtil {
	public static HttpsURLConnection huconn;
	public static HttpsURLConnection getconnbyget(String url){
		try {
			URL u=new URL(url);
			huconn=(HttpsURLConnection) u.openConnection();
			System.out.println("Get HttpURLConnection success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Get HttpURLConnection fail!");
			e.printStackTrace();
		}
		return huconn;
	}
	
	public static HttpsURLConnection getconnbypost(String url){
		try {
			URL u=new URL(url);
			huconn=(HttpsURLConnection) u.openConnection();
			huconn.setHostnameVerifier(new CustomizedHostnameVerifier());
			huconn.setDoOutput(true);
			huconn.setDoInput(true);
			huconn.setRequestMethod("POST");
			//System.out.println("Get HttpURLConnection success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Get HttpURLConnection fail!");
			e.printStackTrace();
		}
		return huconn;
	}
	
	public static void initConnection(Map<String, String> headMap) {
		Iterator<String> it = headMap.keySet().iterator();
		try{
		while (it.hasNext()) {
			String key = it.next();
			String value = headMap.get(key);
			huconn.setRequestProperty(key, value);
			System.out.println("init HttpURLConnection success!");
		}}catch(Exception e){
			System.out.println("init HttpURLConnection fail!");
			e.printStackTrace();
		}
	}
	
	public static String getrsbyget(){
		BufferedReader in = null;        
        StringBuilder result = new StringBuilder(); 
        try{
        //连接服务器  
        huconn.connect();  
        // 取得输入流，并使用Reader读取  
        in = new BufferedReader(new InputStreamReader(huconn.getInputStream(), "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }} catch (Exception e) {
            e.printStackTrace();
        }
        //关闭输入流
        finally{
            try{
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
		return result.toString();
	}
	
	public static String getrsbypost(String data){
		OutputStreamWriter out = null;
		BufferedReader in = null;        
        StringBuilder result = new StringBuilder(); 
        try{
        //连接服务器  
        out = new OutputStreamWriter(huconn.getOutputStream(),"UTF-8");
        out.write(data);
        out.flush();
        out.close();
        // 取得输入流，并使用Reader读取  
        in = new BufferedReader(new InputStreamReader(huconn.getInputStream(), "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
            System.out.println(line);
        }} catch (Exception e) {
            e.printStackTrace();
        }
        //关闭输入流
        finally{
            try{
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
		return result.toString();
	}
}
