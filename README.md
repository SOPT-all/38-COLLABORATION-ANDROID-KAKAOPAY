# 38-COLLABORATION-ANDROID-KAKAOPAY
> **LET'S SOPT 38기 안드로이드 3조**
> 🤑카카오페이(KAKAOPAY)

---

## 👥 Team
|             [남궁혜민 (LEAD)](https://github.com/hyeminililo)             |                [조예슬](https://github.com/joyrii)                 |                [강승희](https://github.com/seunghee0321)                 |                           [윤갑유](https://github.com/gahbyu)                           |
|:-------------------------------------------------------------------:|:-------------------------------------------------------------------:|:------------------------------------------------------------------:|:---------------------------------------------------------------------------------------:|
| <img src="https://github.com/hyeminililo.png" alt="혜민" width="150"/> | <img src="https://github.com/joyrii.png" alt="예슬" width="150"/> | <img src="https://github.com/seunghee0321.png" alt="승희" width="150"/> | <img src="https://github.com/gahbyu.png" alt="갑유" width="150"/> |
|                               `자산 탭 메인화면`                                |                                `지출 통합 내역`                                 |                              `지출 상세 내역`                              |                             `상세 소비 내역`                             |

---

## UX 개선 사항

기존 화면은 주요 기능 진입 경로가 분산되어 있고, 지출 데이터가 단순 나열 중심으로 제공되어 사용자가 핵심 기능을 빠르게 실행하거나 데이터를 이해하기 어려운 구조였습니다.  
이를 개선하기 위해 `핵심 기능 접근성`, `정보 표기 일관성`, `지출 데이터 이해도`를 중심으로 UX를 재설계했습니다.

### 1. 기능 구성 및 표기 방식 일관성 강화

- 분할 결제 금액을 지출 상세 내역에 바로 반영할 수 있도록 기능을 추가했습니다.
- 카드 정보 표기 방식이 화면마다 다르게 보이는 문제를 줄이기 위해 카드 표시 방식을 통일했습니다.
- 이를 통해 지출 관리 흐름의 현실성을 높이고, 데이터 신뢰도를 개선했습니다.

### 2. 핵심 태스크 접근성 개선

- 잔액 확인, 송금 등 자주 사용하는 기능이 스크롤 탐색에 의존하지 않도록 개선했습니다.
- 자산 영역 하단에 핵심 액션 버튼을 고정 배치하여 사용자가 주요 기능에 빠르게 접근할 수 있도록 했습니다.
- 이를 통해 핵심 기능 접근 시간을 줄이고, 초기 탐색 부담을 낮췄습니다.

### 3. 지출 내역을 분석 중심 구조로 재설계

- 기존 지출 내역은 단순 목록 형태로 제공되어 소비 흐름을 파악하기 어려웠습니다.
- 상단 요약 영역을 신설하고, `지난달 대비 소비 변화` 등 분석 중심 정보를 제공하도록 구조를 개선했습니다.
- 분석 진입 CTA를 명확히 배치하여 사용자가 지출 데이터를 단순히 확인하는 것을 넘어 이해할 수 있도록 했습니다.
- 불필요한 섹션은 줄이고 핵심 탭 중심으로 정리하여 화면 복잡도를 낮췄습니다.

### 기대 효과

- 주요 금융 기능 접근성 향상
- 지출 데이터 이해도 개선
- 화면 구조의 일관성 강화
- 사용자 탐색 부담 감소
- 금융 관리 경험의 실생활 밀착도 향상

## 🛠 Tech Stack
- `Language`: Kotlin
- `UI Framework`: Jetpack Compose
- `Network`: Retrofit2, OkHttp3, Kotlinx Serialization
- `Architecture`: MVVM
- `Dependency Management`: Version Catalog (`libs.versions.toml`)

## 📁 Folder Structure
```plaintext
com.example.a38_collaboration_android_kakaopay // 프로젝트 루트 패키지
├── app // 앱 진입점과 전역 앱 설정
│   ├── MainActivity // 앱 시작 Activity
│   ├── App // 최상위 Compose App 구성
│   └── navigation // 전체 화면 이동 경로 정의
│       ├── AppNaviHost // Navigation Host 설정
│       └── Route // 화면별 Route 정의
├── core // 여러 계층에서 공통으로 사용하는 모듈
│   ├── common // 공통 확장 함수, 상태, 유틸 모음
│   ├── designsystem // 공통 UI 컴포넌트와 테마 시스템
│   │   ├── theme // 색상, 타이포그래피, 테마 정의
│   │   └── component // 재사용 가능한 디자인 시스템 컴포넌트
│   ├── local // 로컬 저장소 관련 공통 구현
│   └── network // 네트워크 공통 응답 모델 및 설정
├── data // 데이터 획득 및 변환을 담당하는 계층
│   ├── local // 로컬 데이터 소스 구현
│   ├── mapper // DTO와 Domain/UI 모델 간 매핑
│   ├── remote // 서버 통신 관련 구현
│   │   ├── api // Retrofit API 인터페이스
│   │   ├── datasource // API 호출을 감싼 데이터 소스
│   │   └── dto // 요청/응답 데이터 모델
│   │       ├── request // 요청 DTO
│   │       └── response // 응답 DTO
│   └── repository // Repository 구현체
├── domain // 비즈니스 로직과 도메인 모델 계층
│   ├── model // 핵심 도메인 모델
│   ├── repository // Repository 추상화 인터페이스
│   └── usecase // 기능별 유스케이스
└── presentation // 화면 UI와 상태 관리 계층
    ├── splash // 스플래시 화면
    ├── loading // 로딩 전용 화면
    ├── main // 메인 화면 관련 구성
    ├── edgecase // 에러/빈 상태 등 예외 UI
    ├── financialoverview // 자산 탭 메인 화면 기능
    └── spending // 지출 관련 기능 묶음
        ├── spendingoverview // 지출 통합 내역 화면
        ├── spendingdetails // 지출 상세 내역 화면
        └── spendinganalysis // 상세 소비 내역 화면
```

## 🎥 시연 영상

<details>
<summary>시연 영상 보기</summary>

- [시연 영상 보러가기](링크-추가-예정)

</details>
