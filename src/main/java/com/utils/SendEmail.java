package com.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendEmail {

 private String url;
 private String apiUser;
 private String apiKey;
 private String from;

    public SendEmail() {
        this.url = "http://api.sendcloud.net/apiv2/mail/send";
        this.apiUser = "caofeifan_test_cFmRZL";
        this.apiKey = "o0vJW3CaothP4o5k";
        this.from="service@sendcloud.im";
    }
    public boolean sendingEmail(String email,String emailCode)throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httPost = new HttpPost(url);

        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("from", from));
        params.add(new BasicNameValuePair("fromName", ""));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("subject", "邮箱注册"));
        params.add(new BasicNameValuePair("html", emailCode));

        httPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httPost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            // 读取xml文档
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            return true;
        } else {
            System.err.println("error");
            return false;
        }
//        httPost.releaseConnection();
    }
}



