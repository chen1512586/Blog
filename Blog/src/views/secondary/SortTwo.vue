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
                        <img src="../../assets/米饭.png" style="height: 40px;width: 40px;position: absolute;left: 70px;top: 8px;">
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

                <el-card class="box">
                    <el-image :src="require('../../assets/4.jpg')" fit="cover" style="height: 248px;width: 289px"></el-image>
                    <el-link href="/GraduationSeason" style="font-size: 20px;">毕业季</el-link>
                    <p>2020年9月14日</p>
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
        name: "SortTwo",
        data() {
            return {}
        },
        methods: {
            login(formName) {
                this.$router.replace('/login')
            },
        }
    }
</script>

<style scoped>
    .el-menu{
        position: relative;
        bottom: 60px;
        box-shadow: 0 4px 12px 0 rgba(0, 0, 0, 0.1)
    }

    .el-main{
        position: absolute;
        top: 45%;
        left: 0;
        width: 100%;
    }
    .el-card{
        width: 290px;
        height: 360px;
        border-radius: 15px;
    }

    .el-card:hover{
        transform:scale(1.1);
    }

    .box{
        margin: 0 auto;
    }

    .el-image{
        left: -20px;
        top: -19px;
    }

    p{
        line-height: 50px;
        color: gray;
        font-size: 16px;
        margin-left: -5px;
    }

    .el-menu-item{
        cursor: url("../../assets/cool.png"),auto;
    }
</style>