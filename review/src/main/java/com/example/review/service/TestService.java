package com.example.review.service;

import com.example.review.model.TestEntity;
import com.example.review.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    // @AllArgsConstructor 로 대신가능함: 클래스내 모든 필드를 초기화하는 생성자를 자동으로 생성
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void create(String name, Integer age){
        TestEntity testEntity = new TestEntity(name, age);
        testRepository.save(testEntity);
    }

    public void delete(Long id){
        testRepository.deleteById(id);

//        TestEntity testEntity = testRepository.findById(id).get();
//        testRepository.delete(testEntity);
    }

    public void update(Long id, String name, Integer age){
        TestEntity testEntity = testRepository.findById(id).orElseThrow();
        testEntity.changeTestEntity(name, age);
        testRepository.save(testEntity);
    }

    public List<TestEntity> findAllByNameByJPA(String name){
        return testRepository.findAllByName(name);
    }

    public List<TestEntity> findAllByNameByQuerydsl(String name){
        return testRepository.findAllByNameByQuerydsl(name);
    }

}
