<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "GameHeader.vue" ist für die Darstellung der verbleibenden Restkarten und der akutell gezogenen Könige dar.
-->
<template>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-5">
                <div class="box">
                    Restkarten<br><span>{{ cards }}</span>
                </div>
            </div>
            <div class="col-lg-2 col-5">
                <div class="box">
                    Könige<br><span>{{ kings }}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default 
    {
        name: "item-gameHeader",
        props:
        {
            cards: String,
            kings: String,
        },
        data()
        {
            return{
                portait: Boolean,
            }
        },
    }
</script>

<style lang="scss" scoped>
.row
{
    -webkit-box-pack: center;
        -ms-flex-pack: center;
    justify-content: center;
}

.box
{
    background-color: var(--color-second);
    color: var(--color-main);
    font-size: 22px;
    padding: 20px 0;
    margin-bottom: 10vh;
    text-align: center;
    border-radius: 10px;
    -webkit-box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
            box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}
span
{
    color: white;
    font-size: 24px;
}
@media(max-height: 568px)
{
    .box
    {
        font-size:14px;
        height: 40px;
        padding: 9px 0;
    }
    span
    {
        font-size: 14px;
        margin-left: 8px;
    }
    br
    {
        display:none;
    }
}
</style>