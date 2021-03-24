<<<<<<< HEAD
<template>
  <div>
    <el-card>
      <div style="float: right;padding-bottom: 20px;">
        <el-input
            prefix-icon="el-icon-search"
            size="small"
            placeholder="请输入留言人姓名"
            style="width:200px"
            v-model="searchForm.author"
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
    <el-table :data="messages"
              border
              highlight-current-row
              >
      <el-table-column prop="id" label="序号" align="center" >
      </el-table-column>
      <el-table-column prop="author" label="留言人" align="center">
      </el-table-column>
      <el-table-column prop="message" label="留言内容" align="center">
      </el-table-column>
      <el-table-column prop="messagetime" label="时间" align="center">
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" @click="deleteMessage(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
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
  </div>
</template>

<script>
export default {
name: "MessageList",
  data() {
    return{
      messages: [],
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 7/*每页展示条目数*/
      },
      searchForm:{
        author:''
      }
    }
  },
  methods: {
    deleteMessage(row) {
      this.$confirm('确认删除该留言？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/guest/delete/'+row.id).then(resp=>{
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
      axios.get('/api/guest/page', {
        params: {
          condition: {
            author: this.searchForm.author
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.messages = resp.data.list;
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

<style scoped lang="scss">


</style>
=======
<template>
  <div>
    <el-card>
      <div style="float: right;padding-bottom: 20px;">
        <el-input
            prefix-icon="el-icon-search"
            size="small"
            placeholder="请输入留言人姓名"
            style="width:200px"
            v-model="searchForm.author"
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
    <el-table :data="messages"
              border
              highlight-current-row
              >
      <el-table-column prop="id" label="序号" align="center" >
      </el-table-column>
      <el-table-column prop="author" label="留言人" align="center">
      </el-table-column>
      <el-table-column prop="message" label="留言内容" align="center">
      </el-table-column>
      <el-table-column prop="messagetime" label="时间" align="center">
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" @click="deleteMessage(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
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
  </div>
</template>

<script>
export default {
name: "MessageList",
  data() {
    return{
      messages: [],
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 7/*每页展示条目数*/
      },
      searchForm:{
        author:''
      }
    }
  },
  methods: {
    deleteMessage(row) {
      this.$confirm('确认删除该留言？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/guest/delete/'+row.id).then(resp=>{
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
      axios.get('/api/guest/page', {
        params: {
          condition: {
            author: this.searchForm.author
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.messages = resp.data.list;
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

<style scoped lang="scss">


</style>
>>>>>>> 6904d88... first commit
