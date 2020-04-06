export default {
    template: `
        <div>
            <h2>Channels</h2>
            <div v-for="(userChannel, i) in userChannels" :key="userChannel.id" @click="onClick(i)">
                <h3>{{userChannel.title}}</h3>
            </div>
        </div>
    `,
    computed: {
        userChannels() {
            if(this.$store.state.currentUser === null) {
                return {}
            } else {
                return this.$store.state.currentUser.listOfChannels
            }
        }
    },
    methods: {
        onClick(i) {
            this.$store.commit('setCurrentChannel', this.$store.state.currentUser.listOfChannels[i])
        }
    }
}