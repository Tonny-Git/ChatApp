export default {
    template: `
        <div>
            <h2>Channels</h2>
            <div v-for="userChannel in userChannels">
                <h3>{{userChannel.title}}</h3>
            </div>
        </div>
    `,
    computed: {
        userChannels() {
            if(this.$store.state.currentUser === null) {
                return {}
            } else {
                console.log("in computed: " +this.$store.state.currentUser.listOfChannels[0].title)
                return this.$store.state.currentUser.listOfChannels
            }
        }
    },
}