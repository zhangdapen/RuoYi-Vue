<template>
  <div class="app-container">
    <el-table v-loading="loading" :data="airplaneList">
      <el-table-column label="图层蒙片位置" align="center" prop="coatingLocation" />
      <el-table-column label="数据采集时间" align="center" prop="createTime" />
      <el-table-column label="飞机编号" align="center" prop="airplane" />
      <el-table-column label="原始数据本地存储位置" align="center" prop="coatingFileLocation" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:post:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:post:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改岗位对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="图层蒙片位置" prop="coatingLocation">
          <el-input v-model="form.coatingLocation" placeholder="图层蒙片位置" />
        </el-form-item>
        <el-form-item label="数据采集时间" prop="createTime">
          <el-input-number v-model="form.createTime" controls-position="right" :min="0" />
        </el-form-item>
        <el-form-item label="飞机编号" prop="airplane">
          <el-input-number v-model="form.airplane" controls-position="right" :min="0" />
        </el-form-item>
        <el-form-item label="原始数据本地存储位置" prop="coatingFileLocation" >
          <el-input v-model="form.coatingFileLocation" placeholder="请输入编码名称" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPost, getPost, delPost, addPost, updatePost } from "@/api/system/post";
import { listPlaneData, deletePlaneData, getPlanePost, updatePlaneData } from "@/api/system/saisina";

export default {
  name: "Post",
  dicts: ['sys_normal_disable'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 岗位表格数据
      airplaneList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        createTime: undefined,
        coatingFileLocation: undefined,
        status: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        coatingFileLocation: [
          { required: true, message: "原始数据保存位置不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "不能为空", trigger: "blur" }
        ],
        airplane: [
          { required: true, message: "不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询岗位列表 */
    getList() {
      this.loading = true;
      listPlaneData(this.queryParams).then(response => {
        this.airplaneList= response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        createTime: undefined,
        coatingFileLocation: undefined,
        coatingLocation: undefined,
        airplane: 0,
      };
      this.resetForm("form");
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加岗位";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const postId = row.id;
      getPlanePost({
        id: postId
      }).then(response => {
        this.form = response;
        this.open = true;
        this.title = "修改飞机信息";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updatePlaneData(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const postId = row.id;
      deletePlaneData({
        id: postId
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    }
  }
};
</script>
