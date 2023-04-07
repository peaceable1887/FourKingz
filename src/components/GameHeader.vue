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
    margin-top: 15px;  
}

.box
{
    background-color: #222847;
    color: #ed9623;
    font-weight: bold;
    padding: 20px 0;
    text-align: center;
    border-radius: 10px;
    font-size: 20px;
    -webkit-box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
            box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}
span
{
    color: white;
    font-size: 24px;
}
</style>