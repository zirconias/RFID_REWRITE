package com.icosnet.dev.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xirconias on 10/05/15.
 */
@RestController
@RequestMapping(value ="/users")
public class MyRestController {

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public String  getUser(@PathVariable Long user){
        return "hello "+user +"\n";
    }
}
