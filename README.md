
# ☔소나기 (소상공인의 나누는 기쁨)

**소상공인들의 기부를 쉽게 할 수 있는 웹, 앱**

 조리된 음식을 푸드뱅크에 기부하는 것은 복잡한 과정을 필요로 합니다. 푸드뱅크를 통하지 않고 직접 기부하는 것도 번거로운 일입니다. 그러나 기부자와 수혜자를 자연스럽게 연결하는 시스템을 통해, 기부 과정을 간편하게 만들 수 있습니다. 이렇게 하면, 기부를 더욱 쉽게 할 수 있게 됩니다.
 
# 💻프로젝트 소개

## 🕰 개발 기간

- 23.11 ~ 23.12 (총 1개월)

## 🙋‍♂️ 팀원 소개

| 나형진 | 윤영학 | 정철우 | 최광혁 |
| --- | --- | --- | --- |
| <img src="https://github.com/aSIX-final-project/Sonagi_App/assets/145747048/9f8bd85a-06ef-45c7-a8a0-cac97b2890a3" width="150" height="150"> | <img src="https://github.com/aSIX-final-project/Sonagi_App/assets/145747048/fe02368b-5e14-47cf-be16-c2766a5ab726" width="150" height="150"> | <img src="https://github.com/aSIX-final-project/Sonagi_App/assets/145747048/ef0d850c-df6e-467c-b6c4-4daccb8cdaf9" width="150" height="150"> | <img src="https://github.com/aSIX-final-project/Sonagi_App/assets/145747048/ecfb838c-e02e-4bae-9cb6-0b42b775d3b1" width="150" height="150"> |
| 팀장<br>앱 제작, 아이디어 | 팀원<br>백엔드<br>앱 제작, 웹 설계 | 팀원<br>백엔드<br>DB 설계, 앱 설계 및 제작 | 팀원<br>프론트<br>디자인 |

## ⚙ 개발 환경

- Java 17
- Node 18
- IDE : Intellij, Visual Studio Code
- Framework : Springboot 3.x
- Database : MySQL(8.0.x)
- ORM: Mybatis, JPA

# 📌 주요 기능

## 📝 기능 요구 명세서

<img src="https://github.com/aSIX-final-project/Sonagi_App/assets/75625504/1270fa44-02b4-4921-b934-dbcc3a786a05">

## 📖 REST API

## &ensp;보육시설(피기부자) Member &ensp;/boot/member 

### &emsp;로그인 /login [`POST`]
- `id`: String
- `password`: String

### &emsp;회원가입 /regist [`POST`]
- `id`: String
- `password`: String
- `managerName`: String
- `phoneNum`: String
- `adTel`: String
- `adName`: String
- `address`: String
- `totalHc`: int
- `currHc`: int
- `introduction`: String

### &emsp;모든 회원 정보 얻기 /findAll [`GET`]

### &emsp;회원 정보 수정 /modify [`POST`]
- `id`: String
- `password`: String
- `adTel`: String
- `adName`: String
- `address`: String
- `totalHc`: int
- `introduction`: String
- `profileImage`: String

### &emsp;회원 정보 삭제 /delete [`POST`]
- `id`: String

### &emsp;프로필 이미지 등록 /files [`POST`]
- `file`: MultipartFile
- `nameFile`: String
- `folderName`: String

### &emsp;회원 토큰(알림) /token [`POST`]
- `id`: String
- `fcmToken`: String
- `expotoken`: String

### &emsp;프로필 이미지 변경 /updateImageUrl [`POST`]
- `id`: String
- `profileImage`: String

### &emsp;ID로 회원정보 얻기 /findById [`POST`]
- `id`: String

## &ensp;소상공인(기부자),음식점  Restaurant &ensp;/boot/restaurant

### &emsp;로그인 /login [`POST`]
- `id`: String
- `password`: String

### &emsp;회원가입 /regist [`POST`]
- `id`: String
- `password`: String
- `name`: String
- `phoneNum`: String
- `adTel`: String
- `adName`: String
- `address`: String
- `bNum`: String
- `profileImage`: String

### &emsp;모든 회원 정보 찾기 /findAll [`GET`]

### &emsp;회원 정보 수정 /modifyPw [`POST`]
- `id`: String
- `password`: String
- `adTel`: String
- `adName`: String
- `address`: String

### &emsp;회원 정보 삭제 /delete [`POST`]
- `id`: String

### &emsp;프로필 이미지 등록 /files [`POST`]
- `file`: MultipartFile
- `nameFile`: String
- `folderName`: String

