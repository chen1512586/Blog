<<<<<<< HEAD
<template>
  <el-card class="main-card">
    <!-- 文章标题 -->
    <div class="article-title-container">
      <el-input
          v-model="article.articleTitle"
          size="medium"
          placeholder="输入文章标题"
      />
      <el-button
          type="success"
          size="medium"
          style="margin-left:10px"
          @click="addOrEdit = true"
      >
        发布文章
      </el-button>
    </div>
    <!-- 文章内容 -->
    <mavon-editor
        v-model="article.articleContent"
        style="height:calc(100vh - 225px)"
    />
    <!-- 添加文章对话框 -->
    <el-dialog width="40%" top="10vh" :visible.sync="addOrEdit">
      <div class="dialog-title-container" slot="title">
        上传文章
      </div>
      <!-- 文章数据 -->
      <el-form label-width="80px" size="medium" :model="article" ref="articleForm">
        <el-form-item label="文章分类">
          <el-select  placeholder="请选择分类" v-model="article.categoryId">
            <el-option label="项目介绍" value="项目介绍"/>
            <el-option label="生活随笔" value="生活随笔"/>
          </el-select>
        </el-form-item>
        <el-form-item label="文章标签">
          <el-select v-model="article.tagNames"  placeholder="请选择标签">
            <el-option label="Vue" value="Vue"/>
            <el-option label="Vue CLI" value="Vue CLI"/>
            <el-option label="校园生活" value="校园生活"/>
            <el-option label="百度百科" value="百度百科"/>
            <el-option label="奇闻" value="奇闻"/>
          </el-select>
        </el-form-item>
        <el-form-item label="上传封面">
          <el-upload
              class="upload-demo"
              drag
              action="https://jsonplaceholder.typicode.com/posts/"
              multiple>
            <i class="el-icon-upload" v-if="article.articleCover == ''"></i>
            <div class="el-upload__text" v-if="article.articleCover == ''">将文件拖到此处，或<em>点击上传</em></div>

          </el-upload>
        </el-form-item>
        <el-form-item label="置顶">
          <el-switch
              v-model="article.isTop"
              active-color="#13ce66"
              inactive-color="#F4F4F5"
              :active-value="1"
              :inactive-value="0"
          />
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="addOrEdit = false">取 消</el-button>
        <el-button type="danger" @click="addArticle('articleForm')">
          发 表
        </el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
export default {
  inject: ['reload'],
  name: "AddArticle",
  data() {
    return{
      addOrEdit: false,
      article: {
        articleTitle:'',
        articleContent:"",
        categoryId:'',
        articleCover: "",
        tagNames: '',
        isTop: '',
      }
    }
  },
  methods:{
    addArticle(formName) {
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/article/insert",{
            id:this.article.id,
            articleTitle:this.article.articleTitle,
            articleContent:this.article.articleContent,
            categoryId:this.article.categoryId,
            articleCover:this.article.articleCover,
            tagNames:this.article.tagNames,
            isTop:this.article.isTop,
            flag:this.article.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //关闭窗口
              this.addOrEdit = false;
              this.reload();
            }else {
              this.$notify({
                type:"error",
                message:"保存失败"
              });
            }
          });
        }
      });
    }
  }
}
</script>

<style scoped lang="scss">
.article-title-container {
  display: flex;
  align-items: center;
  margin-bottom: 1.25rem;
}
.save-btn {
  margin-left: 0.75rem;
  background: #fff;
  color: #f56c6c;
}
</style>
=======
<template>
  <el-card class="main-card">
    <!-- 文章标题 -->
    <div class="article-title-container">
      <el-input
          v-model="article.articleTitle"
          size="medium"
          placeholder="输入文章标题"
      />
      <el-button
          type="success"
          size="medium"
          style="margin-left:10px"
          @click="addOrEdit = true"
      >
        发布文章
      </el-button>
    </div>
    <!-- 文章内容 -->
    <mavon-editor
        v-model="article.articleContent"
        style="height:calc(100vh - 225px)"
    />
    <!-- 添加文章对话框 -->
    <el-dialog width="40%" top="10vh" :visible.sync="addOrEdit">
      <div class="dialog-title-container" slot="title">
        上传文章
      </div>
      <!-- 文章数据 -->
      <el-form label-width="80px" size="medium" :model="article" ref="articleForm">
        <el-form-item label="文章分类">
          <el-select  placeholder="请选择分类" v-model="article.categoryId">
            <el-option label="项目介绍" value="项目介绍"/>
            <el-option label="生活随笔" value="生活随笔"/>
          </el-select>
        </el-form-item>
        <el-form-item label="文章标签">
          <el-select v-model="article.tagNames"  placeholder="请选择标签">
            <el-option label="Vue" value="Vue"/>
            <el-option label="Vue CLI" value="Vue CLI"/>
            <el-option label="校园生活" value="校园生活"/>
            <el-option label="百度百科" value="百度百科"/>
            <el-option label="奇闻" value="奇闻"/>
          </el-select>
        </el-form-item>
        <el-form-item label="上传封面">
          <el-upload
              class="upload-demo"
              drag
              action="https://jsonplaceholder.typicode.com/posts/"
              multiple>
            <i class="el-icon-upload" v-if="article.articleCover == ''"></i>
            <div class="el-upload__text" v-if="article.articleCover == ''">将文件拖到此处，或<em>点击上传</em></div>

          </el-upload>
        </el-form-item>
        <el-form-item label="置顶">
          <el-switch
              v-model="article.isTop"
              active-color="#13ce66"
              inactive-color="#F4F4F5"
              :active-value="1"
              :inactive-value="0"
          />
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="addOrEdit = false">取 消</el-button>
        <el-button type="danger" @click="addArticle('articleForm')">
          发 表
        </el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
export default {
  inject: ['reload'],
  name: "AddArticle",
  data() {
    return{
      addOrEdit: false,
      article: {
        articleTitle:'',
        articleContent:"",
        categoryId:'',
        articleCover: "",
        tagNames: '',
        isTop: '',
      }
    }
  },
  methods:{
    addArticle(formName) {
      this.$refs[formName].validate(valid => {
        if (!valid) {
          return false;
        }else {
          //向后台发送请求
          this.$axios.post("/api/article/insert",{
            id:this.article.id,
            articleTitle:this.article.articleTitle,
            articleContent:this.article.articleContent,
            categoryId:this.article.categoryId,
            articleCover:this.article.articleCover,
            tagNames:this.article.tagNames,
            isTop:this.article.isTop,
            flag:this.article.flag
          }).then(resp=>{
            if (resp.data){
              this.$notify({
                type:"success",
                message:"保存成功"
              });
              //关闭窗口
              this.addOrEdit = false;
              this.reload();
            }else {
              this.$notify({
                type:"error",
                message:"保存失败"
              });
            }
          });
        }
      });
    }
  }
}
</script>

<style scoped lang="scss">
.article-title-container {
  display: flex;
  align-items: center;
  margin-bottom: 1.25rem;
}
.save-btn {
  margin-left: 0.75rem;
  background: #fff;
  color: #f56c6c;
}
</style>
>>>>>>> 6904d88... first commit
