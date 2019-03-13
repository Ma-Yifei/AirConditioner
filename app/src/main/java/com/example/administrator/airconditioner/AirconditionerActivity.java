package com.example.administrator.airconditioner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AirconditionerActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView windSpeed;
    private ImageView windSpeedImage;
    private TextView windSpeedText;
    private ImageView switchImage;
    private RelativeLayout switchLayout;
    private TextView modal;
    private ImageView modelImage;
    private TextView modelText;
    private RelativeLayout decreaseLayout;
    private TextView temperatureText;
    private RelativeLayout addLayout;

    private TextView windspeedText;
    private TextView centigrade;



    private int windSpeedCount = 0;
    private int switchCount = 0;
    private int modelCount = 0;
    int temperatureCount = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airconditioner);
        windSpeed = findViewById(R.id.wind_speed);
        windSpeed.setOnClickListener(this);


        windSpeedImage = findViewById(R.id.imageView);
        windSpeedText = findViewById(R.id.textView3);

        switchImage = findViewById(R.id.switch1);
        switchImage.setOnClickListener(this);
        switchLayout = findViewById(R.id.switch_view);
        switchLayout.setOnClickListener(this);

        modal = findViewById(R.id.model);
        modal.setOnClickListener(this);

        modelImage = findViewById(R.id.imageView2);
        modelText = findViewById(R.id.textView4);

        decreaseLayout = findViewById(R.id.decrease_view);
        decreaseLayout.setOnClickListener(this);
        temperatureText = findViewById(R.id.temperature);
        addLayout = findViewById(R.id.add_view);
        addLayout.setOnClickListener(this);

        windspeedText = findViewById(R.id.textView2);
        centigrade = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //改变风速
            case R.id.wind_speed:
                //windSpeedCount为0，风速为自动；windSpeedCount为1，风速为一档；2——二档；3——三档
                if (windSpeedCount >= 3){
                    windSpeedCount = 0;
                }else {
                    windSpeedCount++;
                }
                if (windSpeedCount == 1){
                    windSpeedImage.setImageResource(R.mipmap.wind_speed1);
                    windSpeedText.setText("低");
                }else if (windSpeedCount == 2){
                    windSpeedImage.setImageResource(R.mipmap.wind_speed2);
                    windSpeedText.setText("中");
                }else if (windSpeedCount == 3){
                    windSpeedImage.setImageResource(R.mipmap.wind_speed3);
                    windSpeedText.setText("高");
                }else if (windSpeedCount == 0){
                    windSpeedImage.setImageResource(R.mipmap.wind_speed0);
                    windSpeedText.setText("自动");
                }
                break;
                //开关
            case R.id.switch_view : case R.id.switch1:
                if (switchCount == 1){
                    switchCount = 0;
                }else {
                    switchCount++;
                }
                if (switchCount == 0){


                    switchImage.setImageResource(R.mipmap.airconditioner_switch);


                }else{
                    switchImage.setImageResource(R.mipmap.switch_red);
                }
                break;
                //模式——制冷制热
            case R.id.model:
                if (modelCount == 1){
                    modelCount = 0;
                }else {
                    modelCount++;
                }
                if (modelCount == 0){

                    modelImage.setImageResource(R.mipmap.refrigeration);
                    modelText.setText("制冷");
                }else{
                    modelImage.setImageResource(R.mipmap.heating);
                    modelText.setText("制热");
                }
                break;
                //降温
            case R.id.decrease_view:
               if (temperatureCount <= 16){
                    temperatureCount = 30;
                }else {
                    temperatureCount--;
                }
                String temperature1 = Integer.toString(temperatureCount);
                temperatureText.setText(temperature1);
                break;
                //升温
            case R.id.add_view:
                if (temperatureCount >= 30){
                    temperatureCount = 16;
                }else {
                    temperatureCount++;
                }
                String temperature2 = Integer.toString(temperatureCount);
                temperatureText.setText(temperature2);
                break;

        }
    }
}
