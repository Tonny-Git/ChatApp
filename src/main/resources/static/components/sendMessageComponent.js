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
            let newMessageDate = new Date();
            //Collects all timestamps in an array
            let newDateTimeFormat = [
                newMessageDate.getFullYear()+'',
                newMessageDate.getMonth()+1+'',
                newMessageDate.getDate()+'',
                newMessageDate.getHours()+'',
                newMessageDate.getMinutes()+'',
                newMessageDate.getSeconds()+''
            ]
            let dateTime = '';
            //Builds the right time format and add 0 to single digit numbers
            for (let i = 0; i < newDateTimeFormat.length; i++) {
                dateTime += newDateTimeFormat[i].length === 1 ? "0" + newDateTimeFormat[i] : newDateTimeFormat[i]
                if(i >= 0 && i < 2) {
                    dateTime += "-"
                } else if(i === 2) {
                    dateTime += " "
                } else if(i > 2 && i < 5) {
                    dateTime += ":"
                }
            }

            let newMessage = {
                messageDate: dateTime, //Fixed?
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