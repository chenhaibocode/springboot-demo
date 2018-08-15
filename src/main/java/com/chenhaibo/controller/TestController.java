package com.chenhaibo.controller;

import com.chenhaibo.exception.MyException;
import com.chenhaibo.exception.MyExceptionEnums;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 14:39 2018/8/15
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/index",
            method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String index(@RequestParam(value = "id") String id) throws MyException {
        if (StringUtils.isEmpty(id)) {
            throw new MyException(MyExceptionEnums.REQUEST_EMPTY);
        }
        return "success : " + id;
    }
}
