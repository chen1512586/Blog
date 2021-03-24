<<<<<<< HEAD
<template>
  <el-card class="main-card">
    <!-- 表格操作 -->
    <div class="operation-container">
      <el-button
          type="success"
          size="small"
          icon="el-icon-plus"
          @click="addCategory"
      >
        新增
      </el-button>
      <div style="margin-left:auto">
        <el-input
            prefix-icon="el-icon-search"
            size="small"
            placeholder="请输入分类名"
            style="width:200px"
            v-model="searchForm.categoryName"
        />
        <el-button
            type="primary"
            size="small"
            icon="el-icon-search"
            style="margin-left:1rem"
            @click="search">
          搜索
        </el-button>
      </div>
    </div>
    <!-- 表格展示 -->
    <el-table border :data="categories">
      <!-- 分类名 -->
      <el-table-column prop="categoryName" label="分类名" align="center" />
      <!-- 分类创建时间 -->
      <el-table-column prop="createTime" label="创建时间" align="center">
        <template slot-scope="scope">
          <i class="el-icon-time" style="margin-right:5px" />
          {{ scope.row.createTime}}
        </template>
      </el-table-column>
      <!-- 列操作 -->
      <el-table-column label="操作" width="160" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="editCategory(scope.row)">
            编辑
          </el-button>
            <el-button size="mini" type="danger" slot="reference" @click="deleteCategory(scope.row)">
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
    <!-- 编辑对话框 -->
    <el-dialog  width="30%" :visible.sync="editVisible">
      <el-form label-width="80px" size="medium" :model="category" ref="categoryForm">
        <el-form-item label="分类名" prop="categoryName">
          <el-input  style="width:220px" v-model="category.categoryName"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker v-model="category.createTime"
                          style="display: block;width: 200px">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitCategory('categoryForm')">提交</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 新增对话框 -->
    <el-dialog  width="30%" :visible.sync="addVisible" title="添加分类">
      <el-form label-width="80px" size="medium" :model="category" ref="categoryForm">
        <el-form-item label="分类名" prop="categoryName">
          <el-input  style="width:220px" v-model="category.categoryName"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker v-model="category.createTime"
                          format="yyyy-MM-dd HH:mm:ss"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          style="display: block;width: 200px">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addSubmit('categoryForm')">提交</el-button>
          <el-button type="danger" @click="clearSubmit('categoryForm')">清空</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </el-card>
</template>

