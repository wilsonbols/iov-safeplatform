var carinfotable = $('#carinfotable');

tableData = [];

$.ajax({
    url: "/api/getCarInfo?vin=UJD2X7E854KLG6593",
    type: 'GET',
    success: function(res) {
        if(res != "") {
            showTableData(res);
        }
    }
});

function showTableData(dataString) {
    var data = JSON.parse(dataString);
    var tableBody = carinfotable.find('tbody').empty();
    $.each(data, function (index, item) {
        var row = '<tr>';
        row += '<td>' + item.time + '</td>';
        row += '<td>' + item.location + '</td>';
        row += '<td>' + item.speed + '</td>';
        row += '<td>' + item.mileage + '</td>';
        row += '<td>' + item.engine_status + '</td>';
        row += '<td>' + item.engine_temperature + '</td>';
        row += '<td>' + item.driving_mode + '</td>';
        row += '</tr>';
        tableBody.append(row);
    });
    carinfotable.footable();
}

$.ajax({
    url: "/api/getMyEmergencyInfos?assignee=user",
    type: 'GET',
    success: function (res) {
        var needHandleCount = res.filter(({ state }) => (state === 'Processing' || state === '处理中')).length;
        $("#count-span").html(needHandleCount);
    }
});