export default {
    template: `
        <div class="message-box-div">
            <div v-for="message in showMessages" class="message-div" :hover="true">
                <span class="inner-message-div">
                    <p class="message-name">{{message.senderName}}</p>
                    <p class="message-date">{{message.messageDate}}</p>
                    <button v-if="checkDeleteMessage(message.senderId)" @click="onClick(message.id)" class="delete-button">🗑️</button>
                </span>
                <p class="message-p">{{message.message}}</p>
            <div v-for="message in showMessages">
                <p>{{message.sender.username}}: {{message.message}}</p>
            </div>
        </div>
    `,
    data() {
        return {
            hover: false
        }
    },
    computed: {
        showMessages() {
            if(this.$store.state.currentChannelMessages === null) {
                return {}
            } else {
                return this.$store.state.currentChannelMessages
            }
        },
        
    },
    methods: {
        async onClick(id) {
            let response = await fetch('/rest/messages/' + id, {
                method: 'Delete'
            })
        },
        checkDeleteMessage(senderId) {
            if(senderId === this.$store.state.currentUser.id) {
                return true
            } else {
                return false
            }
        }
    }
}