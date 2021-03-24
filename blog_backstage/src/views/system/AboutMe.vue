<<<<<<< HEAD
<template>

    <el-card class="main-card">
      <mavon-editor v-model="aboutContent" style="height:calc(100vh - 215px)" />
      <!--<el-button type="danger" size="medium" class="edit-btn" >
        修改
      </el-button>-->
    </el-card>

</template>

<script>
export default {
  name: "AboutMe",
  data() {
    return{
      aboutContent:'🐲芜湖！起飞！！'
    }
  }
}


</script>

<style scoped lang="scss">
  .edit-btn {
    float: right;
    margin: 1rem 0;
  }
</style>
=======
<template>

    <el-card class="main-card">
      <mavon-editor v-model="aboutContent" style="height:calc(100vh - 215px)" />
      <!--<el-button type="danger" size="medium" class="edit-btn" >
        修改
      </el-button>-->
    </el-card>

</template>

<script>
export default {
  name: "AboutMe",
  data() {
    return{
      aboutContent:'🐲芜湖！起飞！！'
    }
  }
}


</script>

<style scoped lang="scss">
  .edit-btn {
    float: right;
    margin: 1rem 0;
  }
</style>
>>>>>>> 6904d88... first commit
