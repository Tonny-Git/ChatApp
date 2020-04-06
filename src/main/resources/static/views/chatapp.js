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
    <div>
        <channelBoxComponent/>
        <div>
            <messageBox/>
            <sendMessageComponent/>
        </div>
    </div>
    `
};
