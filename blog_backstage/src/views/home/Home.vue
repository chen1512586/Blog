<<<<<<< HEAD
<template>
  <div>
    <!-- 统计数据 -->
    <el-row :gutter="30">
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="iconfont el-icon-myfangwenliang" style="color:#40C9C6" />
          </div>
          <div class="card-desc">
            <div class="card-title">访问量</div>
            <div class="card-count">{{ viewsCount }}</div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="el-icon-s-comment" style="color:#36A3F7" />
          </div>
          <div class="card-desc">
            <div class="card-title">留言量</div>
            <div class="card-count">{{ messageCount }}</div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="iconfont el-icon-myuser" style="color:#34BFA3" />
          </div>
          <div class="card-desc">
            <div class="card-title">用户量</div>
            <div class="card-count">{{ userCount }}</div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="iconfont el-icon-mywenzhang-copy" style="color:#F4516C" />
          </div>
          <div class="card-desc">
            <div class="card-title">文章量</div>
            <div class="card-count">{{ articleCount }}</div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="30" style="margin-top:1.25rem">
    <!-- 柱状统计 -->
    <el-col :span="15">
      <el-card>
        <div style="height:350px" id="myChart"></div>
      </el-card>
    </el-col>

    <!-- 饼状图 -->
    <el-col :span="9">
      <el-card>
        <div style="height:350px" id="category"></div>
      </el-card>
    </el-col>

    </el-row>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      viewsCount: 710,
      messageCount: 7,
      userCount: 0,
      articleCount: 5,

    }
  },
  mounted() {
    this.drawLine();
    this.initCharts();
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表
      myChart.setOption({
        title: {},
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross"
          }
        },
        color: ["#58AFFF"],
        grid: {
          left: "0%",
          right: "0%",
          bottom: "0%",
          top: "10%",
          containLabel: true
        },
        xAxis: {
          data: ["Vue是什么？", "Vue CLI是什么？", "毕业季", "恰饭", "龙的叫声"]
        },
        yAxis: {},
        series: [{
          name: '浏览量',
          type: 'bar',
          data: [190,160,140,120,100]
        }]
      });
    },
    initCharts() {
      let myChart = this.$echarts.init(document.getElementById("category"));
      myChart.setOption({
        title: {
          text: '文章类型占比',
          left: 'center',
          top: 30
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: 'vertical',
          bottom: 'bottom',
          data: ['项目介绍','生活随笔']
        },
        series: [
            {
            name: "文章分类",
            type: "pie",
            radius: '45%',
            center: ['50%', '65%'],
            data: [
              {value: 2,name: '项目介绍'},
              {value: 3,name: '生活随笔'}
            ]
        }
          ],
        color: [
          "#7EC0EE",
          "#FF9F7F",
          "#FFD700",
          "#C9C9C9",
          "#E066FF",
          "#C0FF3E"
        ],

      });
    }
  }
}
</script>

<style scoped lang="scss">
  .card-icon-container {
    display: inline-block;
    font-size: 3rem;
  }
  .card-desc {
    font-weight: bold;
    float: right;
  }
  .card-title {
    margin-top: 0.3rem;
    line-height: 18px;
    color: rgba(0, 0, 0, 0.45);
    font-size: 1rem;
  }
  .card-count {
    margin-top: 0.75rem;
    color: #666;
    font-size: 1.25rem;
  }
  .echarts {
    width: 100%;
    height: 100%;
  }
</style>
=======
<template>
  <div>
    <!-- 统计数据 -->
    <el-row :gutter="30">
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="iconfont el-icon-myfangwenliang" style="color:#40C9C6" />
          </div>
          <div class="card-desc">
            <div class="card-title">访问量</div>
            <div class="card-count">{{ viewsCount }}</div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="el-icon-s-comment" style="color:#36A3F7" />
          </div>
          <div class="card-desc">
            <div class="card-title">留言量</div>
            <div class="card-count">{{ messageCount }}</div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="iconfont el-icon-myuser" style="color:#34BFA3" />
          </div>
          <div class="card-desc">
            <div class="card-title">用户量</div>
            <div class="card-count">{{ userCount }}</div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div class="card-icon-container">
            <i class="iconfont el-icon-mywenzhang-copy" style="color:#F4516C" />
          </div>
          <div class="card-desc">
            <div class="card-title">文章量</div>
            <div class="card-count">{{ articleCount }}</div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="30" style="margin-top:1.25rem">
    <!-- 柱状统计 -->
    <el-col :span="15">
      <el-card>
        <div style="height:350px" id="myChart"></div>
      </el-card>
    </el-col>

    <!-- 饼状图 -->
    <el-col :span="9">
      <el-card>
        <div style="height:350px" id="category"></div>
      </el-card>
    </el-col>

    </el-row>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      viewsCount: 710,
      messageCount: 7,
      userCount: 0,
      articleCount: 5,

    }
  },
  mounted() {
    this.drawLine();
    this.initCharts();
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表
      myChart.setOption({
        title: {},
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross"
          }
        },
        color: ["#58AFFF"],
        grid: {
          left: "0%",
          right: "0%",
          bottom: "0%",
          top: "10%",
          containLabel: true
        },
        xAxis: {
          data: ["Vue是什么？", "Vue CLI是什么？", "毕业季", "恰饭", "龙的叫声"]
        },
        yAxis: {},
        series: [{
          name: '浏览量',
          type: 'bar',
          data: [190,160,140,120,100]
        }]
      });
    },
    initCharts() {
      let myChart = this.$echarts.init(document.getElementById("category"));
      myChart.setOption({
        title: {
          text: '文章类型占比',
          left: 'center',
          top: 30
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: 'vertical',
          bottom: 'bottom',
          data: ['项目介绍','生活随笔']
        },
        series: [
            {
            name: "文章分类",
            type: "pie",
            radius: '45%',
            center: ['50%', '65%'],
            data: [
              {value: 2,name: '项目介绍'},
              {value: 3,name: '生活随笔'}
            ]
        }
          ],
        color: [
          "#7EC0EE",
          "#FF9F7F",
          "#FFD700",
          "#C9C9C9",
          "#E066FF",
          "#C0FF3E"
        ],

      });
    }
  }
}
</script>

<style scoped lang="scss">
  .card-icon-container {
    display: inline-block;
    font-size: 3rem;
  }
  .card-desc {
    font-weight: bold;
    float: right;
  }
  .card-title {
    margin-top: 0.3rem;
    line-height: 18px;
    color: rgba(0, 0, 0, 0.45);
    font-size: 1rem;
  }
  .card-count {
    margin-top: 0.75rem;
    color: #666;
    font-size: 1.25rem;
  }
  .echarts {
    width: 100%;
    height: 100%;
  }
</style>
>>>>>>> 6904d88... first commit
