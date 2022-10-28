<!-- 友情链接 -->
<template>
    <div>
        <tzyy-nav></tzyy-nav>
        <div class="container">
            <el-row  :gutter="30">
                <el-col :sm="24" :md="16" style="transition:all .5s ease-out;margin-bottom:30px;">
                    <tzyy-friends></tzyy-friends>
                    <tzyy-message></tzyy-message>
                </el-col>
                <el-col :sm="24"  :md="8" >
                    <tzyy-rightlist></tzyy-rightlist>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
import header from '../components/header.vue'
import friends from '../components/friends.vue'
import rightlist from '../components/rightlist.vue'
import message from '../components/message.vue'
    export default {
        name: 'FriendsLink',
        data() { //选项 / 数据
            return {

            }
        },
        methods: { //事件处理器

        },
        components: { //定义组件
            'tzyy-nav':header,
            'tzyy-message':message,
            'tzyy-friends':friends,
            'tzyy-rightlist':rightlist,
        },
        created() { //生命周期函数

        }
    }
</script>

<style>

</style>
