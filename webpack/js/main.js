
import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/SenderApp.vue'

Vue.use(VueResource);

new Vue({
    el:'#senderAppVue',
    render: a=> a(App)
});
