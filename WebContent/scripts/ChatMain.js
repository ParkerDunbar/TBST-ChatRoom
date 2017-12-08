"use strict";

const textArea = document.getElementById('messageOutput');
function shouldScroll() {
	var needToScroll = textArea.scrollTop + textArea.clientHeight == textArea.scrollHeight;
	if (!needToScroll) {
		scrollToBottom();
	}
}
function scrollToBottom() {
	textArea.scrollTop = textArea.scrollHeight;
}
function getDisplayText(text) {
	console.log(text)
	var msg = '';
	for (var i = 0; i < text.length; i++) {
		msg += text[i];
		msg += '\n';
	}
	return msg;
}
function getFriendsList(friendList) {
	console.log(friendList)
	var regex = '(\w*)';
	var msg = '';
	return msg;
}

var Chat = Chat || {};
Chat.connect = function(host) {
	if ('WebSocket' in window) {
		Chat.socket = new WebSocket(host);
	} else if ('MozWebSocket' in window) {
		Chat.socket = new MozWebSocket(host);
	}
	Chat.socket.onopen = function() {
		console.log("Info:Connection Opened");
		Chat.sendJoinMessage();
		Chat.sendGetMessageList();
		Chat.getFriendsList();
		$('#messageInput').keydown(function(evt) {
			if (evt.keyCode == 13) {
				Chat.sendMessage();
			}
		});

		Chat.socket.onclose = function() {
			console.log("Info:Connection Closed");
		}
		Chat.socket.onmessage = function(message) {
			var msg = message.data;
			var json = JSON.parse(msg);
			if (json.tage == 5) {
				var size = json.users.length
				$('#onlineUsers').text(getDisplayText(json.users));
			} else if (json.tage == 6) {
				$('#messageOutput').text(getDisplayText(json.message));
			} else if (json.tage == 7) {
				// bad
				console.log(json)
				$('#friendslist').text(getFriendsList(json.friendsList));
			} else if (json.tage == 8) {
				$('#messageOutput').text(getDisplayText(json.message));
			}
		}
	}
};

Chat.sendJoinMessage = function() {
	var joinTage = '{"tage":1,"userName":"';
	var userName = document.getElementById('userName').textContent;
	var midTage = '","RoomName":"';
	var roomName = ('#RoomName');
	var endTage = '"}'
	var buffer = joinTage + userName.trim() + endTage;
	if (buffer != null) {
		Chat.socket.send(buffer);
	}
}
Chat.sendGetMessageList = function() {
	var tage = '{"tage":2}'
	Chat.socket.send(tage);
}
Chat.getFriendsList = function() {
	var startTage = '{"tage":3,"userName":"';
	var userName = document.getElementById('userName').textContent.trim();
	var endTage = '"}';
	var buffer = startTage + userName + endTage;
	if (userName != null) {
		Chat.socket.send(buffer);
	}
}
Chat.sendMessage = function() {
	var chatTage = '{"tage":4,"userName":"';
	var userName = document.getElementById('userName').textContent.trim();
	var midTage = '","message":"';
	var msg = document.getElementById('messageInput').value
	var endTage = '"}';
	var buffer = chatTage + userName + midTage + msg + endTage;
	if (buffer != '') {
		Chat.socket.send(buffer);
		document.getElementById('messageInput').value = "";
	}

}
Chat.initialize = function() {
	var ep = '/SmallChatRoom/endpoint/';
	var roomName = document.getElementById('roomName').textContent.trim()
	if (window.location.protocol == 'http:') {
		Chat.connect('ws://' + window.location.host + ep + roomName);
	} else {
		Chat.connect('wss://' + window.location.host + ep + roomName);
	}
};
Chat.initialize();