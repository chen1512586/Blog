import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Index',
    component:()=>import('../views/Index'),
    meta:{
      // 页面标题title
      title: '茶泡饭的个人博客'
    }
  },
    {
      path:'/login',
      name:"Login",
      component:()=>import('../views/Login'),
      meta:{
        // 页面标题title
        title: '登录'
      }
    },
    {
      path:'/sort',
      name:"Sort",
      component:()=>import('../views/Sort'),
      meta:{
        // 页面标题title
        title: '分类'
      }
    },
    {
      path:'/label',
      name:"Label",
      component:()=>import('../views/Label'),
      meta:{
        // 页面标题title
        title: '标签'
      }
    },
    {
      path:'/file',
      name:"File",
      component:()=>import('../views/File'),
      meta:{
        // 页面标题title
        title: '文章归档'
      }
    },
    {
      path:'/log',
      name:"Log",
      component:()=>import('../views/Log'),
      meta:{
        // 页面标题title
        title: '日志'
      }
    },
    {
      path:'/guestBook',
      name:"GuestBook",
      component:()=>import('../views/GuestBook'),
      meta:{
        // 页面标题title
        title: '留言板'
      }
    },
    {
      path:'/articleOne',
      name:"ArticleOne",
      component:()=>import('../views/article/ArticleOne'),
      meta:{
        // 页面标题title
        title: '第一篇文章--吃饭'
      }
    },
    {
      path:'/articleTwo',
      name:"ArticleTwo",
      component:()=>import('../views/article/ArticleTwo'),
      meta:{
        // 页面标题title
        title: '第二篇文章--睡觉'
      }
    },
    {
      path:'/VueArticle',
      name:"VueArticle",
      component:()=>import('../views/article/VueArticle'),
      meta:{
        // 页面标题title
        title: 'Vue是什么？'
      }
    },
    {
      path:'/VueCliArticle',
      name:"VueCliArticle",
      component:()=>import('../views/article/VueCliArticle'),
      meta:{
        // 页面标题title
        title: 'Vue CLI是什么？'
      }
    },
    {
      path:'/GraduationSeason',
      name:"GraduationSeason",
      component:()=>import('../views/article/GraduationSeason'),
      meta:{
        // 页面标题title
        title: '毕业季'
      }
    },
    {
      path:'/SortOne',
      name:"SortOne",
      component:()=>import('../views/secondary/SortOne'),
      meta:{
        // 页面标题title
        title: '文章分类--项目介绍'
      }
    },
    {
      path:'/SortTwo',
      name:"SortTwo",
      component:()=>import('../views/secondary/SortTwo'),
      meta:{
        // 页面标题title
        title: '文章分类--生活随笔'
      }
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
