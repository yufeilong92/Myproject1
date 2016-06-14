package com.example.android.activtiy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.R;

/**
 * Created by Administrator on 2016/6/4.
 */
public class CaptureActivity extends Activity {
    private Button button;
    private ImageView imageView;
//    设置其值
    private static final int CAP_TU=100;

    /**
     * 相机的调用
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        控件
        setContentView(R.layout.acptureactivity);
//        得到其按钮
        button= (Button) findViewById(R.id.imagebtn);
        imageView= (ImageView) findViewById(R.id.imageview);
//按钮的监听事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                调用Intent方法mediastore方法
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                有返回
                startActivityForResult(intent,CAP_TU);

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//       判断其返回值
        if(requestCode==100){
//            判断其成功
            if(resultCode==RESULT_OK){
                Bitmap bitmap= (Bitmap) data.getExtras().get("date");
                imageView.setImageBitmap(bitmap);
            }else  if(resultCode==RESULT_CANCELED){
                Toast.makeText(CaptureActivity.this,"拍照未成功",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
