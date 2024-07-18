//var socket = io();

var helptable = $('#helptable');

tableData = [];

showTableData(tableData);


// socket.on('scores', function (json) {
//     data = JSON.parse(json);
//     showTableData(data);
// });

function wsurl() {
    var currentHostname = window.location.hostname;
    var currentPort = window.location.port;
    var portSuffix = (currentPort === '80' || currentPort === '443') ? '' : ':' + currentPort;
    var url = 'ws://' + currentHostname + portSuffix + '/vehicle-websocket';
    console.log('wsurl: ' + url);
    return url
}

const stompClient = new StompJs.Client({
    // brokerURL: 'ws://localhost:8090/vehicle-websocket'
    brokerURL: wsurl()
});

stompClient.onConnect = (frame) => {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/collisionlist', (collision) => {
        showTableData(JSON.parse(collision.body));
    });

};
connect();

function connect() {
    stompClient.activate();
}


function showTableData(data) {
    var tableBody = helptable.find('tbody').empty();
    $.each(data, function (index, item) {
        var row = '<tr>';
        row += '<td>' + item.time + '</td>';
        row += '<td>' + item.brand + '</td>';
        row += '<td>' + item.mod + '</td>';
        row += '<td>' + item.vin + '</td>';
        row += '<td>' + item.name + '</td>';
        row += '<td>' + item.phone + '</td>';
        row += '<td>' + item.locationinfo + '</td>';
        row += '<td>' + item.collisioninfo + '</td>';
        let spanclass = (item.state == "Processing" ||  item.state == "处理中") ? "status-metro status-active" : "status-metro status-suspended"
        row += '<td><span class="' + spanclass + '" title="Suspended">' + item.state + '</span></td>';

        row += '<td style="text-align:center">' + '<button class="btn btn-primary" onclick="assignHelp(' + item.id + ')">Claim</button>' + '</td>';
        row += '</tr>';
        tableBody.append(row);
    });
    helptable.footable();
}

function assignHelp(id) {
    $.ajax({
        url: "/api/assignEmergencyInfo?id=" + id + "&assignee=user",
        type: 'GET',
        success: function (res) {
            alert('Claim task: ' + id + ' successfully!');
        }
    });
}

$.ajax({
    url: "/api/getMyEmergencyInfos?assignee=user",
    type: 'GET',
    success: function (res) {
        console.log(res);
        var needHandleCount = res.filter(({state}) => (state === 'Processing' || state === '处理中')).length;
        $("#count-span").html(needHandleCount);
    }
});