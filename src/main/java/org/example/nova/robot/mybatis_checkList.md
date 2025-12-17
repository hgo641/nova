# 로봇 서비스 MyBatis 체크리스트

## 0. 준비 사항
시작하기전, git checkout -b mybatis-quiz-{본인 팀 번호} 명령어를 사용해 브랜치를 새로 생성해주세요.
* 예시) git checkout -b mybatis-quiz-1

3번까지 전부 끝냈을 경우, 
* git push origin mybatis-quiz-{본인 팀 번호} 

위 명령어를 사용해 코드를 깃허브에 push해주세요.

진행 중 커밋은 자유입니다.

## 1. 엘리베이터 정보 조회 완성

`RobotService`의 getElevators와 createElevator 함수를 완성시키세요.


### 체크리스트 ✅

- [ ] 데이터베이스안에 elevator 테이블을 생성하세요. 
  - 필수적으로 저장할 데이터는 (엘리베이터 아이디, 아파트 아이디, 동, 호) 입니다.
  - 기능 동작여부를 확인하기 위해, 테이블안에 insert 쿼리로 데이터를 추가한 후 테스트해보세요.
- [ ] RobotMapper 자바 인터페이스와 해당 인터페이스와 연동될 xml을 작성하세요.
- [ ] RobotService내부에서 RobotMapper를 사용하게 변경해보세요.


## 2. 엘리베이터 생성 API 추가 
`RobotController`에 엘리베이터 정보를 생성하는 API를 추가해주세요.

### 기능 요구사항

**mybatis를 활용해 개발하세요**

**📌 엘리베이터 정보 생성**
1. apartmentId, dong, hogi가 RequestBody로 주어졌을 때 해당 정보를 elevator테이블안에 저장합니다.
2. 엘리베이터 아이디는, RequestBody로 주어지지 않아도 자동으로 추가합니다.(객체가 생길때마다 아이디를 1씩 늘려 고유한 아이디를 할당합니다.)

## 3. 엘리베이터 정보 삭제 & 엘리베이터 정보 업데이트 API 추가

`RobotController`에 엘리베이터 정보를 삭제하는 함수와 엘리베이터 정보를 업데이트하는 함수를 추가하세요.


### 기능 요구사항

**두 기능 모두, mybatis를 활용해 개발하세요**

**📌 엘리베이터 정보 삭제**
1. apartmentId만 주어지면 해당 아파트에 속한 모든 엘리베이터를 삭제한다.
2. apartmentId, dong이 주어지면 해당 아파트, 동에 속한 모든 엘리베이터를 삭제한다.
3. apartmentId, dong, hogi가 주어지면 해당 아파트, 동, 호기에 속한 모든 엘리베이터를 삭제한다.

**📌 엘리베이터 정보 업데이트**
1. 엘리베이터의 apartmentId, dong, hogi 정보는 전부 변경될 수 있다.
2. 만약 변경하려는 엘리베이터가 데이터베이스에 존재하지 않는다면 에러를 반환한다.

