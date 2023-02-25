<template>
    <div class="startup">
        <header id="transit">NJ Transit Data Demo</header> 

        <button class="startup-btn" @click="changeStarted()">Enter</button>
    </div>
</template>

<script>

    import {animate} from "motion"

    export default {
        props: {
            started : Boolean
        },

        methods: {
            changeStarted() {
                this.$emit('changeStarted')
            }
        }
    }
</script>

