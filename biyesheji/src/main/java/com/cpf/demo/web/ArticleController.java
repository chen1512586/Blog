<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Article;
import com.cpf.demo.model.Friend;
import com.cpf.demo.service.ArticleService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 新增操作
     * */
    @PostMapping("insert")
    public Boolean insert(@RequestBody Article article){
        articleService.save(article);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Article> page(DTO<Article> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Article article = (Article) JSONObject.toBean(jsonObject, Article.class);
        return articleService.page(article,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        articleService.delete(id);
        return true;
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Article;
import com.cpf.demo.model.Friend;
import com.cpf.demo.service.ArticleService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 新增操作
     * */
    @PostMapping("insert")
    public Boolean insert(@RequestBody Article article){
        articleService.save(article);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Article> page(DTO<Article> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Article article = (Article) JSONObject.toBean(jsonObject, Article.class);
        return articleService.page(article,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        articleService.delete(id);
        return true;
    }
}
=======
package com.cpf.demo.web;

import com.cpf.demo.model.Article;
import com.cpf.demo.model.Friend;
import com.cpf.demo.service.ArticleService;
import com.cpf.demo.sys.DTO;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 新增操作
     * */
    @PostMapping("insert")
    public Boolean insert(@RequestBody Article article){
        articleService.save(article);
        return true;
    }

    /**
     * 分页查询数据
     * */
    @GetMapping("page")
    public PageInfo<Article> page(DTO<Article> dto){
        JSONObject jsonObject = JSONObject.fromObject(dto.getCondition());
        Article article = (Article) JSONObject.toBean(jsonObject, Article.class);
        return articleService.page(article,dto.getPageNum(),dto.getPageSize());
    }

    /**
     * 删除操作
     * */
    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id){
        articleService.delete(id);
        return true;
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
