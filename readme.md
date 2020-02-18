
# Logger

개인용 안드로이드 logger

## Getting Started

### 1. 프로젝트 모듈에 maven 저장소 추가
```Groovy
allprojects {
    repositories {
        jcenter()
        maven {
            url 'https://dl.bintray.com/irus2315/maven' <- 추가
        }
    }
}
```

### 2. App모듈에 의존성 추가
```Groovy
implementation 'kr.twothumb.lib:logger:1.0.8'
```

### 3. Application 클래스의 onCreate함수에 추가
```kotlin
override fun onCreate() {
	super.onCreate()
	DevLog.getInstance().init("Editor") <- 초기화 / 태그설정
	DevLog.i("hi")
}
```



## Authors

* **Twothumb** (http://twothumb.kr/)
