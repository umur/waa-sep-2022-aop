package edu.miu.aspect.service.impl;

import edu.miu.aspect.entity.ActiveLog;
import edu.miu.aspect.repo.ActiveLogRepo;
import edu.miu.aspect.service.ActiveLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class ActiveLogServiceImpl implements ActiveLogService {

    @Autowired
    ActiveLogRepo activeLogRepo;

    @Override
    public List<ActiveLog> findAll() {
        return activeLogRepo.findAll();
    }

    @Override
    public void sendingHeader(String myHeader) {

    }
}
