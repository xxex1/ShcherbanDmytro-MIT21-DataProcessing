<template>
  <div id="app">
    <h1>Smartphones</h1>

    <form @submit.prevent="addSmartphone">
      <input v-model="newSmartphone.name" placeholder="Name" />
      <input v-model="newSmartphone.brand" placeholder="Brand" />
      <textarea v-model="newSmartphone.description" placeholder="Description"></textarea>
      <button type="submit">Add Smartphone</button>
    </form>

    <ul>
      <li v-for="smartphone in smartphones" :key="smartphone.id">
        <p>{{ smartphone.name }} ({{ smartphone.brand }})</p>
        <p>{{ smartphone.description }}</p>
        <button @click="editSmartphone(smartphone)">Edit</button>
        <button @click="deleteSmartphone(smartphone.id)">Delete</button>
      </li>
    </ul>

    <div v-if="editing">
      <h2>Edit Smartphone</h2>
      <input v-model="editingSmartphone.name" />
      <input v-model="editingSmartphone.brand" />
      <textarea v-model="editingSmartphone.description"></textarea>
      <button @click="updateSmartphone">Save</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      smartphones: [],
      newSmartphone: {
        name: '',
        brand: '',
        description: ''
      },
      editing: false,
      editingSmartphone: {}
    };
  },
  created() {
    this.fetchSmartphones();
  },
  methods: {
    fetchSmartphones() {
      fetch('http://localhost:8080/SmartphoneServlet/smartphone')
        .then(response => response.json())
        .then(data => {
          this.smartphones = data;
        });
    },
    addSmartphone() {
      fetch('http://localhost:8080/SmartphoneServlet/smartphone', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.newSmartphone)
      })
      .then(() => {
        this.fetchSmartphones();
        this.newSmartphone.name = '';
        this.newSmartphone.brand = '';
        this.newSmartphone.description = '';
      });
    },
    editSmartphone(smartphone) {
      this.editing = true;
      this.editingSmartphone = { ...smartphone };
    },
    updateSmartphone() {
      // Використовуємо правильний URL
      fetch('http://localhost:8080/SmartphoneServlet/smartphone', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.editingSmartphone)
      })
      .then(() => {
        this.fetchSmartphones();
        this.editing = false;
      });
    },
    deleteSmartphone(id) {
      // Використовуємо правильний URL
      fetch(`http://localhost:8080/SmartphoneServlet/smartphone?id=${id}`, {
        method: 'DELETE'
      })
      .then(() => {
        this.fetchSmartphones();
      });
    }
  }
};
</script>

<style scoped>
/* Додаємо стилі для кнопок, форм та списку */
button {
  margin: 5px;
}

form input, form textarea {
  margin: 5px;
  padding: 10px;
}

ul {
  list-style-type: none;
  padding: 0;
}
</style>
