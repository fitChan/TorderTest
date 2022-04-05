### 프로잭트 설명
- 티오더의 (태블릿) 서비스를 구현한 프로잭트입니다.

##기능
- 로그인 로그아웃
- 메뉴 조회 
- 장바구니 추가
- 장바구니 주문 넣기
- 주문한 모든 내용 조회 
- 결제 명세서 및 결제


##API
| 기능 | 세부정보 | URL |METHOD|  기타|
| ------ | -- | -- |----------- |  ----|
| 회원 | 로그인 | /api/login | POST ||  
|  | 회원가입| /api/signup| POST|  |
| 메뉴 | 메뉴 정보| /api/menu|GET   |  |
|  |메뉴 세부 정보  |/api/order | GET️  |미구현|  
|  장바구니|장바구니 주문 넣기  | /api/order| POST |  
|  |장바구니 주문 내역 확인  | /api/order/{userId}| GET|
|결제 관련| 미결제 현황| /api/order/payment/{userId}|GET
||결제 넣기 | /api/paid|POST|


## 환경
- JDK 1.8.0
- MySql (개인 DB)
- Springboot 
- Ajax jquery


##ERD
NOTION 정리
- https://www.notion.so/E-R-D-422cb60498a748f686f0ccca883024d7



##실행 예시
NOTION 정리
- https://www.notion.so/9d983caceb38476ea7612e63f227cca2


## 경로 

java -jar TorderTest-0.0.1-SNAPSHOT

http://localhost:8080