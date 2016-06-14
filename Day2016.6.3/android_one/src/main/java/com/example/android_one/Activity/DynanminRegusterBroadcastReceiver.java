package com.example.android_one.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android_one.R;

/**
 * 系统广播：intent.ACTION_BATTERy_CHANGED接收的信息内容如下
 * "present"  (boolean)   是否使用电池
 * “level”  (int)      电池最大值，通常为100
 * “icon-small” (int)  图片IO
 * "voltage"    (int)   电池的电压（伏特）
 * “tomperature” (int) 电池的温度，0,1度单位，例如表示197的时候，意思为19.7度
 * “technology”  (string ) 电池的类型：例如li_ion等等
 * “pulgged”    (int)  充电方式
 * “status”    （int）  电池状态
 * BatteryManager.BATTERY_STATUS_CHATGING:充电状态
 * BatteryManager.BATTERY_STATUS_DISCHARGING:放电状态
 * BatteryManager.BATTERY_STATUS_NOT_OHATGING:未充满状态
 * BatteryManager.BATTERY_STATUS_FULL:充满电状态
 * BatteryManager.BATTERY_STATUS_UNKNOWN:未知状态
 * “health”     (int)   -健康状态：
 * BatteryManager.BATTERY_HEALTH_GOOD:状态良好
 * BatteryManager.BATTERY_HEALTH_DEAD:电池没有电
 * BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:电池电压过高
 * BatteryManager.BATTERY_HEALTH_OVERHEAT:电池过热
 * BatteryManager.BATTERY_HEALTH_UNKNOWN:未知状态
 * <p/>
 * Created by Administrator on 2016/6/8.
 */
public class DynanminRegusterBroadcastReceiver extends Activity {
    private TextView textView;
    //    intent广播ACTION_BATTERY_CHANGED
    private static final String BATTERY_action = Intent.ACTION_BATTERY_CHANGED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynmian);
        textView = (TextView) findViewById(R.id.tvdynanminreguse);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        动态注册广播接收器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BATTERY_action);
        registerReceiver(mBattertBR, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        取消注册广播接收器
        unregisterReceiver(mBattertBR);
    }

    private BroadcastReceiver mBattertBR = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//    处理Intent传过来的电池信息
            if (intent.getAction().equals(BATTERY_action)) {
                int status = intent.getIntExtra("status", 0);
                int health = intent.getIntExtra("health", 1);
                boolean present = intent.getBooleanExtra("present", false);
                int level = intent.getIntExtra("level", 0);
                int scale = intent.getIntExtra("scale", 0);
                int plugged = intent.getIntExtra("plugged", 0);
                int voltage = intent.getIntExtra("voltage", 0);
                int temperature = intent.getIntExtra("temperature", 0);
                String technology = intent.getStringExtra("technology");
                String statusString = "未知状态";
//                电池状态的判断
                switch (status) {
                    case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                        statusString="未知状态";
                        break;
                    case BatteryManager.BATTERY_STATUS_CHARGING:
                        statusString="充电状态";
                        break;
                    case BatteryManager.BATTERY_STATUS_DISCHARGING:
                        statusString="放电状态";
                        break;
                    case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                        statusString="未充电";
                        break;
                    case BatteryManager.BATTERY_STATUS_FULL:
                        statusString="充满电";
                        break;
                }
                String healthString = "未知状态";
//                电池健康状态判读
                switch (health){
                    case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                        statusString="未知状态";
                        break;
                    case BatteryManager.BATTERY_HEALTH_GOOD:
                        statusString="状态好";
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                        statusString="电池电压过高";
                        break;
                    case BatteryManager.BATTERY_HEALTH_DEAD:
                        statusString="电池没有电";
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                        statusString="电池过热";
                        break;

                }
                String acString="未知状态";
//                电池充电状态
                switch (plugged) {
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        acString="直流充电";
                    break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        acString="usb充电";
                        break;

                }
                textView.setText("电池状态信息如下：\n"+
                "\n是否使用电池："+String.valueOf(present)+
                "\n电池状态："+statusString+
                "\n电池电量："+String.valueOf(level)+
                "\n电池健状态："+healthString+
                "\n最大值："+String.valueOf(scale)+
                "\n充电方式："+acString+
                "\n电池电压："+String.valueOf(voltage)+
                "\n电池温度："+String.valueOf(temperature)+
                "\n电池类型："+technology);
            }
        }
    };
}

