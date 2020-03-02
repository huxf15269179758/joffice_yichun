package com.hy.powerplatform.my_utils.utils;

import android.util.Log;

import com.hy.powerplatform.my_utils.base.MyApplication;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by xml on 2017/3/22.
 */

public class Util {
    //参数类型
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    /**
     * HttpUrlConnection请求
     */
    public static void getDataByHttpUrlConnection(final String s, final HttpURLConnectionCallBackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                BufferedReader reader = null;
                try {
                    URL url=new URL(s);
                    connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(200000);
                    connection.setConnectTimeout(200000);
                    InputStream in=connection.getInputStream();
                    reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder builder=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        builder.append(line);
                    }
                    //通过回调讲结果发出
                    if (listener!=null){
                        listener.onSuccess(builder.toString());
                    }
                } catch (MalformedURLException e) {
                    if (listener!=null){
                        listener.onFaile(e);
                        Log.i("XXX",e.toString());
                    }
                } catch (IOException e) {
                    Log.i("XXX",e.toString());
                    if (listener!=null){
                        listener.onFaile(e);
                    }
                }finally {
                    if (reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    /**
     * OkHttp请求
     */
    public static void getDataByOkHttp(final String s, final Callback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url(s).build();
                client.newCall(request).enqueue(callback);
            }
        }).start();
    }
    /**
     * Post请求数据
     */
    public static void getDataByPost(final String strUrlPath, final String fullname, final String title, final String mobile, final String birthday, final String email, final HttpURLConnectionCallBackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                BufferedReader reader = null;
                try {
                    URL url=new URL(strUrlPath);
                    connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setReadTimeout(8000);
                    connection.setConnectTimeout(8000);
                    //设置请求体的类型是文本类型
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    //OutputStream out=connection.getOutputStream();
                    //out.write(content.getBytes());
//                    params.put("fullname", String.valueOf(etName.getText().toString().getBytes("UTF-8")));
//                    params.put("title", String.valueOf(tvChengW.getText().toString().getBytes("UTF-8")));
//                    params.put("mobile", String.valueOf(etPhone.getText().toString().getBytes("UTF-8")));
//                    params.put("birthday", String.valueOf(tvLib.getText().toString().getBytes("UTF-8")));
//                    params.put("email", String.valueOf("1526617@163.com".getBytes("UTF-8")));
                    out.writeBytes("fullname="+fullname+"&title="+title+"&mobile="+mobile+"&birthday="+birthday+"&email="+email);
                    InputStream in=connection.getInputStream();
                    reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder builder=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        builder.append(line);
                    }
                    if (listener!=null){
                        listener.onSuccess(builder.toString());
                    }
                } catch (MalformedURLException e) {
                    if (listener!=null){
                        listener.onFaile(e);
                    }
                } catch (IOException e) {
                    if (listener!=null){
                        listener.onFaile(e);
                    }
                }finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }


    public static String submitPostData(String strUrlPath, Map<String, String> params, String encode) {
        byte[] data = getRequestData(params, encode).toString().getBytes();//获得请求体
        String context = data.toString();
        try {

            //String urlPath = "http://192.168.1.9:80/JJKSms/RecSms.php";
            URL url = new URL(strUrlPath);

            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(3000);     //设置连接超时时间
            httpURLConnection.setDoInput(true);                  //打开输入流，以便从服务器获取数据
            httpURLConnection.setDoOutput(true);                 //打开输出流，以便向服务器提交数据
            httpURLConnection.setRequestMethod("POST");     //设置以Post方式提交数据
            httpURLConnection.setUseCaches(false);               //使用Post方式不能使用缓存
            //设置请求体的类型是文本类型
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //设置请求体的长度
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
            //获得输出流，向服务器写入数据
            DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
            out.writeBytes("data"+"="+data);

            int response = httpURLConnection.getResponseCode();            //获得服务器的响应码
            if(response == HttpURLConnection.HTTP_OK) {
                InputStream inptStream = httpURLConnection.getInputStream();
                return dealResponseResult(inptStream);                     //处理服务器的响应结果
            }
        } catch (IOException e) {
            //e.printStackTrace();
            return "err: " + e.getMessage().toString();
        }
        return "-1";
    }

    /*
     * Function  :   封装请求体信息
     * Param     :   params请求体内容，encode编码格式
     */
    public static StringBuffer getRequestData(Map<String, String> params, String encode) {
        StringBuffer stringBuffer = new StringBuffer();        //存储封装好的请求体信息
        try {
            for(Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);    //删除最后的一个"&"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    /*
     * Function  :   处理服务器的响应结果（将输入流转化成字符串）
     * Param     :   inputStream服务器的响应输入流
     */
    public static String dealResponseResult(InputStream inputStream) {
        String resultData = null;      //存储处理结果
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultData = new String(byteArrayOutputStream.toByteArray());
        return resultData;
    }

    /**
     * 上传文件及参数
     */
    private void sendMultipart(){

        File sdcache = MyApplication.getContextObject().getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024;
        //设置超时时间及缓存
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize));


        OkHttpClient mOkHttpClient=builder.build();

        MultipartBody.Builder mbody=new MultipartBody.Builder().setType(MultipartBody.FORM);

        List<File> fileList=new ArrayList<File>();
        File img1=new File("/sdcard/wangshu.jpg");
        fileList.add(img1);
        File img2=new File("/sdcard/123.jpg");
        fileList.add(img2);
        int i=0;
        for(File file:fileList){
            if(file.exists()){
                Log.i("imageName:",file.getName());//经过测试，此处的名称不能相同，如果相同，只能保存最后一个图片，不知道那些同名的大神是怎么成功保存图片的。
                mbody.addFormDataPart("image"+i,file.getName(), RequestBody.create(MEDIA_TYPE_PNG,file));
                i++;
            }
        }

        RequestBody requestBody =mbody.build();
        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + "...")
                .url("http://192.168.1.105/interface/index.php?action=sendMultipart")
                .post(requestBody)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("InfoMSG", response.body().string());
            }
        });
    }
}
