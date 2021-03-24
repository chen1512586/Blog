<template>
    <div style="height: 100%">
        <el-container>
            <el-header>
                <el-menu  :default-active="$route.path"
                         mode="horizontal"
                         text-color="#778899"
                         active-text-color="#1989fa" router
                         :router="true">
                    <el-menu-item>
                        <img src="../assets/logo4.png" style="height: 60px;width: 170px;position: absolute;left: 2px;top: 0px;">
                    </el-menu-item>
                    <el-menu-item style="margin-left: 150px;" index="/">首页</el-menu-item>
                    <el-menu-item index="/sort">文章分类</el-menu-item>
                    <el-menu-item index="/label">标签</el-menu-item>
                    <el-menu-item index="/file">文章归档</el-menu-item>
                    <el-menu-item index="/log">日志</el-menu-item>
                    <el-menu-item index="/guestBook">留言板</el-menu-item>
                    <el-menu-item style="margin-left: 300px" @click="login('loginForm')">登录</el-menu-item>
                </el-menu>
            </el-header>
            <el-main style="padding: 17px"><!--style="height:0;flex-grow:1;"-->

                <div class="main" ><!--style="overflow-y:auto;height:100%;"-->
                    <vue-particles
                            color="#1989fa"
                            linesColor="#1989fa"
                            :linesWidth="1.5">
                    </vue-particles>
                    <div style="position: absolute;top: 110px;">
                <el-row>
                    <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                        <el-card :body-style="{ padding: '50px',height:'150px'}" shadow="hover">
                            <el-image :src="require('../assets/2.jpg')" fit="cover"></el-image>
                            <div style="padding: 14px;position: absolute;top: 5px;right: 30%;color: #1989fa;width: 33%">
                                <el-link type="primary" style="font-size: 20px;left: -180px;" href="/VueArticle">Vue是什么?</el-link>
                                <b style="color: #BEBEBE;font-size: small;position: absolute;top: 59px;left: 0px"><i class="el-icon-date"></i>2020-09-07</b>
                                <b style="color: #FFB90F;font-size: small;position: absolute;top: 56px;left: 110px"><i class="el-icon-collection-tag" style="color: #FFB90F"></i>置顶</b>
                                <b style="color: #42b983;font-size: small;position: absolute;top: 57px;left: 185px"><i class="el-icon-link" style="color: #42b983"></i>vue</b>
                                <p v-for="one in ones" style="color: #87CEFA;position: absolute;top: 90px;left: -14px;">{{one.message}}</p>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>

                <el-row style="margin-top: 50px">
                    <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                        <el-card :body-style="{ padding: '50px',height:'150px' }" shadow="hover">
                            <el-image :src="require('../assets/3.jpg')" fit="cover"></el-image>
                            <div style="padding: 14px;position: absolute;top: 5px;right: 58%;color: #1989fa">
                                <el-link type="primary" style="font-size: 20px;left: -10px;" href="/VueCliArticle">Vue CLI</el-link>
                                <b style="color: #BEBEBE;font-size: small;position: absolute;top: 59px;left: 7px"><i class="el-icon-date"></i>2020-09-07</b>
                                <b style="color: #FF6A6A;font-size: small;position: absolute;top: 56px;left: 110px;width: 65px"><i class="el-icon-loading" style="color: #FF6A6A"></i>项目介绍</b>
                                <b style="color: #42b983;font-size: small;position: absolute;top: 57px;left: 200px;width: 55px"><i class="el-icon-link" style="color: #42b983"></i>vue cli</b>
                                <p v-for="two in second" style="color: #87CEFA;position: absolute;top: 90px;left: -5px;width: 469px">{{two.message}}</p>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>

                <el-row style="margin-top: 50px">
                    <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                        <el-card :body-style="{ padding: '50px',height:'150px' }" shadow="hover">
                            <el-image :src="require('../assets/4.jpg')" fit="cover" style="height: 248px;"></el-image>
                            <div style="padding: 14px;position: absolute;top: 5px;right: 58%;color: #1989fa">
                                <el-link type="primary" style="font-size: 20px;left: -22px;" href="/GraduationSeason">毕业季</el-link>
                                <b style="color: #BEBEBE;font-size: small;position: absolute;top: 59px;left: -5px"><i class="el-icon-date"></i>2020-09-07</b>
                                <b style="color: #8470FF;font-size: small;position: absolute;top: 56px;left: 100px;width: 65px"><i class="el-icon-loading" style="color: #8470FF"></i>生活随笔</b>
                                <b style="color: #FFC1C1;font-size: small;position: absolute;top: 56px;left: 191px;width: 65px"><i class="el-icon-link" style="color: #FFC1C1"></i>校园生活</b>
                                <p v-for="three in third" style="color: #87CEFA;position: absolute;top: 90px;left: -14px;width: 464px">{{three.message}}</p>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>

                <el-row class="right">
                    <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                        <el-card :body-style="{ padding: '50px',height: '150px'}" shadow="hover" class="person">
                            <div style="padding: 14px;text-align: center">
                                <div class="avatar">
                                    <el-avatar :size="50" src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2323278491,3146676777&fm=26&gp=0.jpg"></el-avatar>
                                </div>
                                <div class="names">
                                    <el-link :underline="false" style="font-size: 20px">茶泡饭</el-link>
                                </div>
                                <div class="autograph">
                                    <p>以梦为马，不负韶华</p>
                                </div>
                                <div class="BlogWrap">
                                    <div class="BlogInfoLeft">
                                        <el-link target="_blank" :underline="false">文章</el-link><br>
                                        <a style="color: gray">3</a>
                                    </div>
                                    <div class="BlogInfoMiddle">
                                        <el-link href="/sort" target="_blank" :underline="false">分类</el-link><br>
                                        <a style="color: gray">2</a>
                                    </div>
                                    <div class="BlogInfoRight">
                                        <el-link href="/label" target="_blank" :underline="false">标签</el-link><br>
                                        <a style="color: gray">3</a>
                                    </div>
                                </div>
                                <div class="link">
                                   <a href="#" @click="one">加入书签</a>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>

                <el-row class="rights">
                    <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                        <el-card :body-style="{ padding: '50px',height: '50px'}" shadow="hover" >
                            <div style="padding: 14px;text-align: center">
                                <el-link type="primary" style="font-size: 20px;position: absolute;left: 3%;top: 4%;">标签</el-link>
                                <div class="tag" style="position: absolute;top: 30%;left: 2%;width: 66%;line-height: 45px;">
                                <el-tag :key="tag"
                                        v-for="tag in dynamicTags"
                                        closable
                                        :disable-transitions="false"
                                        @close="handleClose(tag)">
                                    {{tag}}
                                </el-tag>
                                <el-input
                                        class="input-new-tag"
                                        v-if="inputVisible"
                                        v-model="inputValue"
                                        ref="saveTagInput"
                                        size="small"
                                        @keyup.enter.native="handleInputConfirm"
                                        @blur="handleInputConfirm"
                                >
                                </el-input>
                                <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
                                </div>
                                </div>
                        </el-card>
                    </el-col>
                </el-row>

                    <el-row class="call">
                        <el-col :span="8" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
                            <el-card :body-style="{ padding: '50px',height: '30px'}" shadow="hover" >
                                <div style="padding: 14px;text-align: center">
                                    <b style="font-size: 20px;position: absolute;left: 3%;top: 4%;color: #1989fa"><i class="el-icon-message-solid" style="color: red"></i>公告</b>
                                    <el-link type="danger" style="font-size: 18px">开发中···</el-link>
                                </div>
                            </el-card>
                        </el-col>
                    </el-row>
                    </div>
                </div>
            </el-main>

            <el-footer style="height: 35px">
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
        name: "Index",
        data() {
            return {
                ones: [
                    {
                        message: 'Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。' +
                            '与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。' +
                            'Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。' +
                            '另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。'
                    }
                ],
                second: [
                    {
                        message: '通过 @vue/cli 实现的交互式的项目脚手架。通过 @vue/cli + @vue/cli-service-global ' +
                            '实现的零配置原型开发。 一个运行时依赖 (@vue/cli-service)，该依赖：可升级； 基于 webpack ' +
                            '构建，并带有合理的默认配置；可以通过项目内的配置文件进行配置；可以通过插件进行扩展。' +
                            '一个丰富的官方插件集合，集成了前端生态中最好的工具。一套完全图形化的创建和管理 Vue.js 项目的用户界面。'
                    }
                ],
                third: [
                    {
                        message: '毕业季马上就要到来了，即使不是处在毕业当中的人，也可以轻易感受到那种氛围，因为许多感觉是会传染的，' +
                            '特别是对于那些还没有毕业的人来说，一看到学长学姐们就要毕业了，就会忍不住幻想以后自己毕业的时候会是什么样子，' +
                            '到底是胸有成竹地奔向远方，还是灰溜溜地找不到工作。最为焦虑的，恐怕就是那种还不确定的人吧，似乎什么事情都做完了，' +
                            '但是却什么事情都没有一个结果。'
                    }
                ],
                dynamicTags: ['Vue', 'Vue cli', '校园生活'],
                inputVisible: false,
                inputValue: '',

            }
        },
        methods: {
            login(formName) {
                this.$router.replace('/login')
            },
            handleClose(tag) {
                this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
            },

            showInput() {
                this.inputVisible = true;
                this.$nextTick(_ => {
                    this.$refs.saveTagInput.$refs.input.focus();
                });
            },

            handleInputConfirm() {
                let inputValue = this.inputValue;
                if (inputValue) {
                    this.dynamicTags.push(inputValue);
                }
                this.inputVisible = false;
                this.inputValue = '';
            },
            one() {
                this.$message({
                    message: '请按Ctrl+D添加本页到书签',
                    type: 'warning'
                });
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
    .image {
        width: 100%;
        display: block;
    }
    .el-col-8 {
        width: 70%;
    }
.right{
    width: 330px;
    position: absolute;
    top: 0px;
    right: -50px;
}
    .rights{
        width: 330px;
        position: absolute;
        top: 302px;
        right: -50px;
    }
    .call{
        width: 330px;
        position: absolute;
        top: 515px;
        right: -48px;
    }
    .el-image {
        position: relative;
        display: inline-block;
        overflow: hidden;
        left: -241px;
        top: -49px;
        width: 55%;
    }
    .el-image:hover{
        transition: all 1s;
        transform: scale(1.1);
    }
    .el-footer{
        position: relative;
        top: 175px;
    }

    .el-tag + .el-tag {
        margin-left: 10px;

    }
    .button-new-tag {
        margin-left: 10px;
        height: 32px;
        line-height: 30px;
        padding-top: 0;
        padding-bottom: 0;
    }
    .input-new-tag {
        width: 90px;
        margin-left: 10px;
        vertical-align: bottom;
    }

    .avatar{
        width: 15%;
        position: absolute;
        top: 20px;
        left: 90px;
    }

    .names{
        position: absolute;
        left: 85px;
        top: 80px;
    }
    .autograph{
        position: absolute;
        top: 120px;
        left: 45px;
    }

    .BlogWrap{
        position: absolute;
        top: 155px;
        width: 70%;
        left: 3px;
    }

    .BlogInfoLeft{
        position: absolute;
        left: 25px;
    }

    .BlogInfoMiddle{
        position: absolute;
        left: 98px;
    }

    .BlogInfoRight{
        position: absolute;
        left: 165px;
        width: 16%;
    }

    .link{
        background-color: #1989fa;
        width: 125px;
        height: 23px;
        position: absolute;
        left: 32%;
        top: 103%;
        margin: -50px 0 0 -50px;
        transition: .3s;
    }

    /*.link:after{
        content: '';
        position: absolute;
        left: 0;
        top: 0;
        bottom: 0;
        right: 0;
        transition: .3s;
        opacity: .3;
        background: white;
        transform-origin: left;
        transform: scaleX(0);
    }
    .link:hover::after {
        transform: scaleX(1);
    }*/
    .link a{
        color: white;
        text-decoration: none;
    }

.el-card{
    border-radius: 15px;
}

    .el-menu-item{
        cursor: url("../assets/cool.png"),auto;
    }

</style>