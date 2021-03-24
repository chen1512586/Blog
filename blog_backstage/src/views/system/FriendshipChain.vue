<<<<<<< HEAD
<template>
  <div>
    <el-card class="main-card">
      <!-- 表格操作 -->
      <div class="operation-container">
        <el-button
            type="success"
            size="small"
            icon="el-icon-plus"
            @click="addFriend"
            >新增</el-button>
        <!-- 条件筛选 -->
        <div style="margin-left:auto">
          <el-input
              prefix-icon="el-icon-search"
              size="small"
              placeholder="请输入友链名"
              style="width:200px"
              v-model="searchForm.linkName"/>
          <el-button
              type="primary"
              size="small"
              icon="el-icon-search"
              style="margin-left:1rem"
              @click="search">搜索
          </el-button>
        </div>
      </div>
      <!-- 表格展示 -->
      <el-table border :data="friends">
        <!-- 表格列 -->
        <el-table-column prop="linkAvatar" label="链接头像" align="center" width="180">
          <template slot-scope="scope">
            <el-avatar :size="45" :src="imageUrl"></el-avatar>
          </template>
        </el-table-column>
        <el-table-column prop="linkName" label="链接名" align="center" />
        <el-table-column prop="linkAddress" label="链接地址" align="center" />
        <el-table-column prop="linkIntro" label="链接介绍" align="center" />
        <el-table-column prop="createTime" label="创建时间" width="140" align="center">
          <template slot-scope="scope">
            <i class="el-icon-time" style="margin-right:5px" />
            {{ scope.row.createTime}}
          </template>
        </el-table-column>
        <!-- 列操作 -->
        <el-table-column label="操作" align="center" width="160">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" @click="editFriend(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" slot="reference" @click="deleteFriend(scope.row)">删除</el-button>
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
      <!-- 修改 -->
      <el-dialog title="修改友链" :visible.sync="editVisible">
        <el-form :model="friend" ref="friendForm" label-width="100px" size="mini">
          <el-form-item label="链接名" prop="linkName">
            <el-input v-model="friend.linkName"/>
          </el-form-item>
          <el-form-item label="链接头像" prop="linkAvatar">
            <el-upload
                class="avatar-uploader"
                action="https://jsonplaceholder.typicode.com/posts/"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                v-model="friend.linkAvatar">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="链接地址" prop="linkAddress">
            <el-input v-model="friend.linkAddress"/>
          </el-form-item>
          <el-form-item label="链接介绍" prop="linkIntro">
            <el-input v-model="friend.linkIntro"/>
          </el-form-item>
          <el-form-item label="创建时间" prop="createTime">
            <el-date-picker v-model="friend.createTime"
                            style="display: block;width: 200px">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitFriend('friendForm')">提交</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <!-- 新增 -->
      <el-dialog title="新增友链" :visible.sync="addVisible">
        <el-form :model="friend" ref="friendForm" label-width="100px" size="mini">
          <el-form-item label="链接名" prop="linkName">
            <el-input v-model="friend.linkName"/>
          </el-form-item>
          <el-form-item label="链接头像" prop="linkAvatar">
            <el-upload
                class="avatar-uploader"
                action="https://jsonplaceholder.typicode.com/posts/"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                v-model="friend.linkAvatar">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="链接地址" prop="linkAddress">
            <el-input v-model="friend.linkAddress"/>
          </el-form-item>
          <el-form-item label="链接介绍" prop="linkIntro">
            <el-input v-model="friend.linkIntro"/>
          </el-form-item>
          <el-form-item label="创建时间" prop="createTime">
            <el-date-picker v-model="friend.createTime"
                            style="display: block;width: 200px">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addSubmit('friendForm')">提交</el-button>
            <el-button type="danger" @click="clearSubmit('friendForm')">清空</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
name: "FriendshipChain",
  data () {
    return {
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 8/*每页展示条目数*/
      },
      friends:[],
      editVisible:false,
      addVisible:false,
      friend: {
        linkName:'',
        linkAvatar:'',
        linkAddress:'',
        linkIntro:'',
        createTime:''
      },
      imageUrl: '',
      searchForm:{
        linkName:''
      }
    }
  },
  methods: {
    page(){
      axios.get('/api/friend/page', {
        params: {
          condition: {
            linkName: this.searchForm.linkName
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.friends = resp.data.list;
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
    deleteFriend(row) {
      this.$confirm('确认删除该友链？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/friend/delete/'+row.id).then(resp=>{
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
    editFriend(row) {
      this.editVisible = true;
      this.friend.id = row.id;
      this.friend.linkName = row.linkName;
      this.friend.linkAvatar = row.linkAvatar;
      this.friend.linkAddress = row.linkAddress;
      this.friend.linkIntro = row.linkIntro;
      this.friend.createTime = row.createTime;
    },
    addFriend(row) {
      this.addVisible= true;
      this.friend.id = row.id;
      this.friend.linkName = row.linkName;
      this.friend.linkAvatar = row.linkAvatar;
      this.friend.linkAddress = row.linkAddress;
      this.friend.linkIntro = row.linkIntro;
      this.friend.createTime = row.createTime;
    },
    submitFriend(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/friend/update",{
            id:this.friend.id,
            linkName:this.friend.linkName,
            linkAvatar:this.friend.linkAvatar,
            linkAddress:this.friend.linkAddress,
            linkIntro:this.friend.linkIntro,
            createTime:this.friend.createTime,
            flag:this.friend.flag
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
    addSubmit(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/friend/save",{
            id:this.friend.id,
            linkName:this.friend.linkName,
            linkAvatar:this.friend.linkAvatar,
            linkAddress:this.friend.linkAddress,
            linkIntro:this.friend.linkIntro,
            createTime:this.friend.createTime,
            flag:this.friend.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //刷新窗口
              this.clearSubmit(formName);
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
    clearSubmit(formName){
      this.$refs[formName].resetFields();
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    }
  },
  created(){
    this.page();
  }
}
</script>

<style scoped lang="scss">
.avatar-uploader-icon[data-v-7327d821] {
  font-size: 28px;
  color: #8c939d;
  width: 140px;
  height: 120px;
  line-height: 115px;
  text-align: center;
  border: 1px dashed #d9d9d9;
}

</style>
=======
<template>
  <div>
    <el-card class="main-card">
      <!-- 表格操作 -->
      <div class="operation-container">
        <el-button
            type="success"
            size="small"
            icon="el-icon-plus"
            @click="addFriend"
            >新增</el-button>
        <!-- 条件筛选 -->
        <div style="margin-left:auto">
          <el-input
              prefix-icon="el-icon-search"
              size="small"
              placeholder="请输入友链名"
              style="width:200px"
              v-model="searchForm.linkName"/>
          <el-button
              type="primary"
              size="small"
              icon="el-icon-search"
              style="margin-left:1rem"
              @click="search">搜索
          </el-button>
        </div>
      </div>
      <!-- 表格展示 -->
      <el-table border :data="friends">
        <!-- 表格列 -->
        <el-table-column prop="linkAvatar" label="链接头像" align="center" width="180">
          <template slot-scope="scope">
            <el-avatar :size="45" :src="imageUrl"></el-avatar>
          </template>
        </el-table-column>
        <el-table-column prop="linkName" label="链接名" align="center" />
        <el-table-column prop="linkAddress" label="链接地址" align="center" />
        <el-table-column prop="linkIntro" label="链接介绍" align="center" />
        <el-table-column prop="createTime" label="创建时间" width="140" align="center">
          <template slot-scope="scope">
            <i class="el-icon-time" style="margin-right:5px" />
            {{ scope.row.createTime}}
          </template>
        </el-table-column>
        <!-- 列操作 -->
        <el-table-column label="操作" align="center" width="160">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" @click="editFriend(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" slot="reference" @click="deleteFriend(scope.row)">删除</el-button>
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
      <!-- 修改 -->
      <el-dialog title="修改友链" :visible.sync="editVisible">
        <el-form :model="friend" ref="friendForm" label-width="100px" size="mini">
          <el-form-item label="链接名" prop="linkName">
            <el-input v-model="friend.linkName"/>
          </el-form-item>
          <el-form-item label="链接头像" prop="linkAvatar">
            <el-upload
                class="avatar-uploader"
                action="https://jsonplaceholder.typicode.com/posts/"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                v-model="friend.linkAvatar">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="链接地址" prop="linkAddress">
            <el-input v-model="friend.linkAddress"/>
          </el-form-item>
          <el-form-item label="链接介绍" prop="linkIntro">
            <el-input v-model="friend.linkIntro"/>
          </el-form-item>
          <el-form-item label="创建时间" prop="createTime">
            <el-date-picker v-model="friend.createTime"
                            style="display: block;width: 200px">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitFriend('friendForm')">提交</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <!-- 新增 -->
      <el-dialog title="新增友链" :visible.sync="addVisible">
        <el-form :model="friend" ref="friendForm" label-width="100px" size="mini">
          <el-form-item label="链接名" prop="linkName">
            <el-input v-model="friend.linkName"/>
          </el-form-item>
          <el-form-item label="链接头像" prop="linkAvatar">
            <el-upload
                class="avatar-uploader"
                action="https://jsonplaceholder.typicode.com/posts/"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
                v-model="friend.linkAvatar">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="链接地址" prop="linkAddress">
            <el-input v-model="friend.linkAddress"/>
          </el-form-item>
          <el-form-item label="链接介绍" prop="linkIntro">
            <el-input v-model="friend.linkIntro"/>
          </el-form-item>
          <el-form-item label="创建时间" prop="createTime">
            <el-date-picker v-model="friend.createTime"
                            style="display: block;width: 200px">
            </el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addSubmit('friendForm')">提交</el-button>
            <el-button type="danger" @click="clearSubmit('friendForm')">清空</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
name: "FriendshipChain",
  data () {
    return {
      pageInfo: {
        pageNum: 1,/*当前是第几页*/
        total: 100,/*总条目数*/
        pageSize: 8/*每页展示条目数*/
      },
      friends:[],
      editVisible:false,
      addVisible:false,
      friend: {
        linkName:'',
        linkAvatar:'',
        linkAddress:'',
        linkIntro:'',
        createTime:''
      },
      imageUrl: '',
      searchForm:{
        linkName:''
      }
    }
  },
  methods: {
    page(){
      axios.get('/api/friend/page', {
        params: {
          condition: {
            linkName: this.searchForm.linkName
          },
          pageNum: this.pageInfo.pageNum,
          pageSize: this.pageInfo.pageSize
        }
      }).then(resp => {
        this.friends = resp.data.list;
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
    deleteFriend(row) {
      this.$confirm('确认删除该友链？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.delete('/api/friend/delete/'+row.id).then(resp=>{
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
    editFriend(row) {
      this.editVisible = true;
      this.friend.id = row.id;
      this.friend.linkName = row.linkName;
      this.friend.linkAvatar = row.linkAvatar;
      this.friend.linkAddress = row.linkAddress;
      this.friend.linkIntro = row.linkIntro;
      this.friend.createTime = row.createTime;
    },
    addFriend(row) {
      this.addVisible= true;
      this.friend.id = row.id;
      this.friend.linkName = row.linkName;
      this.friend.linkAvatar = row.linkAvatar;
      this.friend.linkAddress = row.linkAddress;
      this.friend.linkIntro = row.linkIntro;
      this.friend.createTime = row.createTime;
    },
    submitFriend(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/friend/update",{
            id:this.friend.id,
            linkName:this.friend.linkName,
            linkAvatar:this.friend.linkAvatar,
            linkAddress:this.friend.linkAddress,
            linkIntro:this.friend.linkIntro,
            createTime:this.friend.createTime,
            flag:this.friend.flag
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
    addSubmit(formName){
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/friend/save",{
            id:this.friend.id,
            linkName:this.friend.linkName,
            linkAvatar:this.friend.linkAvatar,
            linkAddress:this.friend.linkAddress,
            linkIntro:this.friend.linkIntro,
            createTime:this.friend.createTime,
            flag:this.friend.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //刷新窗口
              this.clearSubmit(formName);
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
    clearSubmit(formName){
      this.$refs[formName].resetFields();
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    }
  },
  created(){
    this.page();
  }
}
</script>

<style scoped lang="scss">
.avatar-uploader-icon[data-v-7327d821] {
  font-size: 28px;
  color: #8c939d;
  width: 140px;
  height: 120px;
  line-height: 115px;
  text-align: center;
  border: 1px dashed #d9d9d9;
}

</style>
>>>>>>> 6904d88... first commit
