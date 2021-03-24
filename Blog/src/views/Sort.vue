<template>
    <div>
        <el-container>
            <el-header>
                <el-menu :default-active="$route.path"
                         mode="horizontal"
                         text-color="#778899"
                         active-text-color="#1989fa" router
                         :router="true">
                    <el-menu-item>
                        <img src="../assets/米饭.png" style="height: 40px;width: 40px;position: absolute;left: 70px;top: 8px;">
                    </el-menu-item>
                    <el-menu-item style="margin-left: 150px" index="/">首页</el-menu-item>
                    <el-menu-item index="/sort">文章分类</el-menu-item>
                    <el-menu-item index="/label">标签</el-menu-item>
                    <el-menu-item index="/file">文章归档</el-menu-item>
                    <el-menu-item index="/log">日志</el-menu-item>
                    <el-menu-item index="/guestBook">留言板</el-menu-item>
                    <el-menu-item style="margin-left: 300px" @click="login('loginForm')">登录</el-menu-item>
                </el-menu>
            </el-header>
            <vue-particles
                    color="#1989fa"
                    linesColor="#1989fa"
                    :linesWidth="1.5"
                    style="z-index: -1">
            </vue-particles>

            <el-main>
                <el-card class="box-card">
                    <div class="content">
                        <ul class="ulStyle">
                            <li><i class="el-icon-basketball"/>&nbsp;&nbsp;&nbsp;<a href="/SortOne">项目介绍</a></li>
                            <li><i class="el-icon-basketball"/>&nbsp;&nbsp;&nbsp;<a href="/SortTwo">生活随笔</a></li>
                        </ul>

                    </div>
                </el-card>
            </el-main>

            <el-footer>
                <div>
                    <span style="color: #D3D3D3">Powered by <a style="color: #87CEFA">茶泡饭</a></span>
                </div>
                <el-backtop style="background-color: #1989fa">
                    <i class="el-icon-top" style="color: white;position: absolute;left: 9px;"></i>
                </el-backtop>
            </el-footer>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Sort",
        data() {
            return {}
        },
        methods: {
            login (formName) {
                this.$router.replace('/login')
            }
        }
    }
</script>

<style scoped>
    .el-menu{
        position: relative;
        bottom: 60px;
        box-shadow: 0 4px 12px 0 rgba(0, 0, 0, 0.1)
    }

    .box-card {
        width: 480px;
    }

    .el-main{
        position: absolute;
        top: 50%;
        left: 23%;
    }
    .el-card{
        width: 700px;
        height: 200px;
        border-radius: 15px;
    }

    .ulStyle{
        list-style: none;
        line-height: 40px;
    }

    a{
        text-decoration: none;
        color: #606266;
    }

    a:hover{
        background: linear-gradient(to right, #a1c4fd 0%, #c2e9fb 100%);
    }

    .content{
        position: absolute;
        top: 80px;
    }

    .el-menu-item{
        cursor: url("../assets/cool.png"),auto;
    }
</style>