### &emsp;회원 토큰(알림) /token [`POST`]
- `id`: String
- `fcmToken`: String
- `expotoken`: String

### &emsp;프로필 이미지 변경 /updateImageUrl [`POST`]
- `id`: String
- `profileImage`: String

### &emsp;ID로 회원정보 얻기 /findById [`POST`]
- `id`: String

## &ensp;관리자(기부자와 피기부자에서 회원정보 수정,삭제 요청시 관리자에서 처리) Admin &ensp;/boot/admin

### &emsp;관리자에게 요청 /requestAdmin [`POST`]
- `id`: String
- `adName`: String
- `adTel`: String
- `managerName`: String
- `address`: String
- `totalHc`: int
- `introduction`: String

### &emsp;모든 회원 정보 얻기 /findAll [`GET`]

### &emsp;관리자에게 온 요청사항 삭제 /delete [`POST`]
- `adName`: String
- `adTel`: String
- `address`: String
- `id`: String
- `managerName`: String
- `totalHc`: int

## &ensp;재능 기부 Ability &ensp;/boot/Ability

### &emsp;재능 기부 등록 /regist [`POST`]
- `adName`: String
- `managerName`: String
- `phoneNum`: String
- `introduction`: String
- `donationDate`: String
- `progressTime`: String
- `currHc`: String
- `place`: String
- `sharingContents`: String

### &emsp;모든 재능 기부 목록 /findAll [`GET`]

### &emsp;재능 기부 내용 삭제 /delete [`POST`]
- `adName`: String
- `managerName`: String

### &emsp;재능 기부 시설 이름으로 정보 찾기 /findByadName [`POST`]
- `adName`: String

## &ensp;크롤링 Crawling &ensp;/boot/crawling

### &emsp;크롤링 한 리스트 전부 /findAll [`GET`]

### &emsp;공지사항 크롤링 /findNotice [`GET`]
- https://ols.semas.or.kr/ols/man/SMAN051M/page.do 소상공인 정책 자금 공지사항에 게시된 내용 크롤링

### &emsp;네이버 크롤링 /findNaver [`GET`]
- https://finsupport.naver.com/subvention/search 네이버 비즈니스 금융센터 사이트에 나오는 정책지원금 공고 크롤링

## &ensp;기부 Donation &ensp;/boot/donation

### &emsp;기부 등록 /regist [`POST`]
- `donatedProvider`: String
- `donatedReceiver`: String
- `donatedAmount`: String
- `donatedPrice`: String
- `foodTitle`: String

### &emsp;모든 기부 목록 얻기 /findAll [`GET`]

### &emsp;기부 내용 수정 /modify [`POST`]
- `foodTitle`: String
- `donatedReceiver`: String
- `donatedAmount`: String

### &emsp;보육시설 이름으로 기부 정보 찾기 /findByIdP [`POST`]
- `donatedProvider`: String

### &emsp;소상공인 이름으로 기부 정보 찾기 /findByIdR [`POST`]
- `donatedReceiver`: String

### &emsp;기부 유무 확인 /IsReviewed [`POST`]
- `isReviewed`: int
- `donatedProvider`: String
- `foodTitle`: String

## &ensp;음식 Food &ensp;/boot/food

### &emsp;기부 음식 등록 /regist [`POST`]
- `id`: String
- `foodName`: String
- `foodAmount`: String
- `foodPrice`: int
- `foodTel`: String
- `foodAddress`: String
- `foodGiver`: String
- `foodImage`: String
- `context`: String
- `deadline`: String

### &emsp;한 음식점에서 기부하는 모든 음식 찾기 /findAll [`GET`]

### &emsp;기부 음식 정보 수정 /modify [`POST`]
- `id`: String
- `foodName`: String
- `foodAmount`: String
- `foodPrice`: String
- `foodImage`: String
- `context`: String
- `cookingTime`: String
- `deadline`: String

### &emsp;기부 음식 정보 삭제 /delete [`POST`]
- `id`: String
- `foodName`: String

### &emsp;해당 ID를 가진 음식점에서 기부하는 음식 정보 얻기 /findById [`POST`]
- `id`: String

### &emsp;기부 음식 이름으로 정보 찾기 /findByFoodName [`POST`]
- `id`: String
- `foodName`: String

### &emsp;기부 음식 이미지 등록 /files [`POST`]
- `file`: MultipartFile
- `nameFile`: String
- `folderName`: String

### &emsp;기부 음식 이미지 수정 /updateImageUrl [`POST`]
- `id`: String
- `foodImage`: String

### &emsp;기부 음식 등록 시간 /minus [`POST`]
- `id`: String
- `foodAmount`: String
- `foodName`: String

