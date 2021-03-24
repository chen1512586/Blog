<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Friend;
import com.cpf.demo.service.FriendService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Friend friend){
        friendService.save(friend);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Friend friend){
        friendService.save(friend);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Friend> page(DTO<Friend> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Friend friend = (Friend) JSONObject.toBean(jsonObject, Friend.class);
        return friendService.page(friend,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        friendService.delete(id);
        return true;
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Friend;
import com.cpf.demo.service.FriendService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Friend friend){
        friendService.save(friend);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Friend friend){
        friendService.save(friend);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Friend> page(DTO<Friend> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Friend friend = (Friend) JSONObject.toBean(jsonObject, Friend.class);
        return friendService.page(friend,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        friendService.delete(id);
        return true;
    }
}
=======
package com.cpf.demo.web;

import com.cpf.demo.model.Friend;
import com.cpf.demo.service.FriendService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;

    /**
     * 新增操作
     * */
    @PostMapping("save")
    public Boolean save(@RequestBody Friend friend){
        friendService.save(friend);
        return true;
    }
    /**
     * 更新操作
     * */
    @PostMapping("update")
    public Boolean update(@RequestBody Friend friend){
        friendService.save(friend);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Friend> page(DTO<Friend> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Friend friend = (Friend) JSONObject.toBean(jsonObject, Friend.class);
        return friendService.page(friend,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        friendService.delete(id);
        return true;
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
