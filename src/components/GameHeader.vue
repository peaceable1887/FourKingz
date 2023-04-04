<template>
    <div class="table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <th><Button @click="$emit('overlay')"></Button></th>
                    <th>Restkarten: <span>{{ cards }}</span></th>
                    <th>Könige: <span>{{ kings }}</span></th>
                </tr>
            </thead>
        </table>
    </div>
  
</template>

<script>
import Button from "../components/Button.vue";
    export default 
    {
        name: "item-header",
        emits:["overlay"],
        components:
        {
            Button,
        },
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
.box
{
    background-color: #ccc661;
}
table
{
    background-color: #ccc661;
    color: #441d1d;
    width: 100%;
}
th
{
    font-size: 18px;
    text-align: center;
    vertical-align: middle;
}
span
{
    color: black;
}
Button
{
    background: url("../assets/iconmonstr-door-6-240.png");
    background-size: 30px 30px;
    height: 30px;  
    width: 30px;
    border: none;
    margin: 5px auto auto auto;
}


</style>