package net.xdclass.test.demo.controller;

import net.xdclass.test.demo.domain.ServerSettings;
import net.xdclass.test.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>();

    /**
     * 功能描述 测试restful协议，从路径中获取字段
     * 可以试一个参数 也可以试多个参数
     * @param cityId
     * @param userId
     * @return
     */
//    @RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
//    public Object fidnUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId) {
//        params.clear();
//        params.put("cityId", cityId);
//        params.put("userId", userId);
//
//        return params;
//    }

    /**
     * 功能描述 测试GetMapping
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载测试。111。。");
        return params;
    }

    /**
     * 功能描述 默认值，是否必须的参数
     * 分页会使用到
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user2")
    public Object pageUser2(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        return params;
    }

    /**
     * 功能描述 bean对象传参
     * 注意 需要指定http头为  content-type 为 application/json
     * 使用body传输数据
     * 请求体映射实体类
     * @param user
     * @return
     */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user) {
        params.clear();
        params.put("user", user);
        return params;
    }

    /**
     * 功能描述 测试获取http头信息
     * postman 测试的时候需要在 header 里面设置一个access_token 的值
     * 鉴权会使用
     * @param accessToken
     * @param id
     * @return
     */
    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }

    /**
     * request自动注入获取参数
     * @param rqeuest
     * @return
     */
    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest rqeuest){
        params.clear();
        String id = rqeuest.getParameter("id");
        params.put("id",id);
        return params;
    }

    @Autowired
    private ServerSettings serverSettings;
    @GetMapping("/v1/test_properties")
    public Object testPeroperties(){

        return serverSettings;
    }
}
