package com.example.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi
{
    @GetMapping("/hello")
    public String hello(){
        return  "Hello!";
    }
    
    // Request Parameter 방식
    @GetMapping("/hello/param")
    public String helloParam(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ){
        return  "Hello! I am" + name + ", " + age + " years old";
    }

    // Path Variable 방식
    @GetMapping("/hello/pathvariable/{job}")
    public String helloPathVar(
            @PathVariable("job") String job
    ){
        return "Hello! I am " + job;
    }

    //Request Body 방식: POST 방식에서 많이 사용
    @PostMapping("/request/body")
    public String requestBody(
            @RequestBody TestRequestBody request
    ){
        return "Hello, Request Body. I am " + request.name + " " +request.age;
    }

    // TestResponseBody 형태의 json 반환
    @GetMapping("/response/json")
    TestResponseBody responseBody(){
        return new TestResponseBody("chaewon", 28);
    }

    public static class TestResponseBody{
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    public static class TestRequestBody{
        String name;

        Integer age;

        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
