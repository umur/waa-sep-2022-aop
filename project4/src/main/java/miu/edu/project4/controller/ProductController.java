package miu.edu.project4.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.project4.aspect.annotation.ExecutionTime;
import miu.edu.project4.aspect.annotation.LogMe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {



    @ExecutionTime
    @PostMapping
    public int test (){
        return 1;
    }






//    @ExecutionTime
//
//    @GetMapping
//    public List<Controller> getAll(){
//
//        System.out.println("method");
//        return null;
//    }
//
//
//    public void test (){
//
//
//    }
//
//
//    @LogMe
//    @PostMapping
//    public void save(){
//    }
//
//
//    @LogMe
//    @DeleteMapping
//    public void delete(){
//    }

}
