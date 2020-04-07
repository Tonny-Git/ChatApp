import sendMessageComponent from '../components/sendMessageComponent.js'
import messageBox from '../components/messageBox.js'
import channelBoxComponent from '../components/channelBoxComponent.js'

//import channelsComponent from "../components/channelsComponent.js"
//import channelList from "../components/channelList.js";

export default {
    components: {
        sendMessageComponent,
        messageBox,
        channelBoxComponent
    },
    template: `
    <div class="chat-app-cover-div">
        <channelBoxComponent/>
        <div class="message-div">
            <messageBox/>
            <sendMessageComponent/>
        </div>
    </div>
    `
};
