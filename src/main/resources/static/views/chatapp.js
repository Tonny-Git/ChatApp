import sendMessageComponent from '../components/sendMessageComponent.js'
import messageBox from '../components/messageBox.js'

export default {
    components: {
        sendMessageComponent,
        messageBox
    },
    template: `
    <div>
        <messageBox/>
        <sendMessageComponent/>
    </div>
    `
}