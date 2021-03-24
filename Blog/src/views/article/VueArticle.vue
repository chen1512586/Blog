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
                    <h2 style="color: #00BFFF">Vue是什么？</h2>
                        <p>
                            Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。
                            与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心
                            库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，
                            当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单
                            页应用提供驱动。
                        </p>

                        <p style="color: darkgray;font-size: 14px;text-align: right">2020-9-14</p>
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
        name: "VueArticle",
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

    p{
        line-height: 30px;
        position: relative;
        top: 20px;
    }
    .el-menu-item{
        cursor: url("../../assets/cool.png"),auto;
    }
</style>