package voting.cs1631.pitt.edu.votingapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import org.w3c.dom.Text;

/**
 * Created by Kevin on 3/2/2017.
 */

public class TextReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("RECEIVED");
        ReceiverActivity receiverActivity = AdminActivity.getInstance();
        if(receiverActivity == null) {
            return;
        }
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] sms = (Object[]) bundle.get("pdus");
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage msg = SmsMessage.createFromPdu((byte[]) sms[i]);
                receiverActivity.addVote(msg.getMessageBody());
            }
        }

    }

}
