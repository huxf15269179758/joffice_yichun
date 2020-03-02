package com.hy.powerplatform.my_utils.base;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2018/10/26.
 */

public class MyHttpURLConnection {

    public static String getData(String requestUrl, BaseRequestBackTLisenter baseRequestBackLisenter) {
        try {
            //建立连接
//            URL url = new URL(requestUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setDoOutput(false);
//            connection.setDoInput(true);
//            connection.setConnectTimeout(20000);
//            connection.setReadTimeout(20000);
//            connection.connect();
//
//            //获取响应状态
//            int responseCode = connection.getResponseCode();
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            URL url = new URL(requestUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(200000);
            connection.setConnectTimeout(200000);
//                                connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
//                                connection.setRequestProperty("Accept", "application/json");
//                                connection.setRequestProperty("Charset", "UTF-8");
            InputStream in = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String line;
            int responseCode = connection.getResponseCode();
            if (200 == responseCode) {
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
//                responseReader.close();
                baseRequestBackLisenter.success(builder.toString());
                Log.d("HttpGET", builder.toString());
                //JSONObject result = new JSONObject(buffer.toString());
                return builder.toString();
            }else if (401 == responseCode){
                baseRequestBackLisenter.failF("获取数据失败");
            }else {
                baseRequestBackLisenter.fail("faile");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
