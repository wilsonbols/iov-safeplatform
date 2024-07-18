var helptable = $('#helptable');

tableData = [];

$.ajax({
    url: "/api/getMyEmergencyInfos?assignee=user",
    type: 'GET',
    success: function(res) {
        console.log(res);
        var needHandleCount = res.filter (({state}) => (state === 'Processing' || state === '处理中')).length;
        $("#count-span").html(needHandleCount);
        showTableData(res);
    }
});

function openCarDoor(vin) {
    $.ajax({
        url: "/api/openCarDoor?vin=" + vin,
        type: 'GET',
        success: function(res) {
            alert(res.msg);
        }
    });
}

function redirectCarInfo(vin) {
    window.location.href = "/carinfo.html?vin=" + vin;
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
        if(item.state == "Processing" || item.state == "处理中"){
            row += '<td><span class="status-metro status-inprogress">' + item.state + '</span></td>';
        };
        if(item.state == "Done" || item.state == "完成"){
            row += '<td><span class="status-metro status-active">' + item.state + '</span></td>';
        };
        if(item.state == "Processing" || item.state == "处理中"){
            row += '<td style="text-align:center">' + '<div class="btn-group"><button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Process</button><div class="dropdown-menu" style="min-width: 100px;"><button class="dropdown-item btn btn-success" type="button" onclick="openCarDoor(\'' + item.vin + '\')">Open Door</button><button class="dropdown-item btn btn-success" style="margin-top: 2px" type="button" onclick="redirectCarInfo(\'' + item.vin + '\')">Check vehicle</button></div></div>' + '</td>';
        };
        if(item.state == "Done" || item.state == "完成"){
            row += '<td style="text-align:center"></td>';
        };
        row += '</tr>';
        tableBody.append(row);
    });
    helptable.footable();
}