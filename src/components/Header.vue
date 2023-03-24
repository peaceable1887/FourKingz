<template>
    <table>
        <tr>
            <th>Restkarten: <span>{{ cards }}</span></th>
            <th>Könige: <span>{{ kings }}</span></th>
        </tr>
    </table>
</template>

<script>
    export default 
    {
        name: "item-header",
        props:
        {
            cards: String,
            kings: String,
        },
        
    }
    
</script>

<style lang="scss" scoped>
table
{
    font-family: Impact, Regular;
    background-color: #ccc661;
    color: #441d1d;
    position: fixed;
    top:0;
    width: 100%;
    margin: 0;
    padding: 10px;
    font-size: 20px;
    box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
    -webkit-box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
    -moz-box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
}

span
{
    color: black;
}
button
{
    border: 0; 
    background: transparent;
    position: absolute;
    left: 8px;
    top: 10px;
}
img
{
    height: 30px;
}

</style>