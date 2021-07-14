<template>
  <h1>Soon Todo List</h1>
  <TodoList />
  <TodoInput />
</template>

<script>
import TodoList from "@/components/TodoList";
import TodoInput from "@/components/TodoInput";
export default {
  name: "Home",

  components: {
    TodoList,
    TodoInput
  }
};
</script>
