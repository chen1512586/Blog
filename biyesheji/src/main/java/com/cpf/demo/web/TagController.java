<<<<<<< HEAD
package com.cpf.demo.web;


import com.cpf.demo.model.Tag;
import com.cpf.demo.service.TagService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Tag tag){
        tagService.save(tag);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Tag tag){
        tagService.save(tag);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Tag> page(DTO<Tag> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Tag tag = (Tag) JSONObject.toBean(jsonObject, Tag.class);
        return tagService.page(tag,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        tagService.delete(id);
        return true;
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.web;


import com.cpf.demo.model.Tag;
import com.cpf.demo.service.TagService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Tag tag){
        tagService.save(tag);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Tag tag){
        tagService.save(tag);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Tag> page(DTO<Tag> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Tag tag = (Tag) JSONObject.toBean(jsonObject, Tag.class);
        return tagService.page(tag,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        tagService.delete(id);
        return true;
    }
}
=======
package com.cpf.demo.web;


import com.cpf.demo.model.Tag;
import com.cpf.demo.service.TagService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Tag tag){
        tagService.save(tag);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Tag tag){
        tagService.save(tag);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Tag> page(DTO<Tag> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Tag tag = (Tag) JSONObject.toBean(jsonObject, Tag.class);
        return tagService.page(tag,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        tagService.delete(id);
        return true;
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
