<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Category;
import com.cpf.demo.service.CateGoryService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CateGoryService cateGoryService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Category category){
        cateGoryService.save(category);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Category category){
        cateGoryService.save(category);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Category> page(DTO<Category> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Category category = (Category) JSONObject.toBean(jsonObject, Category.class);
        return cateGoryService.page(category,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        cateGoryService.delete(id);
        return true;
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Category;
import com.cpf.demo.service.CateGoryService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CateGoryService cateGoryService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Category category){
        cateGoryService.save(category);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Category category){
        cateGoryService.save(category);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Category> page(DTO<Category> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Category category = (Category) JSONObject.toBean(jsonObject, Category.class);
        return cateGoryService.page(category,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        cateGoryService.delete(id);
        return true;
    }
}
=======
package com.cpf.demo.web;

import com.cpf.demo.model.Category;
import com.cpf.demo.service.CateGoryService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CateGoryService cateGoryService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Category category){
        cateGoryService.save(category);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Category category){
        cateGoryService.save(category);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Category> page(DTO<Category> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Category category = (Category) JSONObject.toBean(jsonObject, Category.class);
        return cateGoryService.page(category,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        cateGoryService.delete(id);
        return true;
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
