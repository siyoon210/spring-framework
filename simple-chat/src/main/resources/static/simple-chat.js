var stompClient = null;

$(function () {
    var $enterBtn = $('#enter');
    var $name = $('#name');

    function enter() {
        console.log('유저 입장 요청', $name.val());
        var socket = new SockJS('/websocket');
        stompClient = Stomp.over(socket);

        function showGreeting(name) {
            alert('Hello ' + name);
        }

        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/topic/greetings', function (greeting) {
                showGreeting(JSON.parse(greeting.body)['name']);
            });
        })
    }

    $enterBtn.on('click', function () {
        enter();
    });
});