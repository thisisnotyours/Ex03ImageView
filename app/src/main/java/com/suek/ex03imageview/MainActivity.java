package com.suek.ex03imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //뷰들을 참조하는 멤버 참조변수
    ImageView iv;
    Button btnAus, btnBel, btnCan, btnKor;

    // 이미지 변경 번호용 멤버변수
    int num=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //res 폴더안에 layout 폴더 안에 있는 activity_main.xml 에서 만든
        //뷰들을 id 를 이용해서 찾아와 참조변수에 대입
        iv= findViewById(R.id.iv);
        btnAus= findViewById(R.id.btn01);
        btnBel= findViewById(R.id.btn02);
        btnCan= findViewById(R.id.btn03);
        btnKor= findViewById(R.id.btn04);


        //4개의 버튼 클릭에 반응하는 리스너객체 생성 및 설정
        //리스너 객체 4개 만들면 번거로우므로 리스너 객체 1개를 만들고
        //이 리스너 1개가 4개의 버튼의 클릭에 모두 반응하도록..
        //리스너 객체를 멤버변수로 생성하는 경우가 더 일반적임.

        btnAus.setOnClickListener(listener);     //버튼을 누르면 밑에 있는 listener 가 발동함.
        btnBel.setOnClickListener(listener);
        btnCan.setOnClickListener(listener);
        btnKor.setOnClickListener(listener);

        //이미지뷰를 클릭할때마다 이미지를 차례로 변경하기!!
        //이미지뷰에 clickable 속성을 true 로 지정해 줘야만 함.
        //이지지뷰에 클릭에 반응하는 클릭리스너 객체 생성 및 설정: 뭐로? 익명클래스로..
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {      //여기서 View 는 이미지뷰
                //이미지를 차례로 변경

                num++;
                if(num>12)  num=0;
                iv.setImageResource(R.drawable.flag_australia + num);

            }
        });


    }//onCreate method...

    //멤버 선언 위치 (클래스 안에만 있으면 멤버변수임. 메소드 안에있으면 지역변수.)
    //버튼클릭 리스너객체 생성
    View.OnClickListener listener= new View.OnClickListener() {        //추상메소드이기 때문에 자동 오버라이드해줌
        // 이 리스너 객체가 바라보고 있는 버튼이 클릭되면 발동하는 메소드
        @Override
        public void onClick(View v) {

            //버튼에 따라 이미지 변경
            //이 onClick 메소드의 파라미터로 전달된 View 객체(v)가 클릭한 뷰임.  //v가 저 클린한 놈을 참조.
            int id= v.getId();
            switch (id){
                case R.id.btn01:
                    iv.setImageResource(R.drawable.flag_australia);
                    break;

                case R.id.btn02:
                    iv.setImageResource(R.drawable.flag_belgium);
                    break;

                case R.id.btn03:
                    iv.setImageResource(R.drawable.flag_canada);
                    break;

                case R.id.btn04:
                    iv.setImageResource(R.drawable.flag_korea);
                    break;
            }

        }
    };

}//MainActivity class...
