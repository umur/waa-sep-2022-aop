package edu.miu.aspect.service;

import edu.miu.aspect.entity.ActiveLog;

import java.util.List;

public interface ActiveLogService {
    List<ActiveLog> findAll();
    void sendingHeader(String myHeader);

}
