<template>
    <div class="startpage">
        <div class="flex">
            <header id="transit">NJ Transit Data Demo</header> 
            <div class="color-square"></div>
            <button class="startup-btn" @click="changeStarted()">Enter</button>
        </div>
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

