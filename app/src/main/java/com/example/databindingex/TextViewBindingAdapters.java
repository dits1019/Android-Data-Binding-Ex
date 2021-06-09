package com.example.databindingex;

// 연결되는 메서드는 두 가지 종류가 있음
// 첫 번째는 속성과 비슷한 이름을 가지는 메서드
// Ex) android:text에 값을 대입했다면 데이터 바인딩은 setText메서드를 찾음
// 두 번째는 바인딩 어댑터, 뷰 속성에 맞는 메서드가 그 뷰에 없을 수도 있음
// 하지만 바인딩 어댑터는 어떤 뷰의 속성을 어떻게 처리할지 뷰 외부에서 정의

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

// TextView에 app:reverseText라는 속성이 있고 이 속성은 글씨를 거꾸러 보여준다고 가정
// app:reverseText를 위한 바인딩 어댑터
// 바인딩 어댑터는 어떤 클래스에 포함되는 어떤 이름을 짓든 상관없지만
// 외부에서 볼 수 있게 개방되어있어야 하고 @BindingAdapter로 지정된 스태틱 메서드만 있으면 됨
public class TextViewBindingAdapters{
    // 21 ~ 22는 바인딩 어댑터
    // 대상 뷰가 첫 번째 인자가 됨(이 바인딩 어댑터는 TextView)를 위한 것이기 때문에 TextView 타입을 받음
    // 두 번째 인자부터는 @BindingAdapter에 적어 둔 속성이 됨.
    @BindingAdapter("reverseText")
    public static void setReverseText(TextView view, String toReverse){
        String reversed = new StringBuilder(toReverse).reverse().toString();
        view.setText(reversed);
    }
}
// 여러 인자가 필요한 경우 괄호 안에 중괄호를 사용
// Ex) 여러인자 처리 시
// @BindingAdapter({"reverseText", "shouldReverse"})
// public static void setReverseText(TextView view, String toReverse, boolean shouldReverse)
