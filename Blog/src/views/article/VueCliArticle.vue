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
                    <h2 style="color: #00BFFF">Vue CLI是什么？</h2>
                    <p style="float: left;line-height: 40px;">
                        Vue CLI 是一个基于 Vue.js 进行快速开发的完整系统，提供：
                    </p>
                        <ul style="display: inline-block;line-height: 30px;">
                            <li>
                                通过 @vue/cli 实现的交互式的项目脚手架。
                            </li>
                            <li>
                                通过 @vue/cli + @vue/cli-service-global 实现的零配置原型开发。
                            </li>
                            <li>
                                一个运行时依赖 (@vue/cli-service)，该依赖：
                            </li>
                            <li>
                                可升级；
                            </li>
                            <li>
                                基于 webpack 构建，并带有合理的默认配置；
                            </li>
                            <li>
                                可以通过项目内的配置文件进行配置；
                            </li>
                            <li>
                                可以通过插件进行扩展。
                            </li>
                            <li>
                                一个丰富的官方插件集合，集成了前端生态中最好的工具。
                            </li>
                            <li>
                                一套完全图形化的创建和管理 Vue.js 项目的用户界面。
                            </li>
                        </ul>
                    <p style="line-height: 30px">
                        Vue CLI 致力于将 Vue 生态中的工具基础标准化。它确保了各种构建工具
                        能够基于智能的默认配置即可平稳衔接，这样你可以专注在撰写应用上，而
                        不必花好几天去纠结配置的问题。与此同时，它也为每个工具提供了调整配置的灵活性，无需 eject。
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
        name: "VueCliArticle",
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


    li{
        text-align: left;
    }

    .el-menu-item{
        cursor: url("../../assets/cool.png"),auto;
    }
</style>