import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  build: {
    outDir: 'dist',
    emptyOutDir: true
  },
  server: {
    proxy: {
      '/smartphone': {
        target: 'http://localhost:8080/SmartphoneServlet/', 
        changeOrigin: true, 
        secure: false 
      }
    }
  }
});
