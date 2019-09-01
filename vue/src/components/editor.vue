<template>
<div>
  <barAndBG active-index="activeIndex"></barAndBG>
<editor-bar v-model="goods.detail" :isClear="isClear" @change="change"></editor-bar>
</div>
</template>
<script>
import EditorBar from './editorBar'
import barAndBG from './barAndBG'
export default {
name:'editor',
components: { EditorBar,barAndBG },
data() {
      return {
        isClear: false,
        goods:[{detail :""}],
        activeIndex: "4"
        }
      },
methods: {
  change(val) {
      console.log(val)
    },
 }
}
</script>
