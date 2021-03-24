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

            <el-main>
                <div class="block" style="width: 50%;position: absolute;left: 25%;">
                    <el-timeline style="text-align: left">
                        <el-timeline-item timestamp="2020/9/1" placement="top" color="#7B68EE">
                            <el-card style="background: linear-gradient(to right, #a1c4fd 0%, #c2e9fb 100%);">
                                <h4>开始前端设计</h4>
                                <p>茶泡饭 提交于 2020/9/1 8：15</p>
                            </el-card>
                        </el-timeline-item>
                        <el-timeline-item timestamp="2020/9/4" placement="top" color="#00BFFF">
                            <el-card style="background: linear-gradient(-90deg, #29bdd9 0%, #276ace 100%);">
                                <h4>制作需求规格说明书</h4>
                                <p>茶泡饭 提交于 2020/9/4 8：15</p>
                            </el-card>
                        </el-timeline-item>
                        <el-timeline-item timestamp="2020/9/5" placement="top" color="#00FFFF">
                            <el-card style="background: linear-gradient(to right, #0cebeb,#20e3b2,#29ffc6);">
                                <h4>开始设计首页</h4>
                                <p>茶泡饭 提交于 2020/9/2 8：15</p>
                            </el-card>
                        </el-timeline-item>
                        <el-timeline-item timestamp="2020/9/9" placement="top" color="#CAFF70">
                            <el-card style="background: linear-gradient(to right,#a8ff78,#78ffd6); ">
                                <h4>首页制作完成</h4>
                                <p>茶泡饭 提交于 2020/9/9 8：15</p>
                            </el-card>
                        </el-timeline-item>
                        <el-timeline-item timestamp="2020/9/10" placement="top" color="#FFC125">
                            <el-card style="background: linear-gradient(to right, #f6d365 0%, #fda085 100%);">
                                <h4>开始设计留言板</h4>
                                <p>茶泡饭 提交于 2020/9/10 8：15</p>
                            </el-card>
                            <el-card style="background: linear-gradient(to right, #f6d365 0%, #fda085 100%);">
                                <h4>留言板数据连接数据库</h4>
                                <p>茶泡饭 提交于 2020/9/10 16：30</p>
                            </el-card>
                            <el-card style="background: linear-gradient(to right, #f6d365 0%, #fda085 100%);">
                                <h4>留言板功能实现</h4>
                                <p>茶泡饭 提交于 2020/9/10 17：15</p>
                            </el-card>
                        </el-timeline-item>
                        <el-timeline-item timestamp="2020/9/11" placement="top" color="#FF6A6A">
                            <el-card style="background: linear-gradient(to right, #ff9569 0%, #e92758 100%);">
                                <h4>开始设计标签</h4>
                                <p>茶泡饭 提交于 2020/9/11 8：15</p>
                            </el-card>
                            <el-card style="background: linear-gradient(to right, #ff9569 0%, #e92758 100%);">
                                <h4>标签设计完成</h4>
                                <p>茶泡饭 提交于 2020/9/11 10：30</p>
                            </el-card>
                            <el-card style="background: linear-gradient(to right, #ff9569 0%, #e92758 100%);">
                                <h4>开始设计日志界面</h4>
                                <p>茶泡饭 提交于 2020/9/11 11：00</p>
                            </el-card>
                        </el-timeline-item>
                    </el-timeline>
                </div>
            </el-main>

            <el-footer>
                <el-backtop style="background-image: linear-gradient(to right, #eea2a2 0%, #bbc1bf 19%, #57c6e1 42%, #b49fda 79%, #7ac5d8 100%);">
                    <i class="el-icon-top" style="color: #F8F8FF;position: absolute;left: 9px;"></i>
                </el-backtop>
            </el-footer>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Log",
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

    .el-card{
        border-radius: 10px;
    }


    h4{
        color: #FFFAFA;
    }
    p{
        font-size: 12px;
        line-height: 30px;
        color: #FFFAFA;
    }

    .el-menu-item{
        cursor: url("../assets/cool.png"),auto;
    }
</style>