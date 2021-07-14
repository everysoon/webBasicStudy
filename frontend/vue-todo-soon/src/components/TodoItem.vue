<template>
  <v-row>
    <v-col>
      <v-card style="display:flex; align-items:center ">
        <input
          type="checkbox"
          :checked="todo.success"
          @change="toggleCheckbox"
        />
        <h3
          v-bind="todoText"
          :style="{ 'text-decoration': checkLine, color: colorGray }"
          class="rounded-lg"
          color="primary"
        >
          {{ todo.text }}
        </h3>

        <button
          class="btn btn-danger btn-sm"
          @click="deleteItem"
          icon
          :color="deepBlue"
        >
          <v-icon>mdi-delete</v-icon>
        </button>
      </v-card>
    </v-col>
  </v-row>
  <v-row>
    <v-col>
      <span
        v-for="(sub, index) in todo.subText"
        :key="index"
        class="grey--text ma-2 text--secondary listSpan"
      >
        {{ sub }}
      </span>
    </v-col>
  </v-row>
  <hr />
</template>
<script>
import colors from 'vuetify/lib/util/colors';
export default {
  data: () => ({
    todoText: '',
    todoList: [],
    deepBlue: colors.blue.darken - 4,
  }),
  props: {
    todo: Object,
  },
  methods: {
    toggleCheckbox(e) {
      this.$store.commit('toggleCheckbox', {
        id: this.todo.id,
        checked: e.target.checked,
      });
    },
    deleteItem(id) {
      this.$store.commit('deleteTodo', id);
    },
  },
  computed: {
    checkLine() {
      return this.todo.success ? 'line-through' : 'none';
    },
    colorGray() {
      return this.todo.success ? 'gray' : 'black';
    },
  },
};
</script>
<style>
* {
  margin: 10px;
}
.listSpan {
  background-color: thistle;
  border-radius: 5%;
  padding: 10px;
}
</style>
