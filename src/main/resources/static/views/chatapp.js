import sendMessageComponent from "../components/sendMessageComponent.js";
import messageBox from "../components/messageBox.js";
import channelBoxComponent from "../components/channelBoxComponent.js";
import createChannel from "../components/createChannel.js";

//import channelList from "../components/channelList.js";

export default {
	components: {
		sendMessageComponent,
		messageBox,
		channelBoxComponent,
		createChannel,
	},
	template: `
    <div class="chat-app-cover-div">
        <channelBoxComponent/>
        <div class="message-component-div">
            <messageBox/>
            <sendMessageComponent/>
            <createChannel/>
        </div>
    </div>
    `,

};
