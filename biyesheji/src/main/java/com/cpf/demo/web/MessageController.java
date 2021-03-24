<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Friend;
import com.cpf.demo.model.Message;
import com.cpf.demo.service.MessageService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/guest")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("save")
    public Boolean save(@RequestBody Message message){
        messageService.save(message);
        return true;
    }

    @GetMapping("page")
    public PageInfo<Message> page(DTO<Message> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Message message = (Message) JSONObject.toBean(jsonObject, Message.class);
        return messageService.page(message,dto.getPageNum(),dto.getPageSize());
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        messageService.delete(id);
        return true;
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Friend;
import com.cpf.demo.model.Message;
import com.cpf.demo.service.MessageService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/guest")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("save")
    public Boolean save(@RequestBody Message message){
        messageService.save(message);
        return true;
    }

    @GetMapping("page")
    public PageInfo<Message> page(DTO<Message> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Message message = (Message) JSONObject.toBean(jsonObject, Message.class);
        return messageService.page(message,dto.getPageNum(),dto.getPageSize());
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        messageService.delete(id);
        return true;
    }
}
=======
package com.cpf.demo.web;

import com.cpf.demo.model.Friend;
import com.cpf.demo.model.Message;
import com.cpf.demo.service.MessageService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/guest")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("save")
    public Boolean save(@RequestBody Message message){
        messageService.save(message);
        return true;
    }

    @GetMapping("page")
    public PageInfo<Message> page(DTO<Message> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Message message = (Message) JSONObject.toBean(jsonObject, Message.class);
        return messageService.page(message,dto.getPageNum(),dto.getPageSize());
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        messageService.delete(id);
        return true;
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
