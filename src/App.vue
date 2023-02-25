<template>
    <start v-if="!started" @changeStarted="started = true"></start>
    <search v-else></search>
</template>


<script>
    import start from './component/Start.vue'
    import search from './component/Search.vue'

    export default {
        data() {
            return {
                started: false    
            }
        },
        components: {
            start,
            search
        }
    }
</script>