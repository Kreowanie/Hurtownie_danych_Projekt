import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
    plugins: [react()],
    server: {
        proxy: {
            "/kraj": "http://localhost:8088",
            "/klient": "http://localhost:8088",
            "/jakosc": "http://localhost:8088",
            "/data": "http://localhost:8088",
            "/produkt": "http://localhost:8088",
            "/zrodlo": "http://localhost:8088",
            "/transakcje": "http://localhost:8088",
        },
    },
});