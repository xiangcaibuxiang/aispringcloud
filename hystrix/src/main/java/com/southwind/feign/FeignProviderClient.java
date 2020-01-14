package com.southwind.feign;

import com.southwind.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider")
public interface FeignProviderClient {

    @GetMapping(value = "/student/findAll")
    public Collection<Student> findAll();

    @GetMapping(value = "/student/index")
    public String index();



}
