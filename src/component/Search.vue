<template>
    <div class="searchpage">
        <div class="searchpage-heading">Find your Station</div>
        <div class="searchpage-heading smaller">Search ID:</div>
        <input type="text" placeholder="Search for a Stop.." class="search">
    </div>
</template>

<script>

    export default {
        data() {
            return {
                successLocation: (position) => {
                    console.log(position)
                },
                error: (error) => {
                    console.log(error)
                }
            }
        },
        methods: {
           
        }
    }
    
</script>