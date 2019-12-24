package org.hjjang.springredis.service;

import org.hjjang.springredis.domain.PersonProfileVo;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface PersonService {

    public PersonProfileVo getPersonData(String userName);
    public String setPersonData(Map<String, Object> params);
}
