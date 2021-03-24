<template>
  <div class="back_image">
      <el-form v-bind:model="account" :rules="rules" ref="loginForm">
        <h3>登录</h3>
        <el-form-item class="input-box" prop="username">
          <el-input prefix-icon="el-icon-user-solid" placeholder="请输入用户名" v-model="account.username" oninput="if(value.length>8)value=value.slice(0,8)"/>
        </el-form-item>
        <el-form-item class="input-box" prop="password">
          <el-input prefix-icon="el-icon-lock" placeholder="请输入密码" show-password v-model="account.password" oninput="if(value.length>8)value=value.slice(0,8)"/>
        </el-form-item>
        <el-form-item class="button-box">
          <el-button type="primary" plain @click="login('loginForm')">登录</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      account: {
        username: "",
        password: ""
      },
      /*rules声明验证规则*/
      rules: {
        username: [{required: true, message: "用户名不能为空,且长度小于或等于8位", trigger: 'blur'}],
        password: [{required: true, message: "密码不能为空,且密码长度为8位", trigger: 'blur'}]
      }
    }
  },
  methods: {
    login(formName) {
      this.$refs[formName].validate(valid => {
        //如果验证成功，就将account对象发送到后台进行验证，如果验证成功，就跳转到首页
        if (valid) {
          //真验证
          this.$axios.post('/api/manager/login', {
            manAccount: this.account.username,
            manPwd: this.$md5(this.account.password)
          }).then(response => {
            //判断后台返回的数据是否代表成功，如果成功，跳转页面，弹出成功提示
            if (response.data === 'success') {
              this.$message({
                message: "登录成功！",
                type: "success",
                onClose: () => {
                  this.$router.push({path: "/Home"})
                }
              });
            }
          }).catch(error => {
            this.$message({
              message: "用户名密码输入错误",
              type: "error"
            })
          });
        }
      });
    }
  }
}
</script>

<style scoped lang="scss">
    .back_image{
      background: url("http://pic.netbian.com/uploads/allimg/200624/233150-159301271012b5.jpg") no-repeat;
      height: 100%;
      display: flex;
      background-size: cover;
      justify-content: center;
      align-items: center;
    }

    .input-box{
      width: 300px;
      margin: 20px auto;
    }

    h3{text-align: center;color: antiquewhite}

    .button-box{text-align: center}

    .el-button{
      width: 100%;
    }

</style>
