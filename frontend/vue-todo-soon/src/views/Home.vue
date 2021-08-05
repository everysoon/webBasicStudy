<template>
  <h1>Soon Todo List</h1>
  <v-app-bar>
    <v-app-bar-nav-icon />
    <v-app-bar-title>Title</v-app-bar-title>
    <v-spacer />
    <icon-button icon="mdi-account-plus" />
    <icon-button icon="mdi-login" />
  </v-app-bar>
  <TodoList />
  <TodoInput />
</template>

<script>
import IconButton from '@/components/IconButton';
import TodoList from '@/components/TodoList';
import TodoInput from '@/components/TodoInput';
export default {
  name: 'Home',

  components: {
    TodoList,
    TodoInput,
    IconButton,
  },
};
</script>
