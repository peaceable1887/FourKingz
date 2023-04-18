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
    transition-duration: 0.5s;
    -webkit-transition-duration: 0.5s;
}
button:active
{
    color: var(--color-second);
    background-color: var(--color-main);;
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
 

</style>