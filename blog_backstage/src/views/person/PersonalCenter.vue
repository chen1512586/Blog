<<<<<<< HEAD
<template>
  <el-card class="main-card">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <!-- 修改信息 -->
      <el-tab-pane label="修改信息" name="info">
        <div class="info-container">
          <el-avatar shape="square" :size="125" :src="imgUrl"></el-avatar>
          <el-form label-width="70px" style="width:320px;margin-left:3rem">
            <el-form-item label="昵称" >
              <el-input size="small" v-model="name"/>
            </el-form-item>
            <el-form-item label="个人简介">
              <el-input size="small" v-model="jieshao"/>
            </el-form-item>
            <el-form-item label="个人网站">
              <el-input size="small" v-model="webinfo"/>
            </el-form-item>
          </el-form>
        </div>
      </el-tab-pane>
      <!-- 联系我们 -->
      <el-tab-pane label="联系我" name="contactme">
        <div class="info-container">
          <el-form label-width="70px" style="width:320px;margin-left:3rem"
                   :model="Mail" ref="SendEmail">
            <el-form-item label="您的姓名" prop="subject">
              <el-input size="small"  v-model="Mail.subject" clearable/>
            </el-form-item>
            <el-form-item label="E-mail" prop="receiver">
              <el-input size="small" v-model="Mail.receiver" clearable placeholder="我的邮箱：1729656686@qq.com"/>
            </el-form-item>
            <el-form-item label="邮件内容" prop="text">
              <el-input size="small"  v-model="Mail.text" clearable/>
            </el-form-item>
            <el-button type="primary" size="small" style="margin-left:4.375rem"
                       @click="submit" >
              发送
            </el-button>
            <el-button type="danger" size="small" style="margin-left:8.375rem"
                       @click="resetForm('SendEmail')" >
              重置
            </el-button>
          </el-form>
        </div>
      </el-tab-pane>
    </el-tabs>
  </el-card>
</template>

<script>
export default {
  name: "PersonalCenter",
  data (){
    return{
      activeName: "info",
      Mail: {
        subject: "",
        receiver: "",
        text: "",
      },
      name:'茶泡饭',
      jieshao:'🐲芜湖！起飞！！',
      webinfo:'茶泡饭的个人博客',
      imgUrl:"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2323278491,3146676777&fm=26&gp=0.jpg"
    }
  },
  methods: {
    submit() {
      axios.post("/api/mail/sendMail", this.Mail).then((response) => {
        if (response.data === "success") {
          this.$message({
            showClose:false,
            message:"发送成功",
            type:"success"
          })
        }
        this.resetForm('SendEmail');
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
}
</script>

<style scoped lang="scss">
.avatar {
  width: 120px;
  height: 120px;
  display: block;
}
.info-container {
  display: flex;
  align-items: center;
  margin-left: 20%;
  margin-top: 5rem;
}
</style>
=======
<template>
  <el-card class="main-card">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <!-- 修改信息 -->
      <el-tab-pane label="修改信息" name="info">
        <div class="info-container">
          <el-avatar shape="square" :size="125" :src="imgUrl"></el-avatar>
          <el-form label-width="70px" style="width:320px;margin-left:3rem">
            <el-form-item label="昵称" >
              <el-input size="small" v-model="name"/>
            </el-form-item>
            <el-form-item label="个人简介">
              <el-input size="small" v-model="jieshao"/>
            </el-form-item>
            <el-form-item label="个人网站">
              <el-input size="small" v-model="webinfo"/>
            </el-form-item>
          </el-form>
        </div>
      </el-tab-pane>
      <!-- 联系我们 -->
      <el-tab-pane label="联系我" name="contactme">
        <div class="info-container">
          <el-form label-width="70px" style="width:320px;margin-left:3rem"
                   :model="Mail" ref="SendEmail">
            <el-form-item label="您的姓名" prop="subject">
              <el-input size="small"  v-model="Mail.subject" clearable/>
            </el-form-item>
            <el-form-item label="E-mail" prop="receiver">
              <el-input size="small" v-model="Mail.receiver" clearable placeholder="我的邮箱：1729656686@qq.com"/>
            </el-form-item>
            <el-form-item label="邮件内容" prop="text">
              <el-input size="small"  v-model="Mail.text" clearable/>
            </el-form-item>
            <el-button type="primary" size="small" style="margin-left:4.375rem"
                       @click="submit" >
              发送
            </el-button>
            <el-button type="danger" size="small" style="margin-left:8.375rem"
                       @click="resetForm('SendEmail')" >
              重置
            </el-button>
          </el-form>
        </div>
      </el-tab-pane>
    </el-tabs>
  </el-card>
</template>

<script>
export default {
  name: "PersonalCenter",
  data (){
    return{
      activeName: "info",
      Mail: {
        subject: "",
        receiver: "",
        text: "",
      },
      name:'茶泡饭',
      jieshao:'🐲芜湖！起飞！！',
      webinfo:'茶泡饭的个人博客',
      imgUrl:"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2323278491,3146676777&fm=26&gp=0.jpg"
    }
  },
  methods: {
    submit() {
      axios.post("/api/mail/sendMail", this.Mail).then((response) => {
        if (response.data === "success") {
          this.$message({
            showClose:false,
            message:"发送成功",
            type:"success"
          })
        }
        this.resetForm('SendEmail');
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
}
</script>

<style scoped lang="scss">
.avatar {
  width: 120px;
  height: 120px;
  display: block;
}
.info-container {
  display: flex;
  align-items: center;
  margin-left: 20%;
  margin-top: 5rem;
}
</style>
>>>>>>> 6904d88... first commit
