package com.example.dpl.multouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FrameLayout layout;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout= (FrameLayout) findViewById(R.id.layout);
        imageView= (ImageView) findViewById(R.id.iv);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity.this,"Action_down",Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ///System.out.println(motionEvent.getPointerCount());获取多个触摸点
                        Toast.makeText(MainActivity.this,"action_move",Toast.LENGTH_SHORT).show();
                        FrameLayout.LayoutParams layoutParams= (FrameLayout.LayoutParams) imageView.getLayoutParams();
                        layoutParams.leftMargin= (int) motionEvent.getX();
                        layoutParams.topMargin= (int) motionEvent.getY();
                        imageView.setLayoutParams(layoutParams);//给某个View设置LayoutParams参数
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this,"Action_up",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
