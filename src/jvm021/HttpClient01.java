package jvm021;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.Scanner;

public class HttpClient01 {
    public static void main(String[] args) throws Exception {
        // 创建一个HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建一个httpGet对象
        HttpGet httpget = new HttpGet("http://localhost:8801");
        // 调试
        System.out.println("Request type: " + httpget.getMethod());
        // 执行并获取响应
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        System.out.println(httpresponse.getStatusLine());
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }
}
