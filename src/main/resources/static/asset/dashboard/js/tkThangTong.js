// render biểu đồ khi vừa tải trang lên
function nhap() {
	$.ajax({
		type: "GET",
		url: "TkNhapThangMd",
		data: "year=" + $('#year').val(),
		success: function(nhap) {
			$.ajax({
				type: "GET",
				url: "TkThangMd",
				data: "year=" + $('#year').val(),
				success: function(xuat) {
					RenderChart(nhap, xuat)
					console.log("xuat", xuat)
				}
			})
		}
	})
}
function nhapSl() {
	$.ajax({
		type: "GET",
		url: "TkNhapThang",
		data: "year=" + $('#year').val(),
		success: function(nhap) {
			$.ajax({
				type: "GET",
				url: "TkThang",
				data: "year=" + $('#year').val(),
				success: function(xuat) {
					RenderChart(nhap, xuat)
					console.log("xuat", xuat)
				}
			})
		}
	})
}
// render biểu đồ khi người dùng chọn năm
$(document).ready(function() {
	$('#year').change(function() {
		$.ajax({
			success: function() {
				nhapSl();
			}
		});

	});
});
$(document).ready(function() {
	$.ajax({
		success: function() {
			nhap();
		}
	})
});

function RenderChart(nhap, xuat) {
	console.log("nhap" + nhap)
	console.log("4", xuat)
	var dataNhap = [];
	var dataXuat = [];
	var tiennhap = 0;
	var tienxuat = 0;
	var thangnhap = [];
	for (var i = 0; i < nhap.length; i++) {
		dataNhap.push((nhap[i][0]));
		tiennhap = tiennhap + Number(nhap[i][0]);
		thangnhap.push("Tháng " +nhap[i][1]);
		console.log("Nhập: " + dataNhap);
	}
	for (var y = 0; y < xuat.length; y++) {
		dataXuat.push((xuat[y][0]));
		tienxuat = tienxuat + Number(xuat[y][0]);
		console.log("Xuất: " + dataXuat);
	}
	var sum = dataXuat.map(function(num, idx) {
		return num - dataNhap[idx];

	}); console.log("Tổng", sum);
	var tongTien = tienxuat - tiennhap;
	console.log("3", nhap)
	$('#tiennhap').text(Number(tiennhap).toLocaleString('vi-VN') + " VNĐ");
	$('#tienxuat').text(Number(tienxuat).toLocaleString('vi-VN') + " VNĐ");
	$('#lai').text(Number(tongTien).toLocaleString('vi-VN') + " VNĐ");

	console.log("sum: " + tongTien);
	Highcharts.chart('containerChart', {
		title: {
			text: "THỐNG KÊ DOANH THU THEO TỪNG THÁNG (NĂM " + $('#year').val()+ ")",
		},
		xAxis: {
			categories: thangnhap
		},
		yAxis: [{ // Primary yAxis,
			title: {
				text: 'Lãi [vnd]',
			},
			opposite: true

		},
		{ // Secondary yAxis
			gridLineWidth: 0,
			title: {
				text: 'Nhập/Xuất [vnd]',
			},

		}],
		tooltip: {
			shared: true
		},
		legend: {
			layout: 'vertical',
			align: 'left',
			x: 80,
			verticalAlign: 'top',
			y: 55,
			floating: true,
			backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
		},
		series: [{
			type: 'column',
			name: 'nhập',
			yAxis: 1,
			data: dataNhap,
			tooltip: {
				pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
					'<td style="padding:0"><b>{point.y:.1f}đ</b></td></tr>',
			}
		}, {
			type: 'column',
			name: 'xuất',
			data: dataXuat,
			yAxis: 1,
			tooltip: {
				pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
					'<td style="padding:0"><b>{point.y:.1f}đ</b></td></tr>',
			}
		}, {
			type: 'spline',
			name: ' lãi',
			data: sum,

			tooltip: {
				headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
				pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
					'<td style="padding:0"><b>{point.y:.1f}đ</b></td></tr>',
				footerFormat: '</table>',
				shared: true,
				useHTML: true
			},
			marker: {
				lineWidth: 2,
				lineColor: Highcharts.getOptions().colors[3],
				fillColor: 'white'
			}
		},
		]
	})
}