package z.messagedeliver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import z.messagedeliverlibrary.MessageDeliver;

public class Main4Activity extends AppCompatActivity {

    private Button mBtButton;
    private TextView mTextTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mBtButton = (Button) findViewById(R.id.bt);
        mTextTextView = (TextView) findViewById(R.id.text);

        mBtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), Main5Activity.class));
            }
        });
        MessageDeliver.addOnHandleListener(new MessageDeliver.OnHandleListener() {
            @Override
            public void onHandle(int type, Object obj) {
                if (type == Main5Activity.CHAGE) {
                    Toast.makeText(getApplicationContext(), "点击了", Toast.LENGTH_SHORT).show();
                    mTextTextView.setText(obj.toString());
                }
            }
        });
        MessageDeliver.addOnHandleListener(new MessageDeliver.OnHandleListener() {
            @Override
            public void onHandle(int type, Object obj) {
                if (type == Main5Activity.CHAGE) {
                    mTextTextView.setText("123456");
                }
            }
        });
    }
}
