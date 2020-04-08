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
        <div>
        <channelBoxComponent/>
        <createChannel/>
</div>
        <div class="message-div">
            <messageBox/>
            <sendMessageComponent/>
        </div>
    </div>
    `,

};
