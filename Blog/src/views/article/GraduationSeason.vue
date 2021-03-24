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
                    <h2 style="color: #00BFFF">毕业季</h2>
                    <p>
                        毕业季马上就要到来了，即使不是处在毕业当中的人，也可以轻易感受到那种氛围，因为许多感觉是会传染的，特别是对于
                        那些还没有毕业的人来说，一看到学长学姐们就要毕业了，就会忍不住幻想以后自己毕业的时候会是什么样子，到底是胸有
                        沉竹地奔向远方，还是灰溜溜地找不到工作。最为焦虑的，恐怕就是那种还不确定的人吧，似乎什么事情都做完了，但是却
                        什么事情都没有一个结果。
                    </p>
                    <p>
                        因为各种各样的原因，这几天不得不写了好几篇毕业感想。其实，自己没有那么多感想的，因为有时候我经常是那种无情无
                        义的人。感觉毕业和放暑假一样，最深切的感觉就是——无处可去，带上一个无望又绝望的苍凉手势。
                    </p>　　
                    <p>
                        回家吧，其实很不想，想要逃离，逃离过于凌厉的现实空气，逃离一群人的琐碎生活。虽然，有时候，我也喜欢人群的，但
                        是喜欢的是陌生的人群，而不是熟悉的人群。去求人收留吧，既没人愿意，自己既不好意思也不习惯。想要去流落街头吧，
                        又怕被热死。
                    </p>　　
                    <p>
                        其实我想去很遥远的暗无天日的地方，然后生命力顽强地自生自灭。可是又不够聪明，许多时候，我希望自己可以聪明一些。
                        不是那种胡思乱想的聪明，是那种会修电灯泡的聪明。有时候觉得自己很独立，但却没有那种会修电灯泡的聪明……哎，其实
                        就是笨啦。
                    </p>　　
                    <p>
                        我想，对许多人来说，毕业，最深切的感受会不会是，来不及？仿佛一切都来不及，还来不及走遍榕城的大街小巷，还来不
                        及谈一场青涩朦胧的校园恋，还来不及做某些年少轻狂的举动，还不及为朋友两肋插刀一场，还来不及成为那个安定的自己，
                        就——毕业了。可是那种来不及似乎也挺理所当然。
                    </p>　　
                    <p>
                        毕业，就是那种既恋恋不舍又迫不及待的告别仪式。那不是我们终将逝去的青春，因为随着岁月的更迭，青春可以不断推迟
                        发生，就算你已经过而立之年，依然可以弹起布满灰尘的吉他神采飞扬地唱一首老男孩。那应该是——我们日渐老去的骄傲。
                    </p>　　
                    <p>
                        毕竟，青春最难得的应该就是，那种不顾一切就骄傲的姿态。
                    </p>

                    <p style="color: darkgray;font-size: 14px;">转载自：随笔网  作者：北城旧事</p>
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
        name: "GraduationSeason",
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