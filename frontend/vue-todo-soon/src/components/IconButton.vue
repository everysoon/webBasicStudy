<template>
  <v-btn icon>
    <v-icon>
      {{ icon }}
    </v-icon>
  </v-btn>
</template>
<script>
export default {
  props: {
    icon: String,
  },
};
</script>
