package com.example.q.neobjukbaseball;

import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int out_count = 0 ;
    int strike = 0 ;
    int ball = 0 ;
    boolean on_3rd_base = false;
    boolean on_2nd_base = false;
    boolean on_1st_base = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize_game();
        findViewById(R.id.btn_swing).setOnClickListener(mClickListener);
    }

//swing part
    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            onSwing();
        }
    };

    private int onSwing() {
        Random random = new Random();
        int dice = random.nextInt(100);
        return 0;
    }
    private int checkifgameset() {
        int score1 = Integer.parseInt((String) ((TextView) findViewById(R.id.des_sum)).getText());
        int score2 = Integer.parseInt((String) ((TextView) findViewById(R.id.des_sum2)).getText());
        if (current_inn() >= 109 && current_inn() <= 199 && (score1 < score2)) {
            return 2;
        }
        if ((current_inn() >= 210) && (score1 > score2)) return 1;
        return 0;
    }

    private int current_inn() {
        int returnee = 0;
        TextView inn = (TextView) findViewById(R.id.des_inn);
        TextView td = (TextView) findViewById(R.id.des_td);
        returnee += Integer.parseInt((String) inn.getText());
        if (td.getText().equals("▲")) returnee += 100;
        else returnee += 200;
        return returnee;
    }
    private void inn_change() {
        TextView inn = (TextView) findViewById(R.id.des_inn);
        TextView td = (TextView) findViewById(R.id.des_td);
        if (td.getText().equals("▲")) {
            td.setText("▼");
        }
        else {
            td.setText("▲");
            inn.setText(Integer.parseInt((String) inn.getText())+1);
        }
        onInn();
    }

    private void raise_score(int team_num) {
        TextView score1 = (TextView) findViewById(R.id.des_sum);
        TextView score2 = (TextView) findViewById(R.id.des_sum2);
        TextView number1 = (TextView) findViewById(R.id.des_1);
        TextView number2 = (TextView) findViewById(R.id.des_2);
        TextView number3 = (TextView) findViewById(R.id.des_3);
        TextView number4 = (TextView) findViewById(R.id.des_4);
        TextView number5 = (TextView) findViewById(R.id.des_5);
        TextView number6 = (TextView) findViewById(R.id.des_6);
        TextView number7 = (TextView) findViewById(R.id.des_7);
        TextView number8 = (TextView) findViewById(R.id.des_8);
        TextView number9 = (TextView) findViewById(R.id.des_9);
        TextView number10 = (TextView) findViewById(R.id.des_10);
        TextView number11 = (TextView) findViewById(R.id.des_11);
        TextView number12 = (TextView) findViewById(R.id.des_12);
        TextView number13 = (TextView) findViewById(R.id.des_13);
        TextView number14 = (TextView) findViewById(R.id.des_14);
        TextView number15 = (TextView) findViewById(R.id.des_15);
        TextView number16 = (TextView) findViewById(R.id.des_16);
        TextView number17 = (TextView) findViewById(R.id.des_17);
        TextView number18 = (TextView) findViewById(R.id.des_18);
        TextView number19 = (TextView) findViewById(R.id.des_19);
        TextView number20 = (TextView) findViewById(R.id.des_20);
        int current_inn = current_inn();
        switch (current_inn) {
            case 101 : number1.setText(Integer.parseInt((String) number1.getText())+1); break;
            case 102 : number2.setText(Integer.parseInt((String) number2.getText())+1); break;
            case 103 : number3.setText(Integer.parseInt((String) number3.getText())+1); break;
            case 104 : number4.setText(Integer.parseInt((String) number4.getText())+1); break;
            case 105 : number5.setText(Integer.parseInt((String) number5.getText())+1); break;
            case 106 : number6.setText(Integer.parseInt((String) number6.getText())+1); break;
            case 107 : number7.setText(Integer.parseInt((String) number7.getText())+1); break;
            case 108 : number8.setText(Integer.parseInt((String) number8.getText())+1); break;
            case 109 : number9.setText(Integer.parseInt((String) number9.getText())+1); break;
            case 201 : number11.setText(Integer.parseInt((String) number11.getText())+1); break;
            case 202 : number12.setText(Integer.parseInt((String) number12.getText())+1); break;
            case 203 : number13.setText(Integer.parseInt((String) number13.getText())+1); break;
            case 204 : number14.setText(Integer.parseInt((String) number14.getText())+1); break;
            case 205 : number15.setText(Integer.parseInt((String) number15.getText())+1); break;
            case 206 : number16.setText(Integer.parseInt((String) number16.getText())+1); break;
            case 207 : number17.setText(Integer.parseInt((String) number17.getText())+1); break;
            case 208 : number18.setText(Integer.parseInt((String) number18.getText())+1); break;
            case 209 : number19.setText(Integer.parseInt((String) number19.getText())+1); break;
        }
        if (current_inn >= 110 && current_inn <= 199) number10.setText(Integer.parseInt((String) number10.getText())+1);
        if (current_inn >= 210 && current_inn <= 299) number20.setText(Integer.parseInt((String) number20.getText())+1);

        if (team_num == 1) score1.setText(Integer.parseInt((String) score1.getText())+1);
        else score2.setText(Integer.parseInt((String) score2.getText())+1);
        }

    private void initialize_game() {
        TextView number1 = (TextView) findViewById(R.id.des_1);
        TextView number2 = (TextView) findViewById(R.id.des_2);
        TextView number3 = (TextView) findViewById(R.id.des_3);
        TextView number4 = (TextView) findViewById(R.id.des_4);
        TextView number5 = (TextView) findViewById(R.id.des_5);
        TextView number6 = (TextView) findViewById(R.id.des_6);
        TextView number7 = (TextView) findViewById(R.id.des_7);
        TextView number8 = (TextView) findViewById(R.id.des_8);
        TextView number9 = (TextView) findViewById(R.id.des_9);
        TextView number10 = (TextView) findViewById(R.id.des_10);
        TextView number11 = (TextView) findViewById(R.id.des_11);
        TextView number12 = (TextView) findViewById(R.id.des_12);
        TextView number13 = (TextView) findViewById(R.id.des_13);
        TextView number14 = (TextView) findViewById(R.id.des_14);
        TextView number15 = (TextView) findViewById(R.id.des_15);
        TextView number16 = (TextView) findViewById(R.id.des_16);
        TextView number17 = (TextView) findViewById(R.id.des_17);
        TextView number18 = (TextView) findViewById(R.id.des_18);
        TextView number19 = (TextView) findViewById(R.id.des_19);
        TextView number20 = (TextView) findViewById(R.id.des_20);
        TextView inn = (TextView) findViewById(R.id.des_inn);
        number1.setText(0);
        number2.setText(0);
        number3.setText(0);
        number4.setText(0);
        number5.setText(0);
        number6.setText(0);
        number7.setText(0);
        number8.setText(0);
        number9.setText(0);
        number10.setText(0);
        number11.setText(0);
        number12.setText(0);
        number13.setText(0);
        number14.setText(0);
        number15.setText(0);
        number16.setText(0);
        number17.setText(0);
        number18.setText(0);
        number19.setText(0);
        number20.setText(0);
        inn.setText(1);
    }


}
