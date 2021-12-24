package com.example.chapter6_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edNum1, edNum2;
    //Button btnNum0,btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6,btnNum7,btnNum8,btnNum9 ;
    Button[] numButton = new Button[10]; //효과적
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    String strNum1, strNum2;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단한 계산기");

        EditText edNum1 = findViewById(R.id.edNum1);
        EditText edNum2 = findViewById(R.id.edNum2);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);

        Button[] numButtons = new Button[10];
        Integer[] btnIDs = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
                R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};

        //10개의 버튼을 쉽게 위젯변수와 id를 연결하기 위해 반복문 활용
        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = (Button) findViewById(btnIDs[i]);

        }
        tvResult = (TextView) findViewById(R.id.tvResult);

        // 숫자 버튼 10개의 이벤트 리스너를 반복문으로 수행
        for (int i = 0; i < numButtons.length; i++) {
            final int index; //상수하나 만들어줌
            index = i;//원래 10개만들어야하는데 반복문안에넣어서 계속돔
            //어디서 선언을 하느냐 따라다르다

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edNum1.isFocused() == true) {//커서가 첫번째 입력란에 있는경우
                        strNum1 = edNum1.getText().toString() + numButtons[index].getText().toString(); // 갖고오고 문자열타입변환
                        edNum1.setText(strNum1);

                    } else if (edNum2.isFocused() == true) {//커서가 두번째 입력락엔 있는경우
                        strNum2 = edNum2.getText().toString() + numButtons[index].getText().toString();
                        edNum2.setText(strNum2);
                    } else {//커서가 첫번째와 두번째 입력란 모두 없는경우
                        Toast.makeText(getApplicationContext(), "먼저 입력란을 선택하세요~", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    strNum1 = edNum1.getText().toString();
                    strNum2 = edNum2.getText().toString();

                    if (strNum1.isEmpty()==true || strNum2.isEmpty()==true){//기입안됬을경우
                        Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        //result에 인티저를 사용하여 변환하며 연산
                        result = Integer.parseInt(strNum1) + Integer.parseInt(strNum2);

                        tvResult.setText("계산결과 :" + result);
                    }
                }
            });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1 = edNum1.getText().toString();
                strNum2 = edNum2.getText().toString();
                if (strNum1.isEmpty()==true || strNum2.isEmpty()==true){
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    //result에 인티저를 사용하여 변환하며 연산
                    result = Integer.parseInt(strNum1) - Integer.parseInt(strNum2);

                    tvResult.setText("계산결과 :" + result);
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1 = edNum1.getText().toString();
                strNum2 = edNum2.getText().toString();
                if (strNum1.isEmpty() == true || strNum2.isEmpty() == true) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    //result에 인티저를 사용하여 변환하며 연산
                    result = Integer.parseInt(strNum1) * Integer.parseInt(strNum2);

                    tvResult.setText("계산결과 :" + result);
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1 = edNum1.getText().toString();
                strNum2 = edNum2.getText().toString();
                if (strNum1.isEmpty()==true || strNum2.isEmpty()==true){
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    //result에 인티저를 사용하여 변환하며 연산
                    result = Integer.parseInt(strNum1) / Integer.parseInt(strNum2);

                    tvResult.setText("계산결과 :" + result);
                }
            }
        });

    }
}
