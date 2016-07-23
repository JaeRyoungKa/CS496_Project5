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
    Random random = new Random();
    int gameset = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize_game();
        findViewById(R.id.btn_swing).setOnClickListener(mClickListener);
        findViewById(R.id.btn_Notswing).setOnClickListener(mClickListener2);
    }

//swing part
    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (gameset == 0) {
                int returnee = onSwing();
                if (returnee == 0) HR();
                if (returnee == 1) OUT();
            }
        }
    };

    //NOT swing part
    Button.OnClickListener mClickListener2 = new View.OnClickListener() {
        public void onClick(View v) {
            if (gameset == 0) {
                int returnee = onNotSwing();
                if (returnee == 0) HR();
                if (returnee == 1) OUT();
            }
        }
    };

    private void HR() {
        raise_score(current_team());
        if (on_3rd_base) raise_score(current_team());
        if (on_2nd_base) raise_score(current_team());
        if (on_1st_base) raise_score(current_team());
        on_1st_base = false;
        on_2nd_base = false;
        on_3rd_base = false;
        ((TextView)findViewById(R.id.log)).setText("홈런!");
    }

    private void OUT() {
        out_count++;
        refresh_billboard();
        if (out_count >= 3 ) {
            checkifgameset();
            checkifinnset();
        }
        ((TextView)findViewById(R.id.log)).setText("아웃!");
    }

    private void refresh_billboard() {
        ((TextView)findViewById(R.id.des_out)).setText(String.valueOf(out_count));
        ((TextView)findViewById(R.id.des_strike)).setText(String.valueOf(strike));
        ((TextView)findViewById(R.id.des_ball)).setText(String.valueOf(ball));

    }

    private void checkifinnset() {
        if (out_count >= 3) {
            out_count = 0 ;
            strike = 0;
            ball = 0;
            on_3rd_base = false;
            on_2nd_base = false;
            on_1st_base = false;
            change_inn();
            refresh_billboard();
        }
    }
    private int onSwing() {
        int dice = random.nextInt(100);
        if (dice > 50) return 1;
        return 0;
    }

    private int onNotSwing() {
        int dice = random.nextInt(100);
        if (dice > 50) return 1;
        return 0;
    }

    private int checkifgameset() {
        int score1 = Integer.parseInt((String) ((TextView) findViewById(R.id.des_sum)).getText());
        int score2 = Integer.parseInt((String) ((TextView) findViewById(R.id.des_sum2)).getText());
        if (current_inn() >= 109 && current_inn() <= 199 && score2 > score1) {
            gameset = 2;
            return 2;
        }
        else if (current_inn() >= 209 && score1 > score2) {
            gameset = 1;
            return 1;
        }
        else if (current_inn() >= 209 && score2 > score1) {
            gameset = 2;
            return 2;
        }
        return 0;
    }

    private int current_team() {
        if (current_inn() > 200) return 2;
        else return 1;
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
    private void change_inn() {
        TextView inn = (TextView) findViewById(R.id.des_inn);
        TextView td = (TextView) findViewById(R.id.des_td);
        if (td.getText().equals("▲")) {
            td.setText("▼");
        }
        else {
            td.setText("▲");
            inn.setText(String.valueOf(Integer.parseInt((String) inn.getText())+1));
        }
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
            case 101 : number1.setText(String.valueOf(Integer.parseInt((String) number1.getText())+1)); break;
            case 102 : number2.setText(String.valueOf(Integer.parseInt((String) number2.getText())+1)); break;
            case 103 : number3.setText(String.valueOf(Integer.parseInt((String) number3.getText())+1)); break;
            case 104 : number4.setText(String.valueOf(Integer.parseInt((String) number4.getText())+1)); break;
            case 105 : number5.setText(String.valueOf(Integer.parseInt((String) number5.getText())+1)); break;
            case 106 : number6.setText(String.valueOf(Integer.parseInt((String) number6.getText())+1)); break;
            case 107 : number7.setText(String.valueOf(Integer.parseInt((String) number7.getText())+1)); break;
            case 108 : number8.setText(String.valueOf(Integer.parseInt((String) number8.getText())+1)); break;
            case 109 : number9.setText(String.valueOf(Integer.parseInt((String) number9.getText())+1)); break;
            case 201 : number11.setText(String.valueOf(Integer.parseInt((String) number11.getText())+1)); break;
            case 202 : number12.setText(String.valueOf(Integer.parseInt((String) number12.getText())+1)); break;
            case 203 : number13.setText(String.valueOf(Integer.parseInt((String) number13.getText())+1)); break;
            case 204 : number14.setText(String.valueOf(Integer.parseInt((String) number14.getText())+1)); break;
            case 205 : number15.setText(String.valueOf(Integer.parseInt((String) number15.getText())+1)); break;
            case 206 : number16.setText(String.valueOf(Integer.parseInt((String) number16.getText())+1)); break;
            case 207 : number17.setText(String.valueOf(Integer.parseInt((String) number17.getText())+1)); break;
            case 208 : number18.setText(String.valueOf(Integer.parseInt((String) number18.getText())+1)); break;
            case 209 : number19.setText(String.valueOf(Integer.parseInt((String) number19.getText())+1)); break;
        }
        if (current_inn >= 110 && current_inn <= 199) number10.setText(String.valueOf(Integer.parseInt((String) number10.getText())+1));
        if (current_inn >= 210 && current_inn <= 299) number20.setText(String.valueOf(Integer.parseInt((String) number20.getText())+1));

        if (team_num == 1) score1.setText(String.valueOf(Integer.parseInt((String) score1.getText())+1));
        else score2.setText(String.valueOf(Integer.parseInt((String) score2.getText())+1));
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
        number1.setText("0");
        number2.setText("0");
        number3.setText("0");
        number4.setText("0");
        number5.setText("0");
        number6.setText("0");
        number7.setText("0");
        number8.setText("0");
        number9.setText("0");
        number10.setText("0");
        number11.setText("0");
        number12.setText("0");
        number13.setText("0");
        number14.setText("0");
        number15.setText("0");
        number16.setText("0");
        number17.setText("0");
        number18.setText("0");
        number19.setText("0");
        number20.setText("0");
        inn.setText("1");
    }


}
