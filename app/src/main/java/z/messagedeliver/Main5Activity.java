package z.messagedeliver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import z.messagedeliverlibrary.MessageDeliver;

public class Main5Activity extends AppCompatActivity {

    public static final int CHAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        MessageDeliver.sendMessage(CHAGE,"哈哈",1000);
    }
}
