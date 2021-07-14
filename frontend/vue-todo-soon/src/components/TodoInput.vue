<template>
  <input type="text" placeholder="what your todo?" v-model="todoText" />
  <v-btn @click="addTodoItem" color="pink">추가</v-btn>
  <v-card class="flex d-flex ml-4">
    <span class="inputSpan" v-for="(sub, index) in subText" :key="index">
      &nbsp;#&nbsp; {{ sub }}
    </span>
  </v-card>
  <div style="display: flex">
    <input
      type="text"
      placeholder="what your sub todo?"
      v-model="subTextItem"
      @keyup.enter="addSubText"
    />
  </div>
</template>
<script>
export default {
  data: () => ({
    todoText: '',
    subText: [],
    subTextItem: '',
  }),
  methods: {
    addTodoItem() {
      if (this.todoText != '' && this.subText != []) {
        this.$store.commit('addTodoItem', {
          todoText: this.todoText,
          subText: this.subText,
        });
        this.todoText = '';
        this.subText = [];
      } else {
        alert('빈칸은 허용이안되용');
      }
    },
    addSubText(e) {
      this.subText.push(e.target.value);
      this.subTextItem = '';
    },
  },
};
</script>
<style>
input[type='text'] {
  margin: 15px;
  border-radius: 5px;
  padding: 10px;
  width: 80%;
  background-color: pink;
}
.inputSpan {
  background-color: rgb(255, 137, 156);
  border-radius: 5%;
  padding: 10px;
}
</style>
