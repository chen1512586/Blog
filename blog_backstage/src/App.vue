<template>
  <div id="app">
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide (){
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload (){
      this.isRouterAlive = false
      this.$nextTick(function (){
        this.isRouterAlive = true
      })
    }
  }
}

</script>

<style>
#app {
  font-family: "PingFang SC", "Microsoft Yahei", sans-serif;
  box-sizing: border-box;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;

}

html,
body,
#app {
  width: 100%;
  height: 100%;
}

.el-table th.gutter{
  display: table-cell!important;
}
</style>
