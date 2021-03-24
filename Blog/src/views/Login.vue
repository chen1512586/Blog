<template>
    <div id="building">
        <div class="front">
        <h1 style="color: #FFC1C1">茶泡饭</h1>
        <el-form v-bind:model="account" :rules="rules" ref="loginForm">
            <el-form-item class="input-box" prop="username">
                <el-input placeholder="请输入用户名" v-model="account.username" oninput="if(value.length>8)value=value.slice(0,8)"/>
            </el-form-item>
            <el-form-item class="input-box" prop="password">
                <el-input placeholder="请输入密码" show-password v-model="account.password" oninput="if(value.length>8)value=value.slice(0,8)"/>
            </el-form-item>
            <el-form-item class="input-box">
                <el-button style="background-color: #FFC1C1;color: white;border: #FFC1C1" @click="login('loginForm')">登录</el-button>
                <el-button style="background-color: #FFC1C1;color: white;border: #FFC1C1" v-on:click="clear('loginForm')">清空</el-button>
            </el-form-item>
        </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data () {
            return {
                account:{
                    username:"",
                    password:""
                },
                /*rules声明验证规则*/
                rules:{
                    username:[{required:true,message:"用户名不能为空,且长度小于等于8位",trigger:'blur'}],
                    password:[{required:true,message:"密码不能为空,且长度小于等于8位",trigger:'blur'}]
                }
            }
        },
        methods:{
            clear (formName) {
                this.$refs[formName].resetFields();
            },
            login (formName) {
                this.$refs[formName].validate(valid=>{
                    //如果验证成功，就将account对象发送到后台进行验证，如果验证成功，就跳转到首页
                    if (valid) {
                        //真验证
                        this.$axios.post('/api/manager/login',{
                            manAccount:this.account.username,
                            manPwd:this.account.password
                        }).then(response=>{
                            //判断后台返回的数据是否代表成功，如果成功，跳转页面，弹出成功提示
                            if(response.data=='success'){
                                this.$message({
                                    message:"登录成功！",
                                    type:"success",
                                    onClose:()=>{
                                        this.$router.push({path:"/"})
                                    }
                                });
                            }
                        }).catch(error=>{
                            this.$message({
                                message:"用户名密码输入错误",
                                type:"error"
                            })
                        });
                    }
                });

            }
        }
    }
</script>

<style scoped>
    .input-box{
        width: 300px;
        margin: 20px auto;
    }
    #building {
        background: url("http://pic.netbian.com/uploads/allimg/200723/165735-1595494655d735.jpg") center center no-repeat;
        width: 100%;
        height: 100%;
        position: fixed;
        background-size: 100% 100%;
        top: 0;
    }
    .front{
        position: relative;
        margin-top: 8%;
        opacity: 0.6;
    }
    /deep/.el-input__inner {
        background-color: transparent !important;
    }

</style>