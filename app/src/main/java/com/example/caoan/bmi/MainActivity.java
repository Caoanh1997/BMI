package com.example.caoan.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText et1,et2;
    public Button bt;
    public TextView tv;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_game,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_game:
                System.out.println("New game");
                return true;
            case R.id.help:
                System.out.println("Help");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        bt = findViewById(R.id.btresult);
        tv = findViewById(R.id.tv);
    }

    public void result(View view) {
        try {
            float a = Float.valueOf(String.valueOf(et1.getText()));
            float b = Float.valueOf(String.valueOf(et2.getText()));

            float bmi = b/(a*a);
            String s = "Chỉ số BMI của bạn là: "+bmi;
            if(bmi<18.5){
                s+=". Bạn đang suy dinh dưỡng nên cần xem lại chế độ ăn uống và ăn nhiều hơn 1 chút nhé.";
            }else
            {
                if(18.5<=bmi && bmi<=24.9){
                    s+=". Bạn đang bình thường, hãy tiếp tục phát huy như vậy nhé.";
                }else {
                    if(bmi>=25 && bmi<=29.9){
                        s+=". Bạn đang hơi bị thừa cân nên bớt ăn lại 1 chút.";
                    }else {
                        if(bmi>=30 && bmi<=34.9){
                            s+=". Bạn đang bị béo phì cấp độ 1. Bạn nên tập thể dục thường xuyên và có chế độ ăn uống hợp lý hơn.";
                        }else {
                            if(bmi>=35 && bmi<=39.9){
                                s+=". Bạn đang bị béo phì cấp độ 2. Nguy cơ mắc bệnh của bạn rất cao, nên tìm bác sỹ tư vấn.";
                            }else {
                                if(bmi>=40){
                                    s+=". Bạn đang bị béo phì cấp độ 3. Kiểu này thì nên đi hút mỡ đi là vừa.";
                                }
                            }
                        }
                    }
                }
            }

            tv.setText(s);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Nhập dữ liệu chưa đúng",Toast.LENGTH_SHORT).show();
        }
    }
}
