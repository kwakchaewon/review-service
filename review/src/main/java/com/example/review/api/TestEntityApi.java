package com.example.review.api;

import com.example.review.model.TestEntity;
import com.example.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class TestEntityApi {
    private final TestService testService;

//    @GetMapping("/test/entity/create")
//    public void createTestEntity(){
//
//    }

//    @PostMapping("/test/entity/create")
//    public void createTestEntity(
//            @RequestBody CreateTestEntityRequest request
//    ){
//        testService.create(request.getName(), request.getAge());
//    }

    @PostMapping("/test/entity")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.create(request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable Long id
    ){
        testService.delete(id);
    }

    @PutMapping("/test/entity/{id}")
    public void updateTestEntity(
            @PathVariable Long id,
            @RequestBody CreateTestEntityRequest request
    ){
        testService.update(id, request.getName(), request.getAge());
    }

    @GetMapping("test/list/jpa")
    public List<TestEntity> getTestEntityLIstByJPA(
            @RequestParam("name") String name
    ){
        return testService.findAllByNameByJPA(name);
    }

    @GetMapping("test/list/dsl")
    public List<TestEntity> getTestEntityLIstByQuerydsl(
            @RequestParam("name") String name
    ){
        return testService.findAllByNameByQuerydsl(name);
    }



    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CreateTestEntityRequest {
        private String name;
        private Integer age;
    }
}
