<<<<<<< HEAD
import Vue from "vue";
import VueRouter from "vue-router";
import Layout from "../layout/index.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "登录",
    hidden: true,
    component: () => import("../views/login/Login.vue")
  },
  {
    path: "/Home",
    component: Layout,
    children: [
      {
        path: "",
        name: "首页",
        icon: "iconfont el-icon-myshouye",
        component: () => import("../views/home/Home.vue"),
      }
    ]
  },
  {
    path: "/article-submenu",
    name: "文章管理",
    icon: "iconfont el-icon-mywenzhang-copy",
    redirect: "/article",
    component: Layout,
    children: [
      {
        path: "/AddArticle",
        name: "添加文章",
        icon: "iconfont el-icon-myfabiaowenzhang",
        component: () => import("../views/article/AddArticle")

      },
      {
        path: "/ArticleList",
        name: "文章列表",
        icon: "iconfont el-icon-mywenzhangliebiao",
        component: () => import("../views/article/ArticleList.vue")
      },
      {
        path: "/SortList",
        name: "分类列表",
        icon: "iconfont el-icon-myfenlei",
        component: () => import("../views/article/SortList")
      },
      {
        path: "/LabelList",
        name: "标签列表",
        icon: "iconfont el-icon-myicontag",
        component: () => import("../views/article/LabelList")
      }
    ]
  },
  {
    path: "/message-submenu",
    name: "消息管理",
    icon: "iconfont el-icon-myxiaoxi",
    redirect: "/message",
    component: Layout,
    children: [
      {
        path: "/MessageList",
        name: "留言列表",
        icon: "iconfont el-icon-myliuyan",
        component: () => import("../views/message/MessageList")
      }
    ]
  },
  {
    path: "/system-submenu",
    name: "系统管理",
    icon: "iconfont el-icon-myxitong",
    redirect: "/system",
    component: Layout,
    children: [
      {
        path: "/FriendshipChain",
        name: "友链",
        icon: "iconfont el-icon-myfangwenliang",
        component: () => import("../views/system/FriendshipChain"),
      },
      {
        path: "/AboutMe",
        name: "关于我",
        icon: "iconfont el-icon-myguanyuwo",
        component: () => import("../views/system/AboutMe"),
      }
    ]
  },
  {
    path: "/PersonalCenter",
    component: Layout,
    children: [
      {
        path: "",
        name: "个人中心",
        icon: "iconfont el-icon-myuser",
        component: () => import("../views/person/PersonalCenter"),
      }
    ]
  }
];

const router = new VueRouter({
  mode: "history",
  routes
});

export default router;
=======
import Vue from "vue";
import VueRouter from "vue-router";
import Layout from "../layout/index.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "登录",
    hidden: true,
    component: () => import("../views/login/Login.vue")
  },
  {
    path: "/Home",
    component: Layout,
    children: [
      {
        path: "",
        name: "首页",
        icon: "iconfont el-icon-myshouye",
        component: () => import("../views/home/Home.vue"),
      }
    ]
  },
  {
    path: "/article-submenu",
    name: "文章管理",
    icon: "iconfont el-icon-mywenzhang-copy",
    redirect: "/article",
    component: Layout,
    children: [
      {
        path: "/AddArticle",
        name: "添加文章",
        icon: "iconfont el-icon-myfabiaowenzhang",
        component: () => import("../views/article/AddArticle")

      },
      {
        path: "/ArticleList",
        name: "文章列表",
        icon: "iconfont el-icon-mywenzhangliebiao",
        component: () => import("../views/article/ArticleList.vue")
      },
      {
        path: "/SortList",
        name: "分类列表",
        icon: "iconfont el-icon-myfenlei",
        component: () => import("../views/article/SortList")
      },
      {
        path: "/LabelList",
        name: "标签列表",
        icon: "iconfont el-icon-myicontag",
        component: () => import("../views/article/LabelList")
      }
    ]
  },
  {
    path: "/message-submenu",
    name: "消息管理",
    icon: "iconfont el-icon-myxiaoxi",
    redirect: "/message",
    component: Layout,
    children: [
      {
        path: "/MessageList",
        name: "留言列表",
        icon: "iconfont el-icon-myliuyan",
        component: () => import("../views/message/MessageList")
      }
    ]
  },
  {
    path: "/system-submenu",
    name: "系统管理",
    icon: "iconfont el-icon-myxitong",
    redirect: "/system",
    component: Layout,
    children: [
      {
        path: "/FriendshipChain",
        name: "友链",
        icon: "iconfont el-icon-myfangwenliang",
        component: () => import("../views/system/FriendshipChain"),
      },
      {
        path: "/AboutMe",
        name: "关于我",
        icon: "iconfont el-icon-myguanyuwo",
        component: () => import("../views/system/AboutMe"),
      }
    ]
  },
  {
    path: "/PersonalCenter",
    component: Layout,
    children: [
      {
        path: "",
        name: "个人中心",
        icon: "iconfont el-icon-myuser",
        component: () => import("../views/person/PersonalCenter"),
      }
    ]
  }
];

const router = new VueRouter({
  mode: "history",
  routes
});

export default router;
>>>>>>> 6904d88... first commit
