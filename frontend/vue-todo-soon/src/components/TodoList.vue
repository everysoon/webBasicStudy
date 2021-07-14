<template>
  <h4 class="gray ma-3">2021 Soon TodoList : I can Do it!</h4>
  <hr />
  <h4>
    완료 :&nbsp;{{
      todoList.filter(function(val) {
        return val.success;
      }).length
    }}
    / {{ todoList.length }}
  </h4>
  <TodoItem v-for="todo in todoList" :key="todo.id" :todo="todo" />
</template>
<script>
import TodoItem from './TodoItem';
export default {
  components: {
    TodoItem,
  },
  computed: {
    todoList() {
      return this.$store.state.todoData;
    },
  },
};
</script>
<style></style>
