export default {
    template: `
        <div class="channel-box-div">
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
        async onClick(i) {
            this.$store.commit('setCurrentChannel', this.$store.state.currentUser.listOfChannels[i])
            let channelId = this.$store.state.currentChannel.id
            let response = await fetch('/rest/messages/' + channelId)
            response = await response.json()
            this.$store.commit('setCurrentChannelMessages', response)
            console.log(this.$store.state.currentChannelMessages)
        }
    }
}