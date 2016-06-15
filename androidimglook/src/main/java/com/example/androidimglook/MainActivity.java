package com.example.androidimglook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private EditText et_img;
    private ImageView imageView;
    private Button btn_img;
    protected final int REQUESTSUCCESS=0;
    protected final int REQUESTSUCCESSNOT=1;
    protected final int REQUESTSUCCESSNOTS=1;
//        []创建handler
    private  Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case REQUESTSUCCESS:
              Bitmap bitmap = (Bitmap) msg.obj;
                imageView.setImageBitmap(bitmap);
            break;

        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_img = (EditText) findViewById(R.id.et_img);
        btn_img = (Button) findViewById(R.id.btn_img);
        imageView = (ImageView) findViewById(R.id.i_vimage);
    }
  public void click(View v){
      new Thread(){
          @Override
          public void run() {
              //        [2.1]获取路径
              String path = et_img.getText().toString().trim();
              //        [2.2]创建URL
              try {
                  URL url = new URL(path);
                  //        [2.3]获取HttpURLConnection
                  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                  //        [2.4]设置请求方式
                  conn.setRequestMethod("GET");
                  //        [2.5]浏览器返回请求
                  //        [2.5.0]设置超时时间
                  conn.setConnectTimeout(5000);
                  int code = conn.getResponseCode();
                  if(code==200){
                      //        [2.6]得到请求资源不管什么数据都是流的形式
                      InputStream inputStream =conn.getInputStream();
                      //        [2.7]把资源转换成字符串【位图bitmap】
                      Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                      Message message =Message.obtain();
                      message.what=REQUESTSUCCESS;
                      message.obj=bitmap;
                      handler.sendMessage(message);
                  }else {
//                      使用msg静态方法
                      Message message =Message.obtain();
                      message.what=REQUESTSUCCESSNOT;
                      handler.sendMessage(message);
                  }

              } catch (Exception e) {
                  e.printStackTrace();
              Message message=new Message();
              message.what=REQUESTSUCCESSNOTS;
                  handler.sendMessage(message);
              }

          }
          }.start();
      }

}
