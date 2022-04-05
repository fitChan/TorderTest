### 프로젝트 설명
- 티오더의 (태블릿) 서비스를 구현한 프로잭트입니다.

## 기능
- 로그인 로그아웃
- 메뉴 조회 
- 장바구니 추가
- 장바구니 주문 넣기
- 주문한 모든 내용 조회 
- 결제 명세서 및 결제


## API
| 기능 | 세부정보 | URL |METHOD|  기타|
| ------ | -- | -- |----------- |  ----|
| 회원 | 로그인 | /api/login | POST ||  
|  | 회원가입| /api/signup| POST|  |
| 메뉴 | 메뉴 정보| /api/menu|GET   |  | 
|  장바구니|장바구니 주문 넣기  | /api/order| POST |  
|  |장바구니 주문 내역 확인  | /api/order/{userId}| GET|
|결제 관련| 미결제 현황| /api/order/payment/{userId}|GET
||결제 넣기 | /api/paid|POST|


## 환경
- JDK 1.8.0
- MySql
- Springboot 
- Jquery


## ERD
NOTION 정리
![TorderE-R-D.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f8ec3fde-e497-433a-9f73-5e73b196314c/TorderE-R-D.png)
- https://www.notion.so/E-R-D-422cb60498a748f686f0ccca883024d7



## 실행 예시
NOTION 정리
# 실행 예제

# 1. 로그인 및 회원가입

## 1-1 로그인 제한

![로그인 제한](https://user-images.githubusercontent.com/84306157/161745175-3ec3b8c9-f294-4a1e-a94b-a5f1934ebc79.png)

로그인을 하지 않을시 메뉴를 볼 수 없습니다.

## 1-2 회원가입

로그인 버튼을 누르면 로그인을 할지 회원가입을 할지 선택가능

![Untitled (1)](https://user-images.githubusercontent.com/84306157/161745527-1694cdf3-c536-438b-b63d-54bf2358108b.png)

회원가입시 제한

- 아이디는 2~8자 사이로 입력.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f8591e6e-9e29-481a-a906-b8c972db1fbe/Untitled.png)

- 비밀번호와 비밀번호 확인이 다를 경우 알림

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/58839cf4-4522-45a2-9142-2c2a529356f6/Untitled.png)

- 비밀번호는 영어 또는 숫자로 6~12자 (특수문자 띄어쓰기등 불가능)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b0769dc5-e134-4c33-a8a5-5c20898656ad/Untitled.png)

- 아이디가 중복 될시에 알림

현재 mysql DB안에 “user” 라는 닉네임이 있을시

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6be3aff8-c4d1-4021-ac22-b2d5a937864b/Untitled.png)

## 1-3 로그인

- 로그인을 성공적으로 하면 Sesstion Storage에 해당 유저의 ID(PK)값이 저장됩니다.

이는 로그아웃을 누르면 삭제됩니다.

로그인 후 로그아웃 버튼이 생성된 모습

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/02165965-6373-45ba-837a-ea559eaa938a/Untitled.png)

Sesstion Storage에 해당 유저의 ID(PK)값 저장된 모습

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/12f517be-d9af-400f-90a2-18215a8ca505/Untitled.png)

## 1-4 로그아웃

로그아웃 선택시 바로 로그인 페이지로 넘어가게 되며

Sesstion Storage에 해당 유저의 ID(PK)값이 사라졌음을 확인할 수 있습니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b1286a52-f085-44a9-9566-41dda5a62e88/Untitled.png)

# 2. 메뉴 확인 및 주문

## 2-1 메뉴 확인 및 장바구니

- 메뉴보기 버튼으로 메뉴를 확인할 수 있습니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f613feda-1787-4908-9292-ef3d3f86937f/Untitled.png)

- enum값이 SOLD_OUT인 상품은 장바구니 버튼이 활성화 되어있지 않습니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c8d50abc-2b9c-45bc-a399-06ee0107341f/Untitled.png)

