<template>
  <div>
    <h1>Каталог мобільних телефонів</h1>

    <form @submit.prevent="addPhone" class="form">
      <input v-model="newPhone.name" placeholder="Назва" required />
      <input v-model="newPhone.imageUrl" placeholder="URL зображення" required />
      <textarea v-model="newPhone.description" placeholder="Опис" required></textarea>
      <button type="submit">Додати телефон</button>
    </form>

    <hr />

    <div v-for="phone in phones" :key="phone.id" class="phone-card">
      <h2>{{ phone.name }}</h2>
      <img :src="phone.imageUrl" alt="Фото" width="200" />
      <p>{{ phone.description }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const phones = ref([]);
const newPhone = ref({
  name: '',
  description: '',
  imageUrl: ''
});

const fetchPhones = () => {
  axios.get('http://localhost:8081/api/phones')
    .then(response => {
      phones.value = response.data;
    })
    .catch(error => {
      console.error('Помилка при завантаженні телефонів:', error);
    });
};

const addPhone = () => {
  axios.post('http://localhost:8081/api/phones', newPhone.value)
    .then(response => {
      phones.value.push(response.data);
      newPhone.value = { name: '', description: '', imageUrl: '' }; // Очистити форму
    })
    .catch(error => {
      console.error('Помилка при додаванні телефону:', error);
    });
};

onMounted(fetchPhones);
</script>

<style scoped>
.phone-card {
  border: 1px solid #ccc;
  padding: 12px;
  margin: 12px;
  border-radius: 8px;
}

.form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  max-width: 400px;
  margin-bottom: 20px;
}
</style>
