package org.hjjang.springredis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hjjang.springredis.domain.PersonProfileVo;
import org.hjjang.springredis.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public PersonProfileVo getPersonData(String userName) {
        Optional<PersonProfileVo> byId = personRepository.findById(userName);
        PersonProfileVo personProfileVo = byId.orElseThrow(() -> new IllegalArgumentException());
        return personProfileVo;
    }

    @Override
    public String setPersonData(Map<String, Object> params) {
        log.info("InsertData!");
        String userName = (String) params.get("name");
        String userPhoneNum = (String) params.get("phone");
        String userEmail = (String) params.get("email");

        PersonProfileVo personProfileVo = new PersonProfileVo();
        personProfileVo.setUserName(userName);
        personProfileVo.setUserPhoneNum(userPhoneNum);
        personProfileVo.setUserEmail(userEmail);
        PersonProfileVo save = personRepository.save(personProfileVo);
        log.info("InsertData Done!");
        return save.getUserName();
    }
}
