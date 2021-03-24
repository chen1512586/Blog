<<<<<<< HEAD
package com.cpf.demo.sys;

import java.util.List;

public interface BaseDao<T extends BaseModel> {

    void insert(T t);

    void update(T t);

    void delete(int id);

    T find(T condition);

    T findById(int id);

    List<T> findList(T condition);

    List<T> findAll(T condition);
}
=======
<<<<<<< HEAD
package com.cpf.demo.sys;

import java.util.List;

public interface BaseDao<T extends BaseModel> {

    void insert(T t);

    void update(T t);

    void delete(int id);

    T find(T condition);

    T findById(int id);

    List<T> findList(T condition);

    List<T> findAll(T condition);
}
=======
package com.cpf.demo.sys;

import java.util.List;

public interface BaseDao<T extends BaseModel> {

    void insert(T t);

    void update(T t);

    void delete(int id);

    T find(T condition);

    T findById(int id);

    List<T> findList(T condition);

    List<T> findAll(T condition);
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
