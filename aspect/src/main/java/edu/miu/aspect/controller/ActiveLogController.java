package edu.miu.aspect.controller;

import edu.miu.aspect.annotation.ExecutionTime;
import edu.miu.aspect.entity.ActiveLog;
import edu.miu.aspect.service.ActiveLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/activelog")
@RestController
public class ActiveLogController {
    @Autowired
    ActiveLogService activeLogService;

    @Autowired
    HttpServletRequest request;

    @ExecutionTime
    @GetMapping
    public List<ActiveLog> findAll(){
        return activeLogService.findAll();
    }

    @PostMapping
    public void sendingHeader(@RequestHeader String myHeader){
        activeLogService.sendingHeader(myHeader);
    }

}
