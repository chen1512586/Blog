<template>
    <div>
        <el-container>
            <el-header>
                <el-menu :default-active="$route.path"
                         mode="horizontal"
                         text-color="#778899"
                         active-text-color="#1989fa" router
                         :router="true">
                    <el-menu-item>
                        <img src="../assets/米饭.png" style="height: 40px;width: 40px;position: absolute;left: 70px;top: 8px;">
                    </el-menu-item>
                    <el-menu-item style="margin-left: 150px" index="/">首页</el-menu-item>
                    <el-menu-item index="/sort">文章分类</el-menu-item>
                    <el-menu-item index="/label">标签</el-menu-item>
                    <el-menu-item index="/file">文章归档</el-menu-item>
                    <el-menu-item index="/log">日志</el-menu-item>
                    <el-menu-item index="/guestBook">留言板</el-menu-item>
                    <el-menu-item style="margin-left: 300px" @click="login('loginForm')">登录</el-menu-item>
                </el-menu>
            </el-header>
            <el-form :model="guest" ref="guestForm" :rules="rules">
                <el-form-item prop="author">
            <el-input
                    type="text"
                    placeholder="请输入你的名字"
                    v-model="guest.author"
                    maxlength="12"
                    show-word-limit
            >
            </el-input>
                </el-form-item>
                <el-form-item prop="message">
            <el-input
                    type="textarea"
                    placeholder="请输入留言"
                    v-model="guest.message"
                    show-word-limit
            >
            </el-input>
                </el-form-item>
            <el-button type="primary"  @click="submitGuest('guestForm')">留言</el-button>
            </el-form>
                <el-divider></el-divider>
            <el-table
                    :data="messages"
                    border
                    highlight-current-row>
                <el-table-column
                        prop="id"
                        label="序号"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="author"
                        label="名字">
                </el-table-column>
                <el-table-column
                        prop="message"
                        label="留言">
                </el-table-column>
                <!--<el-table-column
                        prop="time"
                        label="时间"
                        width="160">
                </el-table-column>-->
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
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "GuestBook",
        data() {
            return {
                guest: {
                    id:'',
                    author: '',
                    message: ''
                },
                messages: [],
                pageInfo: {
                    pageNum: 1,/*当前是第几页*/
                    total: 100,/*总条目数*/
                    pageSize: 3/*每页展示条目数*/
                },
                rules:{
                    author:[
                        {required:true,message:"姓名不能为空",trigger:"blur"}
                    ],
                    message:[
                        {required:true,message:"留言内容不能为空",trigger:"blur"}
                    ]
                }
            }
        },
        methods: {
            login(formName) {
                this.$router.replace('/login')
            },
            submitGuest(formName) {
                this.$refs[formName].validate(valid => {
                    if (valid) {
                        //真验证
                        this.$axios.post('/api/guest/save', {
                            author:this.guest.author,
                            message:this.guest.message
                        }).then(response => {
                            if (response.data) {
                                this.$message({
                                    message: '留言成功！',
                                    type: 'success',
                                });
                                //刷新表格数据
                                this.page();
                                //刷新表单，清空数据
                                this.$refs.guestForm.resetFields();
                            }
                        }).catch(error => {
                            this.$message({
                                message: '错误',
                                type: 'error'
                            });
                        });
                    }
                });
            },
          page(){
            axios.get('/api/guest/page', {
              params: {
                condition: {

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
        },
    created(){
        this.page();
    }
    }
</script>
<style scoped>
    .el-menu{
        position: relative;
        bottom: 60px;
        box-shadow: 0 4px 12px 0 rgba(0, 0, 0, 0.1)
    }

    .el-divider--horizontal {
        display: block;
        height: 1px;
        width: 70%;
        margin: 24px 0;
        left: 15%;
        position: relative;
    }

    .el-table{
        width: 70%;
        position: relative;
        left: 15%;
    }

    .el-form{
        width: 30%;
        line-height: 65px;
        margin: 0 auto;
    }

    .el-input {
        position: relative;
        font-size: 14px;
        display: inline-block;
        width: 50%;
    }

    .el-textarea {
        position: relative;
        display: inline-block;
        width: 100%;
        vertical-align: bottom;
        font-size: 14px;
    }

    .el-button{
        width: 50%;
        position: relative;
        left: 0%;
    }

    .el-menu-item{
        cursor: url("../assets/cool.png"),auto;
    }
</style>
