package com.example.databindingex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.os.Bundle;
import android.view.View;

import com.example.databindingex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 언더바(_)가 들어간 표현 방식은 스네이크 케이스(ex. activity_main.xml)
        // 첫 글자와 중간 글자들이 대문자일 경우는 파스칼 케이스(ex. MainActivity.java)

        // 데이터 바인딩을 사용할 때에는 다른 형태로 뷰를 생성
        // 자동 생성된 객체의 이름은 파스칼 케이스에 Binding이 붙은 형태
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 레이아웃에 변수와 연결
        viewModel = new ViewModel();
        binding.setViewModel(viewModel);

        // 뷰 모델의 값을 설정
        viewModel.title.set("Hello World");
    }

    // ObservableField는 값이 바뀌면 연동된 DataBinding에게 정보를 전달하고 이를 이용해 UI를 업데이트할 수 있음
    public static class ViewModel{
        private int clickCount = 0;

        public ObservableField<String> title = new ObservableField<>();

        // 메서드 인자로 꼭 View를 받아야 함(xml에서 클릭 이벤트 처리 시)
        // 레퍼런스 사용 시
//        public void sayHello(View v){
//            clickCount++;
//            title.set("안녕하세요. " + clickCount + "번째 클릭입니다.");
//        }
        public void sayHello(){
            clickCount++;
            title.set("안녕하세요. " + clickCount + "번째 클릭입니다.");
        }
    }

}