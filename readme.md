# Clone_Weather
### retrofit으로 날씨 openAPI에서 데이터를 불러와서, <br>현재의 날씨와 온도를 보여주는 안드로이드 애플리케이션

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
->Shimmer 애니메이션이 들어간 프래그먼트와, 정보를 담을 수 있는 프래그먼트 (쌍둥이처럼 비슷하 생긴) 두 개를 준비한다.
->MainActivity는 일단 전자를 부착한 후, 뷰모델의 LiveData를 관찰할 객체를 등록한다.
->뷰모델이 API에서 데이터를 받아와 postValue() 메서드로 LiveData에 변경사항이 생긴다.
->아까 등록한 객체가 MainActivity의 shimmer 애니메이션 프래그먼트를 정보를 담느 프래그먼트로 replace()한다.
       
DataBinding을 사용하였다. (+BindingAdapter을 사용해 보았다.)
->image resource id를 xml attribute로 넣으면 imageView로 이미지를 설정하는 간단한 어댑터을 만들어 보았다.    


### 해맸던 부분, 어려웠던 부분
- **MVVM**을 사용할 때 ViewModel이 어디부터 어디까지 가지고 있어야 하는지 알기 어려웠다.
    - ViewModel은 개발자들의 개성에 따라 다르게 구현한다는 것을 알 수 있었다.
- **LiveData**의 값이 바뀌어도 UI가 전혀 반영되지 않는 오류가 발생하였다.
    - LiveData의 setValue(postValue)를 사용하여야 반영된다는 것을 알게 되었다.
        
        ```kotlin
        data.value.id=0 (X)
        
        data.setValue(postValue)(data.value.copy(id=0)) (O)
        ```
        
- BindingAdapter를 사용하도록 하면 component가 null이라는 오류가 발생하였다.
    - Kotlin에서는 @**JVMStatic**이라는 어노테이션을 붙여야 한다는 것을 배웠다.

## 기능 소개

### OpenAPI를 호출하여 리스폰스를 받을 때까지 로딩 애니메이션을 보여준다.<br>+현재 날씨와 온도를 화면에 표시한다.(서울기준)
![shimmerView](https://user-images.githubusercontent.com/60867063/163924150-adada2f2-d888-4ba1-9c84-52b4de8c4e9d.gif)

