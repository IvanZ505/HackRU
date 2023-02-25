<template>
    <start v-if="!started" @changeStarted="started = true"></start>
    <div v-else style="color: white;">ASKJDASL</div>
</template>


<script>
    import start from './component/Start.vue'

    export default {
        data() {
            return {
                started: false    
            }
        },
        components: {
            start
        }
    }
</script>