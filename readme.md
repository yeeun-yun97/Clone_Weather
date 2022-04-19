# Clone_Weather
### retrofit으로 날씨 openAPI에서 데이터를 불러와서 현재의 날씨와 온도를 보여주는 안드로이드 애플리케이션

## 스택
<img src="https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=Android&logoColor=black"/> <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=black"/> 

## 클론 출처
위키북스.     
만들면서 배우는 코틀린 & 안드로이드 프로그래밍. 유병석 지음.   
http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791158392529&orderClick=LAG&Kc=

### 따라하면서 배운 것
Fragment에 대해서    
->파라미터가 없는 기본 생성자가 필수라는 것을 알게 되었다.    
->SupportFragmentManager로 프래그먼트 추가하고 제거하는 방법을 배웠다.      

retrofit을 사용하기    
->retrofit 기본 사용 방법을 복습할 수 있었다.    
->OpenAPI 출처 : https://openweathermap.org/   


### 새로 추가해본 것
MVVM 구조를 서툴게나마 만들어보았다.  
->ViewModel이 Model을 MutableLiveData로 가지며, 모델을 API호출로 가져오는 로직도 가지도록 만들었다.

Coroutine을 사용해보았다.    
->코루틴+retrofit으로 OpenApi와 비동기적으로 통신하게 만들어 보았다.
->scope는 viewModelScope를 사용하여 뷰모델의 생명주기를 따르게 하였다.

Shimmer-android 라이브러리를 활용하여 로딩 화면을 추가하였다.    
->일단 shimmer 적용된 레이아웃을 보여주다가, ViewModel이 화면을 표시하기 위한 모델을 가져오는 대로, 
<br>shimmer 적용된 레이아웃을 숨기고, 실제 레이아웃을 보여주도록 만들어보았다.    
       
DataBinding을 사용하였다. (+BindingAdapter을 사용해 보았다.)
->image resource id를 xml attribute로 넣으면 imageView로 이미지를 설정하는 간단한 어댑터을 만들어 보았다.    

## 기능 소개

### OpenAPI를 호출하여 리스폰스를 받을 때까지 로딩 애니메이션을 보여준다.<br>+현재 날씨와 온도를 화면에 표시한다.(서울기준)
![shimmerView](https://user-images.githubusercontent.com/60867063/163924150-adada2f2-d888-4ba1-9c84-52b4de8c4e9d.gif)

