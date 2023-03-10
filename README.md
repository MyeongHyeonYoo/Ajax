# **Project - REST & Ajax**  ♻️

 ## 💡 `Spring` PROJECT <img src="https://img.shields.io/badge/Spring-5.0.8-darkgreen"> <img src="https://img.shields.io/badge/Java-11-purple"> <img src="https://img.shields.io/badge/JSP-2.1-orange"> <img src="https://img.shields.io/badge/Servlet-2.5-skyblue"> <img src="https://img.shields.io/badge/Tomcat-9.0.70-yellow"> <img src="https://img.shields.io/badge/Oracle-11.2.0.2.0-red">



---

### 🧾 프로젝트 소개 

---

>**ECLIPSE 환경 구축**

> 1. ECLIPSE 설치
> 2. JDK 설치
> 3. Oracle 설치 
> 4. Tomcat 설치

###### Eclipse Marketplace
> 5. Spring Tools 3 Add-On for Spring Tools 4 [3.9.22.RELEASE] 설치
> 6. Eclipse Enterprise Java and Web Developer Tools 3.20 설치
 
---

### Ajax 댓글 처리

#### ◾ **initial source file upload** 
- ###### `/board/list`
database<br>
- CRUD 작업을 테스트하기 전에 tbl_reply 테이블이 tbl_board 테이블과 FK(외래키)의 관계로 처리되어 있다는 점을 알아두기<br>
<img src="img/database_relationship_diagram.jpg" width="274" height="427"><br>
- tbl_reply가 tbl_board 테이블의 bno 값과 정확히 일치해야 하므로 테스트 진행 전 최신 bno 번호 몇 개를 예제로 확인
<img src="img/database_select.jpg" width="450" height="100">
```
SELECT * FROM tbl_board WHERE rownum < 10 ORDER BY bno DESC;
```

#### ◾ **testMapper** 
- src/test/java
    - org.zerock.mapper
        - ReplyMapperTests : testMapper()를 통해서 ReplyMapper 타입의 객체가 정상적으로 사용이 가능한지 확인<br>
<img src="img/JUnit_testMapper.jpg" width="200" height="100">

---

#### CRUD 작업
#### ◾ **등록(create)** 
- TEST(게시물 번호의 일부로 실제 데이터베이스에 있는 번호 확인(PK - FK))<br>
<img src="img/JUnit_testCreate.jpg" width="200" height="100">
- tbl_reply의 상태 확인<br>
<img src="img/database_select_check.jpg" width="400" height="200">

```
SELECT * FROM tbl_reply ORDER BY rno DESC;
```

#### ◾ **조회(read)** 
- TEST(5번 댓글 조회)<br>
<img src="img/console_testRead.jpg" width="500" height="120">
<img src="img/JUnit_testRead.jpg" width="200" height="100">

#### ◾ **삭제(delete)** 
- TEST(1번 삭제)<br>
<img src="img/database_delete_check.jpg" width="400" height="190">
<img src="img/JUnit_testDelete.jpg" width="200" height="100">

#### ◾ **수정(update)** 
- TEST(10번 수정)<br>

<img src="img/database_update_check.jpg" width="400" height="190">
<img src="img/console_testUpdate.jpg" width="500" height="120">
<img src="img/JUnit_testUpdate.jpg" width="200" height="100">

#### ◾ **@Param어노테이션과 댓글 목록** 
- TEST(특정 게시물의 댓글 불러오기)<br>
<img src="img/console_@Param_check.jpg" width="500" height="120">
<img src="img/console_@Param_check2.jpg" width="500" height="120">
<img src="img/JUnit_testList.jpg" width="200" height="100"><br>
▶ XML에서 #{bno}가 @Param("bno")와 매칭되어 사용

#### ◾ **서비스 영역과 Controller 처리** 
스프링 version - 4.3 
```
@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private ReplyMapper mapper;
}
...
```
스프링 version - 4.2 이하
```
@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper mapper;
```
- TEST(등록작업 테스트 : Postman - `POST` TEST)<br>
<img src="img/Postman_replies_new_post_test.jpg" width="600" height="450"><br>
예외발생
```
ERROR: org.zerock.exception.CommonExceptionAdvice - Exception .......Content type 'application/json;charset=UTF-8' not supported
ERROR: org.zerock.exception.CommonExceptionAdvice - {exception=org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/json;charset=UTF-8' not supported}
```
>###### 분명 Content type은 UTF-8로 되어있는 것이 확인이 되고 200으로 POST 방식으로 전송이 성공했는데, 왜 예외발생이 되는지 모르겠다... pass
>###### 데이터베이스에도 물론 등록 실패...
---
