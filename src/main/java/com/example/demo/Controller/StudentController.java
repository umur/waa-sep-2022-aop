package com.example.demo.Controller;

import com.example.demo.Entity.vehicule.SteeringHandle;
import com.example.demo.Entity.vehicule.SteeringWheel;
import com.example.demo.Entity.vehicule.Vehicle;
import com.example.demo.aspects.MyAnnotation;
import com.example.demo.dto.StudentDto;
import com.example.demo.repository.vehiculeRep.SteeringHandleRepository;
import com.example.demo.repository.vehiculeRep.SteeringWheelRepositiry;
import com.example.demo.repository.vehiculeRep.VehiculeRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SteeringWheelRepositiry steeringWheelRepositiry;
    @Autowired
    private SteeringHandleRepository steeringHandleRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;


@MyAnnotation
@PostMapping("/students")
    public ResponseEntity<String> saveStudent (@RequestBody StudentDto studentDto){
    studentService.saveStudent(studentDto);

    // inheritance demo
    Vehicle vehicle =new Vehicle();
    vehicle.setName("mazda");
    vehiculeRepository.save(vehicle);

    SteeringHandle steeringHandle=new SteeringHandle();
    steeringHandle.setHandleProp("handleprop");
    steeringHandle.setName("aaaa");
    steeringHandleRepository.save(steeringHandle);


    SteeringWheel steeringWheel=new SteeringWheel();
    steeringWheel.setWheelProp("wheelprop");
    steeringWheel.setName("bbbb");
    vehiculeRepository.save(steeringWheel);




    // inheritance demo



    return  ResponseEntity.status(HttpStatus.OK).body("save succesfully");


}


}
