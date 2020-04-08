export default {
    template: `
        <div class="channel-box-div">
            <h2>Channels</h2>
            <div v-for="(userChannel, i) in userChannels" :key="userChannel.id">
                <h3 @click="onClick(i)">{{userChannel.title}}</h3>
                <button @click="onClickLeaveChannel(i)" class="delete-button">🗑️</button>
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
        },
        async onClickLeaveChannel(i) {
            let userChannelRelation = {
                userId: 14,
                channelId: 3
            }
            console.log("1 step")
            let response = await fetch('/rest/relation', {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userChannelRelation)
            })
            console.log("2 step")
            
            //response = await response.json()
            console.log("3 step")
            this.$store.commit('removeChannelfromUser', i)
            console.log("4 step")
        }
    }
}