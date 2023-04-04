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
    background-color: #ccc661;
    color: #441d1d;
    border: none;
    width: 100%;
    border-radius: 10px;
}
button:hover
{
    background-color: #441d1d;
    color: #ccc661;
}
</style>