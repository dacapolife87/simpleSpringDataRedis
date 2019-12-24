package org.hjjang.springredis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hjjang.springredis.domain.PersonProfileVo;
import org.hjjang.springredis.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PersonController {

    private final PersonService personService;

    @RequestMapping(value = "/user/{userName}",method = RequestMethod.GET)
    public @ResponseBody PersonProfileVo getPersonProfiles(@PathVariable(value = "userName") String userName){

        return personService.getPersonData(userName);
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public @ResponseBody String setPersonProfiles(@RequestParam Map<String,Object> params){
        log.info("Insert Profile!");
        String s = personService.setPersonData(params);
        log.info("Done!");
        return s;
    }
}