<script>
export default {
name: "SortList",
  data() {
    return {
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 8/*每页展示条目数*/
      },
      category:{
        categoryName:'',
        createTime:''
      },
      categories:[],
      addVisible:false,
      editVisible:false,
      searchForm:{
        categoryName:''
      }
    }
  },
  methods:{
    addCategory(row){
      this.addVisible= true;
      this.category.id = row.id;
      this.category.categoryName = row.categoryName;
      this.category.createTime = row.createTime;
    },
    addSubmit(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/category/save",{
            categoryName:this.category.categoryName,
            createTime:this.category.createTime,
            flag:this.category.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //刷新窗口
              this.clearSubmit(formName);
              //关闭窗口
              this.addVisible = false;
              //刷新表格数据
              this.page();
            }else {
              this.$notify({
                type:"error",
                message:"保存失败"
              });
            }
          });
        }
      })
    },
    editCategory(row){
      this.editVisible = true;
      this.category.id = row.id;
      this.category.categoryName = row.categoryName;
      this.category.createTime = row.createTime;
    },
    submitCategory(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/category/update",{
            id:this.category.id,
            categoryName:this.category.categoryName,
            createTime:this.category.createTime,
            flag:this.category.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //关闭窗口
              this.editVisible = false;
              //刷新表格数据
              this.page();
            }else {
              this.$notify({
                type:"error",
                message:"保存失败"
              });
            }
          });
        }
      })
    },
    deleteCategory(row) {
      this.$confirm('确认删除该分类？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/category/delete/'+row.id).then(resp=>{
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
    clearSubmit(formName){
      this.$refs[formName].resetFields();
    },
    page(){
      axios.get('/api/category/page', {
        params: {
          condition: {
            categoryName: this.searchForm.categoryName
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.categories = resp.data.list;
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
      <el-button
          type="success"
          size="small"
          icon="el-icon-plus"
          @click="addCategory"
      >
        新增
      </el-button>
      <div style="margin-left:auto">
        <el-input
            prefix-icon="el-icon-search"
            size="small"
            placeholder="请输入分类名"
            style="width:200px"
            v-model="searchForm.categoryName"
        />
        <el-button
            type="primary"
            size="small"
            icon="el-icon-search"
            style="margin-left:1rem"
            @click="search">
          搜索
        </el-button>
      </div>
    </div>
    <!-- 表格展示 -->
    <el-table border :data="categories">
      <!-- 分类名 -->
      <el-table-column prop="categoryName" label="分类名" align="center" />
      <!-- 分类创建时间 -->
      <el-table-column prop="createTime" label="创建时间" align="center">
        <template slot-scope="scope">
          <i class="el-icon-time" style="margin-right:5px" />
          {{ scope.row.createTime}}
        </template>
      </el-table-column>
      <!-- 列操作 -->
      <el-table-column label="操作" width="160" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="editCategory(scope.row)">
            编辑
          </el-button>
            <el-button size="mini" type="danger" slot="reference" @click="deleteCategory(scope.row)">
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
    <!-- 编辑对话框 -->
    <el-dialog  width="30%" :visible.sync="editVisible">
      <el-form label-width="80px" size="medium" :model="category" ref="categoryForm">
        <el-form-item label="分类名" prop="categoryName">
          <el-input  style="width:220px" v-model="category.categoryName"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker v-model="category.createTime"
                          style="display: block;width: 200px">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitCategory('categoryForm')">提交</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 新增对话框 -->
    <el-dialog  width="30%" :visible.sync="addVisible" title="添加分类">
      <el-form label-width="80px" size="medium" :model="category" ref="categoryForm">
        <el-form-item label="分类名" prop="categoryName">
          <el-input  style="width:220px" v-model="category.categoryName"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker v-model="category.createTime"
                          format="yyyy-MM-dd HH:mm:ss"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          style="display: block;width: 200px">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addSubmit('categoryForm')">提交</el-button>
          <el-button type="danger" @click="clearSubmit('categoryForm')">清空</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </el-card>
</template>

<script>
export default {
name: "SortList",
  data() {
    return {
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 8/*每页展示条目数*/
      },
      category:{
        categoryName:'',
        createTime:''
      },
      categories:[],
      addVisible:false,
      editVisible:false,
      searchForm:{
        categoryName:''
      }
    }
  },
  methods:{
    addCategory(row){
      this.addVisible= true;
      this.category.id = row.id;
      this.category.categoryName = row.categoryName;
      this.category.createTime = row.createTime;
    },
    addSubmit(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/category/save",{
            categoryName:this.category.categoryName,
            createTime:this.category.createTime,
            flag:this.category.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //刷新窗口
              this.clearSubmit(formName);
              //关闭窗口
              this.addVisible = false;
              //刷新表格数据
              this.page();
            }else {
              this.$notify({
                type:"error",
                message:"保存失败"
              });
            }
          });
        }
      })
    },
    editCategory(row){
      this.editVisible = true;
      this.category.id = row.id;
      this.category.categoryName = row.categoryName;
      this.category.createTime = row.createTime;
    },
    submitCategory(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/category/update",{
            id:this.category.id,
            categoryName:this.category.categoryName,
            createTime:this.category.createTime,
            flag:this.category.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //关闭窗口
              this.editVisible = false;
              //刷新表格数据
              this.page();
            }else {
              this.$notify({
                type:"error",
                message:"保存失败"
              });
            }
          });
        }
      })
    },
    deleteCategory(row) {
      this.$confirm('确认删除该分类？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/category/delete/'+row.id).then(resp=>{
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
    clearSubmit(formName){
      this.$refs[formName].resetFields();
    },
    page(){
      axios.get('/api/category/page', {
        params: {
          condition: {
            categoryName: this.searchForm.categoryName
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.categories = resp.data.list;
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