## 2-2 장바구니 취소

- (편의상 id를 노출하였습니다. ) 2번을 삭제하기 버튼을 누른후 주문을 하면

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7d37a423-e47f-4c2e-9aba-52884ad98b44/Untitled.png)

- DB에는 2개의 메뉴(1번과 3번)만 주문이 됩니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fa11debc-65cf-49d9-8f4c-513e7daeba5b/Untitled.png)

## 2-3 주문하기

- 하단 주문하기 버튼을 누르면 LocalStorage에 있는 정보들을 db에 저장합니다.

이후 LocalStorage와 장바구니 내역은 사라집니다.

- 주문하기 버튼 및 장바구니

주문하기 버튼을 누르면 List에 저장되어있던 메뉴들이 LocalStorage로 저장이 되며 이는 서버로 POST요청을 보내게 됩니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f11d97d4-a35e-433e-ad5f-ea8d764b3fc1/Untitled.png)

- 주문하기 버튼 클릭

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8e46a299-94b5-4880-9da9-2e7324fa3d42/Untitled.png)

- Local Storage삭제 및 장바구니 내역 삭제

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0310416f-f817-4184-bd32-aa4fdec26807/Untitled.png)

# 3. 주문 내역 확인 및 결제

- 주문내역 버튼을 통해 지금 까지 주문했던 모든 내역을 확인 할 수 있습니다.

결제 상태인지 아닌지 상관없이 모두 확인이 가능합니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/de541847-286e-49a5-8fe5-2e424f7249e9/Untitled.png)

- 미결제 상품 및 결제 하기 버튼을 통해 미결제 상품들을 볼 수 있으며 즉시 결제가 가능합니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/74f993dd-678c-41d4-ab0f-4e97425bd937/Untitled.png)

- 결제 버튼을 누른 후

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/35f7e379-872e-4340-aa5f-c4e3226d2add/Untitled.png)

- 주문내역의 내용은 결제 완료로 변경 됩니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f4ca82a1-9ced-47a2-a8ce-6dba6d9ed48f/Untitled.png)

- 미결제 상품 및 결제 하기 버튼의 팝업창을 비워지게 되고 DB에 결제 내역이 전송됩니다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a3a0c73b-f5bc-4744-aed3-040512a671f9/Untitled.png)

# 4. 아쉬운 점

1. 장바구니 삭제 시 버튼을 눌렀을 때 내부 List에서는 삭제가 되지만 UI적으로 삭제가 되지않음.

삭제버튼이 그대로 활성화 되어있는데 더 누를시

삭제한 아이템을 다시 장바구니추가 할시에 menuId가 null값이 되어버리는 문제가 있습니다.


- https://www.notion.so/9d983caceb38476ea7612e63f227cca2


## 경로 

java -jar TorderTest-0.0.1-SNAPSHOT

- http://localhost:8080

## 간단한 코드 정리
# 회원가입

Controller

```java
@PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody @Valid SignupRequestDto signupRequestDto, Errors error) {
        boolean isExist = userRepository.existsByUsername(signupRequestDto.getUsername());
        if(isExist || error.hasErrors()){
            return ResponseEntity.badRequest().body(error);
        }else {
            userService.registerUser(signupRequestDto);
            return ResponseEntity.ok().build();
        }
    }
```

Service

```
@Transactional
public void registerUser(SignupRequestDtorequestDto) {
Stringusername =requestDto.getUsername();
Stringpassword =requestDto.getPassword();
StringpasswordChecker =requestDto.getPasswordChecker();

    if (!passwordChecker.equals(password)) {
        throw new IllegalArgumentException("비밀번호 확인 필요");
    } else {
Useruser =User.builder()
                .username(username)
                .password(password)
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }
```

# 로그인

Controller

