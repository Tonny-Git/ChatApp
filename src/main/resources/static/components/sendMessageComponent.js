export default {
    template: `
        <form @submit.prevent="sendNewMessage">
            <textarea v-model="message"></textarea>
            <button>Send</button>
        </form>
    `,
    data() {
        return {
            message: ''
        }
    },
    methods: {
        async sendNewMessage() {
            let date = new Date();

            let dateString = ''

            console.log()

            let newMessage = {
                messageDate: new Date().toLocaleString, //Fixed?
                message: this.message,
                read: false, //Remove in database, backend and here later if no time left.
                senderId: this.$store.state.currentUser.id, // Fix
                channelId: 1, // Fix
                receiverId: null, //fix
                direct: false // Change later? remove?
            }

            console.log(newMessage) //Remove later

            let response = await fetch('/rest/messages', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newMessage)
            })

            response = await response.json()
        }
    }
}