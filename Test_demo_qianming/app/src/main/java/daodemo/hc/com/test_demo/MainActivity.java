package daodemo.hc.com.test_demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import daodemo.hc.com.test_demo.handwritten.SignaturePad;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
    SignaturePad myImageView;
Button button;
Handler mHandler  = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageBitmap(myImageView.getSignatureBitmap());
        button.setVisibility(View.INVISIBLE);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv);
        imageView.setVisibility(View.INVISIBLE);
        myImageView = findViewById(R.id.iv_my);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.setVisibility(View.INVISIBLE);
                Message msg = new Message();
                mHandler.sendMessage(msg);


            }
        });
    }
}
