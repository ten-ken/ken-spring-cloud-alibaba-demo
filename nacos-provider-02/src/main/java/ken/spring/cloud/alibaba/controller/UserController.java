package ken.spring.cloud.alibaba.controller;

import ken.spring.cloud.alibaba.po.User;
import ken.spring.cloud.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <ul>
 * <li>Title: UserController</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/25 16:12
 */
@RestController
public class UserController {

     @Autowired
     private UserService userService;

     @GetMapping("user/add")
     public boolean addUser(User user){
         return userService.addUser(user);
     }


    @GetMapping("user/get/{userNo}")
    public User findUserById(@PathVariable("userNo") Long userNo){
        return userService.findUserById(userNo);
    }

    @GetMapping("user/list")
    public List<User> list(){
        return userService.findAll();
    }

}
