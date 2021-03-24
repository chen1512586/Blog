<<<<<<< HEAD
package com.cpf.demo.service;

import com.cpf.demo.dao.ManagerDao;
import com.cpf.demo.model.Manager;
import com.cpf.demo.sys.BaseService;
import org.springframework.stereotype.Service;

@Service  //注解必须加，否则spring无法实现自动装配
public class ManagerService extends BaseService<Manager, ManagerDao> {
    /**
     * 验证用户名是否重复
     * @param account
     * @return
     */
    public Boolean validAccount(String account) {
       Manager conditon = new Manager();
       conditon.setManAccount(account);
       return dao.find(conditon) !=null;
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.service;

import com.cpf.demo.dao.ManagerDao;
import com.cpf.demo.model.Manager;
import com.cpf.demo.sys.BaseService;
import org.springframework.stereotype.Service;

@Service  //注解必须加，否则spring无法实现自动装配
public class ManagerService extends BaseService<Manager, ManagerDao> {
    /**
     * 验证用户名是否重复
     * @param account
     * @return
     */
    public Boolean validAccount(String account) {
       Manager conditon = new Manager();
       conditon.setManAccount(account);
       return dao.find(conditon) !=null;
    }
}
=======
package com.cpf.demo.service;

import com.cpf.demo.dao.ManagerDao;
import com.cpf.demo.model.Manager;
import com.cpf.demo.sys.BaseService;
import org.springframework.stereotype.Service;

@Service  //注解必须加，否则spring无法实现自动装配
public class ManagerService extends BaseService<Manager, ManagerDao> {
    /**
     * 验证用户名是否重复
     * @param account
     * @return
     */
    public Boolean validAccount(String account) {
       Manager conditon = new Manager();
       conditon.setManAccount(account);
       return dao.find(conditon) !=null;
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
