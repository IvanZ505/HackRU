<template>
    <label class="containing-box">
        <input type="checkbox" @click="useDarkMode()"> 
        <span class="slider"></span>
    </label>
    <start v-if="!started" @changeStarted="started = true"></start>
    <search v-else></search>
</template>


<script>
    import start from './component/Start.vue'
    import search from './component/Search.vue'

    export default {
        data() {
            return {
                started: false,
                darkMode: false,
            }
        },
        components: {
            start,
            search
        },
        methods: {
            useDarkMode() {
                document.body.classList.toggle("dark-mode");
            },
        },
        created() {
            console.log('Created!')
        }
    }
</script>