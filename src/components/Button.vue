<template>
    <button>{{ text }}</button>
</template>

<script>
    export default 
    {
        name: "item-button",
        props:
        {
            text: String,
        }    
    }
</script>

<style scoped>
button
{
    background-color:#222847;
    border-radius: 10px;
    color: #ed9623;
    border: none;
    text-shadow: rgba(0, 0, 0, 0.25) 0 3px 8px;
}

</style>