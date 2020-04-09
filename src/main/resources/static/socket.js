import { store } from './store.js'

let ws;
let isConnected = false;
connect();

function connect() {
    ws = new WebSocket('ws://localhost:4000/your-socket-route');
    ws.onmessage = (e) => {
      let data = JSON.parse(e.data)

      if(data.message && store.state.currentChannel != null) {
        if(store.state.currentChannel.id === data.channelId) {
          console.log(data)
          store.commit('addToCurrentChannelMessages', data)
        }
      }
      showSomething(e.data);
    }
    ws.onopen = (e) => {
        //sendSomething();
        isConnected = true;
    };

    ws.onclose = (e) => {
        console.log("Closing websocket...");
    };

  console.log("Connecting...");
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    isConnected = false;
    console.log("Disconnected");
}

function sendSomething() {
    ws.send(JSON.stringify({firstname: "Hello World!" }));
}

function showSomething(message) {
    console.log(message);
}
/*
 switch(data.action) {
  case 'new-user':
           store.commit('appendUser', data)
           break

  case 'new-message':
             for (let i = 0; i < store.state.userChannels.length; i++) {
               if (store.state.userChannels[i].id === data.channel_id){
                 store.commit('sendMessage', data)
                 break
               }
             }
              break

  case 'new-channel':
            store.commit('appendChannel', data)
            break

  case 'delete-message':
            store.commit('deleteMessage', data.index)
            break
 }
 */