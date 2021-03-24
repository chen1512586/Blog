<<<<<<< HEAD
<template>
  <div>
    <!-- 导航栏 -->
    <div class="nav-bar">
      <!-- 折叠按钮 -->
      <div class="hambuger-container" @click="trigger">
        <i :class="isFold" />
      </div>
      <!-- 面包屑导航 -->
      <el-breadcrumb>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 右侧菜单 -->
      <div class="right-menu">
        <!-- 全屏按钮 -->
        <div class="screen-full" @click="fullScreen">
          <i class="iconfont el-icon-myicwindowzoom48px" />
        </div>
        <!-- 用户选项 -->
        <el-dropdown>
          <el-avatar :size="40" src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2323278491,3146676777&fm=26&gp=0.jpg"/>
          <i class="el-icon-caret-bottom" />
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="person">
              <i class="el-icon-s-custom" />个人中心
            </el-dropdown-item>
            <el-dropdown-item @click.native="loginout">
              <i class="iconfont el-icon-mytuichu" />退出登录
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data: function() {
    return {
      isSearch: false,
      fullscreen: false,
    };
  },
  methods: {
    trigger() {
      this.$store.commit("trigger");
    },
    fullScreen() {
      let element = document.documentElement;
      if (this.fullscreen) {
        if (document.exitFullscreen) {
          document.exitFullscreen();
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen();
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen();
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen();
        }
      } else {
        if (element.requestFullscreen) {
          element.requestFullscreen();
        } else if (element.webkitRequestFullScreen) {
          element.webkitRequestFullScreen();
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen();
        } else if (element.msRequestFullscreen) {
          element.msRequestFullscreen();
        }
      }
      this.fullscreen = !this.fullscreen;
    },
    person() {
      this.$router.replace({path: '/PersonalCenter'})
    },
    loginout() {
      this.$router.replace({path: '/'})
    }
  },
  computed: {
    isFold() {
      return this.$store.state.collapse ? "el-icon-s-unfold" : "el-icon-s-fold";
    }
  }
};
</script>

<style scoped>
.nav-bar {
  display: flex;
  align-items: center;
  padding-left: 15px;
  padding-right: 30px;
  height: 50px;
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
}
.hambuger-container {
  font-size: 1.25rem;
  cursor: pointer;
  margin-right: 24px;
}
.right-menu {
  margin-left: auto;
  display: flex;
  align-items: center;
}
.el-icon-caret-bottom {
  margin-left: 0.5rem;
  font-size: 0.75rem;
}
.screen-full {
  cursor: pointer;
  margin-right: 1rem;
  font-size: 1.25rem;
}
</style>
=======
<template>
  <div>
    <!-- 导航栏 -->
    <div class="nav-bar">
      <!-- 折叠按钮 -->
      <div class="hambuger-container" @click="trigger">
        <i :class="isFold" />
      </div>
      <!-- 面包屑导航 -->
      <el-breadcrumb>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 右侧菜单 -->
      <div class="right-menu">
        <!-- 全屏按钮 -->
        <div class="screen-full" @click="fullScreen">
          <i class="iconfont el-icon-myicwindowzoom48px" />
        </div>
        <!-- 用户选项 -->
        <el-dropdown>
          <el-avatar :size="40" src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2323278491,3146676777&fm=26&gp=0.jpg"/>
          <i class="el-icon-caret-bottom" />
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="person">
              <i class="el-icon-s-custom" />个人中心
            </el-dropdown-item>
            <el-dropdown-item @click.native="loginout">
              <i class="iconfont el-icon-mytuichu" />退出登录
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data: function() {
    return {
      isSearch: false,
      fullscreen: false,
    };
  },
  methods: {
    trigger() {
      this.$store.commit("trigger");
    },
    fullScreen() {
      let element = document.documentElement;
      if (this.fullscreen) {
        if (document.exitFullscreen) {
          document.exitFullscreen();
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen();
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen();
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen();
        }
      } else {
        if (element.requestFullscreen) {
          element.requestFullscreen();
        } else if (element.webkitRequestFullScreen) {
          element.webkitRequestFullScreen();
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen();
        } else if (element.msRequestFullscreen) {
          element.msRequestFullscreen();
        }
      }
      this.fullscreen = !this.fullscreen;
    },
    person() {
      this.$router.replace({path: '/PersonalCenter'})
    },
    loginout() {
      this.$router.replace({path: '/'})
    }
  },
  computed: {
    isFold() {
      return this.$store.state.collapse ? "el-icon-s-unfold" : "el-icon-s-fold";
    }
  }
};
</script>

<style scoped>
.nav-bar {
  display: flex;
  align-items: center;
  padding-left: 15px;
  padding-right: 30px;
  height: 50px;
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
}
.hambuger-container {
  font-size: 1.25rem;
  cursor: pointer;
  margin-right: 24px;
}
.right-menu {
  margin-left: auto;
  display: flex;
  align-items: center;
}
.el-icon-caret-bottom {
  margin-left: 0.5rem;
  font-size: 0.75rem;
}
.screen-full {
  cursor: pointer;
  margin-right: 1rem;
  font-size: 1.25rem;
}
</style>
>>>>>>> 6904d88... first commit
