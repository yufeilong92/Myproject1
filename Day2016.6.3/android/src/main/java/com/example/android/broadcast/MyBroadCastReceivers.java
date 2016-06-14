package com.example.android.broadcast;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/7.
 */
public class MyBroadCastReceivers extends BroadcastReceiver {
    private static final String CALLACTIOM = Intent.ACTION_NEW_OUTGOING_CALL;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(CALLACTIOM)) {
            String phonenumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.i("broadcast", "有人在打电话" + phonenumber);
        } else {
            Log.i("broadcast", "有电话呼入");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
    }

    PhoneStateListener phoneStateListener = new PhoneStateListener() {

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.i("broadcast", "接收");
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.i("broadcast", "接听");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    Log.i("broadcast", "有电话呼入，来电号码" + incomingNumber);
                    break;
                default:
                    break;
            }
        }
    };

}