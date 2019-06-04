package net.xdclass.test.demo.controller;


import net.xdclass.test.demo.domain.MyException;
import net.xdclass.test.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * 功能描述 异常处理
 */
@RestController
public class ExcptionController {

    /**
     * 功能描述 模拟全局异常
     * @return
     */
    @RequestMapping(value = "/api/v1/test_ext")
    public Object index() {

        // 模拟异常
        int i = 1 / 0;
        return  new User(11,"asdasd","10000000", new Date());
    }

    /**
     * 功能描述 模拟自定义异常
     */
    @RequestMapping(value = "/api/v1/myext")
    public Object myexc(){
        throw new MyException("499","my ext异常");
    }


}
