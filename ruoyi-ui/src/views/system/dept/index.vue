<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="rules" label-width="200px">
      <el-row>
        <el-col :span="24" v-if="form.coatingLocation !== 0">
          <el-form-item label="图层蒙皮位置" prop="coatingLocation" >
            <el-input v-model="form.coatingLocation" placeholder="请输入蒙皮位置" maxlength="11" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="飞机编号" prop="airplane">
            <el-input v-model="form.airplane" placeholder="请输入编号" maxlength="11" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="补光情况" prop="fillLightInfo">
            <el-input v-model="form.fillLightInfo" placeholder="请输入补光情况" maxlength="11" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="原始数据本地存储位置" prop="coatingFileLocation">
            <el-input v-model="form.coatingFileLocation" placeholder="请输入本地存储位置" maxlength="50" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
<!--          <el-form-item label="文件" prop="file">-->
<!--            <FileUpload />-->
<!--          </el-form-item>-->
        </el-col>
      </el-row>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitForm">确 定</el-button>
      <el-button @click="cancel">取 消</el-button>
    </div>
  </div>
</template>

<script>
import Treeselect from "@riophae/vue-treeselect";
import FileUpload from '@/components/FileUpload'
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import { addPlaneData} from "@/api/system/saisina";

export default {
  name: "Dept",
  dicts: ['sys_normal_disable'],
  components: { Treeselect, FileUpload },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 表格树数据
      deptList: [],
      // 部门树选项
      deptOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否展开，默认全部展开
      isExpandAll: true,
      // 重新渲染表格状态
      refreshTable: true,
      // 查询参数
      queryParams: {
        deptName: undefined,
        status: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        coatingLocation: [
          { required: true, message: "蒙皮位置不能为空", trigger: "blur" }
        ],
        airplane: [
          { required: true, message: "飞机编号不能为空", trigger: "blur" }
        ],
        dataAddress: [
          { required: true, message: "存储位置不能为空", trigger: "blur" }
        ],
        fillLightInfo: [
          { required: true, message: "补光情况不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    // this.getList();
  },
  methods: {
    // /** 查询部门列表 */
    // getList() {
    //   this.loading = true;
    //   listDept(this.queryParams).then(response => {
    //     this.deptList = this.handleTree(response.data, "deptId");
    //     this.loading = false;
    //   });
    // },
    /** 转换部门数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.deptId,
        label: node.deptName,
        children: node.children
      };
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        coatingLocation: undefined,
        airplane: undefined,
        fillLightInfo: undefined,
        coatingImage: undefined,
        dataAddress: undefined,
        coatingIdentifyImage: undefined
      };
      this.resetForm("form");
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          console.log(this.form);
          addPlaneData(this.form).then(response => {
            this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + '上传成功' + "</div>", { dangerouslyUseHTMLString: true })
            this.open = false;
            this.reset();
          });
        }
      });
    }
  }
};
</script>
