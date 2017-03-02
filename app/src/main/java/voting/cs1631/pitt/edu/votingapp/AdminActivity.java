package voting.cs1631.pitt.edu.votingapp;

import android.content.IntentFilter;
import android.provider.Telephony;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdminActivity extends AppCompatActivity implements ReceiverActivity {

    private TextView choice1 = null;
    private TextView choice2 = null;
    private TextView choice3 = null;
    private static AdminActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        instance = this;
//        textReceiver = new TextReceiver();
//        textReceiver.setReceiverActivity(this);
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(Telephony.Sms.Intents.DATA_SMS_RECEIVED_ACTION);
//        filter.addAction(Telephony.Sms.Intents.SMS_DELIVER_ACTION);
//        filter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
//        getBaseContext().registerReceiver(textReceiver, filter);
        choice1 = (TextView) findViewById(R.id.count_1);
        choice2 = (TextView) findViewById(R.id.count_2);
        choice3 = (TextView) findViewById(R.id.count_3);
    }

    @Override
    public void addVote(String msg) {
        try {

            Integer code = Integer.parseInt(msg);

            switch(code) {
                case 1000:
                    addOne(choice1);
                    break;
                case 2000:
                    addOne(choice2);
                    break;
                case 3000:
                    addOne(choice3);
                    break;
                default:
                    return;
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }

    }

    private void addOne(TextView choice) {
        Integer count = Integer.parseInt(choice.getText().toString());
        count++;
        choice.setText(count.toString());
    }

    public static AdminActivity getInstance() {
        return instance;
    }
}
