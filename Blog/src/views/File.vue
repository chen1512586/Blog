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
                <el-collapse v-model="activeNames"  style="width: 50%;margin: 0 auto">
                    <el-collapse-item title="2020年7月">
                        <el-card class="one">
                            <el-link href="/articleOne">恰饭</el-link>
                        </el-card>
                    </el-collapse-item>
                    <el-collapse-item title="2020年8月">
                        <el-card class="two">
                            <el-link href="/articleTwo">龙的叫声是什么？</el-link>
                        </el-card>
                    </el-collapse-item>
                    <el-collapse-item title="2020年9月">
                        <el-card class="three">
                            <el-link href="/VueArticle">Vue</el-link>
                        </el-card>
                        <el-card class="three">
                            <el-link href="/VueCliArticle">Vue CLI</el-link>
                        </el-card>
                        <el-card class="three">
                            <el-link href="/GraduationSeason">毕业季</el-link>
                        </el-card>
                    </el-collapse-item>
                    <el-collapse-item title="2020年10月">
                        <el-card class="four">
                            <el-link href="">别看了，啥都没有</el-link>
                        </el-card>
                    </el-collapse-item>
                </el-collapse>
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
        name: "File",
        data() {
            return {
                activeNames:''
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

    .one{
        background-image: linear-gradient(to right, #ebc0fd 0%, #d9ded8 100%);
    }

    .two{
        background-image: linear-gradient(to right, #ebbba7 0%, #cfc7f8 100%);
    }

    .three{
        background: linear-gradient(to right, #a1c4fd 0%, #c2e9fb 100%);
    }

    .four{
        background: linear-gradient(to right, #f6d365 0%, #fda085 100%);
    }

    .el-menu-item{
        cursor: url("../assets/cool.png"),auto;
    }
</style>