## &ensp;음식 요청사항 FoodReq &ensp;/boot/foodReq

### &emsp;음식점에 음식 요청사항 등록 /regist [`POST`]
- `sender`: String
- `senderImage`: String
- `receiver`: String
- `foodName`: String
- `serving`: String
- `foodPrice`: String
- `receiverId`: String
- `senderTel`: String
- `senderId`: String

### &emsp;음식점에 기부를 요청한 ID로 정보 얻기/findById [`POST`]
- `receiverId`: String

### &emsp;음식점에 기부를 요청한 ID와 기부를 원하는 음식 이름으로 음식 요청한 정보 얻기 /findByIdFoodName [`POST`]
- `receiverId`: String
- `foodName`: String

### &emsp;음식점에 기부를 요청한 보육시설 ID와 해당 음식점 ID, 음식점 음식 이름으로 요청한 정보 얻기 /findByIdFoodNameSenderId [`POST`]
- `receiverId`: String
- `foodName`: String
- `senderId`: String

### &emsp;음식점에 기부 요청한 내용 삭제 /delete [`POST`]
- `senderId`: String
- `serving`: String
- `receiver`: String
- `foodName`: String

### &emsp;음식점에 기부를 요청한 보육시설 ID로 요청한 정보 얻기/findBySenderId [`POST`]
- `senderId`: String

### &emsp;음식점에 기부를 요청한 보육시설이 음식 기부 요청 취소하기 /senderDelete [`POST`]
- `receiverId`: String
- `senderId`: String
- `foodName`: String

## &ensp;공지사항 Notice &ensp;/boot/notice

### &emsp;공지사항 등록 /regist [`POST`]
- `id`: Stringn
- `title`: String
- `context`: String
- `noticeIdentify`: boolean

### &emsp;모든 공지사항 얻기 /findAll [`GET`]

### &emsp;공지사항 번호로 공지사항 정보 찾기 /textNumSearch [`POST`]
- `textNum`: String

### &emsp;공지사항 수정 /modify [`POST`]
- `textNum`: String
- `title`: String
- `context`: String

### &emsp;공지사항 삭제 /delete [`POST`]
- `textNum`: String

### &emsp;공지사항 아이디로 번호 찾기 /{id} [`GET`]

## &ensp;공고 Notification &ensp;/boot/notification

### &emsp;공고 등록 /regist [`POST`]
- `title`: String
- `body`: String
- `image`: String
- `reList`: String

### &emsp;모든 공고 얻기 /findAll [`GET`]

## &ensp;리뷰 Review &ensp;/boot/review

### &emsp;리뷰 등록 /regist [`POST`]
- `regionCategory`: String
- `reviewTitle`: String
- `reviewContext`: String
- `donator`: String
- `receiver`: String
- `reviewImage`: String
- `foodName`: String

### &emsp;모든 리뷰 얻기 /findAll [`GET`]

### &emsp;리뷰 수정 /modify [`POST`]
- `receiver`: String
- `donator`: String
- `foodName`: String
- `reviewTitle`: String
- `reviewContext`: String

### &emsp;리뷰 삭제 /delete [`POST`]
- `receiver`: String
- `reviewTitle`: String

### &emsp;리뷰 이미지 업로드 /files [`POST`]
- `file`: MultipartFile
- `nameFile`: String
- `folderName`: String

### &emsp;리뷰 이미지 변경 /updateImageUrl [`POST`]
- `receiver`: String
- `donator`: String
- `foodName`: String
- `reviewImage`: String

### &emsp;리뷰 찾기 (기부한 사람의 아이디로) /findByIdD [`POST`] (donator)
- `donator`: String

### &emsp;리뷰 찾기 (기부받은 사람의 아이디로) /findByIdR [`POST`] (Receiver)
- `receiver`: String

### &emsp;리뷰 찾기 (기부한 사람, 기부 받은 사람, 리뷰 제목) /findByDonatorReciverReviewTitle [`POST`]
- `receiver`: String
- `donator`: String
- `foodName`: String

## 📋 ERD

<img src="https://github.com/aSIX-final-project/Sonagi_App/assets/145747048/3d6d0e71-bec4-4959-88fc-33f59889e3d4">

#### 프론트엔드
<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=javascript&logoColor=white">&nbsp;<img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=CSS&logoColor=white">&nbsp;<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">&nbsp;

#### 백엔드
<img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">&nbsp;<img src="https://img.shields.io/badge/node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white">
<br>

#### API
<img src="https://img.shields.io/badge/kakao-FFCD00?style=for-the-badge&logo=springboot&logoColor=white">&nbsp;
