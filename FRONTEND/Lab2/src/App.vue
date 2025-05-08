<template>
  <div>
    <h1>Смартфон</h1>
    <div v-if="smartphone">
      <h2>{{ smartphone.brand }} {{ smartphone.model }}</h2>
      <img :src="smartphone.imageUrl" alt="Фото смартфона" width="300" />
      <p><strong>Опис:</strong> {{ smartphone.description }}</p>
      <p><strong>Характеристики:</strong> {{ smartphone.specifications }}</p>
    </div>
    <div v-else>
      <p>Завантаження даних...</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      smartphone: null,
    };
  },
  mounted() {
    fetch('http://localhost:8080/SmartphoneServlet/smartphone')
      .then((response) => response.json())
      .then((data) => {
        this.smartphone = data;
      })
      .catch((error) => {
        console.error("Помилка при отриманні даних:", error);
      });
  },
};
</script>
