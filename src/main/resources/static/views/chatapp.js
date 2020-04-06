import sendMessageComponent from '../components/sendMessageComponent.js'
import messageBox from '../components/messageBox.js'

//import channelsComponent from "../components/channelsComponent.js";
//import channelsComponent from "../components/channelList.js";

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
};
