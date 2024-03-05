## Spring 이란?

- 서버 성능, 안정성, 보안 등을 고려해 의존성 주입과 관점 지향 프로그래밍 등의 개념을 통해 애플리케이션을 유지보수하기 쉽도록 도와줌.
- 메인 로직에 집중할 수 있도록 제공

<br>

### 엔터프라이즈 애플리케이션

- 대규모의 복잡한 데이터를 관리하는 애플리케이션

<br>

### 프레임워크

- 코드 전체의 생명주기를 관리

<br>

## 스프링부트의 주요 특징

- 톰캣, 제티, 언더토우 같은 웹 애플리케이션 서버(web application server, WAS)가 내장, 설치하지 않아도 독립적으로 실행 가능.
- 빌드 구성을 단순화하는 스프링 부트 스타터를 제공.
- XML 설정을 하지 않고 자바 코드로 모두 작성 가능.
- JAR을 이용해서 자바 옵션만으로도 배포가 가능.
- 애플리케이션의 모니터링 및 관리 도구인 스프링 액츄에이터(spring actuator)를 제공.
- 스프링 부트는 스프링에 속한 도구

---

## 스프링, 스프링 부트 차이점

### 차이점 1. 구성의 차이

스프링 : 애플리케이션 개발에 필요한 환경을 수동으로 구성, 정의 <br>
스프링 부트 : 스프링 코어와 스프링 MVC의 모든 기능을 자동으로 로드, 수동으로 개발 환경을 구성할 필요 없음 

### 차이점 2. 내장 AWS의 유무

- 스프링 애플리케이션 : 톰캣과 같은 WAS에서 배포
    - WAS란 간단히 웹 애플리케이션을 실행하기 위한 장치
- 스프링부트 : 자체 WAS 소유
    - jar 파일만 만들면 별도로 WAS 설정을 하지 않아도 애플리케이션을 실행 가능
    - 스프링 부트의 내장 WAS에는 톰캣, 제티, 언더토우가 있어서 상황에 맞는 WAS 선택도 가능

### Tomcat

Tomcat started on port 8080 (http) with context path '’

- 서버에 접근할 수 있는 상태(문)

크롬에 url 입력하면 서버 연결됨

정적인 html 페이지

`http://localhost:8080/hi.html`

`http://localhost:8080/hi`

Hello! World

`http://localhost:8080/hi?name=eunji`

Hello! eunji

## 어노테이션

[스프링(Spring)에서 자주 사용하는 Annotation 개념 및 예제 정리 - Easy is Perfect](https://melonicedlatte.com/2021/07/18/182600.html)

### Postman

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/e8f11927-b70c-4524-9227-a3efac08e7aa/15b2db92-3303-45b1-b76c-f6a808483f70/Untitled.png)

```sql
{
"value": "name"
}
```

## 실습

```java
package com.estsoft.spring.cotroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.estsoft.spring.domain.Person;

@RestController
public class HiController {
    @GetMapping("/hi")     //HTTP GET Method
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello! %s", name);
    }

    @PostMapping("/hi")
    public String testPost(@RequestBody String value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {  //json -> java object : deSerialize
            Person person = objectMapper.readValue(value, Person.class);
            System.out.println("person = " + person);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("value=" + value);
        return value; //josn
    }
}
```

```java
public class Person {     // { "name": "", "age" : 12}
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

### 서버

자바를 이용해 웹 페이지를 **동적으로** 생산하는 백엔드 웹 애플리케이션 개발 기술을 `**Servlet**`

서블릿 → (서블릿 덩어리)서블릿 컨테이너 → 톰캣~?