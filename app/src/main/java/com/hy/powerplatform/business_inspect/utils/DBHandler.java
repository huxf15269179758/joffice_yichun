package com.hy.powerplatform.business_inspect.utils;

import android.util.Log;

import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.bean.Matter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBHandler {
    //提交优服数据
    public String kaoheCommitValue_(String url, String userName, String kaoheDate, String dirverName,
                                    String userCode, String lineString, String carNo, String busCode,
                                    String gffwYrybyt, String gffwYrybytBz, String gffwYrybytPic, String gffwPth, String gffwPthBz,
                                    String gffwPthPic, String gffwSzwmyy, String gffwSzwmyyBz, String gffwSzwmyyPic, String gffwFwyytd,
                                    String gffwFwyytdBz, String gffwFwyytdPic, String gffwZgsd, String gffwZgsdBz, String gffwZgsdPic,
                                    String gffwBaozhanqi, String gffwBaozhanqiBz, String gffwBaozhanqiPic, String gffwClws, String gffwClwsBz,
                                    String gffwClwsPic, String gffwWpbf, String gffwWpbfBz, String gffwWpbfPic, String gffwLEDlp,
                                    String gffwLEDlpBz, String gffwLEDlpPic, String gffwClbz, String gffwClbzBz, String gffwClbzPic,
                                    String gffwFwzsp, String gffwFwzspBz, String gffwFwzspPic, String gffwWendutf, String gffwWendutfBz,
                                    String gffwWendutfPic, String gffwGuzhanghc, String gffwGuzhanghcBz, String gffwGuzhanghcPic,
                                    String gffwFuwuts, String gffwFuwutsBz, String gffwFuwutsPic, String jsjnTingzhansk,
                                    String jsjnTingzhanskBz, String jsjnTingzhanskPic, String jsjnJiashiypcl, String jsjnJiashiypclBz,
                                    String jsjnJiashiypclPic, String jsjnYibiaojc, String jsjnYibiaojcBz, String jsjnYibiaojcPic,
                                    String jsjnLiheqi, String jsjnLiheqiBz, String jsjnLiheqiPic, String jsjnDwsy, String jsjnDwsyBz,
                                    String jsjnDwsyPic, String jsjnZhuanxiangd, String jsjnZhuanxiangdBz, String jsjnZhuanxiangdPic,
                                    String jsjnGuifantk, String jsjnGuifantkBz, String jsjnGuifantkPic, String aqxcZuishougz,
                                    String aqxcZuishougzBz, String aqxcZuishougzPic, String aqxcWenmingjs, String aqxcWenmingjsBz,
                                    String aqxcWenmingjsPic, String aqxcChaosu, String aqxcChaosuBz, String aqxcChaosuPic, String aqxcShigu,
                                    String aqxcShiguBz, String aqxcShiguPic, String aqxcGuifanjcz, String aqxcGuifanjczBz,
                                    String aqxcGuifanjczPic, String aqxcPaolaid, String aqxcPaolaidBz, String aqxcPaolaidPic,
                                    String aqxcKaiguancm, String aqxcKaiguancmBz, String aqxcKaiguancmPic, String aqxcAnjian,
                                    String aqxcAnjianBz, String aqxcAnjianPic, String aqxcXiaofangss, String aqxcXiaofangssBz,
                                    String aqxcXiaofangssPic, String aqxcZhongdianz, String aqxcZhongdianzBz, String aqxcZhongdianzPic,
                                    String fenshu) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        System.out.println("userName=" + userName);
        System.out.println("kaoheDate=" + kaoheDate);
        System.out.println("carNo=" + carNo);
        System.out.println("busCode=" + busCode);

        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        try {
            json.put("userName", userName);
            json.put("driverName", dirverName);
            json.put("driverCode", userCode);
            json.put("lineCode", lineString);
            json.put("carNo", carNo);
            json.put("busCode", busCode);
            json.put("kaoheDate", kaoheDate);

            json.put("gffwYrybyt", gffwYrybyt);
            json.put("gffwYrybytBz", gffwYrybytBz);
            json.put("gffwYrybytPic", gffwYrybytPic);
            json.put("gffwPth", gffwPth);
            json.put("gffwPthBz", gffwPthBz);
            json.put("gffwPthPic", gffwPthPic);
            json.put("gffwSzwmyy", gffwSzwmyy);
            json.put("gffwSzwmyyBz", gffwSzwmyyBz);
            json.put("gffwSzwmyyPic", gffwSzwmyyPic);
            json.put("gffwFwyytd", gffwFwyytd);
            json.put("gffwFwyytdBz", gffwFwyytdBz);
            json.put("gffwFwyytdPic", gffwFwyytdPic);
            json.put("gffwZgsd", gffwZgsd);
            json.put("gffwZgsdBz", gffwZgsdBz);
            json.put("gffwZgsdPic", gffwZgsdPic);
            json.put("gffwBaozhanqi", gffwBaozhanqi);
            json.put("gffwBaozhanqiBz", gffwBaozhanqiBz);
            json.put("gffwBaozhanqiPic", gffwBaozhanqiPic);
            json.put("gffwClws", gffwClws);
            json.put("gffwClwsBz", gffwClwsBz);
            json.put("gffwClwsPic", gffwClwsPic);
            json.put("gffwWpbf", gffwWpbf);
            json.put("gffwWpbfBz", gffwWpbfBz);
            json.put("gffwWpbfPic", gffwWpbfPic);
            json.put("gffwLEDlp", gffwLEDlp);
            json.put("gffwLEDlpBz", gffwLEDlpBz);
            json.put("gffwLEDlpPic", gffwLEDlpPic);
            json.put("gffwClbz", gffwClbz);
            json.put("gffwClbzBz", gffwClbzBz);
            json.put("gffwClbzPic", gffwClbzPic);
            json.put("gffwFwzsp", gffwFwzsp);
            json.put("gffwFwzspBz", gffwFwzspBz);
            json.put("gffwFwzspPic", gffwFwzspPic);
            json.put("gffwWendutf", gffwWendutf);
            json.put("gffwWendutfBz", gffwWendutfBz);
            json.put("gffwWendutfPic", gffwWendutfPic);
            json.put("gffwGuzhanghc", gffwGuzhanghc);
            json.put("gffwGuzhanghcBz", gffwGuzhanghcBz);
            json.put("gffwGuzhanghcPic", gffwGuzhanghcPic);
            json.put("gffwFuwuts", gffwFuwuts);
            json.put("gffwFuwutsBz", gffwFuwutsBz);
            json.put("gffwFuwutsPic", gffwFuwutsPic);

            json.put("jsjnTingzhansk", jsjnTingzhansk);
            json.put("jsjnTingzhanskBz", jsjnTingzhanskBz);
            json.put("jsjnTingzhanskPic", jsjnTingzhanskPic);
            json.put("jsjnJiashiypcl", jsjnJiashiypcl);
            json.put("jsjnJiashiypclBz", jsjnJiashiypclBz);
            json.put("jsjnJiashiypclPic", jsjnJiashiypclPic);
            json.put("jsjnYibiaojc", jsjnYibiaojc);
            json.put("jsjnYibiaojcBz", jsjnYibiaojcBz);
            json.put("jsjnYibiaojcPic", jsjnYibiaojcPic);
            json.put("jsjnLiheqi", jsjnLiheqi);
            json.put("jsjnLiheqiBz", jsjnLiheqiBz);
            json.put("jsjnLiheqiPic", jsjnLiheqiPic);
            json.put("jsjnDwsy", jsjnDwsy);
            json.put("jsjnDwsyBz", jsjnDwsyBz);
            json.put("jsjnDwsyPic", jsjnDwsyPic);
            json.put("jsjnZhuanxiangd", jsjnZhuanxiangd);
            json.put("jsjnZhuanxiangdBz", jsjnZhuanxiangdBz);
            json.put("jsjnZhuanxiangdPic", jsjnZhuanxiangdPic);
            json.put("jsjnGuifantk", jsjnGuifantk);
            json.put("jsjnGuifantkBz", jsjnGuifantkBz);
            json.put("jsjnGuifantkPic", jsjnGuifantkPic);

            json.put("aqxcZuishougz", aqxcZuishougz);
            json.put("aqxcZuishougzBz", aqxcZuishougzBz);
            json.put("aqxcZuishougzPic", aqxcZuishougzPic);
            json.put("aqxcWenmingjs", aqxcWenmingjs);
            json.put("aqxcWenmingjsBz", aqxcWenmingjsBz);
            json.put("aqxcWenmingjsPic", aqxcWenmingjsPic);
            json.put("aqxcChaosu", aqxcChaosu);
            json.put("aqxcChaosuBz", aqxcChaosuBz);
            json.put("aqxcChaosuPic", aqxcChaosuPic);
            json.put("aqxcShigu", aqxcShigu);
            json.put("aqxcShiguBz", aqxcShiguBz);
            json.put("aqxcShiguPic", aqxcShiguPic);
            json.put("aqxcGuifanjcz", aqxcGuifanjcz);
            json.put("aqxcGuifanjczBz", aqxcGuifanjczBz);
            json.put("aqxcGuifanjczPic", aqxcGuifanjczPic);
            json.put("aqxcPaolaid", aqxcPaolaid);
            json.put("aqxcPaolaidBz", aqxcPaolaidBz);
            json.put("aqxcPaolaidPic", aqxcPaolaidPic);
            json.put("aqxcKaiguancm", aqxcKaiguancm);
            json.put("aqxcKaiguancmBz", aqxcKaiguancmBz);
            json.put("aqxcKaiguancmPic", aqxcKaiguancmPic);
            json.put("aqxcAnjian", aqxcAnjian);
            json.put("aqxcAnjianBz", aqxcAnjianBz);
            json.put("aqxcAnjianPic", aqxcAnjianPic);
            json.put("aqxcXiaofangss", aqxcXiaofangss);
            json.put("aqxcXiaofangssBz", aqxcXiaofangssBz);
            json.put("aqxcXiaofangssPic", aqxcXiaofangssPic);
            json.put("aqxcZhongdianz", aqxcZhongdianz);
            json.put("aqxcZhongdianzBz", aqxcZhongdianzBz);
            json.put("aqxcZhongdianzPic", aqxcZhongdianzPic);
            json.put("fenshu", fenshu);
//            json.put("position", position);
            jsonArray.put(json);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        nvs.add(new BasicNameValuePair("data", String.valueOf(jsonArray)));
        try {
            // ��������ӵ�POST������
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // ��������
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // ��ȡ����ֵ
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            System.out.println("sb=" + sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_.toString());
            if (json_ != null) {
                // String msg = json_.get("msg").toString();
                String show = json_.get("success").toString();
                if (show.equals("true")) {
                    return "";
                } else {
                    return "test";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //提交服务卫生数据
    public String fuwuweishengCommitValue(String url, String examiner, String InspectionDate, String InspectionTime,
                                          String currency, String userCode, String busCode, String road, String section, String weather, String mfbjf,
                                          String note, Map<String, String> map_project, Map<String, String> map_photoName,
                                          Map<String, String> map_beizhu) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        // httpRequst.addHeader("Content-Type",
        // "application/json;charset=utf-8");
        System.out.println("examiner=" + examiner);
        System.out.println("InspectionDate=" + InspectionDate);
        System.out.println("InspectionTime=" + InspectionTime);
        System.out.println("currency=" + currency);
        System.out.println("userCode=" + userCode);
        System.out.println("busCode=" + busCode);
        System.out.println("road=" + road);
        System.out.println("section=" + section);
        System.out.println("weather=" + weather);
        System.out.println("mfbjf=" + mfbjf);
        System.out.println("note=" + note);
        System.out.println("map_project=" + map_project);
        System.out.println("map_photoName=" + map_photoName);
        System.out.println("map_beizhu=" + map_beizhu);
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = new JSONArray();
        try {
            for (String key : map_project.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_project.get(key));
                jsonArray.put(json);
            }
            for (String key : map_photoName.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_photoName.get(key));
                jsonArray1.put(json);
            }
            for (String key : map_beizhu.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_beizhu.get(key));
                jsonArray2.put(json);
            }
        } catch (JSONException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        // List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
        nvs.add(new BasicNameValuePair("data", String.valueOf(jsonArray)));
        nvs.add(new BasicNameValuePair("data_photoName", String.valueOf(jsonArray1)));
        nvs.add(new BasicNameValuePair("data_beizhu", String.valueOf(jsonArray2)));
        nvs.add(new BasicNameValuePair("examiner", examiner));
        nvs.add(new BasicNameValuePair("InspectionDate", InspectionDate));
        nvs.add(new BasicNameValuePair("InspectionTime", InspectionTime));
        nvs.add(new BasicNameValuePair("currency", currency));
        nvs.add(new BasicNameValuePair("userCode", userCode));
        nvs.add(new BasicNameValuePair("busCode", busCode));
        nvs.add(new BasicNameValuePair("road", road));
        nvs.add(new BasicNameValuePair("section", section));
        nvs.add(new BasicNameValuePair("mfbjf", mfbjf));
        nvs.add(new BasicNameValuePair("weather", weather));
        nvs.add(new BasicNameValuePair("note", note));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            Log.i("weisheng", sb.toString());
            reader.close();
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_);
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (msg.equals("保存成功")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    // 提交安全秩序数据
    public String anquanzhixuCommitValue(String url, String examiner, String kaoheDate, String kaoheTime,
                                         String driverName, String driverId, String lineCode, String carNo, String busCode, String depId,
                                         String depName, String section, String pingjia, String luoshi, String note, Map<String, String> map_project,
                                         Map<String, String> map_photoName, Map<String, String> map_beizhu, String position) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        // httpRequst.addHeader("Content-Type",
        // "application/json;charset=utf-8");
        System.out.println("examiner=" + examiner);
        System.out.println("kaoheDate=" + kaoheDate);
        System.out.println("kaoheTime=" + kaoheTime);
        System.out.println("driverName=" + driverName);
        System.out.println("driverId=" + driverId);
        System.out.println("lineCode=" + lineCode);
        System.out.println("carNo=" + carNo);
        System.out.println("busCode=" + busCode);
        System.out.println("depId=" + depId);
        System.out.println("depName=" + depName);
        System.out.println("section=" + section);
        System.out.println("pingjia=" + pingjia);
        System.out.println("luoshi=" + luoshi);
        System.out.println("note=" + note);
        System.out.println("map_project=" + map_project);
        System.out.println("map_photoName=" + map_photoName);
        System.out.println("map_beizhu=" + map_beizhu);
        System.out.println("position=" + position);
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = new JSONArray();
        try {
            for (String key : map_project.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_project.get(key));
                jsonArray.put(json);
            }
            for (String key : map_photoName.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_photoName.get(key));
                jsonArray1.put(json);
            }
            for (String key : map_beizhu.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_beizhu.get(key));
                jsonArray2.put(json);
            }
        } catch (JSONException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        // List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
        JSONObject json = new JSONObject();
        try {
            json.put("examiner", examiner);
            json.put("kaoheDate", kaoheDate);
            json.put("kaoheTime", kaoheTime);
            json.put("driverName", driverName);
            json.put("driverId", driverId);
            json.put("lineCode", lineCode);
            json.put("carNo", carNo);
            json.put("busCode", busCode);
            json.put("depId", depId);
            json.put("depName", depName);
            json.put("section", section);
            json.put("pingjia", pingjia);
            json.put("luoshi", luoshi);
            json.put("note", note);
            json.put("position", position);
            for (String key : map_project.keySet()) {
                if (key.equals("违反标志标线")) {
                    json.put("wfbzbx", map_project.get(key));
                }
                if (key.equals("进靠站")) {
                    json.put("jkz", map_project.get(key));
                }
                if (key.equals("右转弯直行")) {
                    json.put("yzwzx", map_project.get(key));
                }
                if (key.equals("接打手机")) {
                    json.put("jdsj", map_project.get(key));
                }
                if (key.equals("闲谈")) {
                    json.put("xt", map_project.get(key));
                }
                if (key.equals("交通信号")) {
                    json.put("jtxh", map_project.get(key));
                }
                if (key.equals("开快车")) {
                    json.put("kkc", map_project.get(key));
                }
                if (key.equals("安检")) {
                    json.put("aj", map_project.get(key));
                }
                if (key.equals("疲劳驾驶")) {
                    json.put("pljs", map_project.get(key));
                }
                if (key.equals("其他")) {
                    json.put("qt", map_project.get(key));
                }
            }
        } catch (JSONException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        nvs.add(new BasicNameValuePair("data", String.valueOf(jsonArray)));
        nvs.add(new BasicNameValuePair("data_photoName", String.valueOf(jsonArray1)));
        nvs.add(new BasicNameValuePair("data_beizhu", String.valueOf(jsonArray2)));
        nvs.add(new BasicNameValuePair("json", String.valueOf(json)));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_);
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (msg.equals("保存成功")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    // 提交技术状况数据
    public String anquanzhixuCommitValueS(String url, String examiner, String kaoheDate, String kaoheTime, String dirverName,
                                          String userCode, String lineString, String carNo,
                                          String busCode, String section, Map<String, String> map_project, Map<String, String> map_photoName,
                                          Map<String, String> map_beizhu, String position) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        // httpRequst.addHeader("Content-Type",
        // "application/json;charset=utf-8");
        System.out.println("examiner=" + examiner);
        System.out.println("kaoheDate=" + kaoheDate);
        System.out.println("kaoheTime=" + kaoheTime);
        System.out.println("carNo=" + carNo);
        System.out.println("busCode=" + busCode);
        System.out.println("section=" + section);
        System.out.println("map_project=" + map_project);
        System.out.println("map_photoName=" + map_photoName);
        System.out.println("map_beizhu=" + map_beizhu);
        System.out.println("position=" + position);
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = new JSONArray();
        try {
            for (String key : map_project.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_project.get(key));
                jsonArray.put(json);
            }
            for (String key : map_photoName.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_photoName.get(key));
                jsonArray1.put(json);
            }
            for (String key : map_beizhu.keySet()) {
                JSONObject json = new JSONObject();
                json.put(key, map_beizhu.get(key));
                jsonArray2.put(json);
            }
        } catch (JSONException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        // List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
        JSONObject json = new JSONObject();
        try {
            json.put("examiner", examiner);
            json.put("kaoheDate", kaoheDate);
            json.put("kaoheTime", kaoheTime);
            json.put("driverName", dirverName);
            json.put("driverCode", userCode);
            json.put("lineCode", lineString);
            json.put("carNo", carNo);
            json.put("busCode", busCode);
            json.put("section", section);
            json.put("position", position);
            json.put("fenshu", "0.0");
            for (String key : map_project.keySet()) {
                if (key.equals("内部设施")) {
                    json.put("nbss", map_project.get(key));
                }
                if (key.equals("车身外表")) {
                    json.put("cswb", map_project.get(key));
                }
                if (key.equals("灯光部分")) {
                    json.put("dgbf", map_project.get(key));
                }
                if (key.equals("发动机")) {
                    json.put("fdj", map_project.get(key));
                }
                if (key.equals("三漏(气、水、电)")) {
                    json.put("sl", map_project.get(key));
                }
            }
        } catch (JSONException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        nvs.add(new BasicNameValuePair("data", String.valueOf(jsonArray)));
        nvs.add(new BasicNameValuePair("data_photoName", String.valueOf(jsonArray1)));
        nvs.add(new BasicNameValuePair("data_beizhu", String.valueOf(jsonArray2)));
        nvs.add(new BasicNameValuePair("json", String.valueOf(json)));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            Log.i("XXX", sb.toString());
            reader.close();
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_);
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (msg.equals("保存成功")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    // 提交综合评定考核数据
    public String kaoheCommitValue(String url, String userName, String kaoheDate, String dirverName,
                                   String userCode, String lineString, String carNo, String busCode,
                                   String aqxcWmjs, String aqxcWmjsBz, String aqxcWmjsPic, String aqxcPwjs, String aqxcPwjsBz,
                                   String aqxcPwjsPic, String aqxcJcz, String aqxcJczBz, String aqxcJczPic, String aqxcAnjian,
                                   String aqxcAnjianBz, String aqxcAnjianPic, String aqxcZdgfyy, String aqxcZdgfyyBz, String aqxcZdgfyyPic,
                                   String aqxcYingji, String aqxcYingjiBz, String aqxcYingjiPic, String aqxcDanzhan, String aqxcDanzhanBz,
                                   String aqxcDanzhanPic, String aqxcYindaock, String aqxcYindaockBz, String aqxcYindaockPic, String aqxcZdzsk,
                                   String aqxcZdzskBz, String aqxcZdzskPic, String jsjnBabuzou, String jsjnBabuzouBz, String jsjnBabuzouPic,
                                   String jsjnDaisuyz, String jsjnDaisuyzBz, String jsjnDaisuyzPic, String jsjnYibiaojc, String jsjnYibiaojcBz,
                                   String jsjnYibiaojcPic, String jsjnQiqong, String jsjnQiqongBz, String jsjnQiqongPic, String jsjnDangwei,
                                   String jsjnDangweiBz, String jsjnDangweiPic, String jsjnDengguang, String jsjnDengguangBz,
                                   String jsjnDengguangPic, String jsjnKgqb, String jsjnKgqbBz, String jsjnKgqbPic, String jsjnZengjiand,
                                   String jsjnZengjiandBz, String jsjnZengjiandPic, String jsjnZongdianyuan, String jsjnZongdianyuanBz,
                                   String jsjnZongdianyuanPic, String fwgfYryb, String fwgfYrybBz, String fwgfYrybPic, String fwgfYuyantaidu,
                                   String fwgfYuyantaiduBz, String fwgfYuyantaiduPic, String fwgfPutonghua, String fwgfPutonghuaBz,
                                   String fwgfPutonghuaPic, String fwgfZhaogu, String fwgfZhaoguBz, String fwgfZhaoguPic, String fwgfShudao,
                                   String fwgfShudaoBz, String fwgfShudaoPic, String fwgfBaozhanqi, String fwgfBaozhanqiBz,
                                   String fwgfBaozhanqiPic, String fwgfWendu, String fwgfWenduBz, String fwgfWenduPic, String fwgfWeisheng,
                                   String fwgfWeishengBz, String fwgfWeishengPic, String fwgfBaifang, String fwgfBaifangBz,
                                   String fwgfBaifangPic, String fwgfZhanshipai, String fwgfZhanshipaiBz, String fwgfZhanshipaiPic,
                                   String fwgfWeizhan, String fwgfWeizhanBz, String fwgfWeizhanPic, String fwgfErcijz, String fwgfErcijzBz,
                                   String fwgfErcijzPic, String fwgfYiweishipin, String fwgfYiweishipinBz, String fwgfYiweishipinPic,
                                   String fwgfZhongdianzhanjc, String fwgfZhongdianzhanjcBz, String fwgfZhongdianzhanjcPic, String fenshu,
                                   String position) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        System.out.println("userName=" + userName);
        System.out.println("kaoheDate=" + kaoheDate);
        System.out.println("carNo=" + carNo);
        System.out.println("busCode=" + busCode);
        System.out.println("aqxcWmjs=" + aqxcWmjs);
        System.out.println("aqxcWmjsBz=" + aqxcWmjsBz);
        System.out.println("aqxcWmjsPic=" + aqxcWmjsPic);
        System.out.println("aqxcPwjs=" + aqxcPwjs);
        System.out.println("aqxcPwjsBz=" + aqxcPwjsBz);
        System.out.println("aqxcPwjsPic=" + aqxcPwjsPic);
        System.out.println("aqxcJcz=" + aqxcJcz);
        System.out.println("aqxcJczBz=" + aqxcJczBz);
        System.out.println("aqxcJczPic=" + aqxcJczPic);
        System.out.println("aqxcAnjian=" + aqxcAnjian);
        System.out.println("aqxcAnjianBz=" + aqxcAnjianBz);
        System.out.println("aqxcAnjianPic=" + aqxcAnjianPic);
        System.out.println("aqxcZdgfyy=" + aqxcZdgfyy);
        System.out.println("aqxcZdgfyyBz=" + aqxcZdgfyyBz);
        System.out.println("aqxcZdgfyyPic=" + aqxcZdgfyyPic);
        System.out.println("aqxcYingji=" + aqxcYingji);
        System.out.println("aqxcYingjiBz=" + aqxcYingjiBz);
        System.out.println("aqxcYingjiPic=" + aqxcYingjiPic);
        System.out.println("aqxcDanzhan=" + aqxcDanzhan);
        System.out.println("aqxcDanzhanBz=" + aqxcDanzhanBz);
        System.out.println("aqxcDanzhanPic=" + aqxcDanzhanPic);
        System.out.println("aqxcYindaock=" + aqxcYindaock);
        System.out.println("aqxcYindaockBz=" + aqxcYindaockBz);
        System.out.println("aqxcYindaockPic=" + aqxcYindaockPic);
        System.out.println("aqxcZdzsk=" + aqxcZdzsk);
        System.out.println("aqxcZdzskBz=" + aqxcZdzskBz);
        System.out.println("aqxcZdzskPic=" + aqxcZdzskPic);

        System.out.println("jsjnBabuzou=" + jsjnBabuzou);
        System.out.println("jsjnBabuzouBz=" + jsjnBabuzouBz);
        System.out.println("jsjnBabuzouPic=" + jsjnBabuzouPic);
        System.out.println("jsjnDaisuyz=" + jsjnDaisuyz);
        System.out.println("jsjnDaisuyzBz=" + jsjnDaisuyzBz);
        System.out.println("jsjnDaisuyzPic=" + jsjnDaisuyzPic);
        System.out.println("jsjnYibiaojc=" + jsjnYibiaojc);
        System.out.println("jsjnYibiaojcBz=" + jsjnYibiaojcBz);
        System.out.println("jsjnYibiaojcPic=" + jsjnYibiaojcPic);
        System.out.println("jsjnQiqong=" + jsjnQiqong);
        System.out.println("jsjnQiqongBz=" + jsjnQiqongBz);
        System.out.println("jsjnQiqongPic=" + jsjnQiqongPic);
        System.out.println("jsjnDangwei=" + jsjnDangwei);
        System.out.println("jsjnDangweiBz=" + jsjnDangweiBz);
        System.out.println("jsjnDangweiPic=" + jsjnDangweiPic);
        System.out.println("jsjnDengguang=" + jsjnDengguang);
        System.out.println("jsjnDengguangBz=" + jsjnDengguangBz);
        System.out.println("jsjnDengguangPic=" + jsjnDengguangPic);
        System.out.println("jsjnKgqb=" + jsjnKgqb);
        System.out.println("jsjnKgqbBz=" + jsjnKgqbBz);
        System.out.println("jsjnKgqbPic=" + jsjnKgqbPic);
        System.out.println("jsjnZengjiand=" + jsjnZengjiand);
        System.out.println("jsjnZengjiandBz=" + jsjnZengjiandBz);
        System.out.println("jsjnZengjiandPic=" + jsjnZengjiandPic);
        System.out.println("jsjnZongdianyuan=" + jsjnZongdianyuan);
        System.out.println("jsjnZongdianyuanBz=" + jsjnZongdianyuanBz);
        System.out.println("jsjnZongdianyuanPic=" + jsjnZongdianyuanPic);

        System.out.println("fwgfYryb=" + fwgfYryb);
        System.out.println("fwgfYrybBz=" + fwgfYrybBz);
        System.out.println("fwgfYrybPic=" + fwgfYrybPic);
        System.out.println("fwgfYuyantaidu=" + fwgfYuyantaidu);
        System.out.println("fwgfYuyantaiduBz=" + fwgfYuyantaiduBz);
        System.out.println("fwgfYuyantaiduPic=" + fwgfYuyantaiduPic);
        System.out.println("fwgfPutonghua=" + fwgfPutonghua);
        System.out.println("fwgfPutonghuaBz=" + fwgfPutonghuaBz);
        System.out.println("fwgfPutonghuaPic=" + fwgfPutonghuaPic);
        System.out.println("fwgfZhaogu=" + fwgfZhaogu);
        System.out.println("fwgfZhaoguBz=" + fwgfZhaoguBz);
        System.out.println("fwgfZhaoguPic=" + fwgfZhaoguPic);
        System.out.println("fwgfShudao=" + fwgfShudao);
        System.out.println("fwgfShudaoBz=" + fwgfShudaoBz);
        System.out.println("fwgfShudaoPic=" + fwgfShudaoPic);
        System.out.println("fwgfBaozhanqi=" + fwgfBaozhanqi);
        System.out.println("fwgfBaozhanqiBz=" + fwgfBaozhanqiBz);
        System.out.println("fwgfBaozhanqiPic=" + fwgfBaozhanqiPic);
        System.out.println("fwgfWendu=" + fwgfWendu);
        System.out.println("fwgfWenduBz=" + fwgfWenduBz);
        System.out.println("fwgfWenduPic=" + fwgfWenduPic);
        System.out.println("fwgfWeisheng=" + fwgfWeisheng);
        System.out.println("fwgfWeishengBz=" + fwgfWeishengBz);
        System.out.println("fwgfWeishengPic=" + fwgfWeishengPic);
        System.out.println("fwgfBaifang=" + fwgfBaifang);
        System.out.println("fwgfBaifangBz=" + fwgfBaifangBz);
        System.out.println("fwgfBaifangPic=" + fwgfBaifangPic);
        System.out.println("fwgfZhanshipai=" + fwgfZhanshipai);
        System.out.println("fwgfZhanshipaiBz=" + fwgfZhanshipaiBz);
        System.out.println("fwgfZhanshipaiPic=" + fwgfZhanshipaiPic);
        System.out.println("fwgfWeizhan=" + fwgfWeizhan);
        System.out.println("fwgfWeizhanBz=" + fwgfWeizhanBz);
        System.out.println("fwgfWeizhanPic=" + fwgfWeizhanPic);
        System.out.println("fwgfErcijz=" + fwgfErcijz);
        System.out.println("fwgfErcijzBz=" + fwgfErcijzBz);
        System.out.println("fwgfErcijzPic=" + fwgfErcijzPic);
        System.out.println("fwgfYiweishipin=" + fwgfYiweishipin);
        System.out.println("fwgfYiweishipinBz=" + fwgfYiweishipinBz);
        System.out.println("fwgfYiweishipinPic=" + fwgfYiweishipinPic);
        System.out.println("fwgfZhongdianzhanjc=" + fwgfZhongdianzhanjc);
        System.out.println("fwgfZhongdianzhanjcBz=" + fwgfZhongdianzhanjcBz);
        System.out.println("fwgfZhongdianzhanjcPic=" + fwgfZhongdianzhanjcPic);

        System.out.println("fenshu=" + fenshu);
        System.out.println("position=" + position);
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        try {
            json.put("userName", userName);
            json.put("driverName", dirverName);
            json.put("driverCode", userCode);
            json.put("lineCode", lineString);
            json.put("carNo", carNo);
            json.put("busCode", busCode);
            json.put("kaoheDate", kaoheDate);

            json.put("aqxcWmjs", aqxcWmjs);
            json.put("aqxcWmjsBz", aqxcWmjsBz);
            json.put("aqxcWmjsPic", aqxcWmjsPic);
            json.put("aqxcPwjs", aqxcPwjs);
            json.put("aqxcPwjsBz", aqxcPwjsBz);
            json.put("aqxcPwjsPic", aqxcPwjsPic);
            json.put("aqxcJcz", aqxcJcz);
            json.put("aqxcJczBz", aqxcJczBz);
            json.put("aqxcJczPic", aqxcJczPic);
            json.put("aqxcAnjian", aqxcAnjian);
            json.put("aqxcAnjianBz", aqxcAnjianBz);
            json.put("aqxcAnjianPic", aqxcAnjianPic);
            json.put("aqxcZdgfyy", aqxcZdgfyy);
            json.put("aqxcZdgfyyBz", aqxcZdgfyyBz);
            json.put("aqxcZdgfyyPic", aqxcZdgfyyPic);
            json.put("aqxcYingji", aqxcYingji);
            json.put("aqxcYingjiBz", aqxcYingjiBz);
            json.put("aqxcYingjiPic", aqxcYingjiPic);
            json.put("aqxcDanzhan", aqxcDanzhan);
            json.put("aqxcDanzhanBz", aqxcDanzhanBz);
            json.put("aqxcDanzhanPic", aqxcDanzhanPic);
            json.put("aqxcYindaock", aqxcYindaock);
            json.put("aqxcYindaockBz", aqxcYindaockBz);
            json.put("aqxcYindaockPic", aqxcYindaockPic);
            json.put("aqxcZdzsk", aqxcZdzsk);
            json.put("aqxcZdzskBz", aqxcZdzskBz);
            json.put("aqxcZdzskPic", aqxcZdzskPic);

            json.put("jsjnBabuzou", jsjnBabuzou);
            json.put("jsjnBabuzouBz", jsjnBabuzouBz);
            json.put("jsjnBabuzouPic", jsjnBabuzouPic);
            json.put("jsjnDaisuyz", jsjnDaisuyz);
            json.put("jsjnDaisuyzBz", jsjnDaisuyzBz);
            json.put("jsjnDaisuyzPic", jsjnDaisuyzPic);
            json.put("jsjnYibiaojc", jsjnYibiaojc);
            json.put("jsjnYibiaojcBz", jsjnYibiaojcBz);
            json.put("jsjnYibiaojcPic", jsjnYibiaojcPic);
            json.put("jsjnQiqong", jsjnQiqong);
            json.put("jsjnQiqongBz", jsjnQiqongBz);
            json.put("jsjnQiqongPic", jsjnQiqongPic);
            json.put("jsjnDangwei", jsjnDangwei);
            json.put("jsjnDangweiBz", jsjnDangweiBz);
            json.put("jsjnDangweiPic", jsjnDangweiPic);
            json.put("jsjnDengguang", jsjnDengguang);
            json.put("jsjnDengguangBz", jsjnDengguangBz);
            json.put("jsjnDengguangPic", jsjnDengguangPic);
            json.put("jsjnKgqb", jsjnKgqb);
            json.put("jsjnKgqbBz", jsjnKgqbBz);
            json.put("jsjnKgqbPic", jsjnKgqbPic);
            json.put("jsjnZengjiand", jsjnZengjiand);
            json.put("jsjnZengjiandBz", jsjnZengjiandBz);
            json.put("jsjnZengjiandPic", jsjnZengjiandPic);
            json.put("jsjnZongdianyuan", jsjnZongdianyuan);
            json.put("jsjnZongdianyuanBz", jsjnZongdianyuanBz);
            json.put("jsjnZongdianyuanPic", jsjnZongdianyuanPic);

            json.put("fwgfYryb", fwgfYryb);
            json.put("fwgfYrybBz", fwgfYrybBz);
            json.put("fwgfYrybPic", fwgfYrybPic);
            json.put("fwgfYuyantaidu", fwgfYuyantaidu);
            json.put("fwgfYuyantaiduBz", fwgfYuyantaiduBz);
            json.put("fwgfYuyantaiduPic", fwgfYuyantaiduPic);
            json.put("fwgfPutonghua", fwgfPutonghua);
            json.put("fwgfPutonghuaBz", fwgfPutonghuaBz);
            json.put("fwgfPutonghuaPic", fwgfPutonghuaPic);
            json.put("fwgfZhaogu", fwgfZhaogu);
            json.put("fwgfZhaoguBz", fwgfZhaoguBz);
            json.put("fwgfZhaoguPic", fwgfZhaoguPic);
            json.put("fwgfShudao", fwgfShudao);
            json.put("fwgfShudaoBz", fwgfShudaoBz);
            json.put("fwgfShudaoPic", fwgfShudaoPic);
            json.put("fwgfBaozhanqi", fwgfBaozhanqi);
            json.put("fwgfBaozhanqiBz", fwgfBaozhanqiBz);
            json.put("fwgfBaozhanqiPic", fwgfBaozhanqiPic);
            json.put("fwgfWendu", fwgfWendu);
            json.put("fwgfWenduBz", fwgfWenduBz);
            json.put("fwgfWenduPic", fwgfWenduPic);
            json.put("fwgfWeisheng", fwgfWeisheng);
            json.put("fwgfWeishengBz", fwgfWeishengBz);
            json.put("fwgfWeishengPic", fwgfWeishengPic);
            json.put("fwgfBaifang", fwgfBaifang);
            json.put("fwgfBaifangBz", fwgfBaifangBz);
            json.put("fwgfBaifangPic", fwgfBaifangPic);
            json.put("fwgfZhanshipai", fwgfZhanshipai);
            json.put("fwgfZhanshipaiBz", fwgfZhanshipaiBz);
            json.put("fwgfZhanshipaiPic", fwgfZhanshipaiPic);
            json.put("fwgfWeizhan", fwgfWeizhan);
            json.put("fwgfWeizhanBz", fwgfWeizhanBz);
            json.put("fwgfWeizhanPic", fwgfWeizhanPic);
            json.put("fwgfErcijz", fwgfErcijz);
            json.put("fwgfErcijzBz", fwgfErcijzBz);
            json.put("fwgfErcijzPic", fwgfErcijzPic);
            json.put("fwgfYiweishipin", fwgfYiweishipin);
            json.put("fwgfYiweishipinBz", fwgfYiweishipinBz);
            json.put("fwgfYiweishipinPic", fwgfYiweishipinPic);
            json.put("fwgfZhongdianzhanjc", fwgfZhongdianzhanjc);
            json.put("fwgfZhongdianzhanjcBz", fwgfZhongdianzhanjcBz);
            json.put("fwgfZhongdianzhanjcPic", fwgfZhongdianzhanjcPic);

            json.put("fenshu", fenshu);
            json.put("position", position);
            jsonArray.put(json);
        } catch (JSONException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        nvs.add(new BasicNameValuePair("data", String.valueOf(jsonArray)));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            Log.i("XXX", sb.toString());
            reader.close();
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_.toString());
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (msg.equals("保存成功")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //签到
    public String qiandaoCommitValue(String url, String username, String addr, String rq, String sj, String gps,
                                     String userCode, String photoName) {
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);//连接时间
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);//数据传输时间
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        System.out.println("url=" + url);
        System.out.println("username=" + username);
        System.out.println("rq=" + rq);
        System.out.println("sj=" + sj);
        System.out.println("gps=" + gps);
        System.out.println("addr=" + addr);
        System.out.println("photoName=" + photoName);
        System.out.println("userCode=" + userCode);
        nvs.add(new BasicNameValuePair("userName", username));
        nvs.add(new BasicNameValuePair("addr", addr));
        nvs.add(new BasicNameValuePair("rq", rq));
        nvs.add(new BasicNameValuePair("gps", gps));
        nvs.add(new BasicNameValuePair("sj", sj));
        nvs.add(new BasicNameValuePair("userCode", userCode));
        nvs.add(new BasicNameValuePair("photo", photoName));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            System.out.println("sb=" + sb.toString());
            JSONObject json = new JSONObject(sb.toString());
            if (json != null) {
                String msg = json.get("msg").toString();
                String show = json.get("show").toString();
                if (show.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

//    // 自动提示 数据源加载
//    public Map<String, List<String>> getResult(QueryBean bean) {
//        HttpClient httpClient = new DefaultHttpClient();
//        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
//        String url = bean.getUrl();
//        String departCode = bean.getDepartCode() == null ? "" : bean.getDepartCode();
//        HttpPost httpRequst = new HttpPost(url);
//        JSONArray departArr = null;
//        List<String> departList = new ArrayList<String>();
//        // List<String> dList=new ArrayList<String>();
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        try {
//            // 将参数添加的POST请求中
//            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
//            httpRequst.setEntity(uefEntity);
//            Log.d("开始查询", url);
//            // 发送请求
//            HttpResponse res = httpClient.execute(httpRequst);
//            HttpEntity entity = res.getEntity();
//            // 读取返回值
//            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
//            StringBuffer sb = new StringBuffer();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            reader.close();
//            JSONObject json = new JSONObject(sb.toString());
//            String arrType = "departList";
//            String jsonType = "departCode";
//            String mapType = "depart";
//            if (!departCode.equals("")) {
//                arrType = "lineList";
//                jsonType = "lineCode";
//                mapType = "line";
//            }
//            departArr = json.getJSONArray(arrType);
//            /// 处理返回值
//            if (json != null) {
//                Log.d("查询单位/线路", "return");
//                String value = "";// map
//                for (int i = 0; i < departArr.length(); i++) {
//                    json = departArr.getJSONObject(i);
//                    value = json.get(jsonType).toString();
//                    departList.add(value);
//                }
//
//                map.put(mapType, departList);
//
//            }
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }

//    /**
//     * 查询计划、实际 趟次、里程
//     */
//
//    public static JSONArray getQueryData(QueryBean bean) {
//        HttpClient httpClient = new DefaultHttpClient();
//        // 发送参数组装
//        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
//        if (bean.getBusCode() != null) {
//            nvs.add(new BasicNameValuePair("busCode", bean.getBusCode()));
//        }
//        nvs.add(new BasicNameValuePair("beginDate", bean.getBeginDate()));
//        nvs.add(new BasicNameValuePair("endDate", bean.getEndDate()));
//        // 单位
//        Log.e("单位", bean.getDepartCode());
//        nvs.add(new BasicNameValuePair("departCode", bean.getDepartCode()));
//        if (bean.getLineCode() != null) {
//            nvs.add(new BasicNameValuePair("lineCode", bean.getLineCode()));
//        }
//        // 汇总类型
//        Log.e(" 汇总类型", bean.getSumType());
//        nvs.add(new BasicNameValuePair("sumType", bean.getSumType()));
//        String url = bean.getUrl();
//        HttpPost httpRequst = new HttpPost(url);
//        JSONArray jsonArray = null;
//        try {
//            // 将参数添加的POST请求中
//            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
//            httpRequst.setEntity(uefEntity);
//            Log.d("查询", url);
//            // 发送请求
//            HttpResponse res = httpClient.execute(httpRequst);
//            HttpEntity entity = res.getEntity();
//            // 读取返回值
//            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
//            StringBuffer sb = new StringBuffer();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            reader.close();
//            // 生成两列str
//            // String[] ColumnNames = { "planBegin","realBegin" };
//            jsonArray = new JSONArray(sb.toString());
//
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonArray;
//    }

    // 事故管理-事故类型，责任，性质请求
    public List<String> getValues_5(String url, String type) {
        List<String> list = new ArrayList<String>();
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        nvs.add(new BasicNameValuePair("type", type));
        HttpPost httpRequst = new HttpPost(url);
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            System.out.println(sb.toString());
            JSONObject json = new JSONObject(sb.toString());
            if (json != null) {
                JSONArray jsonArg = json.getJSONArray("data");
                if (jsonArg != null) {
                    for (int i = 0; i < jsonArg.length(); i++) {
                        json = jsonArg.getJSONObject(i);
                        String itemValue = json.get("itemValue").toString();
                        list.add(itemValue);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e + "<>" + url);
            e.printStackTrace();
        }
        return list;
    }

    // 提交事故数据
    public String accidentCommitValue(String url, String atAtDate, String atTime, String carNo, String carId,
                                      String depId, String depName, String lineCode, String profileId, String atType, String atLiability,
                                      String acNature, String atPlace, String atReason, String atPhoto, String sideName,
                                      String sideSex, String sideContact, String sideCarPlate, String sideLicenseNum,
                                      String atOtherPay, String atPersonPay, String userCode) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        System.out.println("atAtDate=" + atAtDate);
        System.out.println("atTime=" + atTime);
        System.out.println("carId=" + carId);
        System.out.println("carNo=" + carNo);
        System.out.println("depId=" + depId);
        System.out.println("depName=" + depName);
        System.out.println("lineCode=" + lineCode);
        System.out.println("profileId=" + profileId);
        System.out.println("atType=" + atType);
        System.out.println("atLiability=" + atLiability);
        System.out.println("acNature=" + acNature);
        System.out.println("atPlace=" + atPlace);
        System.out.println("atReason=" + atReason);
        System.out.println("atPhoto=" + atPhoto);
        nvs.add(new BasicNameValuePair("atAtDate", atAtDate));
        nvs.add(new BasicNameValuePair("atTime", atTime));
        nvs.add(new BasicNameValuePair("busCode", carId));
        nvs.add(new BasicNameValuePair("carNo", carNo));
        nvs.add(new BasicNameValuePair("depId", depId));
        nvs.add(new BasicNameValuePair("depName", depName));
        nvs.add(new BasicNameValuePair("lineCode", lineCode));
        nvs.add(new BasicNameValuePair("profileId", profileId));
        nvs.add(new BasicNameValuePair("atType", atType));
        nvs.add(new BasicNameValuePair("atLiability", atLiability));
        nvs.add(new BasicNameValuePair("acNature", acNature));
        nvs.add(new BasicNameValuePair("atPlace", atPlace));
        nvs.add(new BasicNameValuePair("atReason", atReason));
        nvs.add(new BasicNameValuePair("atPhoto", atPhoto));
        nvs.add(new BasicNameValuePair("sideName", sideName));
        nvs.add(new BasicNameValuePair("sideSex", sideSex));
        nvs.add(new BasicNameValuePair("sideContact", sideContact));
        nvs.add(new BasicNameValuePair("sideCarPlate", sideCarPlate));
        nvs.add(new BasicNameValuePair("sideLicenseNum", sideLicenseNum));
        nvs.add(new BasicNameValuePair("atOtherPay", atOtherPay));
        nvs.add(new BasicNameValuePair("atPersonPay", atPersonPay));
        nvs.add(new BasicNameValuePair("userCode", userCode));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_);
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (show.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    // 提交事故编辑数据
    public String accidentCommitValue(String url, String atAtDate, String atTime, String carNo, String carId,
                                      String depId, String depName, String lineCode, String profileId, String atType, String atLiability,
                                      String acNature, String atPlace, String atReason, String atPhoto, String sideName,
                                      String sideSex, String sideContact, String sideCarPlate, String sideLicenseNum,
                                      String atOthrPay, String atPersonPay, String userCode,
                                      String atId, String partyId, String atTreatmentId) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        System.out.println("atAtDate=" + atAtDate);
        System.out.println("atTime=" + atTime);
        System.out.println("carId=" + carId);
        System.out.println("carNo=" + carNo);
        System.out.println("depId=" + depId);
        System.out.println("depName=" + depName);
        System.out.println("lineCode=" + lineCode);
        System.out.println("profileId=" + profileId);
        System.out.println("atType=" + atType);
        System.out.println("atLiability=" + atLiability);
        System.out.println("acNature=" + acNature);
        System.out.println("atPlace=" + atPlace);
        System.out.println("atReason=" + atReason);
        System.out.println("atPhoto=" + atPhoto);
        nvs.add(new BasicNameValuePair("atAtDate", atAtDate));
        nvs.add(new BasicNameValuePair("atTime", atTime));
        nvs.add(new BasicNameValuePair("busCode", carId));
        nvs.add(new BasicNameValuePair("carNo", carNo));
        nvs.add(new BasicNameValuePair("depId", depId));
        nvs.add(new BasicNameValuePair("depName", depName));
        nvs.add(new BasicNameValuePair("lineCode", lineCode));
        nvs.add(new BasicNameValuePair("profileId", profileId));
        nvs.add(new BasicNameValuePair("atType", atType));
        nvs.add(new BasicNameValuePair("atLiability", atLiability));
        nvs.add(new BasicNameValuePair("acNature", acNature));
        nvs.add(new BasicNameValuePair("atPlace", atPlace));
        nvs.add(new BasicNameValuePair("atReason", atReason));
        nvs.add(new BasicNameValuePair("atPhoto", atPhoto));
        nvs.add(new BasicNameValuePair("sideName", sideName));
        nvs.add(new BasicNameValuePair("sideSex", sideSex));
        nvs.add(new BasicNameValuePair("sideContact", sideContact));
        nvs.add(new BasicNameValuePair("sideCarPlate", sideCarPlate));
        nvs.add(new BasicNameValuePair("sideLicenseNum", sideLicenseNum));
        nvs.add(new BasicNameValuePair("atOtherPay", atOthrPay));
        nvs.add(new BasicNameValuePair("atPersonPay", atPersonPay));
        nvs.add(new BasicNameValuePair("userCode", userCode));
        nvs.add(new BasicNameValuePair("atId", atId));
        nvs.add(new BasicNameValuePair("partyId", partyId));
        nvs.add(new BasicNameValuePair("atTreatmentId", atTreatmentId));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_);
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (show.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //提交晋中卫生检查
    public String matterCommitValue(String url, String busCode, String carNo, String xcgCode, String xcgName,
                                    String jcrName, String jcDate, List<Matter.ResultBean> resultBeanList, List<String> stringList) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        System.out.println("busCode=" + busCode);
        System.out.println("carNo=" + carNo);
        System.out.println("xcgCode=" + xcgCode);
        System.out.println("xcgName=" + carNo);
        System.out.println("jcrName=" + jcrName);
        System.out.println("jcDate=" + jcDate);
        nvs.add(new BasicNameValuePair("busCode", busCode));
        nvs.add(new BasicNameValuePair("carNo", carNo));
        nvs.add(new BasicNameValuePair("xcgCode", xcgCode));
        nvs.add(new BasicNameValuePair("xcgName", xcgName));
        nvs.add(new BasicNameValuePair("jcrName", jcrName));
        nvs.add(new BasicNameValuePair("jcDate", jcDate));
        for (int i = 0; i < resultBeanList.size(); i++) {
            nvs.add(new BasicNameValuePair(resultBeanList.get(i).getProjectName(), stringList.get(i)));
        }
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_);
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (show.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //流程前获取数据步骤1
    public String OAQingJiaMor(String turl, String tag) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("defId", tag));
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    String data = json_.toString() + "";
                    return data;
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //流程前获取数据步骤2
    public String OAQingJiaMorNext(String turl, String tag, String name) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("defId", tag));
        nvs.add(new BasicNameValuePair("activityName", name));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //请假流程
    public String OAQingJia(String turl, String person, String time, String startDay, String endDay,
                            String startTime, String endTime, String type, String reason, String dayNum
            , String userName, String userId, String uName, String uId) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("defId", Constant.LEAVERDIFID));
        nvs.add(new BasicNameValuePair("formDefId", Constant.LEAVER));
        nvs.add(new BasicNameValuePair("LiuShuiHao", "No.20190116173"));
        nvs.add(new BasicNameValuePair("fullnameUId", userId));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));

        nvs.add(new BasicNameValuePair("fullname", person));
        nvs.add(new BasicNameValuePair("TianDanRiQi", time));
        nvs.add(new BasicNameValuePair("ksdayType", startDay));
        nvs.add(new BasicNameValuePair("jsdayType", endDay));
        nvs.add(new BasicNameValuePair("beginDate", startTime));
        nvs.add(new BasicNameValuePair("endDate", endTime));
        nvs.add(new BasicNameValuePair("vocationType", type));
        nvs.add(new BasicNameValuePair("shiyou", reason));
        nvs.add(new BasicNameValuePair("vocationDays", dayNum));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //请假待处理流程
    public String OAQingJiaWillDo(final String turl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        try {
            URL url = new URL(turl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(40000);
            connection.setReadTimeout(40000);
            connection.addRequestProperty("Cookie", Session);
            //此时获取的是字节流
            InputStream in = connection.getInputStream();
            //对获取到的输入流进行读取
            reader = new BufferedReader(new InputStreamReader(in)); //将字节流转化成字符流
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_ + "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
//
//
//
//        HttpClient httpClient = new DefaultHttpClient();
//        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
//        HttpPost httpRequst = new HttpPost(turl);
//        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//        httpRequst.setHeader("Cookie", Session);
//        try {
//            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
//            httpRequst.setEntity(uefEntity);
//            HttpResponse res = httpClient.execute(httpRequst);
//            HttpEntity entity = res.getEntity();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
//            StringBuffer sb = new StringBuffer();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            reader.close();
//            Log.i("sb=", sb.toString());
//            JSONObject json_ = new JSONObject(sb.toString());
//            if (json_ != null) {
//                String msg = json_.get("success").toString();
//                if (msg.equals("true")) {
//                    return json_ + "";
//                } else {
//                    return msg;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//            HttpClient httpClient1 = new DefaultHttpClient();
//            List<NameValuePair> nvs1 = new ArrayList<NameValuePair>();
//            HttpPost httpRequst1 = new HttpPost(turl);
//            String Session1 = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//            httpRequst1.setHeader("Cookie", Session1);
//            try {
//                UrlEncodedFormEntity uefEntity1 = new UrlEncodedFormEntity(nvs1, "utf-8");
//                httpRequst1.setEntity(uefEntity1);
//                HttpResponse res1 = httpClient1.execute(httpRequst);
//                HttpEntity entity1 = res1.getEntity();
//                BufferedReader reader1 = new BufferedReader(new InputStreamReader(entity1.getContent()));
//                StringBuffer sb1 = new StringBuffer();
//                String line = null;
//                while ((line = reader1.readLine()) != null) {
//                    sb1.append(line + "\n");
//                }
//                reader1.close();
//                Log.i("sb=", sb1.toString());
//                JSONObject json_ = new JSONObject(sb1.toString());
//                if (json_ != null) {
//                    String msg = json_.get("success").toString();
//                    if (msg.equals("true")) {
//                        return json_ + "";
//                    } else {
//                        return msg;
//                    }
//                }
//            } catch (Exception e1) {
//                System.out.println(e1);
//                e1.printStackTrace();
//            }
//        }
        return "获取数据失败";
    }

    public String GoodsPurchaseAboutDep(final String turl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        try {
            URL url = new URL(turl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(40000);
            connection.setReadTimeout(40000);
            connection.addRequestProperty("Cookie", Session);
            //此时获取的是字节流
            InputStream in = connection.getInputStream();
            //对获取到的输入流进行读取
            reader = new BufferedReader(new InputStreamReader(in)); //将字节流转化成字符流
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_ + "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
//
//
//
//        HttpClient httpClient = new DefaultHttpClient();
//        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
//        HttpPost httpRequst = new HttpPost(turl);
//        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//        httpRequst.setHeader("Cookie", Session);
//        try {
//            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
//            httpRequst.setEntity(uefEntity);
//            HttpResponse res = httpClient.execute(httpRequst);
//            HttpEntity entity = res.getEntity();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
//            StringBuffer sb = new StringBuffer();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            reader.close();
//            Log.i("sb=", sb.toString());
//            JSONObject json_ = new JSONObject(sb.toString());
//            if (json_ != null) {
//                String msg = json_.get("success").toString();
//                if (msg.equals("true")) {
//                    return json_ + "";
//                } else {
//                    return msg;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//            HttpClient httpClient1 = new DefaultHttpClient();
//            List<NameValuePair> nvs1 = new ArrayList<NameValuePair>();
//            HttpPost httpRequst1 = new HttpPost(turl);
//            String Session1 = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//            httpRequst1.setHeader("Cookie", Session1);
//            try {
//                UrlEncodedFormEntity uefEntity1 = new UrlEncodedFormEntity(nvs1, "utf-8");
//                httpRequst1.setEntity(uefEntity1);
//                HttpResponse res1 = httpClient1.execute(httpRequst);
//                HttpEntity entity1 = res1.getEntity();
//                BufferedReader reader1 = new BufferedReader(new InputStreamReader(entity1.getContent()));
//                StringBuffer sb1 = new StringBuffer();
//                String line = null;
//                while ((line = reader1.readLine()) != null) {
//                    sb1.append(line + "\n");
//                }
//                reader1.close();
//                Log.i("sb=", sb1.toString());
//                JSONObject json_ = new JSONObject(sb1.toString());
//                if (json_ != null) {
//                    String msg = json_.get("success").toString();
//                    if (msg.equals("true")) {
//                        return json_ + "";
//                    } else {
//                        return msg;
//                    }
//                }
//            } catch (Exception e1) {
//                System.out.println(e1);
//                e1.printStackTrace();
//            }
//        }
        return "获取数据失败";
    }


    //追回流程
    public String BackFlowList(final String turl) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection=null;
//                BufferedReader reader = null;
//                try {
//                    URL url=new URL(turl);
//                    connection= (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setReadTimeout(200000);
//                    connection.setConnectTimeout(200000);
//                    InputStream in=connection.getInputStream();
//                    reader=new BufferedReader(new InputStreamReader(in));
//                    StringBuilder builder=new StringBuilder();
//                    String line;
//                    int responseCode = connection.getResponseCode();
//                    if (200 == responseCode) {
//                        while ((line=reader.readLine())!=null){
//                            builder.append(line);
//                        }
//                    }
//                    JSONObject jsonObject = new JSONObject(builder.toString());
//                    if (jsonObject != null) {
//                        String msg = jsonObject.get("success").toString();
//                        if (msg.equals("true")) {
//                            return jsonObject + "";
//                        } else {
//                            return msg;
//                        }
//                    }
//                } catch (MalformedURLException e) {
//                    Log.i("XXX",e.toString());
//                } catch (IOException e) {
//                    Log.i("XXX",e.toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                } finally {
//                    if (reader!=null){
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (connection!=null){
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_ + "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "获取数据失败";
    }

    //请假待处理流程详情
    public String OAQingJiaWillDoDex(String turl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        try {
            URL url = new URL(turl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            connection.addRequestProperty("Cookie", Session);
            //此时获取的是字节流
            InputStream in = connection.getInputStream();
            //对获取到的输入流进行读取
            reader = new BufferedReader(new InputStreamReader(in)); //将字节流转化成字符流
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_ + "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

        return "获取数据失败";
    }

    //获取代办数量
    public String OAWillDoNum(String turl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        try {
            URL url = new URL(turl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            connection.addRequestProperty("Cookie", Session);
            //此时获取的是字节流
            InputStream in = connection.getInputStream();
            //对获取到的输入流进行读取
            reader = new BufferedReader(new InputStreamReader(in)); //将字节流转化成字符流
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_ + "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
//
//
//        HttpClient httpClient = new DefaultHttpClient();
//        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
//        HttpPost httpRequst = new HttpPost(turl);
//        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//        httpRequst.setHeader("Cookie", Session);
//        try {
//            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
//            httpRequst.setEntity(uefEntity);
//            HttpResponse res = httpClient.execute(httpRequst);
//            HttpEntity entity = res.getEntity();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
//            StringBuffer sb = new StringBuffer();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            reader.close();
//            Log.i("sb=", sb.toString());
//            JSONObject json_ = new JSONObject(sb.toString());
//            if (json_ != null) {
//                String msg = json_.get("success").toString();
//                if (msg.equals("true")) {
//                    return json_ + "";
//                } else {
//                    return msg;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
        return "获取数据失败";
    }

    //提交数据前获取下一步接收人步骤
    public String OAQingJiaFornt1(String turl, String tag, String name) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("taskId", tag));
        nvs.add(new BasicNameValuePair("isParentFlow", "flase"));
        nvs.add(new BasicNameValuePair("activityName", name));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //最后需要签字的流程  处理之后其他人不再处理
    public String OAQingJiaLast(String turl, String tag) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("taskId", tag));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //获取我的申请列表
    public String OAQingJiaMy(String turl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "获取数据失败";
    }

    //获取我的申请详情
    public String OAQingJiaMyDetail(String turl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
//        String Session = new SharedPreferencesHelper(MyApplication.getContext(),"login").getData(MyApplication.getContext(),"session","");
//        httpRequst.setHeader("Cookie", Session);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "获取数据失败";
    }

    //获取我的申请详情
    public String FlowBack(String turl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "获取数据失败";
    }

    //请假流程领导意见提交
    public String OAQingJiaLeader(String url, String person, String time, String type, String reason,
                                  String beginDate, String endDate, String userName, String userCode,
                                  String signaName, String destName, String taskId, String comments,
                                  String days, String fullnameUId, String fullName, String flowAssignld,
                                  String mainId, String bmfzr, String fgfze, String zjl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("flowAssignId" , flowAssignld));
//        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signaName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comments));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.LEAVER));

        nvs.add(new BasicNameValuePair("fullname", fullName));
        nvs.add(new BasicNameValuePair("fullnameUId", fullnameUId));
        nvs.add(new BasicNameValuePair("TianDanRiQi", time));
        nvs.add(new BasicNameValuePair("beginDate", beginDate));
        nvs.add(new BasicNameValuePair("endDate", endDate));
        nvs.add(new BasicNameValuePair("vocationType", type));
        nvs.add(new BasicNameValuePair("shiyou", reason));
        nvs.add(new BasicNameValuePair("vocationDays", days));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("fgldyj", fgfze));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    /**
     * 合同付款
     */
    //获取流水号
    public String OAContractPayLiuSHui(String url, String data) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//        httpRequst.setHeader("Cookie", Session);
//        nvs.add(new BasicNameValuePair("alias", data));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_.getString("number");
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //请假流程申请
    public String OAFuKuanLiuCHeng(String turl, String person, String time, String department,
                                   String type, String classD, String bigMoney, String smallMoney,
                                   String data, String userName, String userId, String uName,
                                   String uId, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.PAYFLOWDIFID));
        nvs.add(new BasicNameValuePair("skdwqc", classD));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.PAYFLOW));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("YS", type));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userId));
        nvs.add(new BasicNameValuePair("sqr", userName));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("fkyt", data));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工会付款流程申请
    public String OAGHPay(String turl, String person, String time, String department,
                          String type, String classD, String bigMoney, String smallMoney,
                          String data, String userName, String userId, String uName,
                          String uId, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.GHPAYFLOWDIFID));
        nvs.add(new BasicNameValuePair("skdwqc", classD));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GHPAYFLOW));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("YS", type));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userId));
        nvs.add(new BasicNameValuePair("sqr", userName));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("fkyt", data));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工会付款流程申请
    public String OAZGSPay(String turl, String person, String time, String department,
                          String type, String classD, String bigMoney, String smallMoney,
                          String data, String userName, String userId, String uName,
                          String uId, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.ZGSFLOWDIFID));
        nvs.add(new BasicNameValuePair("skdwqc", classD));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.ZGSFLOW));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("YS", type));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userId));
        nvs.add(new BasicNameValuePair("sqr", userName));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("fkyt", data));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //合同付款生成表单提交
    public String OAContractPayUp(String turl, String uName, String uId, String liuShuiNo, String department
            , String userId, String jsb, String name, String time, String situation) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "10093"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CONTRACEPAY));
        nvs.add(new BasicNameValuePair("htbh", liuShuiNo));
