<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24" style="padding-left: 20px; text-align: center; margin-bottom: 100px;margin-top: 200px">
        <h2>塞斯纳172飞机蒙皮高光谱数据库</h2>
      </el-col>
      <el-col :sm="24" :lg="24">
        <el-row >
          <el-col :span="6" class="route-button">
            <router-link to="/system/user">
              <el-button
                type="primary"
                plain
              >搜索</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" class="route-button">
            <router-link to="/system/role">
              <el-button
                type="primary"
                plain
              >数据展示</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" class="route-button">
            <router-link to="/system/dept">
              <el-button
                type="primary"
                plain
              >数据上传</el-button>
            </router-link>
          </el-col>
          <el-col :span="6" class="route-button">
            <router-link to="/system/post">
              <el-button
                type="primary"
                plain
              >数据维护</el-button>
            </router-link>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.7"
    };
  },
  methods: {
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  .route-button {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>
