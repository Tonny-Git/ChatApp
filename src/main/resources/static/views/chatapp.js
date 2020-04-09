import sendMessageComponent from "../components/sendMessageComponent.js";
import messageBox from "../components/messageBox.js";
import channelBoxComponent from "../components/channelBoxComponent.js";
import createChannel from "../components/createChannel.js";
import channelList from "../components/channelList.js";

export default {
	components: {
		sendMessageComponent,
		messageBox,
		channelBoxComponent,
		createChannel,
		channelList,
	},
	template: `
        <div class="chat-app-cover-div">
            <channelBoxComponent/>
            <createChannel/>
            <channelList/>
            <div class="message-component-div">
                <messageBox/>
                <sendMessageComponent/>
            </div>
        </div>
    `,
};