//        nvs.add(new BasicNameValuePair("fullnameUId", userId));
        nvs.add(new BasicNameValuePair("cbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("jbrUId", userId));
        nvs.add(new BasicNameValuePair("jbr", jsb));
        nvs.add(new BasicNameValuePair("htmc", name));
        nvs.add(new BasicNameValuePair("spsj", time));
        nvs.add(new BasicNameValuePair("jbqk", situation));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("fgcwldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //合同签订生成表单提交
    public String OAContractSignUp(String turl, String uName, String uId, String name, String department
            , String userId, String person, String time, String situation,String money) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.CONTRACTSIGNDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", "66"));
//        nvs.add(new BasicNameValuePair("fullnameUId", userId));
        nvs.add(new BasicNameValuePair("cbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("cbbmfzrUId", userId));
        nvs.add(new BasicNameValuePair("cbbmfzr", person));
        nvs.add(new BasicNameValuePair("htmc", name));
        nvs.add(new BasicNameValuePair("spsj", time));
        nvs.add(new BasicNameValuePair("jbqk", situation));
        nvs.add(new BasicNameValuePair("csbmyj", ""));
        nvs.add(new BasicNameValuePair("jgbmyj", ""));
        nvs.add(new BasicNameValuePair("flgwyj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        nvs.add(new BasicNameValuePair("je", money));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工会合同签订生成表单提交
    public String OAGHContractSignUp(String turl, String uName, String uId, String name, String department
            , String userId, String person, String time, String situation) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.GHCONTRACTSIGNDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GHCONTRACTSINGLE));
//        nvs.add(new BasicNameValuePair("fullnameUId", userId));
        nvs.add(new BasicNameValuePair("cbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("cbbmfzrUId", userId));
        nvs.add(new BasicNameValuePair("cbbmfzr", person));
        nvs.add(new BasicNameValuePair("htmc", name));
        nvs.add(new BasicNameValuePair("spsj", time));
        nvs.add(new BasicNameValuePair("jbqk", situation));
        nvs.add(new BasicNameValuePair("csbmyj", ""));
        nvs.add(new BasicNameValuePair("jgbmyj", ""));
        nvs.add(new BasicNameValuePair("flgwyj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工会付款生成表单提交
    public String OAGHPayUp(String turl, String uName, String uId, String liuShuiNo, String department
            , String userId, String jsb, String name, String time, String situation) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "10093"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GHPAYFLOW));
        nvs.add(new BasicNameValuePair("htbh", liuShuiNo));
//        nvs.add(new BasicNameValuePair("fullnameUId", userId));
        nvs.add(new BasicNameValuePair("cbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("jbrUId", userId));
        nvs.add(new BasicNameValuePair("jbr", jsb));
        nvs.add(new BasicNameValuePair("htmc", name));
        nvs.add(new BasicNameValuePair("spsj", time));
        nvs.add(new BasicNameValuePair("jbqk", situation));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("fgcwldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //合同付款待办签字提交
    public String OAContractPayLeader(String url, String department, String person, String name,
                                      String time, String situation, String userCode, String destName,
                                      String taskId, String flowAssignld, String mainId, String bmfzr,
                                      String fgfze, String zjl, String fgcwze, String serialNumber, String comment) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.CONTRACEPAYDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CONTRACEPAY));
        nvs.add(new BasicNameValuePair("htbh", serialNumber));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));

        nvs.add(new BasicNameValuePair("cbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("hbrUId", userCode));
        nvs.add(new BasicNameValuePair("jbr", person));
        nvs.add(new BasicNameValuePair("htmc", name));
        nvs.add(new BasicNameValuePair("spsj", time));
        nvs.add(new BasicNameValuePair("jbqk", situation));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("fgldyj", fgfze));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        nvs.add(new BasicNameValuePair("fgcwldyj", fgcwze));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //付款流程待办签字提交
    public String OAPayLiuChengLeader(String url, String time, String person, String department,
                                      String classY, String moneyB, String moneyS, String userCode,
                                      String destName, String signaName, String taskId, String flowAssignld,
                                      String mainId, String bmfzr, String fgfze, String zjl, String fgcwze,
                                      String serialNumber, String comment, String use) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.PAYFLOW));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("skdwqc", classY));
        nvs.add(new BasicNameValuePair("jine", moneyB));
        nvs.add(new BasicNameValuePair("xiaoxie", moneyS));
        nvs.add(new BasicNameValuePair("fkyt", use));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("fgldyj", fgfze));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        nvs.add(new BasicNameValuePair("cwzjyj", fgcwze));

        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工会付款流程待办签字提交
    public String OAGHPayLeader(String url, String time, String person, String department,
                                String classY, String moneyB, String moneyS, String userCode,
                                String destName, String signaName, String taskId, String flowAssignld,
                                String mainId, String bmfzr, String zjl, String fgcwze,
                                String serialNumber, String comment, String use) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GHPAYFLOW));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("skdwqc", classY));
        nvs.add(new BasicNameValuePair("jine", moneyB));
        nvs.add(new BasicNameValuePair("xiaoxie", moneyS));
        nvs.add(new BasicNameValuePair("fkyt", use));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("ghzx", zjl));
        nvs.add(new BasicNameValuePair("cwzjyj", fgcwze));

        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //子公司付款流程待办签字提交
    public String OAZGSPayLeader(String url, String time, String person, String department,
                                String classY, String moneyB, String moneyS, String userCode,
                                String destName, String signaName, String taskId, String flowAssignld,
                                String mainId, String bmfzr, String zjl, String fgcwze,
                                String serialNumber, String comment, String use) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.ZGSFLOW));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("skdwqc", classY));
        nvs.add(new BasicNameValuePair("jine", moneyB));
        nvs.add(new BasicNameValuePair("xiaoxie", moneyS));
        nvs.add(new BasicNameValuePair("fkyt", use));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("ghzx", zjl));
        nvs.add(new BasicNameValuePair("fgldyj", fgcwze));

        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //合同签订流程待办签字提交
    public String OAContractSignLeader(String url, String department, String person, String name,
                                       String time, String situation, String userCode, String destName, String taskId,
                                       String flowAssignld, String mainId, String csbmyj, String jgbmyj, String flgwyj,
                                       String fgldyj, String zjl, String serialNumber, String comment
                                    , String signaName,String cbPerson,String money) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("defId", Constant.CONTRACTSIGNDIFID));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CONTRACTSIGN));
        nvs.add(new BasicNameValuePair("cbbmDid", "500"));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("cbbmfzrUId", userCode));
        nvs.add(new BasicNameValuePair("cbbmfzr", cbPerson));
        nvs.add(new BasicNameValuePair("htmc", name));
        nvs.add(new BasicNameValuePair("spsj", time));
        nvs.add(new BasicNameValuePair("jbqk", situation));
        nvs.add(new BasicNameValuePair("cwsjbyj", csbmyj));
        nvs.add(new BasicNameValuePair("jcbmyj", jgbmyj));
        nvs.add(new BasicNameValuePair("flgwyj", flgwyj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        nvs.add(new BasicNameValuePair("je", money));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工会合同签订流程待办签字提交
    public String OAGHContractSignLeader(String url, String department, String person, String name,
                                         String time, String situation, String userCode, String destName, String taskId,
                                         String flowAssignld, String mainId, String csbmyj, String jgbmyj, String flgwyj,
                                         String fgldyj, String zjl, String serialNumber, String comment, String signaName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("defId", Constant.GHCONTRACTSIGNDIFID));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GHCONTRACTSINGLE));
        nvs.add(new BasicNameValuePair("cbbmDid", "500"));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("cbbmfzrUId", userCode));
        nvs.add(new BasicNameValuePair("cbbmfzr", person));
        nvs.add(new BasicNameValuePair("htmc", name));
        nvs.add(new BasicNameValuePair("spsj", time));
        nvs.add(new BasicNameValuePair("jbqk", situation));
        nvs.add(new BasicNameValuePair("bmfzryj", csbmyj));
        nvs.add(new BasicNameValuePair("cwsjbyj", jgbmyj));
        nvs.add(new BasicNameValuePair("jcbmyj", flgwyj));
        nvs.add(new BasicNameValuePair("flgwyj", fgldyj));
        nvs.add(new BasicNameValuePair("ghzx", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //物质采购流程待办签字提交
    public String OAGoodsPurchaseUp(String turl, String department, String person, String time
            , String name1, String name2, String name3, String name4, String name5, String num1, String num2
            , String num3, String num4, String num5, String money1, String money2, String money3, String money4
            , String money5, String allMoney1, String allMoney2, String allMoney3, String allMoney4
            , String allMoney5, String userCode, String uName, String uId, String hejisl, String hejidj
            , String hejije, String use, String other,String iszc ,String goodsType,String zcDepName
            , String depart1, String depart2, String depart3, String depart4, String depar5) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.GOODSPUECHASEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GOODSPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine2", allMoney2));
        nvs.add(new BasicNameValuePair("jine3", allMoney3));
        nvs.add(new BasicNameValuePair("jine4", allMoney4));
        nvs.add(new BasicNameValuePair("jine5", allMoney5));

        nvs.add(new BasicNameValuePair("danwei1", depart1));
        nvs.add(new BasicNameValuePair("danwei2", depart2));
        nvs.add(new BasicNameValuePair("danwei3", depart3));
        nvs.add(new BasicNameValuePair("danwei4", depart4));
        nvs.add(new BasicNameValuePair("danwei5", depar5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", ""));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("iszc", iszc ));
        nvs.add(new BasicNameValuePair("goodsType", goodsType));
        nvs.add(new BasicNameValuePair("zcDepName", zcDepName));
        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("QiTa", other));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("jcbmyj", ""));
        nvs.add(new BasicNameValuePair("zcgkbmyj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //春城通采购流程待办签字提交
    public String OACCTPurchaseUp(String turl, String department, String person, String time
            , String name1, String name2, String name3, String name4, String name5, String num1, String num2
            , String num3, String num4, String num5, String money1, String money2, String money3, String money4
            , String money5, String allMoney1, String allMoney2, String allMoney3, String allMoney4
            , String allMoney5, String userCode, String uName, String uId, String hejisl, String hejidj
            , String hejije, String use, String other) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.CCTPUECHASEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CCTPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine2", allMoney2));
        nvs.add(new BasicNameValuePair("jine3", allMoney3));
        nvs.add(new BasicNameValuePair("jine4", allMoney4));
        nvs.add(new BasicNameValuePair("jine5", allMoney5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", ""));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("QiTa", other));
        nvs.add(new BasicNameValuePair("xgfj", ""));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("zcgkbmyj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //春城通采购流程待办签字提交
    public String OAGHPurchaseUp(String turl, String department, String person, String time
            , String name1, String name2, String name3, String name4, String name5, String num1, String num2
            , String num3, String num4, String num5, String money1, String money2, String money3, String money4
            , String money5, String allMoney1, String allMoney2, String allMoney3, String allMoney4
            , String allMoney5, String userCode, String uName, String uId, String hejisl, String hejidj
            , String hejije, String use, String other,String userDepart) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("defId", Constant.GHPUECHASEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GHPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine2", allMoney2));
        nvs.add(new BasicNameValuePair("jine3", allMoney3));
        nvs.add(new BasicNameValuePair("jine4", allMoney4));
        nvs.add(new BasicNameValuePair("jine5", allMoney5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", ""));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("QiTa", other));
        nvs.add(new BasicNameValuePair("xgfj", ""));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("zcgkbmyj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //物质采购流程待办签字提交
    public String OAPurchaseUp(String turl, String department, String person, String time, String name1
            , String name2, String name3, String name4, String name5, String num1, String num2
            , String num3, String num4, String num5, String money1, String money2, String money3, String money4
            , String money5, String allMoney1, String allMoney2, String allMoney3, String allMoney4
            , String allMoney5, String userCode, String uName, String uId, String hejisl, String hejidj,
                               String hejije, String use, String other,String iszc ,String goodsType,String zcDepName
            , String depart1, String depart2, String depart3, String depart4,String bz1,String bz2,String bz3,String bz4
            ,String otherMoney,String otherMemo) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.PUECHASEFLOWDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.PUECHASEFLOW));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("QiTa", other));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine2", allMoney2));
        nvs.add(new BasicNameValuePair("jine3", allMoney3));
        nvs.add(new BasicNameValuePair("jine4", allMoney4));
        nvs.add(new BasicNameValuePair("jine5", allMoney5));

        nvs.add(new BasicNameValuePair("danwei1", depart1));
        nvs.add(new BasicNameValuePair("danwei2", depart2));
        nvs.add(new BasicNameValuePair("danwei3", depart3));
        nvs.add(new BasicNameValuePair("danwei4", depart4));
        nvs.add(new BasicNameValuePair("danwei5", depart4));

        nvs.add(new BasicNameValuePair("beizhu1", bz1));
        nvs.add(new BasicNameValuePair("beizhu2", bz2));
        nvs.add(new BasicNameValuePair("beizhu3", bz3));
        nvs.add(new BasicNameValuePair("beizhu4", bz4));

        nvs.add(new BasicNameValuePair("iszc", iszc ));
        nvs.add(new BasicNameValuePair("goodsType", goodsType));
        nvs.add(new BasicNameValuePair("zcDepName", zcDepName));
        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", ""));
        nvs.add(new BasicNameValuePair("hejije", hejije));
        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("jine6", otherMoney));
        nvs.add(new BasicNameValuePair("beizhu6", otherMemo));

        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("jcbmyj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //物质采购流程待办签字提交
    public String OAGoodsPurchaseLeader(String url, String department, String person, String name,
                                        String time, String name1, String name2, String name3, String name4, String name5,
                                        String num1, String num2, String num3, String num4, String num5, String money1,
                                        String money2, String money3, String money4, String money5, String allMoney1,
                                        String allMoney2, String allMoney3, String allMoney4, String allMoney5, String userCode,
                                        String destName, String taskId, String flowAssignld, String mainId, String bmfzryj,
                                        String zcgkbmyj, String fgldyj, String cwzjyj, String zjl, String serialNumber,
                                        String comment, String signaName, String hejisl, String hejidj, String hejije, String use,
                                        String other,String jcbmyj,String danwei1,String danwei2,String danwei3,String danwei4,
                                        String danwei5,String zc,String type) {
        //,String jcbmyj,String danwei1,String danwei2,String danwei3,String danwei4,String danwei5
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GOODSPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", "500"));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("QiTa", other));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine1", allMoney2));
        nvs.add(new BasicNameValuePair("jine1", allMoney3));
        nvs.add(new BasicNameValuePair("jine1", allMoney4));
        nvs.add(new BasicNameValuePair("jine1", allMoney5));

        nvs.add(new BasicNameValuePair("danwei1", danwei1));
        nvs.add(new BasicNameValuePair("danwei2", danwei2));
        nvs.add(new BasicNameValuePair("danwei3", danwei3));
        nvs.add(new BasicNameValuePair("danwei4", danwei4));
        nvs.add(new BasicNameValuePair("danwei5", danwei5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", hejidj));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("iszc ", zc));
        nvs.add(new BasicNameValuePair("goodsType", type));
        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("QiTa", other));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("jcbmyj", jcbmyj));
        nvs.add(new BasicNameValuePair("zcgkbmyj", zcgkbmyj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("cwzjyj", cwzjyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //物质采购流程待办签字提交
    public String OACCTPurchaseLeader(String url, String department, String person, String name,
                                      String time, String name1, String name2, String name3, String name4, String name5,
                                      String num1, String num2, String num3, String num4, String num5, String money1,
                                      String money2, String money3, String money4, String money5, String allMoney1,
                                      String allMoney2, String allMoney3, String allMoney4, String allMoney5, String userCode,
                                      String destName, String taskId, String flowAssignld, String mainId, String bmfzryj,
                                      String zcgkbmyj, String fgldyj, String cwzjyj, String zjl, String serialNumber,
                                      String comment, String signaName, String hejisl, String hejidj, String hejije, String use, String other) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CCTPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", "500"));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("QiTa", other));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine1", allMoney2));
        nvs.add(new BasicNameValuePair("jine1", allMoney3));
        nvs.add(new BasicNameValuePair("jine1", allMoney4));
        nvs.add(new BasicNameValuePair("jine1", allMoney5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", hejidj));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("QiTa", other));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("zcgkbmyj", zcgkbmyj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("cwzjyj", cwzjyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //工会采购流程待办签字提交
    public String OAGhPurchaseLeader(String url, String department, String person, String name,
                                     String time, String name1, String name2, String name3, String name4, String name5,
                                     String num1, String num2, String num3, String num4, String num5, String money1,
                                     String money2, String money3, String money4, String money5, String allMoney1,
                                     String allMoney2, String allMoney3, String allMoney4, String allMoney5, String userCode,
                                     String destName, String taskId, String flowAssignld, String mainId, String bmfzryj,
                                     String zcgkbmyj, String fgldyj, String cwzjyj, String zjl, String serialNumber,
                                     String comment, String signaName, String hejisl, String hejidj, String hejije
            , String use, String other) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GHPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", "500"));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("QiTa", other));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine1", allMoney2));
        nvs.add(new BasicNameValuePair("jine1", allMoney3));
        nvs.add(new BasicNameValuePair("jine1", allMoney4));
        nvs.add(new BasicNameValuePair("jine1", allMoney5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", hejidj));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("QiTa", other));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("ghzx", cwzjyj));
        nvs.add(new BasicNameValuePair("cwzjyj", fgldyj));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //办公采购流程待办签字提交
    public String OAWorkPurchaseLeader(String url, String department, String person, String name, String time
            , String name1, String name2, String name3, String name4, String name5, String dep1, String dep2
            , String dep3, String dep4, String dep5, String num1, String num2, String num3, String num4
            , String num5, String money1, String money2, String money3, String money4, String money5
            , String allMoney1, String allMoney2, String allMoney3, String allMoney4, String allMoney5
            , String userCode, String destName, String taskId, String flowAssignld, String mainId
            , String bmfzryj, String fgldyj, String zjl, String serialNumber, String comment
            , String signaName, String hejisl, String hejidj, String hejije, String other, String type) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.WORKPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("caigouleixing", type));

        nvs.add(new BasicNameValuePair("chanpinmingcheng1", name1));
        nvs.add(new BasicNameValuePair("chanpinmingcheng2", name2));
        nvs.add(new BasicNameValuePair("chanpinmingcheng3", name3));
        nvs.add(new BasicNameValuePair("chanpinmingcheng4", name4));
        nvs.add(new BasicNameValuePair("chanpinmingcheng5", name5));

        nvs.add(new BasicNameValuePair("danwei1", dep1));
        nvs.add(new BasicNameValuePair("danwei2", dep2));
        nvs.add(new BasicNameValuePair("danwei3", dep3));
        nvs.add(new BasicNameValuePair("danwei4", dep4));
        nvs.add(new BasicNameValuePair("danwei5", dep5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine1", allMoney2));
        nvs.add(new BasicNameValuePair("jine1", allMoney3));
        nvs.add(new BasicNameValuePair("jine1", allMoney4));
        nvs.add(new BasicNameValuePair("jine1", allMoney5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", hejidj));
        nvs.add(new BasicNameValuePair("hejije", hejije));
        nvs.add(new BasicNameValuePair("QiTa", other));

        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //物质采购流程待办签字提交
    public String OAWorkPurchaseUp(String turl, String department, String person, String time, String use
            , String name1, String name2, String name3, String name4, String name5, String num1, String num2
            , String num3, String num4, String num5, String money1, String money2, String money3, String money4
            , String money5, String allMoney1, String allMoney2, String allMoney3, String allMoney4
            , String allMoney5, String userCode, String uName, String uId, String hejisl, String hejidj
            , String hejije, String depart1, String depart2, String depart3, String depart4, String depar5, String other
            , String type) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.WORKPUECHASEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.WORKPUECHASE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("QiTa", other));
        nvs.add(new BasicNameValuePair("caigouleixing", type));

        nvs.add(new BasicNameValuePair("chanpinmingcheng1", name1));
        nvs.add(new BasicNameValuePair("chanpinmingcheng2", name2));
        nvs.add(new BasicNameValuePair("chanpinmingcheng3", name3));
        nvs.add(new BasicNameValuePair("chanpinmingcheng4", name4));
        nvs.add(new BasicNameValuePair("chanpinmingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine2", allMoney2));
        nvs.add(new BasicNameValuePair("jine3", allMoney3));
        nvs.add(new BasicNameValuePair("jine4", allMoney4));
        nvs.add(new BasicNameValuePair("jine5", allMoney5));

        nvs.add(new BasicNameValuePair("danwei1", depart1));
        nvs.add(new BasicNameValuePair("danwei2", depart2));
        nvs.add(new BasicNameValuePair("danwei3", depart3));
        nvs.add(new BasicNameValuePair("danwei4", depart4));
        nvs.add(new BasicNameValuePair("danwei5", depar5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", ""));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("zcgkbmyj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("jbldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //物质采购流程待办签字提交3000以上
    public String OAPurchaseLeader(String url, String department, String person, String name,
                                   String time, String name1, String name2, String name3, String name4, String name5,
                                   String num1, String num2, String num3, String num4, String num5, String money1,
                                   String money2, String money3, String money4, String money5, String allMoney1,
                                   String allMoney2, String allMoney3, String allMoney4, String allMoney5, String userCode,
                                   String destName, String taskId, String flowAssignld, String mainId, String bmfzryj,
                                   String gybmyj,String zcgkbmyj, String fgldyj, String cwzjyj, String zjl, String serialNumber,
                                   String comment, String signaName, String hejisl, String hejidj, String hejije, String use
            , String jbldyj, String other,String jcbmyj,String danwei1,String danwei2,String danwei3,String danwei4,
                                   String danwei5,String zc,String type,String bz1,String bz2,String bz3,String bz4,String bz5
            ,String otherMoney,String otherMemo) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.PUECHASEFLOW));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", "500"));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("QiTa", other));

        nvs.add(new BasicNameValuePair("mingcheng1", name1));
        nvs.add(new BasicNameValuePair("mingcheng2", name2));
        nvs.add(new BasicNameValuePair("mingcheng3", name3));
        nvs.add(new BasicNameValuePair("mingcheng4", name4));
        nvs.add(new BasicNameValuePair("mingcheng5", name5));

        nvs.add(new BasicNameValuePair("shuliang1", num1));
        nvs.add(new BasicNameValuePair("shuliang2", num2));
        nvs.add(new BasicNameValuePair("shuliang3", num3));
        nvs.add(new BasicNameValuePair("shuliang4", num4));
        nvs.add(new BasicNameValuePair("shuliang5", num5));

        nvs.add(new BasicNameValuePair("danjia1", money1));
        nvs.add(new BasicNameValuePair("danjia2", money2));
        nvs.add(new BasicNameValuePair("danjia3", money3));
        nvs.add(new BasicNameValuePair("danjia4", money4));
        nvs.add(new BasicNameValuePair("danjia5", money5));

        nvs.add(new BasicNameValuePair("jine1", allMoney1));
        nvs.add(new BasicNameValuePair("jine1", allMoney2));
        nvs.add(new BasicNameValuePair("jine1", allMoney3));
        nvs.add(new BasicNameValuePair("jine1", allMoney4));
        nvs.add(new BasicNameValuePair("jine1", allMoney5));

        nvs.add(new BasicNameValuePair("danwei1", danwei1));
        nvs.add(new BasicNameValuePair("danwei2", danwei2));
        nvs.add(new BasicNameValuePair("danwei3", danwei3));
        nvs.add(new BasicNameValuePair("danwei4", danwei4));
        nvs.add(new BasicNameValuePair("danwei5", danwei5));

        nvs.add(new BasicNameValuePair("beizhu1", bz1));
        nvs.add(new BasicNameValuePair("beizhu2", bz2));
        nvs.add(new BasicNameValuePair("beizhu3", bz3));
        nvs.add(new BasicNameValuePair("beizhu4", bz4));
        nvs.add(new BasicNameValuePair("beizhu5", bz5));

        nvs.add(new BasicNameValuePair("hejisl", hejisl));
        nvs.add(new BasicNameValuePair("hejidj", hejidj));
        nvs.add(new BasicNameValuePair("hejije", hejije));

        nvs.add(new BasicNameValuePair("iszc ", zc));
        nvs.add(new BasicNameValuePair("goodsType", type));
        nvs.add(new BasicNameValuePair("yt", use));
        nvs.add(new BasicNameValuePair("jine6", otherMoney));
        nvs.add(new BasicNameValuePair("beizhu6", otherMemo));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("jcbmyj", jcbmyj));
        nvs.add(new BasicNameValuePair("cggybyj", gybmyj));
        nvs.add(new BasicNameValuePair("zcgkbmyj", zcgkbmyj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("cbfgldyj", jbldyj));
        nvs.add(new BasicNameValuePair("cwzjyj", cwzjyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //驾驶员入职待办签字
    public String OAEntryLeader(String url, String person, String phone, String idCard, String sex,
                                String carType1, String carType2, String carType3, String rlzy1,
                                String rlzy2, String rlzy3, String userCode, String destName, String taskId, String flowAssignld,
                                String mainId, String cwsjbyj, String yyglbyj, String xxjsbyj, String cctkjyxgsyj, String zhglbyj,
                                String rlzyb1, String comment, String signaName, String jbbmyj, String fgs,String ygbh) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.ENTRY));
        nvs.add(new BasicNameValuePair("xm", person));
        nvs.add(new BasicNameValuePair("lxdh", phone));
        nvs.add(new BasicNameValuePair("sfzh", idCard));
        nvs.add(new BasicNameValuePair("xmUId", userCode));
        nvs.add(new BasicNameValuePair("fgs", fgs));
        nvs.add(new BasicNameValuePair("ygbh", ygbh));

        nvs.add(new BasicNameValuePair("zjcx1", carType1));
        nvs.add(new BasicNameValuePair("zjcx2", carType2));
        nvs.add(new BasicNameValuePair("zjcx3", carType3));

        nvs.add(new BasicNameValuePair("rlzyb1", rlzy1));
        nvs.add(new BasicNameValuePair("rlzyb2", rlzy2));
        nvs.add(new BasicNameValuePair("rlzyb3", rlzy3));

        nvs.add(new BasicNameValuePair("cwsjbyj", cwsjbyj));
        nvs.add(new BasicNameValuePair("yyglbyj", yyglbyj));
        nvs.add(new BasicNameValuePair("xxjsbyj", xxjsbyj));
        nvs.add(new BasicNameValuePair("cctkjyxgsyj", cctkjyxgsyj));
        nvs.add(new BasicNameValuePair("zhglbyj", zhglbyj));
        nvs.add(new BasicNameValuePair("jbbmyj", jbbmyj));
        nvs.add(new BasicNameValuePair("rlzybyj", rlzyb1));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //员工入职待办签字
    public String OAWillAssessLeader(String url, String person, String phone, String idCard, String sex,
                                String department, String userCode, String destName, String taskId, String flowAssignld,
                                String mainId, String jsbmyj, String cwsjbyj, String xxjsbyj, String cctkjyxgsyj,
                                String ygbh, String comment, String signaName, String carType) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.WORKENTRY));
        nvs.add(new BasicNameValuePair("xm", person));
        nvs.add(new BasicNameValuePair("lxdh", phone));
        nvs.add(new BasicNameValuePair("sfzh", idCard));
        nvs.add(new BasicNameValuePair("xmUId", userCode));
        nvs.add(new BasicNameValuePair("zjcx", carType));
        nvs.add(new BasicNameValuePair("bumen", department));
        nvs.add(new BasicNameValuePair("sex", sex));
        nvs.add(new BasicNameValuePair("gonghao", ygbh));

        nvs.add(new BasicNameValuePair("jbbmyj", jsbmyj));
        nvs.add(new BasicNameValuePair("cwsjbyj", cwsjbyj));
        nvs.add(new BasicNameValuePair("xxjsbyj", xxjsbyj));
        nvs.add(new BasicNameValuePair("cctkjyxgsyj", cctkjyxgsyj));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //驾驶员入职发布
    public String OAEntryUp(String turl, String uName, String uId, String person, String phone, String idCard
            , String sex, String carType, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.ENTRYDIFID));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.ENTRY));

        nvs.add(new BasicNameValuePair("xm", person));
        nvs.add(new BasicNameValuePair("lxdh", phone));
        nvs.add(new BasicNameValuePair("sfzh", idCard));
        nvs.add(new BasicNameValuePair("xb", sex));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("zjcx", carType));

        nvs.add(new BasicNameValuePair("cwsjbyj", ""));
        nvs.add(new BasicNameValuePair("yyglbyj", ""));
        nvs.add(new BasicNameValuePair("xxjsbyj", ""));
        nvs.add(new BasicNameValuePair("cctkjyxgsyj", ""));
        nvs.add(new BasicNameValuePair("zhglbyj", ""));
        nvs.add(new BasicNameValuePair("rlzybyj", ""));
        nvs.add(new BasicNameValuePair("jbbmyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //员工入职待办签字
    public String OAWorkEntryUp(String turl, String uName, String uId, String person, String phone, String idCard
            , String sex, String carType, String liushuihao, String bumenDid, String bumen) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.WORKENTRYDIFID));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.WORKENTRY));

        nvs.add(new BasicNameValuePair("xm", person));
        nvs.add(new BasicNameValuePair("lxdh", phone));
        nvs.add(new BasicNameValuePair("sfzh", idCard));
        nvs.add(new BasicNameValuePair("xb", sex));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("zjcx", carType));
        nvs.add(new BasicNameValuePair("bumenDid", bumenDid));
        nvs.add(new BasicNameValuePair("bumen", bumen));

        nvs.add(new BasicNameValuePair("jbbmyj", ""));
        nvs.add(new BasicNameValuePair("cwsjbyj", ""));
        nvs.add(new BasicNameValuePair("xxjsbyj", ""));
        nvs.add(new BasicNameValuePair("gonghao", ""));
        nvs.add(new BasicNameValuePair("cctkjyxgsyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //集团发文流程提交
    public String OAOutMessageUp(String turl, String uName, String uId, String title, String zhuSong
            , String chaoBao, String chaoSong, String niGao, String heGao, String num, String wenHao
            , String riQi, String xuHao, String userId, String userName, String time) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("defId", Constant.OUTMESSAGEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.OUTMESSAGE));

        nvs.add(new BasicNameValuePair("FaWenBiaoTi", title));
        nvs.add(new BasicNameValuePair("ZhuSongRen", zhuSong));
        nvs.add(new BasicNameValuePair("ChaoBaoRen", chaoBao));
        nvs.add(new BasicNameValuePair("ChaoSongRen", chaoSong));
        nvs.add(new BasicNameValuePair("NiGaoRenUId", userId));
        nvs.add(new BasicNameValuePair("NiGaoRen", niGao));

        nvs.add(new BasicNameValuePair("HeGaoRen", heGao));
        nvs.add(new BasicNameValuePair("WenHaoRiQi", ""));
        nvs.add(new BasicNameValuePair("YinFaRiQi", ""));
        nvs.add(new BasicNameValuePair("FaWenRiQi", ""));
        nvs.add(new BasicNameValuePair("FaWenWenHao", wenHao));

        nvs.add(new BasicNameValuePair("FaWenXuHao", xuHao));
        nvs.add(new BasicNameValuePair("YinFaFenShu", num));

        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //集团发文待办签字
    public String OAOutMessageLeader(String url, String title, String zhuSong, String chaoBao,
                                     String chaoSong, String niGao, String heGao, String num, String wenHao, String date,
                                     String xuHao, String userCode, String destName, String taskId, String flowAssignld,
                                     String mainId, String fgldyj, String zjl, String serialNumber, String comment,
                                     String signaName, String userName, String time) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.OUTMESSAGE));

        nvs.add(new BasicNameValuePair("FaWenBiaoTi", title));
        nvs.add(new BasicNameValuePair("ZhuSongRen", zhuSong));
        nvs.add(new BasicNameValuePair("ChaoBaoRen", chaoBao));
        nvs.add(new BasicNameValuePair("ChaoSongRen", chaoSong));
        nvs.add(new BasicNameValuePair("NiGaoRenUId", userCode));
        nvs.add(new BasicNameValuePair("NiGaoRen", niGao));

        nvs.add(new BasicNameValuePair("HeGaoRen", heGao));
        nvs.add(new BasicNameValuePair("HeGaoRenUId", userCode));
        nvs.add(new BasicNameValuePair("YinFaRiQi", time));
        nvs.add(new BasicNameValuePair("FaWenWenHao", wenHao));

        nvs.add(new BasicNameValuePair("WenHaoRiQi", date));
        nvs.add(new BasicNameValuePair("FaWenXuHao", xuHao));
        nvs.add(new BasicNameValuePair("YinFaFenShu", num));

        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //报修审批发布
    public String OARepairUp(String turl, String uName, String uId, String department, String address
            , String date, String data, String departP, String userId, String userName, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.REPAIRDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.REPAIR));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("BaoXiuBuMenMingChengDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
//        nvs.add(new BasicNameValuePair("fullnameUId", userId));
        nvs.add(new BasicNameValuePair("BaoXiuBuMenMingCheng", department));
        nvs.add(new BasicNameValuePair("BaoXiuDiDian", address));
        nvs.add(new BasicNameValuePair("RiQi", date));
        nvs.add(new BasicNameValuePair("JuTiQingKuang", data));
        nvs.add(new BasicNameValuePair("BaoXiuBuMenRenYuanQianZiUId", userId));
        nvs.add(new BasicNameValuePair("BaoXiuBuMenRenYuanQianZi", userName));
        nvs.add(new BasicNameValuePair("WeiXiuRenYuanQianZiUId", ""));
        nvs.add(new BasicNameValuePair("WeiXiuRenYuanQianZi", ""));
        nvs.add(new BasicNameValuePair("WeiXiuQingKuangFanKuiYiJian", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //保修项目待办签字
    public String OARepairLeader(String url, String departement, String address, String date, String data
            , String yj, String userCode, String destName, String taskId, String flowAssignld, String mainId
            , String etLeaderW1, String etLeaderW2, String etLeaderW3, String etLeaderW4, String etLeaderW5
            , String zjl, String serialNumber, String comment, String signaName, String userName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.REPAIR));

        nvs.add(new BasicNameValuePair("BaoXiuBuMenMingChengDid", "500"));
        nvs.add(new BasicNameValuePair("BaoXiuBuMenMingCheng", departement));
        nvs.add(new BasicNameValuePair("BaoXiuDiDian", address));
        nvs.add(new BasicNameValuePair("BaoXiuiRiQi", date));
        nvs.add(new BasicNameValuePair("JuTiQingKuang", data));
//        nvs.add(new BasicNameValuePair("JuTiShiXiang", userCode));
//        nvs.add(new BasicNameValuePair("NiGaoRen", userName));

        nvs.add(new BasicNameValuePair("bmfzryj", etLeaderW1));
        nvs.add(new BasicNameValuePair("jjbzbyj", etLeaderW2));
        nvs.add(new BasicNameValuePair("WeiXiuRenYuanQianZi", etLeaderW3));
        nvs.add(new BasicNameValuePair("bjap", etLeaderW4));
        nvs.add(new BasicNameValuePair("bjpj", etLeaderW5));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //出差项目待办签字
    public String OAChuCaiLeader(String url, String time, String person, String startTime, String endTine
            , String days, String addres1, String addres2, String addres3, String car, String reason
            , String yjMoney, String zjMoney, String userCode, String destName, String taskId
            , String flowAssignld, String mainId, String bmfzr, String fgfze, String zjl, String comment
            , String signName, String userName, String jygj1, String jygj2, String jygj3, String jygj4
            , String chuCaiCode,String cwzjyj) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signalName", signName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CHUCAI));

        nvs.add(new BasicNameValuePair("sqsj", time));
        nvs.add(new BasicNameValuePair("sbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
//        nvs.add(new BasicNameValuePair("sbbm", de));
//        nvs.add(new BasicNameValuePair("sbbmDid", date));
        nvs.add(new BasicNameValuePair("chuchairenyuanUId", chuCaiCode));
        nvs.add(new BasicNameValuePair("chuchairenyuan", person));

        nvs.add(new BasicNameValuePair("ccrq", startTime));
        nvs.add(new BasicNameValuePair("jiezhiriqi", endTine));
        nvs.add(new BasicNameValuePair("ccts", days));
        nvs.add(new BasicNameValuePair("ccdd", addres1));
        nvs.add(new BasicNameValuePair("tujing", addres2));
        nvs.add(new BasicNameValuePair("mudidi", addres3));

        nvs.add(new BasicNameValuePair("jtgj1", jygj1));
        nvs.add(new BasicNameValuePair("jtgj2", jygj2));
        nvs.add(new BasicNameValuePair("jtgj3", jygj3));
        nvs.add(new BasicNameValuePair("jtgj4", jygj4));
        nvs.add(new BasicNameValuePair("ccsy", reason));
        nvs.add(new BasicNameValuePair("yjfy", yjMoney));
        nvs.add(new BasicNameValuePair("zjxj", zjMoney));

        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("fgldyj", fgfze));
        nvs.add(new BasicNameValuePair("cwzjyj", cwzjyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //出差申请提交
    public String OAChuCaiup(String turl, String uName, String uId, String date, String person
            , String startTime, String endTime, String days, String address1, String address2
            , String address3, String carType, String reason, String yjMoney, String zjMoney
            , String userId, String userName, String jtgj1, String jtgj2, String jtgj3, String jtgj4
            , String department) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.CHUCAIDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CHUCAI));
        nvs.add(new BasicNameValuePair("sbbm", department));

        nvs.add(new BasicNameValuePair("sqsj", date));
        nvs.add(new BasicNameValuePair("sbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("sbbm", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depName", "")));
        nvs.add(new BasicNameValuePair("chuchairenyuanUId", userId));
        nvs.add(new BasicNameValuePair("chuchairenyuan", person));

        nvs.add(new BasicNameValuePair("ccrq", startTime));
        nvs.add(new BasicNameValuePair("jiezhiriqi", endTime));
        nvs.add(new BasicNameValuePair("ccts", days));
        nvs.add(new BasicNameValuePair("ccdd", address1));
        nvs.add(new BasicNameValuePair("tujing", address2));
        nvs.add(new BasicNameValuePair("mudidi", address3));

        nvs.add(new BasicNameValuePair("jtgj1", jtgj1));
        nvs.add(new BasicNameValuePair("jtgj2", jtgj2));
        nvs.add(new BasicNameValuePair("jtgj3", jtgj3));
        nvs.add(new BasicNameValuePair("jtgj4", jtgj4));
        nvs.add(new BasicNameValuePair("ccsy", reason));
        nvs.add(new BasicNameValuePair("yjfy", yjMoney));
        nvs.add(new BasicNameValuePair("zjxj", zjMoney));

        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工程量增加申请提交
    public String OAGCAddUp(String turl, String uName, String uId, String date, String department
            , String person, String data, String userId, String userName, String defId, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", defId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GCADD));
        nvs.add(new BasicNameValuePair("XuQiuBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("XuQiuBuMen", department));
        nvs.add(new BasicNameValuePair("ShenQingRenUId", userId));
        nvs.add(new BasicNameValuePair("ShenQingRen", userName));
        nvs.add(new BasicNameValuePair("RiQi", date));
        nvs.add(new BasicNameValuePair("JuTiShiXiang", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("jjbzbyj", ""));
        nvs.add(new BasicNameValuePair("jbfgldyj", ""));
        nvs.add(new BasicNameValuePair("csbmyj", ""));
        nvs.add(new BasicNameValuePair("jcbmyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工程量变更申请提交
    public String OAGCAddUp1(String turl, String uName, String uId, String date, String department
            , String person, String data, String userId, String userName, String defId, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", defId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", uName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", uName + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GCCHECK));
        nvs.add(new BasicNameValuePair("XuQiuBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("XuQiuBuMen", department));
        nvs.add(new BasicNameValuePair("ShenQingRenUId", userId));
        nvs.add(new BasicNameValuePair("ShenQingRen", userName));
        nvs.add(new BasicNameValuePair("RiQi", date));
        nvs.add(new BasicNameValuePair("JuTiShiXiang", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("jjbzbyj", ""));
        nvs.add(new BasicNameValuePair("jbfgldyj", ""));
        nvs.add(new BasicNameValuePair("csbmyj", ""));
        nvs.add(new BasicNameValuePair("jcbmyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工程量增加待办签字提交
    public String OAGCAddLeader(String url, String department, String person, String time, String userCode
            , String destName, String taskId, String flowAssignld, String mainId, String xqbmyj
            , String xqbmldyj, String jsbmyj, String jsbmldyj, String csbmyj, String jcbmyj
            , String zjl, String serialNumber, String comment, String tag1, String formDefId, String signaName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("defId", tag1));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", formDefId));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));

        nvs.add(new BasicNameValuePair("cbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("ShenQingRenUId", userCode));
        nvs.add(new BasicNameValuePair("ShenQingRen", person));
        nvs.add(new BasicNameValuePair("RiQi", time));
        nvs.add(new BasicNameValuePair("bmfzryj", xqbmyj));
        nvs.add(new BasicNameValuePair("fgldyj", xqbmldyj));
        nvs.add(new BasicNameValuePair("jjbzbyj", jsbmyj));
        nvs.add(new BasicNameValuePair("jbfgldyj", jsbmldyj));
        nvs.add(new BasicNameValuePair("cwsjbyj", csbmyj));
        nvs.add(new BasicNameValuePair("jcbmyj", jcbmyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //加班审批发布
    public String OAOverTime(String turl, String date, String person, String department, String startDay
            , String endDay, String startTime, String endTime, String address, String task, String userName
            , String userId, String userDepart, String uId, String days, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.OVERTIMEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.OVERTIME));
        nvs.add(new BasicNameValuePair("applyNameUId", userId));
        nvs.add(new BasicNameValuePair("applyName", person));
        nvs.add(new BasicNameValuePair("applyDate", date));
        nvs.add(new BasicNameValuePair("depNameDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("depName", department));
        nvs.add(new BasicNameValuePair("addClassCounts", days));
        nvs.add(new BasicNameValuePair("addClassDate", startTime));
        nvs.add(new BasicNameValuePair("beginTime", startDay));
        nvs.add(new BasicNameValuePair("endClassDate", endTime));
        nvs.add(new BasicNameValuePair("endTime", endDay));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("addClassContent", task));
        nvs.add(new BasicNameValuePair("addClassPlace", address));
        nvs.add(new BasicNameValuePair("FuJian", ""));
        nvs.add(new BasicNameValuePair("jsdayType", endDay));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //加班流程领导意见提交
    public String OAOverTimeLeader(String url, String time, String person, String department, String startDay
            , String startTime, String endDay, String endTime, String userName, String userCode
            , String signaName, String destName, String taskId, String comments, String days
            , String fullnameUId, String fullname, String flowAssignld, String mainId, String bmfzr
            , String fgfze, String zjl, String address, String task) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("flowAssignld", flowAssignld));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("signaName", signaName));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("comments", comments));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("formDefId", Constant.OVERTIME));

        nvs.add(new BasicNameValuePair("applyName", person));
        nvs.add(new BasicNameValuePair("applyNameUId", fullnameUId));
        nvs.add(new BasicNameValuePair("applyDate", time));
        nvs.add(new BasicNameValuePair("addClassDate", startDay));
        nvs.add(new BasicNameValuePair("beginTime", startTime));
        nvs.add(new BasicNameValuePair("endClassDate", endDay));
        nvs.add(new BasicNameValuePair("endTime", endTime));
        nvs.add(new BasicNameValuePair("addClassCounts", days));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("fgldyj", fgfze));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        nvs.add(new BasicNameValuePair("addClassPlace", address));
        nvs.add(new BasicNameValuePair("addClassContent", task));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //车辆保险审批发布
    public String OACarSafeUp(String turl, String userDepart, String uId, String time, String person
            , String department, String carNo1, String carNo2, String carNo3, String carNo4
            , String carNo5, String comp1, String comp2, String comp3, String comp4, String comp5
            , String type1, String type2, String type3, String type4, String type5, String money1
            , String money2, String money3, String money4, String money5, String date1, String date2
            , String date3, String date4, String date5, String userId, String allMonet) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.CARSAFEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CARSAFE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("cbbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userId));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("chepaihao1", carNo1));
        nvs.add(new BasicNameValuePair("chepaihao2", carNo2));
        nvs.add(new BasicNameValuePair("chepaihao3", carNo3));
        nvs.add(new BasicNameValuePair("chepaihao4", carNo4));
        nvs.add(new BasicNameValuePair("chepaihao5", carNo5));

        nvs.add(new BasicNameValuePair("baoxiangongsi1", comp1));
        nvs.add(new BasicNameValuePair("baoxiangongsi2", comp2));
        nvs.add(new BasicNameValuePair("baoxiangongsi3", comp3));
        nvs.add(new BasicNameValuePair("baoxiangongsi4", comp4));
        nvs.add(new BasicNameValuePair("baoxiangongsi5", comp5));

        nvs.add(new BasicNameValuePair("xianzhong1", type1));
        nvs.add(new BasicNameValuePair("xianzhong2", type2));
        nvs.add(new BasicNameValuePair("xianzhong3", type3));
        nvs.add(new BasicNameValuePair("xianzhong4", type4));
        nvs.add(new BasicNameValuePair("xianzhong5", type5));

        nvs.add(new BasicNameValuePair("jine1", money1));
        nvs.add(new BasicNameValuePair("jine2", money2));
        nvs.add(new BasicNameValuePair("jine3", money3));
        nvs.add(new BasicNameValuePair("jine4", money4));
        nvs.add(new BasicNameValuePair("jine5", money5));

        nvs.add(new BasicNameValuePair("qibaoriqi1", date1));
        nvs.add(new BasicNameValuePair("qibaoriqi2", date2));
        nvs.add(new BasicNameValuePair("qibaoriqi3", date3));
        nvs.add(new BasicNameValuePair("qibaoriqi4", date4));
        nvs.add(new BasicNameValuePair("qibaoriqi5", date5));

        nvs.add(new BasicNameValuePair("hjje", allMonet));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //合同签订流程待办签字提交
    public String OACarSafeLeader(String url, String time, String person, String department, String carNo1
            , String carNo2, String carNo3, String carNo4, String carNo5, String comp1, String comp2
            , String comp3, String comp4, String comp5, String type1, String type2, String type3
            , String type4, String type5, String money1, String money2, String money3, String money4
            , String money5, String date1, String date2, String date3, String date4, String date5
            , String myAllMoney, String userCode, String destName, String taskId, String flowAssignld
            , String mainId, String bmfzryj, String fgldyj, String zjl, String serialNumber
            , String comment, String signaName, String userName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "10150"));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignld", flowAssignld));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CARSAFE));
        nvs.add(new BasicNameValuePair("sqrq", time));
        nvs.add(new BasicNameValuePair("bmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("bm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("comments", comment));

        nvs.add(new BasicNameValuePair("chepaihao1", carNo1));
        nvs.add(new BasicNameValuePair("chepaihao2", carNo2));
        nvs.add(new BasicNameValuePair("chepaihao3", carNo3));
        nvs.add(new BasicNameValuePair("chepaihao4", carNo4));
        nvs.add(new BasicNameValuePair("chepaihao5", carNo5));

        nvs.add(new BasicNameValuePair("baoxiangongsi1", comp1));
        nvs.add(new BasicNameValuePair("baoxiangongsi2", comp2));
        nvs.add(new BasicNameValuePair("baoxiangongsi3", comp3));
        nvs.add(new BasicNameValuePair("baoxiangongsi4", comp4));
        nvs.add(new BasicNameValuePair("baoxiangongsi5", comp5));

        nvs.add(new BasicNameValuePair("xianzhong1", type1));
        nvs.add(new BasicNameValuePair("xianzhong2", type2));
        nvs.add(new BasicNameValuePair("xianzhong3", type3));
        nvs.add(new BasicNameValuePair("xianzhong4", type4));
        nvs.add(new BasicNameValuePair("xianzhong5", type5));

        nvs.add(new BasicNameValuePair("jine1", money1));
        nvs.add(new BasicNameValuePair("jine2", money2));
        nvs.add(new BasicNameValuePair("jine3", money3));
        nvs.add(new BasicNameValuePair("jine4", money4));
        nvs.add(new BasicNameValuePair("jine5", money5));

        nvs.add(new BasicNameValuePair("qibaoriqi1", date1));
        nvs.add(new BasicNameValuePair("qibaoriqi2", date2));
        nvs.add(new BasicNameValuePair("qibaoriqi3", date3));
        nvs.add(new BasicNameValuePair("qibaoriqi4", date4));
        nvs.add(new BasicNameValuePair("qibaoriqi5", date5));

        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("hjje", myAllMoney));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //车载视频流程提交
    public String OACarVideoUp(String turl, String userDepart, String uId, String zhiDanRen, String zhiDanDate
            , String department, String person, String carNo, String line1, String time, String address
            , String xingZhi, String staus, String bigMonet, String smallMoney, String userId
            , String userName, String card, String diaoQu, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("defId", Constant.CARVIDEODIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CARVIDEO));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("DiaoYueBuMen", department));
        nvs.add(new BasicNameValuePair("ShenQingRen", person));
        nvs.add(new BasicNameValuePair("CheHao", carNo));
        nvs.add(new BasicNameValuePair("XianLu", line1));
        nvs.add(new BasicNameValuePair("ShiGuShiJian", time));
        nvs.add(new BasicNameValuePair("ShiGuDiDian", address));

        nvs.add(new BasicNameValuePair("ShiGuXingZhi", xingZhi));
        nvs.add(new BasicNameValuePair("ChuLiZhuangKuang", staus));
        nvs.add(new BasicNameValuePair("jine", bigMonet));

        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("ShiFouDiaoQu", diaoQu));

        nvs.add(new BasicNameValuePair("ZhiDanRenUId", userId));

        nvs.add(new BasicNameValuePair("DiaoYueRenZhengJian", card));
        nvs.add(new BasicNameValuePair("ZhiDanRen", zhiDanRen));
        nvs.add(new BasicNameValuePair("ZhiDanShiJIan", zhiDanDate));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("xxjsbyj", ""));
        nvs.add(new BasicNameValuePair("jkczyyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //车载视频待办签字提交
    public String OACarVideoLeader(String url, String zhiNanRen, String zhiDanRiQi, String department
            , String person, String carNo, String line1, String time, String address, String xingZhi
            , String zhuangKuang, String bigMoney, String smallMoney, String card, String diaoQu
            , String userCode, String destName, String taskId, String flowAssignld, String mainId
            , String bmfzr, String fgfze, String zjl, String serialNumber, String comment) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20324"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.CARVIDEO));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));

        nvs.add(new BasicNameValuePair("CheHao", carNo));
        nvs.add(new BasicNameValuePair("XianLu", line1));
        nvs.add(new BasicNameValuePair("ShiGuDiDian", address));
        nvs.add(new BasicNameValuePair("ShiGuXingZhi", xingZhi));
        nvs.add(new BasicNameValuePair("ChuLiZhuangKuang", zhuangKuang));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("DiaoYueRenZhengJian", card));
        nvs.add(new BasicNameValuePair("ShiFouDiaoQu", diaoQu));

        nvs.add(new BasicNameValuePair("cbbm", department));
        nvs.add(new BasicNameValuePair("ZhiDanRenUId", userCode));
        nvs.add(new BasicNameValuePair("ZhiDanRen", zhiNanRen));
        nvs.add(new BasicNameValuePair("ShiGuShiJian", time));
        nvs.add(new BasicNameValuePair("ZhiDanShiJIan", zhiDanRiQi));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("xxjsbyj", fgfze));
        nvs.add(new BasicNameValuePair("jkczyyj", zjl));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //驾驶员考核审批发布
    public String OADriverAssessUp(String turl1, String person, String userDepart, String uId) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl1);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.DRIVERASSESSDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.DRIVERASSESS));
        nvs.add(new BasicNameValuePair("xm", person));
        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("jbbmyj", ""));
        nvs.add(new BasicNameValuePair("rlzybyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //驾驶员考核审批待办签字提交
    public String OADriverAssessLeader(String url, String person, String userCode, String destName
            , String taskId, String flowAssignld, String mainId, String bmfzryj, String fgldyj
            , String zjl, String serialNumber, String comment, String signaName, String userName, String comments) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20373"));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.DRIVERASSESS));
        nvs.add(new BasicNameValuePair("xm", person));
        nvs.add(new BasicNameValuePair("comments", comments));

        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("jbbmyj", fgldyj));
        nvs.add(new BasicNameValuePair("rlzybyj", zjl));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //用车审批发布
    public String OAUserCarUp(String turl, String userDepart, String uId, String job, String phone
            , String task, String address, String startMile, String endMile, String allMile
            , String userId, String person, String department, String startTime, String endTime
            , String time, String carNo, String carType, String liushuihao, String pcPerson) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.USERCARDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.USERCAR));
        nvs.add(new BasicNameValuePair("YongCheBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("YongCheBuMen", department));
        nvs.add(new BasicNameValuePair("PaiCheShiJian", time));
        nvs.add(new BasicNameValuePair("YongCheRen", person));
        nvs.add(new BasicNameValuePair("ZhiWu", job));
        nvs.add(new BasicNameValuePair("LianXiDianHua", phone));
        nvs.add(new BasicNameValuePair("CheXIng", carType));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("PaiCheYuan", pcPerson));

        nvs.add(new BasicNameValuePair("PaiCheYuanUId", userId));
        nvs.add(new BasicNameValuePair("PaiCheYuan", person));
        nvs.add(new BasicNameValuePair("YongCheRenWu", task));
        nvs.add(new BasicNameValuePair("RenWuDiDian", address));
        nvs.add(new BasicNameValuePair("YongCheShiJian", time));

        nvs.add(new BasicNameValuePair("FuWuCheHao", carNo));
        nvs.add(new BasicNameValuePair("FuWuKaiShiLiCheng", startMile));
        nvs.add(new BasicNameValuePair("JieShuLiChengShu", endMile));
        nvs.add(new BasicNameValuePair("FuWuKaiShiShiJian", startTime));
        nvs.add(new BasicNameValuePair("FuWuJieShuShiJian", endTime));
        nvs.add(new BasicNameValuePair("FuWULiCheng", allMile));


        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        nvs.add(new BasicNameValuePair("zhglbyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    ///用车待办签字提交
    public String OAUseCarLeader(String url, String time, String person, String department, String job
            , String phone, String task, String address, String carNo, String carType, String startMile
            , String endMile, String allMile, String startTime, String endTime, String userCode
            , String destName, String taskId, String flowAssignld, String mainId, String bmfzryj
            , String fgldyj, String zjlyj, String zhglyj, String pcryj, String serialNumber, String comment) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20209"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignld", flowAssignld));
        nvs.add(new BasicNameValuePair("YongCheBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("YongCheBuMen", department));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.USERCAR));
        nvs.add(new BasicNameValuePair("PaiCheShiJian", time));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("PaiCheYuanUId", userCode));
        nvs.add(new BasicNameValuePair("PaiCheYuan", pcryj));

        nvs.add(new BasicNameValuePair("YongCheRen", person));
        nvs.add(new BasicNameValuePair("ZhiWu", job));
        nvs.add(new BasicNameValuePair("LianXiDianHua", phone));
        nvs.add(new BasicNameValuePair("YongCheRenWu", task));

        nvs.add(new BasicNameValuePair("RenWuDiDian", address));
        nvs.add(new BasicNameValuePair("FuWuCheHao", carNo));
        nvs.add(new BasicNameValuePair("CheXIng", carType));
        nvs.add(new BasicNameValuePair("FuWuKaiShiLiCheng", startMile));
        nvs.add(new BasicNameValuePair("JieShuLiChengShu", endMile));
        nvs.add(new BasicNameValuePair("FuWULiCheng", allMile));
        nvs.add(new BasicNameValuePair("FuWuKaiShiShiJian", startTime));
        nvs.add(new BasicNameValuePair("FuWuJieShuShiJian", endTime));

        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjlyj));
        nvs.add(new BasicNameValuePair("zhglbyj", zhglyj));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //用餐流程提交
    public String OADinnerUp(String turl, String userDepart, String uId, String time, String person
            , String department, String pcPerson, String lkDepartment, String lkPerson, String eatBz
            , String bigMoney, String smallMoney, String userId, String userName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("defId", Constant.DINNERDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.DINNER));

        nvs.add(new BasicNameValuePair("sqbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("sqbm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userId));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("pcryUId", ""));
        nvs.add(new BasicNameValuePair("pcry", pcPerson));
        nvs.add(new BasicNameValuePair("lkdwhbm", lkDepartment));

        nvs.add(new BasicNameValuePair("lkrs", lkPerson));
        nvs.add(new BasicNameValuePair("ycbz", eatBz));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));

        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //用餐待办签字提交
    public String OADinnerder(String url, String person, String department, String pcPerson
            , String lkDepartment, String lkPerson, String eatBz, String bigMoney, String smallMoney
            , String userCode, String destName, String taskId, String flowAssignld, String mainId
            , String bmfzr, String fgfze, String zjl, String serialNumber, String comment) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "10152"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.DINNER));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));

        nvs.add(new BasicNameValuePair("sqbmDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("sqbm", department));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("pcryUId", ""));
        nvs.add(new BasicNameValuePair("pcry", pcPerson));
        nvs.add(new BasicNameValuePair("lkdwhbm", lkDepartment));
        nvs.add(new BasicNameValuePair("lkrs", lkPerson));
        nvs.add(new BasicNameValuePair("ycbz", eatBz));

        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("fgldyj", fgfze));
        nvs.add(new BasicNameValuePair("zjlyj", zjl));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //投诉流程提交
    public String OAComplainUp(String turl, String userDepart, String uId, String person, String time
            , String sex, String phone, String person1, String carNo, String department, String line1
            , String shouLi, String data, String userId, String userName, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("defId", Constant.COMPLAINDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.COMPLAIN));

        nvs.add(new BasicNameValuePair("TouSuRenXingMing", person));
        nvs.add(new BasicNameValuePair("TouSuRiQi", time));
        nvs.add(new BasicNameValuePair("XingBie", sex));
        nvs.add(new BasicNameValuePair("LianXiDianHua", phone));
        nvs.add(new BasicNameValuePair("BeiTouSuRenXingMing", person1));
        nvs.add(new BasicNameValuePair("BeiTouSuChePaiHao", carNo));
        nvs.add(new BasicNameValuePair("SuoShuFenGongSi", department));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("SuoShuXianLu", line1));
        nvs.add(new BasicNameValuePair("TouSuNeiRong", data));
