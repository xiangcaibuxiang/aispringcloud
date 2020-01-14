package com.southwind.contoller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }


    @GetMapping(value = "/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping(value = "/findById/{id}")
    public Student findById(@PathVariable("id")long id){
        return restTemplate.getForEntity("http://localhost:8010/student/findById/{id}",Student.class,id).getBody();
    }

    @GetMapping(value = "/findById2/{id}")
    public Student findById2(@PathVariable("id")long id){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Student.class,id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/student/save",student,null).getBody();
    }


    @PostMapping(value = "/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/student/save",student,null);
    }


    @PutMapping(value = "/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/student/update",student);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        restTemplate.delete("http://localhost:8010/student/deleteById/{id}",id);
    }

}
