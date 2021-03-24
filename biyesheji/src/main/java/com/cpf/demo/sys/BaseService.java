<<<<<<< HEAD
package com.cpf.demo.sys;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T extends BaseModel,D extends BaseDao<T>> {

    @Autowired
    protected D dao;

    public T find(T condition){
        return dao.find(condition);
    }

    public List<T> findList(T condition){
        return dao.findList(condition);
    }

    public List<T> findAll(T condition){
        return dao.findAll(condition);
    }

    public void delete(int id){
        dao.delete(id);
    }

    public void save(T t){
        if (t.getId()==null){
            dao.insert(t);
        }else {
            dao.update(t);
        }
    }

    /**
     * 根据条件进行分页查询
     * @param condition
     * @return
     */
    public PageInfo<T> page(T condition, Integer pageNum, Integer pageSize){
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->dao.findList(condition));
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.sys;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T extends BaseModel,D extends BaseDao<T>> {

    @Autowired
    protected D dao;

    public T find(T condition){
        return dao.find(condition);
    }

    public List<T> findList(T condition){
        return dao.findList(condition);
    }

    public List<T> findAll(T condition){
        return dao.findAll(condition);
    }

    public void delete(int id){
        dao.delete(id);
    }

    public void save(T t){
        if (t.getId()==null){
            dao.insert(t);
        }else {
            dao.update(t);
        }
    }

    /**
     * 根据条件进行分页查询
     * @param condition
     * @return
     */
    public PageInfo<T> page(T condition, Integer pageNum, Integer pageSize){
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->dao.findList(condition));
    }
}
=======
package com.cpf.demo.sys;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T extends BaseModel,D extends BaseDao<T>> {

    @Autowired
    protected D dao;

    public T find(T condition){
        return dao.find(condition);
    }

    public List<T> findList(T condition){
        return dao.findList(condition);
    }

    public List<T> findAll(T condition){
        return dao.findAll(condition);
    }

    public void delete(int id){
        dao.delete(id);
    }

    public void save(T t){
        if (t.getId()==null){
            dao.insert(t);
        }else {
            dao.update(t);
        }
    }

    /**
     * 根据条件进行分页查询
     * @param condition
     * @return
     */
    public PageInfo<T> page(T condition, Integer pageNum, Integer pageSize){
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->dao.findList(condition));
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