```
@PostMapping("/login")
publicLonglogin(@RequestBody  @Valid SignupRequestDtorequestDto) {
Useruser = userRepository.findByUsername(requestDto.getUsername());
    if (!requestDto.getPassword().equals(user.getPassword())) {
        throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }
    return user.getId();
}
```

# 메뉴 전체 조회

Controller

```
@GetMapping()
publicResponseEntity<List<MenuRes>> getAllmenu(){
    returnResponseEntity.ok().body(menuService.getAllmenu());
}
```

Service

```
@Transactional
publicList<MenuRes> getAllmenu(){
List<Menu> menuList = menuRepository.findAll();
    returnMenuRes.list(menuList);
}
```

# 주문 DB 저장

Controller

```
@PostMapping("")
publicResponseEntitycreateOrder(@RequestBody @Valid OrderRequestorderRequest,Errorserrors) {
    if(errors.hasErrors()){
        returnResponseEntity.badRequest().body(errors);
    }
    orderService.createOrder(orderRequest);
    returnResponseEntity.created(URI.create("/api/order")).build();
}
```

Service

```
@Transactional
public void createOrder(OrderRequestorderRequest) {

Useruser = userRepository.findById(orderRequest.getUserId()).orElseThrow(
            () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
    );
Menumenu = menuRepository.findById(orderRequest.getMenuId()).orElseThrow(
            () -> new IllegalArgumentException("")
    );

Orderorder =Order.builder()
            .menu(menu)
            .user(user)
            .build();
    orderRepository.save(order);
}
```

# 모든 주문 내역 조회

Controller

```
@GetMapping("/{userId}")
publicResponseEntity<List<OrderRes>> getOrderList(@PathVariable LonguserId){
    returnResponseEntity.ok().body(orderService.getOrderList(userId));
}
```

Service

```
@Transactional
publicList<OrderRes> getOrderList(LonguserId) {
List<Order> orderList = orderRepository.findByUserIdOrderByModifiedAtDesc(userId);
    returnOrderRes.list(orderList);
}
```

# 미결제 내역 조회

Controller

```
@GetMapping("/payment/{userId}")
publicResponseEntity<List<OrderRes>> getOrderNotPaidList(@PathVariable LonguserId){
    returnResponseEntity.ok().body(orderService.getOrderNotPaidList(userId));
}
```

Service

```
@Transactional
publicList<OrderRes> getOrderNotPaidList(LonguserId) {
List<Order> order = orderRepository.findByOrderStatusAndUserIdOrderByModifiedAtDesc(OrderStatus.NOTPAID ,userId);
    returnOrderRes.list(order);
}
```

# 결제 DB저장

Controller

```
@PostMapping
publicResponseEntityupdatePaid(@RequestBody @Valid PaymentRespaymentRes,Errorserrors){
    if(errors.hasErrors()){
        returnResponseEntity.badRequest().body(errors);
    }
    orderService.updatePaid(paymentRes);
    returnResponseEntity.created(URI.create("/api/paid")).build();
}
```

Service

```
@Transactional
public void updatePaid(PaymentRespaymentRes) {
OrderorderId = orderRepository.findByOrderId(paymentRes.getOrderId());

    orderId.updateStatus(OrderStatus.PAID);
Paymentpayment =Payment.builder()
            .order(orderId)
            .build();
    paymentRepository.save(payment);

}
```

# TomCat

```
@Configuration
public classTomcatWebServerCustomizerimplementsWebServerFactoryCustomizer<TomcatServletWebServerFactory> {

// Ajax를 통한  "<>[\\]^`{|}"에 대한 파라미터 전달이 되도록 톰캣 설정
@Override
public void customize(TomcatServletWebServerFactoryfactory) {
factory.addConnectorCustomizers((TomcatConnectorCustomizer)
connector->connector.setAttribute("relaxedQueryChars", "<>[\\]^`{|}"));
    }

}
```

- https://www.notion.so/eeab210c87d2423b8c6d8a1c8d0a5263
