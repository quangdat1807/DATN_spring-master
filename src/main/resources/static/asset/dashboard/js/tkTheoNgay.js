
  // VẼ BIỂU ĐỒ KHI VỪA LOAD TRANG
$(document).ready(function () {
  	// START - Lấy ngày của DatePicker
	var DatePicker = $('#datePicker').val();
	var yearOfDatePicker = DatePicker.substring(0,4);
	var monthOfDatePicker = DatePicker.substring(5,7);
	var dateOfDatePicker = DatePicker.substring(8,10);
	var DateMain = dateOfDatePicker + "/" +monthOfDatePicker + "/" +yearOfDatePicker;
  // END - Lấy ngày của DatePicker
  // #############################################

   $.ajax({
      type: "GET",
      url: "LayDuLieuHienTai",
      success: function (result) {
    

         var totalMonth = result[0][0];
         var totalDate = result[0][1];
         var tinhPhanTram = Math.round(((totalDate/totalMonth)*100) * 100)/100;
        // Kiểm tra nếu không có doanh thu thì dừng vẽ biểu đồ
         if (Number(totalMonth) == 0) {
          document.getElementById('chartContainer').style.display = "NONE";
          document.getElementById('msg').innerHTML = "THÁNG " +monthOfDatePicker +"/"+yearOfDatePicker+ " KHÔNG CÓ DOANH THU !" ;
        }  else {
          $('#chartContainer').show();
        }
         
            // Vẽ biểu đồ
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2",
                exportEnabled: true,
                animationEnabled: true,
                title: {
                  text: "DOANH THU HÔM NAY",
                  fontSize: 20
                },
                data: [{
                  type: "pie",
                  startAngle: 25,
                  toolTipContent: "<b>{label}</b>",
                  showInLegend: "true",
                  legendText: "{label}",
                  indexLabelFontSize: 14,
                  indexLabel: "{label2} - {y}%",
                  dataPoints: [
                      { y: Number(100-tinhPhanTram), 
                      label: "Tổng doanh thu tháng "+monthOfDatePicker + "/"+yearOfDatePicker +" : " + Number(totalMonth).toLocaleString('vi-VN') + " VNĐ", 
                      label2: "Tổng doanh thu theo tháng "},
                      { y: Number(tinhPhanTram), 
                        label: "Tổng doanh thu ngày "+DateMain+": " + Number(totalDate).toLocaleString('vi-VN') + " VNĐ" , label2:  "Tổng doanh thu theo ngày ", exploded: true}
                  ]
                }]
                });
      //  END Vẽ biểu đồ
         chart.render();
      }
   });
  

});
// END VẼ BIỂU ĐỒ KHI VỪA LOAD TRANG
//##############################################################
// VẼ BIỂU ĐỒ THEO NGÀY MÀ NGƯỜI DÙNG CHỌN
$(document).ready(function () {
  $('#datePicker').change(function () { 
    console.log('Click');
     // START - Lấy ngày của DatePicker
     var DatePicker = $('#datePicker').val();
     var yearOfDatePicker = DatePicker.substring(0,4);
     var monthOfDatePicker = DatePicker.substring(5,7);
     var dateOfDatePicker = DatePicker.substring(8,10);
     var DateMain = dateOfDatePicker + "/" +monthOfDatePicker + "/" +yearOfDatePicker;
     // END - Lấy ngày của DatePicker
  
  $.ajax({
    type: "GET",
    url: "LayDuLieuTheoNgay",
    data: "date=" + DatePicker,
  
    success: function (result) {
      var totalMonth = result[0][0];
      var totalDate = result[0][1];
      var tinhPhanTram = Math.round(((totalDate/totalMonth)*100) * 100)/100;

      if (Number(totalMonth) == 0) {
        $('#chartContainer').hide(1000);
        $('#msg').show().text("THÁNG " +monthOfDatePicker +"/"+yearOfDatePicker+ " KHÔNG CÓ DOANH THU !" );
      }  else {
        $('#chartContainer').show();
        $('#msg').hide();

      }
      
      // Vẽ biểu đồ
      var chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2",
        exportEnabled: true,
        animationEnabled: true,
        title: {
            text: "DOANH THU NGÀY " + DateMain,
            fontSize: 20
        },

        data: [{
            type: "pie",
            startAngle: 25,
            toolTipContent: "<b>{label}</b>",
            showInLegend: "true",
            legendText: "{label}",
            indexLabelFontSize: 14,
            indexLabel: "{label2} - {y}%",
            dataPoints: [
              { y: Number(100-tinhPhanTram), 
              label: "Tổng doanh thu tháng "+monthOfDatePicker + "/"+yearOfDatePicker +" : " + Number(totalMonth).toLocaleString('vi-VN') + " VNĐ", 
              label2: "Tổng doanh thu theo tháng "},
              { y: Number(tinhPhanTram), 
                  label: "Tổng doanh thu ngày "+DateMain+": " + Number(totalDate).toLocaleString('vi-VN') + " VNĐ" , label2:  "Tổng doanh thu theo ngày ", exploded: true}
            ]
        }]
        });
        //  END Vẽ biểu đồ
            chart.render();
    }
  });
  
  });
});

// END VẼ BIỂU ĐỒ THEO NGÀY MÀ NGƯỜI DÙNG CHỌN
