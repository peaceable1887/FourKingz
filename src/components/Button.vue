<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "Button.vue" dient als grobes Schema, wie ein Button auszusehen hat und was dieser behinhalten muss.
-->
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
    background-color:var(--color-second);
    border-radius: 10px;
    color: var(--color-main);
    border: none;
    text-shadow: rgba(0, 0, 0, 0.25) 0 3px 8px;
}

</style>