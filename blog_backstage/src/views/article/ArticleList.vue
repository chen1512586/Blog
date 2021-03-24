<<<<<<< HEAD
<template>
  <el-card class="main-card">
    <!-- 表格操作 -->
    <div class="operation-container">
      <!-- 条件筛选 -->
      <div style="margin-left:auto">
        <el-input
            prefix-icon="el-icon-search"
            size="small"
            placeholder="请输入文章名"
            style="width:200px"
            v-model="searchForm.articleTitle"
        />
        <el-button
            type="primary"
            size="small"
            icon="el-icon-search"
            style="margin-left:1rem"
            @click="search"
        >
          搜索
        </el-button>
      </div>
    </div>
    <!-- 表格展示 -->
    <el-table border :data="articles">
      <!-- 表格列 -->
      <el-table-column prop="articleTitle" label="标题" align="center" />
      <!-- 文章分类 -->
      <el-table-column prop="categoryId" label="分类" width="120" align="center"/>
      <!-- 文章标签 -->
      <el-table-column prop="tagNames" label="标签" width="180" align="center">
      </el-table-column>
      <!-- 文章发表时间 -->
      <el-table-column prop="createTime" label="发表时间" width="140" align="center"
      >
      </el-table-column>
      <!-- 文章置顶 -->
      <el-table-column prop="isTop" label="置顶" width="100" align="center">
        <template slot-scope="scope">
          <el-switch
              active-color="#13ce66"
              inactive-color="#F4F4F5"
          />
        </template>
      </el-table-column>
      <!-- 列操作 -->
      <el-table-column label="操作" align="center" width="160">
        <template slot-scope="scope">
            <el-button size="mini" type="danger" slot="reference" @click="deleteArticle(scope.row)">
              删除
            </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
        style="text-align: center;padding-top: 25px"
        background
        layout="prev,pager,next"
        :page-size="pageInfo.pageSize"
        :total="pageInfo.total"
        :current-page.sync="pageInfo.pageNum"
        @current-change="handleCurrentPage"
        @size-change="handleSizeChange">
    </el-pagination>
  </el-card>
</template>

<script>
export default {
  name: "ArticleList",
  data() {
    return{
      articles:[],
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 5/*每页展示条目数*/
      },
      searchForm:{
        articleTitle:''
      }
    }
  },
  methods: {
    deleteArticle(row) {
      this.$confirm('确认删除该文章？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/article/delete/'+row.id).then(resp=>{
          if(resp.data){
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            this.page();
          }
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    page(){
      axios.get('/api/article/page', {
        params: {
          condition: {
            articleTitle: this.searchForm.articleTitle
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.articles = resp.data.list;
        this.pageInfo.total = resp.data.total;
      });
    },
    handleCurrentPage(num) {
      this.pageInfo.pageNum = num;
      this.page();
    },
    handleSizeChange(limit) {
      this.pageInfo.pageSize = limit;
      this.page();
    },
    search() {
      this.pageInfo.pageNum = 1;
      this.page();
    },
  },
  created(){
    this.page();
  }
}
</script>

<style scoped>

</style>
=======
<template>
  <el-card class="main-card">
    <!-- 表格操作 -->
    <div class="operation-container">
      <!-- 条件筛选 -->
      <div style="margin-left:auto">
        <el-input
            prefix-icon="el-icon-search"
            size="small"
            placeholder="请输入文章名"
            style="width:200px"
            v-model="searchForm.articleTitle"
        />
        <el-button
            type="primary"
            size="small"
            icon="el-icon-search"
            style="margin-left:1rem"
            @click="search"
        >
          搜索
        </el-button>
      </div>
    </div>
    <!-- 表格展示 -->
    <el-table border :data="articles">
      <!-- 表格列 -->
      <el-table-column prop="articleTitle" label="标题" align="center" />
      <!-- 文章分类 -->
      <el-table-column prop="categoryId" label="分类" width="120" align="center"/>
      <!-- 文章标签 -->
      <el-table-column prop="tagNames" label="标签" width="180" align="center">
      </el-table-column>
      <!-- 文章发表时间 -->
      <el-table-column prop="createTime" label="发表时间" width="140" align="center"
      >
      </el-table-column>
      <!-- 文章置顶 -->
      <el-table-column prop="isTop" label="置顶" width="100" align="center">
        <template slot-scope="scope">
          <el-switch
              active-color="#13ce66"
              inactive-color="#F4F4F5"
          />
        </template>
      </el-table-column>
      <!-- 列操作 -->
      <el-table-column label="操作" align="center" width="160">
        <template slot-scope="scope">
            <el-button size="mini" type="danger" slot="reference" @click="deleteArticle(scope.row)">
              删除
            </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
        style="text-align: center;padding-top: 25px"
        background
        layout="prev,pager,next"
        :page-size="pageInfo.pageSize"
        :total="pageInfo.total"
        :current-page.sync="pageInfo.pageNum"
        @current-change="handleCurrentPage"
        @size-change="handleSizeChange">
    </el-pagination>
  </el-card>
</template>

<script>
export default {
  name: "ArticleList",
  data() {
    return{
      articles:[],
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 5/*每页展示条目数*/
      },
      searchForm:{
        articleTitle:''
      }
    }
  },
  methods: {
    deleteArticle(row) {
      this.$confirm('确认删除该文章？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/article/delete/'+row.id).then(resp=>{
          if(resp.data){
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            this.page();
          }
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    page(){
      axios.get('/api/article/page', {
        params: {
          condition: {
            articleTitle: this.searchForm.articleTitle
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.articles = resp.data.list;
        this.pageInfo.total = resp.data.total;
      });
    },
    handleCurrentPage(num) {
      this.pageInfo.pageNum = num;
      this.page();
    },
    handleSizeChange(limit) {
      this.pageInfo.pageSize = limit;
      this.page();
    },
    search() {
      this.pageInfo.pageNum = 1;
      this.page();
    },
  },
  created(){
    this.page();
  }
}
</script>

<style scoped>

</style>
>>>>>>> 6904d88... first commit
