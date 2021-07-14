import { createStore } from 'vuex';

export default createStore({
  state: {
    todoData: [
      {
        id: 1,
        text: 'learn WebBasic',
        subText: ['Html', 'Css', 'JavaScript'],
        success: true,
      },
      {
        id: 2,
        text: 'learn WebDevelopment',
        subText: ['JSP', 'Spring Framework', 'Web Structure'],
        success: true,
      },
      {
        id: 3,
        text: 'learn Web Deep Study',
        subText: ['SpringBoot', 'VueJs', 'Nuex.js', 'Http통신'],
        success: false,
      },
      {
        id: 4,
        text: 'make Web My Project',
        subText: [
          'VueJs',
          'Vuetify',
          'Vuex',
          'Nuex.js',
          'Spring',
          'SpringBoot',
          'MySQL',
          'MyBatis',
        ],
        success: false,
      },
    ],
  },
  mutations: {
    getTodoList(state) {
      return state.todoData;
    },
    addTodoItem(state, { todoText, subText }) {
      console.log(todoText);
      state.todoData.push({
        id: Math.random(),
        text: todoText,
        subText: subText,
        checked: false,
      });
    },
    deleteTodo(state, id) {
      const index = state.todoData.findIndex((todo) => {
        return todo.id === id;
      });
      state.todoData.splice(index, 1);
    },
    toggleCheckbox(state, { id, checked }) {
      const index = state.todoData.findIndex((todo) => {
        return todo.id == id;
      });
      state.todoData[index].success = checked;
    },
  },
  actions: {},
  modules: {},
});
