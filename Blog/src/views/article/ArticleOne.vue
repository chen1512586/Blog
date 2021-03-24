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

            <el-main>
                <el-card style="width: 60%;margin: 0 auto;min-height: 200px;">
                    <h2 style="color: #00BFFF">恰饭</h2>
                    <div class="text">
                       <p>
                           在中国及世界的大部分国家，吃是一种文化，民以食为天，
                           一般一日三餐，分吃早饭、午饭和晚饭，发展到现在，在许多大中城市，
                           许多人形成了吃夜宵的习惯。 吃饭是人摄入负熵维持耗散体系的主要方式。
                       </p>
                    </div>
                    <div class="endnote">
                       <p style="color: darkgray;font-size: 14px">2020-9-14</p>
                    </div>
                </el-card>
            </el-main>

            <el-footer>
                <div>
                    <span style="color: #D3D3D3">Powered by <a style="color: #87CEFA">茶泡饭</a></span>
                </div>
            </el-footer>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "ArticleOne",
        data() {
            return {

            }
        },
        methods: {
            login (formName) {
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

    .text{
        position: relative;
        top: 30px;
    }
    .endnote{
        position: relative;
        top: 65px;
        text-align: right;
    }
    p{
        line-height: 30px;
    }

    .el-menu-item{
        cursor: url("../../assets/cool.png"),auto;
    }
</style>