package com.code19.send2me;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by gh0st on 2016/12/5.
 */

public class SmsListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("sms", "on receive," + intent.getAction());
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String messageBody = smsMessage.getMessageBody();
                String address = smsMessage.getOriginatingAddress();
                Log.i("sms", "body: " + messageBody);
                Log.i("sms", "address: " + address);
                String message = "[" + address + "] " + messageBody;
                String number = context.getSharedPreferences("data", Context.MODE_PRIVATE).getString("number", "");
                if (TextUtils.isEmpty(number)) {
                    Log.i("sms", "phone number not set. ignore this one.");
                    return;
                }
                Log.i("sms", "sending to " + number);
                Log.i("sms", "message send:" + message);
                //SmsManager.getDefault().sendTextMessage(number, null, message, null, null);
                //处理短信

            }
        }
    }
}
