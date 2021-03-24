<<<<<<< HEAD
package com.cpf.demo.web;


import com.cpf.demo.model.Manager;
import com.cpf.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /*
    * 处理登录请求
    * */
    @PostMapping("login")//代表这个方法处理/manager/login的post请求
    public String managerLogin(@RequestBody Manager manager, HttpSession session,
                               HttpServletResponse response) {
        //将用户名和密码作为条件进行数据查询，如果查到有数据，代表登录成功
        Manager principal = managerService.find(manager);

        if (principal!=null){
            //代表登录成功,将principal存入session中
            session.setAttribute("principal",principal);
            return "success";
        }
        response.setStatus(403);
        return null;
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.web;


import com.cpf.demo.model.Manager;
import com.cpf.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /*
    * 处理登录请求
    * */
    @PostMapping("login")//代表这个方法处理/manager/login的post请求
    public String managerLogin(@RequestBody Manager manager, HttpSession session,
                               HttpServletResponse response) {
        //将用户名和密码作为条件进行数据查询，如果查到有数据，代表登录成功
        Manager principal = managerService.find(manager);

        if (principal!=null){
            //代表登录成功,将principal存入session中
            session.setAttribute("principal",principal);
            return "success";
        }
        response.setStatus(403);
        return null;
    }
}
=======
package com.cpf.demo.web;


import com.cpf.demo.model.Manager;
import com.cpf.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /*
    * 处理登录请求
    * */
    @PostMapping("login")//代表这个方法处理/manager/login的post请求
    public String managerLogin(@RequestBody Manager manager, HttpSession session,
                               HttpServletResponse response) {
        //将用户名和密码作为条件进行数据查询，如果查到有数据，代表登录成功
        Manager principal = managerService.find(manager);

        if (principal!=null){
            //代表登录成功,将principal存入session中
            session.setAttribute("principal",principal);
            return "success";
        }
        response.setStatus(403);
        return null;
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
