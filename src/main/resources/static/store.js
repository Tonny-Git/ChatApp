import Vue from "https://cdn.jsdelivr.net/npm/vue@2.6.11/dist/vue.esm.browser.js";
import Vuex from "https://cdn.jsdelivr.net/npm/vuex@3.1.2/dist/vuex.esm.browser.js";
Vue.use(Vuex);

export const store = new Vuex.Store({
	state: {
		currentUser: null,
		currentChannel: null,
		currentChannelMessages: null,
		otherChannels: null,
	},
	mutations: {
		setCurrentUser(state, user) {
			state.currentUser = user;
		},
		setCurrentChannel(state, channel) {
			state.currentChannel = channel;
		},
		setCurrentChannelMessages(state, messages) {
			state.currentChannelMessages = messages;
		},
		setOtherChannels(state, channels) {
			state.otherChannels = channels;
		},
		removeChannelfromUser(state, index) {
			state.currentUser.listOfChannels.splice(index, 1);
    },
    addToCurrentChannelMessages(state, message) {
      state.setCurrentChannelMessages.add(message)
    },
	},
	actions: {},
});
