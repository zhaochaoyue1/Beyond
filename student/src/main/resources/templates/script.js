// 获取悬浮客服图标和悬浮客服弹窗
const chatIcon1 = document.getElementById('chat-icon1');
const chatIcon2 = document.getElementById('chat-icon2');
const chatWidget1 = document.getElementById('chat-widget1');
const chatWidget2 = document.getElementById('chat-widget2');

// 显示悬浮客服弹窗
function showChatWidget(widget) {
    widget.style.display = 'block';
}

// 隐藏悬浮客服弹窗
function hideChatWidget(widget) {
    widget.style.display = 'none';
}

// 点击悬浮图标1显示悬浮客服弹窗1
chatIcon1.addEventListener('click', function() {
    showChatWidget(chatWidget1);
});

// 点击悬浮图标2显示悬浮客服弹窗2
chatIcon2.addEventListener('click', function() {
    showChatWidget(chatWidget2);
});

// 关闭悬浮客服弹窗1
chatWidget1.querySelector('.chat-close').addEventListener('click', function() {
    hideChatWidget(chatWidget1);
});

// 关闭悬浮客服弹窗2
chatWidget2.querySelector('.chat-close').addEventListener('click', function() {
    hideChatWidget(chatWidget2);
});
