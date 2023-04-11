<template>
    <div class="container">
        <div class="row">
            <div class="col-5">
                <div class="box">
                    Restkarten<br><span>{{ cards }}</span>
                </div>
            </div>
            <div class="col-5">
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
        created()
        {
            const portrait = window.matchMedia("(orientation: portrait)").matches

            if(portrait)
            {
                this.portait = true
            }else
            {
                this.portait = false
            }
        },
        mounted()
        {
            window.matchMedia("(orientation: portrait)").addEventListener("change", e =>
            {
                const portrait = e.matches;

                if(portrait)
                {
                    this.portait = true
                }else
                {
                    this.portait = false
                }
            });
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
    background-color: #222847;
    color: #ed9623;
    font-size: 22px;
    padding: 20px 0;
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