//        nvs.add(new BasicNameValuePair("ShouLiRenUId", userId));
        nvs.add(new BasicNameValuePair("ShouLiRen", person));

        nvs.add(new BasicNameValuePair("BuMenFuZeRen", ""));
        nvs.add(new BasicNameValuePair("FenGongSiChengBanRen", ""));
        nvs.add(new BasicNameValuePair("YingYunFenGongSiChuLiJieGuo", ""));
        nvs.add(new BasicNameValuePair("AnQuanFuWuBuYiJian", ""));
        nvs.add(new BasicNameValuePair("FanKuiTouSuRenJieGuo", ""));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //投诉待办签字提交
    public String OAComplainder(String url, String person, String time, String sex, String phone
            , String person1, String carNo, String department, String line1, String shouLi
            , String data, String userCode, String destName, String taskId, String flowAssignld
            , String mainId, String bmfzr, String fgsfze, String yygs, String aqfy, String fkts
            , String serialNumber, String comment) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.COMPLAINDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.COMPLAIN));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));

        nvs.add(new BasicNameValuePair("TouSuRenXingMing", person));
        nvs.add(new BasicNameValuePair("TouSuRenZunCheng", ""));
        nvs.add(new BasicNameValuePair("TouSuRiQi", time));
        nvs.add(new BasicNameValuePair("XingBie", sex));
        nvs.add(new BasicNameValuePair("LianXiDianHua", phone));
        nvs.add(new BasicNameValuePair("BeiTouSuRenXingMingUId", ""));
        nvs.add(new BasicNameValuePair("BeiTouSuRenXingMing", person1));
        nvs.add(new BasicNameValuePair("BeiTouSuChePaiHao", carNo));
        nvs.add(new BasicNameValuePair("SuoShuFenGongSi", department));

        nvs.add(new BasicNameValuePair("SuoShuXianLu", line1));
        nvs.add(new BasicNameValuePair("TouSuNeiRong", data));
        nvs.add(new BasicNameValuePair("ShouLiRenUId", userCode));
        nvs.add(new BasicNameValuePair("ShouLiRen", person));

        nvs.add(new BasicNameValuePair("bmfzryj", bmfzr));
        nvs.add(new BasicNameValuePair("FenGongSiChengBanRen", fgsfze));
        nvs.add(new BasicNameValuePair("bjap", yygs));
        nvs.add(new BasicNameValuePair("aqfwbyj", aqfy));
        nvs.add(new BasicNameValuePair("bjpj", fkts));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //安装改造审批发布
    public String OAInstallUp(String turl, String userDepart, String uId, String department
            , String date, String data, String userId, String userName, String liushuihao,String ys) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.INSTALLDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.INSTALL));

        nvs.add(new BasicNameValuePair("ShenBanBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("ShenBanBuMen", department));
        nvs.add(new BasicNameValuePair("ShenBanShiJian", date));
        nvs.add(new BasicNameValuePair("BanJieShiJian", date));
        nvs.add(new BasicNameValuePair("ShenBanShiXiang", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("yusuan", ys));

        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("jbfgldyj", ""));
        nvs.add(new BasicNameValuePair("jbbmyj", ""));
        nvs.add(new BasicNameValuePair("bjap", ""));
        nvs.add(new BasicNameValuePair("BanJieRen", ""));
        nvs.add(new BasicNameValuePair("BanJieShiJian", ""));
        nvs.add(new BasicNameValuePair("bjpj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //待办签字提交
    public String OAInstallder(String url, String department, String date, String data
            , String userCode, String destName, String taskId, String flowAssignld
            , String mainId, String bmfzryj, String fgldyj, String jbfgldyj, String jbbmyj
            , String bjap, String bjr, String bjpj, String serialNumber, String comment
            , String liushuihao,String signaName, String zjlyj,String ys,String data1) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20232"));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("signalName", signaName));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.INSTALL));

        nvs.add(new BasicNameValuePair("ShenBanBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("ShenBanBuMen", department));
        nvs.add(new BasicNameValuePair("ShenBanShiJian", date));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("ys",ys));
        nvs.add(new BasicNameValuePair("zjlyj", zjlyj));
        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("jbfgldyj", jbfgldyj));
        nvs.add(new BasicNameValuePair("jbbmyj", jbbmyj));
        nvs.add(new BasicNameValuePair("bjap", bjap));
        nvs.add(new BasicNameValuePair("BanJieRen", bjr));
        nvs.add(new BasicNameValuePair("BanJieShiJian", data1));
        nvs.add(new BasicNameValuePair("bjpj", bjpj));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //用餐待办签字提交
    public String OAInstallder1(String url, String department, String date, String data
            , String userCode, String destName, String taskId, String flowAssignld
            , String mainId, String bmfzryj, String fgldyj, String jbfgldyj, String jbbmyj
            , String bjap, String bjr, String bjpj, String serialNumber, String comment
            , String date1, String liushuihao, String zjlyj,String ys,String signName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20232"));
        nvs.add(new BasicNameValuePair("zjlyj", zjlyj));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("ys",ys));
        nvs.add(new BasicNameValuePair("signalName", signName));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.INSTALL));

        nvs.add(new BasicNameValuePair("ShenBanBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("ShenBanBuMen", department));
        nvs.add(new BasicNameValuePair("ShenBanShiJian", date));
        nvs.add(new BasicNameValuePair("ShenBanShiXiang", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("BanJieShiJian", date1));

        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("jbfgldyj", jbfgldyj));
        nvs.add(new BasicNameValuePair("jbbmyj", jbbmyj));
        nvs.add(new BasicNameValuePair("bjap", bjap));
        nvs.add(new BasicNameValuePair("BanJieRen", bjr));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bjpj", bjpj));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //工程启动申请提交
    public String OAGCQDUp(String turl, String userDepart, String uId, String date, String department
            , String person, String data, String userId, String userName, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.GCQDDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GCQD));
        nvs.add(new BasicNameValuePair("XuQiuBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("XuQiuBuMen", department));
        nvs.add(new BasicNameValuePair("ShenQingRenUId", userId));
        nvs.add(new BasicNameValuePair("ShenQingRen", userName));
        nvs.add(new BasicNameValuePair("RiQi", date));
        nvs.add(new BasicNameValuePair("XuQiuShiXiang", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bmfzryj ", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("jjbzbyj", ""));
        nvs.add(new BasicNameValuePair("jbfgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工程启动待办签字提交
    public String OAJSGCLeader(String url, String department, String person, String time, String userCode
            , String destName, String taskId, String flowAssignld, String mainId, String xqbmyj
            , String xqbmldyj, String jsbmyj, String jsbmldyj, String zjlyj, String serialNumber
            , String comment, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20233"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.GCQD));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("XuQiuBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("XuQiuBuMen", department));
        nvs.add(new BasicNameValuePair("ShenQingRenUId", userCode));
        nvs.add(new BasicNameValuePair("ShenQingRen", person));
        nvs.add(new BasicNameValuePair("RiQi", time));
        nvs.add(new BasicNameValuePair("bmfzryj", xqbmyj));
        nvs.add(new BasicNameValuePair("fgldyj", xqbmldyj));
        nvs.add(new BasicNameValuePair("jjbzbyj", jsbmyj));
        nvs.add(new BasicNameValuePair("jbfgldyj", jsbmldyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjlyj));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //电子设备申请提交
    public String OAEMaintainUp(String turl, String userDepart, String uId, String date, String department
            , String person, String data, String userId, String userName, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.EMAINTAINDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.EMAINTAIN));
        nvs.add(new BasicNameValuePair("BaoXiuBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("BaoXiuBuMen", department));
//        nvs.add(new BasicNameValuePair("ShenQingRenUId", userId));
//        nvs.add(new BasicNameValuePair("ShenQingRen", userName));
        nvs.add(new BasicNameValuePair("BaoXiuShiJian", date));
        nvs.add(new BasicNameValuePair("GuZhangQingKuang", data));
//        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bmfzryj ", ""));
        nvs.add(new BasicNameValuePair("xxjsbyj", ""));
        nvs.add(new BasicNameValuePair("WeiXiuRenYuanQianZi", ""));
        nvs.add(new BasicNameValuePair("WeiXiuShiJian", ""));
        nvs.add(new BasicNameValuePair("bjap", ""));
        nvs.add(new BasicNameValuePair("SheBeiShiYongRenQianZi", ""));
        nvs.add(new BasicNameValuePair("bjpj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //电子设备签字提交
    public String OAEMaintainder1(String url, String department, String time, String data, String userCode
            , String destName, String taskId, String flowAssignld, String mainId, String bxbmyj
            , String wxbmyj, String wxryyj, String wxqkyj, String sbsyryj, String wxfkyj
            , String serialNumber, String comment, String date,String signaName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.EMAINTAINDIFID));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("formDefId", Constant.EMAINTAIN));

        nvs.add(new BasicNameValuePair("ShenBanBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("ShenBanBuMen", department));

        nvs.add(new BasicNameValuePair("BaoXiuShiJian", time));
        nvs.add(new BasicNameValuePair("GuZhangQingKuang", data));
//        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bmfzryj ", bxbmyj));
        nvs.add(new BasicNameValuePair("xxjsbyj", wxbmyj));
        nvs.add(new BasicNameValuePair("WeiXiuRenYuanQianZi", wxryyj));
        nvs.add(new BasicNameValuePair("WeiXiuShiJian", date));
        nvs.add(new BasicNameValuePair("bjap", wxqkyj));
        nvs.add(new BasicNameValuePair("SheBeiShiYongRenQianZi", sbsyryj));
        nvs.add(new BasicNameValuePair("bjpj", wxfkyj));
        nvs.add(new BasicNameValuePair("comments", comment));

        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //电子设备签字提交
    public String OAEMaintainder(String url, String department, String time, String data
            , String userCode, String destName, String taskId, String flowAssignld
            , String mainId, String bxbmyj, String wxbmyj, String wxryyj, String wxqkyj
            , String sbsyryj, String wxfkyj, String serialNumber, String comment,String signaName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", ""));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("sendFQRMsg", "false"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("formDefId", Constant.EMAINTAIN));

        nvs.add(new BasicNameValuePair("BaoXiuBuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("BaoXiuBuMen", department));

        nvs.add(new BasicNameValuePair("BaoXiuShiJian", time));
        nvs.add(new BasicNameValuePair("GuZhangQingKuang", data));
//        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bmfzryj", bxbmyj));
        nvs.add(new BasicNameValuePair("xxjsbyj", wxbmyj));
        nvs.add(new BasicNameValuePair("WeiXiuRenYuanQianZi", wxryyj));
//        nvs.add(new BasicNameValuePair("WeiXiuShiJian", date));
        nvs.add(new BasicNameValuePair("bjap", wxqkyj));
        nvs.add(new BasicNameValuePair("SheBeiShiYongRenQianZi", sbsyryj));
        nvs.add(new BasicNameValuePair("bjpj", wxfkyj));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //员工宿舍审批发布
    public String OADormUp(String turl, String userDepart, String uId, String person, String time
            , String sex, String age, String idCard, String phone, String address, String userId
            , String userName, String liushuihao, String reason) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.DORMDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.DORM));

        nvs.add(new BasicNameValuePair("ShenQingRiQi", time));
        nvs.add(new BasicNameValuePair("XingMingUId", userId));
        nvs.add(new BasicNameValuePair("XingMing", person));
        nvs.add(new BasicNameValuePair("XingBie", sex));
        nvs.add(new BasicNameValuePair("NianLing", age));
        nvs.add(new BasicNameValuePair("ShenFenZhengHao", idCard));
        nvs.add(new BasicNameValuePair("ShouJiHaoMa", phone));
        nvs.add(new BasicNameValuePair("HuJiSuoZaiDi", address));
        nvs.add(new BasicNameValuePair("ShenQingLiYou", reason));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("jjbzbyj", ""));
        nvs.add(new BasicNameValuePair("RuZhuShiJian", ""));
        nvs.add(new BasicNameValuePair("FangJian", ""));
        nvs.add(new BasicNameValuePair("TuiFangShiJian", ""));
        nvs.add(new BasicNameValuePair("ChuangHao", ""));
        nvs.add(new BasicNameValuePair("BeiZhu", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //员工宿舍签字提交
    public String OADormder1(String url, String person, String time, String sex, String age
            , String idCard, String phone, String address, String reason, String userCode
            , String startTime, String home, String endTime, String chuangHao, String money
            , String destName, String taskId, String flowAssignld, String mainId, String bmfzryj
            , String wygsyj, String cwsjyj, String bzyj, String serialNumber
            , String comment, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20308"));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.DORM));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("ShenQingRiQi", time));

        nvs.add(new BasicNameValuePair("XingMingUId", userCode));
        nvs.add(new BasicNameValuePair("XingMing", person));
        nvs.add(new BasicNameValuePair("XingBie", sex));
        nvs.add(new BasicNameValuePair("NianLing", age));
        nvs.add(new BasicNameValuePair("ShenFenZhengHao", idCard));

        nvs.add(new BasicNameValuePair("ShouJiHaoMa", phone));
        nvs.add(new BasicNameValuePair("HuJiSuoZaiDi", address));
        nvs.add(new BasicNameValuePair("ShenQingLiYou", reason));

        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("jjbzbyj", wygsyj));
        nvs.add(new BasicNameValuePair("RuZhuShiJian", startTime));
        nvs.add(new BasicNameValuePair("FangJian", home));
        nvs.add(new BasicNameValuePair("TuiFangShiJian", endTime));
        nvs.add(new BasicNameValuePair("ChuangHao", chuangHao));
        nvs.add(new BasicNameValuePair("cwsjbyj", cwsjyj));
        nvs.add(new BasicNameValuePair("ShiFouXuYaoShouQu", money));
        nvs.add(new BasicNameValuePair("bjpj", bzyj));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //上诉申请提交
    public String OAAppealUp(String turl, String userDepart, String uId, String date, String department
            , String person, String data, String userId, String userName, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.APPEALDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.APPEAL));
//        nvs.add(new BasicNameValuePair("XuQiuBuMenDid", "378"));
        nvs.add(new BasicNameValuePair("sqbm", department));
        nvs.add(new BasicNameValuePair("ShenQingRenUId", userId));
        nvs.add(new BasicNameValuePair("ShenQingRen", userName));
        nvs.add(new BasicNameValuePair("ShenQingShiJian", date));
        nvs.add(new BasicNameValuePair("qingshishangbaoneirong", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("jbfgldyj", ""));
        nvs.add(new BasicNameValuePair("jbbmyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //工程启动待办签字提交
    public String OAAppealLeader(String url, String department, String person, String time
            , String userCode, String data, String destName, String taskId, String flowAssignld
            , String mainId, String xqbmyj, String xqbmldyj, String jsbmyj, String jsbmldyj
            , String serialNumber, String comment, String liushuihao,String bmyj,String dszyj,String signaName) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
//        nvs.add(new BasicNameValuePair("useTemplate", "false"));
//        nvs.add(new BasicNameValuePair("defId", "20321"));
//        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("signalName", signaName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.APPEAL));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));


        nvs.add(new BasicNameValuePair("sqbm", department));
        nvs.add(new BasicNameValuePair("ShenQingRenUId", userCode));
        nvs.add(new BasicNameValuePair("ShenQingRen", person));
        nvs.add(new BasicNameValuePair("ShenQingShiJian", time));
        nvs.add(new BasicNameValuePair("qingshishangbaoneirong", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bmfzryj", bmyj));
        nvs.add(new BasicNameValuePair("fgldyj", xqbmyj));
        nvs.add(new BasicNameValuePair("jbfgldyj", xqbmldyj));
        nvs.add(new BasicNameValuePair("bjap", jsbmyj));
        nvs.add(new BasicNameValuePair("jbbmyj", xqbmldyj));
        nvs.add(new BasicNameValuePair("zjlyj", jsbmldyj));
        nvs.add(new BasicNameValuePair("dszyj", dszyj));
        nvs.add(new BasicNameValuePair("sqbmDid", "512"));
        try {
            Log.e("XXXXH", "========"+nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if(msg.equals("true")){
                    return "";
                }else{

                    if (json_.has("message")){
                        String s = json_.getString("message");
                        return s;
                    }else{
                        return "保存失败";
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //事故借款审批单发布
    public String OABillUp(String turl, String userDepart, String uId, String zdPerson, String zdTime
            , String department, String JKPerson, String driver, String carNo, String str
            , String address, String use, String otherPerson, String otherPhone, String reason
            , String smallMoney, String bigMoney, String type, String blame, String num, String money
            , String allMoneyM, String allmoneyY, String userId, String userName, String liushuihao, String s) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.BILLDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.BILL));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("riqi", zdTime.split(" ")[0]));
        nvs.add(new BasicNameValuePair("BuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("BuMen", department));
        nvs.add(new BasicNameValuePair("JiaShiYuan", driver));
        nvs.add(new BasicNameValuePair("JieKuanRenUId", userId));
        nvs.add(new BasicNameValuePair("JieKuanRen", JKPerson));
        nvs.add(new BasicNameValuePair("CheHao", carNo));
        nvs.add(new BasicNameValuePair("ShiJian", str));
        nvs.add(new BasicNameValuePair("DiDian", address));
        nvs.add(new BasicNameValuePair("JieKuanYT", use));

        nvs.add(new BasicNameValuePair("ShouShangRenShu", otherPerson));
        nvs.add(new BasicNameValuePair("SanZheDH", otherPhone));
        nvs.add(new BasicNameValuePair("ShiGuYuanYin", reason));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("XianZhong", type));
        nvs.add(new BasicNameValuePair("ShiGuZeRen", blame));
        nvs.add(new BasicNameValuePair("JiCi", num));
        nvs.add(new BasicNameValuePair("YiJie", money));
        nvs.add(new BasicNameValuePair("aqfwbyj", ""));

        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        nvs.add(new BasicNameValuePair("ZhiDanUId", userId));
        nvs.add(new BasicNameValuePair("ZhiDan", zdPerson));
        nvs.add(new BasicNameValuePair("zhidanshijian", zdTime));
        nvs.add(new BasicNameValuePair("danyueleiji", allMoneyM));
        nvs.add(new BasicNameValuePair("bennianleiji", allmoneyY));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //用餐待办签字提交
    public String OABillder1(String url, String zdPerson, String zdTime, String department, String JKPerson
            , String driver, String carNo, String address, String use, String otherPerson, String otherPhone
            , String reason, String smallMoney, String bigMoney, String type, String blame, String num
            , String money, String allMoneyM, String allmoneyY, String userCode, String destName
            , String taskId, String flowAssignld, String mainId, String aqfwyj, String fgldyj
            , String ldspyj, String serialNumber, String comment, String liushuihao, String shiJian) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20226"));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.BILL));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("riqi", zdTime.split(" ")[0]));
        nvs.add(new BasicNameValuePair("BuMenDid", new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "depId", "")));
        nvs.add(new BasicNameValuePair("BuMen", department));
        nvs.add(new BasicNameValuePair("JiaShiYuan", driver));
        nvs.add(new BasicNameValuePair("JieKuanRenUId", userCode));
        nvs.add(new BasicNameValuePair("JieKuanRen", JKPerson));
        nvs.add(new BasicNameValuePair("CheHao", carNo));
        nvs.add(new BasicNameValuePair("ShiJian", shiJian));
        nvs.add(new BasicNameValuePair("DiDian", address));
        nvs.add(new BasicNameValuePair("JieKuanYT", use));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));

        nvs.add(new BasicNameValuePair("ShouShangRenShu", otherPerson));
        nvs.add(new BasicNameValuePair("SanZheDH", otherPhone));
        nvs.add(new BasicNameValuePair("ShiGuYuanYin", reason));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("XianZhong", type));
        nvs.add(new BasicNameValuePair("ShiGuZeRen", blame));
        nvs.add(new BasicNameValuePair("JiCi", num));
        nvs.add(new BasicNameValuePair("YiJie", money));
        nvs.add(new BasicNameValuePair("aqfwbyj", aqfwyj));

        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("cwzjyj", ldspyj));
        nvs.add(new BasicNameValuePair("ZhiDanUId", userCode));
        nvs.add(new BasicNameValuePair("ZhiDan", zdPerson));
        nvs.add(new BasicNameValuePair("zhidanshijian", zdTime));
        nvs.add(new BasicNameValuePair("danyueleiji", allMoneyM));
        nvs.add(new BasicNameValuePair("bennianleiji", allmoneyY));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //保险审批发布
    public String OASaferUp(String turl, String userDepart, String uId, String time, String num
            , String smallMoney, String bigMoney, String userId, String userName, String liushuihao
            , String tag) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        if (tag.equals("1")) {
            nvs.add(new BasicNameValuePair("defId", Constant.SAFER1DIFID));
        } else {
            nvs.add(new BasicNameValuePair("defId", Constant.SAFER2DIFID));
        }
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        if (tag.equals("1")) {
            nvs.add(new BasicNameValuePair("formDefId", Constant.SAFER1));
        } else {
            nvs.add(new BasicNameValuePair("formDefId", Constant.SAFER2));
        }
        nvs.add(new BasicNameValuePair("TuanTiYiWaiXianRenShu", num));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("JieKuanShiJian", time));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("bmfzryj", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("cwzjyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //用餐待办签字提交
    public String OASaferder1(String url, String liuShuiHao, String time, String num, String smallMoney
            , String bigMoney, String userCode, String destName, String taskId, String flowAssignld
            , String mainId, String bmfzryj, String fgldyj, String cwldyj, String serialNumber
            , String comment, String liushuihao, String tag) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        if (tag.equals("1")) {
            nvs.add(new BasicNameValuePair("defId", "20224"));
        } else {
            nvs.add(new BasicNameValuePair("defId", "20225"));
        }
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liuShuiHao));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        if (tag.equals("1")) {
            nvs.add(new BasicNameValuePair("formDefId", Constant.SAFER1));
        } else {
            nvs.add(new BasicNameValuePair("formDefId", Constant.SAFER2));
        }
        nvs.add(new BasicNameValuePair("TuanTiYiWaiXianRenShu", num));
        nvs.add(new BasicNameValuePair("xiaoxie", smallMoney));
        nvs.add(new BasicNameValuePair("jine", bigMoney));
        nvs.add(new BasicNameValuePair("JieKuanShiJian", time));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("bmfzryj", bmfzryj));
        nvs.add(new BasicNameValuePair("fgldyj", fgldyj));
        nvs.add(new BasicNameValuePair("cwzjyj", cwldyj));
        nvs.add(new BasicNameValuePair("comments", comment));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //会签申请提交
    public String OAHuiQianUp(String turl, String userDepart, String uId, String person, String data
            , String userId, String userName, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.HUIQIANDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.HUIQIAN));
        nvs.add(new BasicNameValuePair("HuiQianShiXiang", data));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("sqrUId", userId));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("jbfgldyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        nvs.add(new BasicNameValuePair("dszyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //会签签字提交
    public String OAHuiQiander(String url, String person, String data, String userCode, String destName
            , String taskId, String flowAssignld, String mainId, String bxbmyj, String wxbmyj
            , String wxryyj, String serialNumber, String comment, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", "20411"));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("defId", Constant.HUIQIANDIFID));
        nvs.add(new BasicNameValuePair("formDefId", Constant.HUIQIAN));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("HuiQianShiXiang", data));
        nvs.add(new BasicNameValuePair("sqrUId", userCode));
        nvs.add(new BasicNameValuePair("sqr", person));
        nvs.add(new BasicNameValuePair("jbfgldyj", bxbmyj));
        nvs.add(new BasicNameValuePair("zjlyj", wxbmyj));
        nvs.add(new BasicNameValuePair("dszyj", wxryyj));
        nvs.add(new BasicNameValuePair("comments", comment));

        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //公司信息发布申请提交
    public String OACompMessageUp(String turl, String userDepart, String uId, String date, String person
            , String title, String fbpt1, String fbpt2, String fbpt3, String userId, String userName
            , String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.COMPMESSAGEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", userDepart));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", userDepart + "|" + uId));
        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("formDefId", Constant.COMPMESSAGE));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));
        nvs.add(new BasicNameValuePair("bt", title));
        nvs.add(new BasicNameValuePair("fbpt1", fbpt1));
        nvs.add(new BasicNameValuePair("fbpt2", fbpt2));
        nvs.add(new BasicNameValuePair("fbpt3", fbpt3));
        nvs.add(new BasicNameValuePair("ngUId", userId));
        nvs.add(new BasicNameValuePair("ng", person));
        nvs.add(new BasicNameValuePair("rq", date));
        nvs.add(new BasicNameValuePair("bmfzryj ", ""));
        nvs.add(new BasicNameValuePair("fgldyj", ""));
        nvs.add(new BasicNameValuePair("zhglbyj", ""));
        nvs.add(new BasicNameValuePair("jbbmyj", ""));
        nvs.add(new BasicNameValuePair("zjlyj", ""));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //公司信息发布待办签字提交
    public String OACompMessageLeader(String url, String title, String person, String time, String fbpt1
            , String fbpt2, String fbpt3, String userCode, String destName, String taskId
            , String flowAssignld, String mainId, String xqbmyj, String xqbmldyj, String jsbmyj
            , String jsbmldyj, String zjlyj, String serialNumber, String comment, String liushuihao) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("useTemplate", "false"));
        nvs.add(new BasicNameValuePair("defId", Constant.COMPMESSAGEDIFID));
        nvs.add(new BasicNameValuePair("startFlow", "true"));
        nvs.add(new BasicNameValuePair("destName", destName));
        nvs.add(new BasicNameValuePair("sendMsg", "true"));
        nvs.add(new BasicNameValuePair("sendMail", "true"));
        nvs.add(new BasicNameValuePair("flowAssignId", flowAssignld));

        nvs.add(new BasicNameValuePair("flowVars", "{}"));
        nvs.add(new BasicNameValuePair("showvalue", ""));
        nvs.add(new BasicNameValuePair("formDefId", Constant.COMPMESSAGE));
        nvs.add(new BasicNameValuePair("comments", comment));
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mainId", mainId));
        nvs.add(new BasicNameValuePair("LiuShuiHao", liushuihao));

        nvs.add(new BasicNameValuePair("ngUId", userCode));
        nvs.add(new BasicNameValuePair("ng", person));
        nvs.add(new BasicNameValuePair("rq", time));
        nvs.add(new BasicNameValuePair("bt", title));
        nvs.add(new BasicNameValuePair("fbpt1", fbpt1));
        nvs.add(new BasicNameValuePair("fbpt2", fbpt2));
        nvs.add(new BasicNameValuePair("fbpt3", fbpt3));

        nvs.add(new BasicNameValuePair("bmfzryj", xqbmyj));
        nvs.add(new BasicNameValuePair("fgldyj", xqbmldyj));
        nvs.add(new BasicNameValuePair("zhglbyj", jsbmyj));
        nvs.add(new BasicNameValuePair("jbbmyj", jsbmldyj));
        nvs.add(new BasicNameValuePair("zjlyj", zjlyj));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return "";
                } else {
                    String s = json_.getString("message");
                    return s;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //获取代办数量
    public String getNumDaiBan(String turl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return sb.toString();
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //获取员工
    public String personList(String turl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_.toString();
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }


    //获取我的申请详情
    public String OAFiel(String turl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "获取数据失败";
    }

    //查询版本
    public String getAPKVerson(String url) {
        String versor = "";
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);

            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    //获取历史列表
    public String OAHistory(String url, String type, String name, String person, String startTime
            , String endTime, String tag) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("proTypeId", tag));
        nvs.add(new BasicNameValuePair("Q_subject_S_LK", name));
        nvs.add(new BasicNameValuePair("Q_creator_S_EQ", person));
        nvs.add(new BasicNameValuePair("Q_runStatus_SN_EQ", type));
        nvs.add(new BasicNameValuePair("Q_createtime_D_GE", startTime));
        nvs.add(new BasicNameValuePair("Q_createtime_D_LE", endTime));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_.toString();
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //获取流水号
    public String OAFlowMessage(String url, String runId) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(url);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
//        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("runId", runId));
        try {
            Log.e("XXXXH", nvs.toString());
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return json_.toString();
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //获取收件箱列表
    public String getInbox(String turl) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("folderId", "1"));
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                } else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "获取数据失败";
    }


    //提交服务卫生数据
    public String Test() {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost("http://192.168.2.132:8080/joffice21/info/newAppNews.do");
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        try {
            // 将参数添加的POST请求中
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            // 发送请求
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            // 读取返回值
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            Log.i("weisheng", sb.toString());
            reader.close();
            JSONObject json_ = new JSONObject(sb.toString());
            System.out.println("json=" + json_);
            if (json_ != null) {
                String msg = json_.get("msg").toString();
                String show = json_.get("show").toString();
                if (msg.equals("保存成功")) {
                    return "";
                } else {
                    return msg;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "保存失败";
    }

    //待办作废
    public Boolean OAFlowNullify(String turl, String taskId, String mycomments, String executionId ) {
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
        String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        httpRequst.setHeader("Cookie", Session);
        nvs.add(new BasicNameValuePair("taskId", taskId));
        nvs.add(new BasicNameValuePair("mycomments", mycomments));
        nvs.add(new BasicNameValuePair("executionId", executionId));
        Log.i("sb1=", turl);
        Log.i("sb1=", taskId);
        Log.i("sb1=", mycomments);
        Log.i("sb1=", executionId);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            Log.i("sb1=", sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_ + "";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return false;
    }

}
