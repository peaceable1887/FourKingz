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
    background-image: linear-gradient(92.88deg, #222847 9.16%, #222847 43.89%, #222847 64.72%);
    border-radius: 10px;
    color: #ed9623;
    border: none;
    text-shadow: rgba(0, 0, 0, 0.25) 0 3px 8px;
}

button:hover
{
    background-color:#222847;
    color: #ccc661;
}
</style>