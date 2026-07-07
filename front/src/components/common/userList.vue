<template>
  <div class="main-border">
    <!-- 菜单：只留正常用户 -->
    <el-menu default-active="1" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1">正常用户</el-menu-item>
    </el-menu>

    <!-- 正常用户表格（只读展示，无操作按钮） -->
    <el-table
        :data="userData"
        stripe
        style="width: 100%; color: #5a5c61;"
    >
      <el-table-column label="头像" width="50">
        <template slot-scope="scope">
          <el-avatar shape="square" :size="23" :src="scope.row.avatar"></el-avatar>
        </template>
      </el-table-column>
      <el-table-column
          prop="accountNumber"
          label="用户账号"
          show-overflow-tooltip
          min-width="150"
      />
      <el-table-column
          prop="nickname"
          label="用户昵称"
          show-overflow-tooltip
          min-width="150"
      />
      <el-table-column
          prop="signInTime"
          label="注册时间"
          show-overflow-tooltip
          width="200"
      />
    </el-table>

    <!-- 分页 -->
    <div class="block">
      <el-pagination
          @current-change="handleCurrentChange"
          :current-page.sync="nowPage"
          :page-size="7"
          background
          layout="prev, pager, next, jumper"
          :total="total"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: "userList",
  created() {
    this.getUserData();
  },
  methods: {
    handleCurrentChange(val) {
      this.nowPage = val;
      this.getUserData();
    },

    // 获取正常用户列表
    getUserData() {
      this.$api.getUserData({
        page: this.nowPage,
        nums: 8,
        status: 0
      })
          .then(res => {
            if (res.status_code === 1) {
              this.userData = res.data.list;
              this.total = res.data.count;
            } else {
              this.$message.error(res.msg);
            }
          })
          .catch(e => {
            console.log(e);
          });
    }
    // 已删除封号功能
  },
  data() {
    return {
      mode: 1,
      nowPage: 1,
      total: 0,
      userData: []
    };
  }
};
</script>

<style scoped>
.main-border {
  background-color: #fff;
  padding: 10px 30px;
  box-shadow: 0 1px 15px -6px rgba(0, 0, 0, 0.5);
  border-radius: 5px;
}

.block {
  display: flex;
  justify-content: center;
  padding-top: 15px;
  padding-bottom: 10px;
  width: 100%;
}
</style>