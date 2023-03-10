# **Project - REST & Ajax**  โป๏ธ

 ## ๐ก `Spring` PROJECT <img src="https://img.shields.io/badge/Spring-5.0.8-darkgreen"> <img src="https://img.shields.io/badge/Java-11-purple"> <img src="https://img.shields.io/badge/JSP-2.1-orange"> <img src="https://img.shields.io/badge/Servlet-2.5-skyblue"> <img src="https://img.shields.io/badge/Tomcat-9.0.70-yellow"> <img src="https://img.shields.io/badge/Oracle-11.2.0.2.0-red">



---

### ๐งพ ํ๋ก์ ํธ ์๊ฐ 

---

>**ECLIPSE ํ๊ฒฝ ๊ตฌ์ถ**

> 1. ECLIPSE ์ค์น
> 2. JDK ์ค์น
> 3. Oracle ์ค์น 
> 4. Tomcat ์ค์น

###### Eclipse Marketplace
> 5. Spring Tools 3 Add-On for Spring Tools 4 [3.9.22.RELEASE] ์ค์น
> 6. Eclipse Enterprise Java and Web Developer Tools 3.20 ์ค์น
 
---

### Ajax ๋๊ธ ์ฒ๋ฆฌ

#### โพ **initial source file upload** 
- ###### `/board/list`
database<br>
- CRUD ์์์ ํ์คํธํ๊ธฐ ์ ์ tbl_reply ํ์ด๋ธ์ด tbl_board ํ์ด๋ธ๊ณผ FK(์ธ๋ํค)์ ๊ด๊ณ๋ก ์ฒ๋ฆฌ๋์ด ์๋ค๋ ์ ์ ์์๋๊ธฐ<br>
<img src="img/database_relationship_diagram.jpg" width="274" height="427"><br>
- tbl_reply๊ฐ tbl_board ํ์ด๋ธ์ bno ๊ฐ๊ณผ ์ ํํ ์ผ์นํด์ผ ํ๋ฏ๋ก ํ์คํธ ์งํ ์  ์ต์  bno ๋ฒํธ ๋ช ๊ฐ๋ฅผ ์์ ๋ก ํ์ธ
<img src="img/database_select.jpg" width="450" height="100">
```
SELECT * FROM tbl_board WHERE rownum < 10 ORDER BY bno DESC;
```

#### โพ **testMapper** 
- src/test/java
    - org.zerock.mapper
        - ReplyMapperTests : testMapper()๋ฅผ ํตํด์ ReplyMapper ํ์์ ๊ฐ์ฒด๊ฐ ์ ์์ ์ผ๋ก ์ฌ์ฉ์ด ๊ฐ๋ฅํ์ง ํ์ธ<br>
<img src="img/JUnit_testMapper.jpg" width="200" height="100">

---

#### CRUD ์์
#### โพ **๋ฑ๋ก(create)** 
- TEST(๊ฒ์๋ฌผ ๋ฒํธ์ ์ผ๋ถ๋ก ์ค์  ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ์๋ ๋ฒํธ ํ์ธ(PK - FK))<br>
<img src="img/JUnit_testCreate.jpg" width="200" height="100">
- tbl_reply์ ์ํ ํ์ธ<br>
<img src="img/database_select_check.jpg" width="400" height="200">

```
SELECT * FROM tbl_reply ORDER BY rno DESC;
```

#### โพ **์กฐํ(read)** 
- TEST(5๋ฒ ๋๊ธ ์กฐํ)<br>
<img src="img/console_testRead.jpg" width="500" height="120">
<img src="img/JUnit_testRead.jpg" width="200" height="100">

#### โพ **์ญ์ (delete)** 
- TEST(1๋ฒ ์ญ์ )<br>
<img src="img/database_delete_check.jpg" width="400" height="190">
<img src="img/JUnit_testDelete.jpg" width="200" height="100">

#### โพ **์์ (update)** 
- TEST(10๋ฒ ์์ )<br>

<img src="img/database_update_check.jpg" width="400" height="190">
<img src="img/console_testUpdate.jpg" width="500" height="120">
<img src="img/JUnit_testUpdate.jpg" width="200" height="100">

#### โพ **@Param์ด๋ธํ์ด์๊ณผ ๋๊ธ ๋ชฉ๋ก** 
- TEST(ํน์  ๊ฒ์๋ฌผ์ ๋๊ธ ๋ถ๋ฌ์ค๊ธฐ)<br>
<img src="img/console_@Param_check.jpg" width="500" height="120">
<img src="img/console_@Param_check2.jpg" width="500" height="120">
<img src="img/JUnit_testList.jpg" width="200" height="100"><br>
โถ XML์์ #{bno}๊ฐ @Param("bno")์ ๋งค์นญ๋์ด ์ฌ์ฉ

#### โพ **์๋น์ค ์์ญ๊ณผ Controller ์ฒ๋ฆฌ** 
์คํ๋ง version - 4.3 
```
@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private ReplyMapper mapper;
}
...
```
์คํ๋ง version - 4.2 ์ดํ
```
@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper mapper;
```
- TEST(๋ฑ๋ก์์ ํ์คํธ : Postman - `POST` TEST)<br>
<img src="img/Postman_replies_new_post_test.jpg" width="600" height="450"><br>
์์ธ๋ฐ์
```
ERROR: org.zerock.exception.CommonExceptionAdvice - Exception .......Content type 'application/json;charset=UTF-8' not supported
ERROR: org.zerock.exception.CommonExceptionAdvice - {exception=org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/json;charset=UTF-8' not supported}
```
>###### ๋ถ๋ช Content type์ UTF-8๋ก ๋์ด์๋ ๊ฒ์ด ํ์ธ์ด ๋๊ณ  200์ผ๋ก POST ๋ฐฉ์์ผ๋ก ์ ์ก์ด ์ฑ๊ณตํ๋๋ฐ, ์ ์์ธ๋ฐ์์ด ๋๋์ง ๋ชจ๋ฅด๊ฒ ๋ค... pass
>###### ๋ฐ์ดํฐ๋ฒ ์ด์ค์๋ ๋ฌผ๋ก  ๋ฑ๋ก ์คํจ...
---
