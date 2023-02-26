<template>
    <div class="startpage">
        <div class="flex">
            <header id="transit">NJ Transit Data Demo</header> 
            <div class="background--custom">
                <canvas id="canvas"></canvas>
            </div>
    
            <button class="startup-btn" @click="changeStarted()">Enter</button>
        </div>
    </div>
</template>

<script>
    import { loadScript } from "vue-plugin-load-script";
    export default {
        props: {
            started : Boolean
        },
        mounted() {
            // let meshScript = document.createElement('script')
            // meshScript.setAttribute('src', 'https://cdn.jsdelivr.net/gh/greentfrapp/pocoloco@minigl/minigl.js')
            // document.head.appendChild(meshScript)
            // var gradient = new Gradient()
            // gradient.initGradient("#canvas")
        loadScript("https://cdn.jsdelivr.net/gh/greentfrapp/pocoloco@minigl/minigl.js")
            .then(() => {
                var gradient = new Gradient()
                gradient.initGradient("#canvas")
                console.log("Working!")
            // Script is loaded, do something
            })
            .catch((e) => {
                console.log(e)
            // Failed to fetch script
            })
    },
        methods: {
            changeStarted() {
                this.$emit('changeStarted')
            }
        }
        
    }
    
</script>

