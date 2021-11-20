
const tk = localStorage.getItem("jwtToken");

console.log(tk);

/* lấy phần tử modal */
var modal = document.getElementById("myModal");
/* thiết lập nút mở modal */
 var btn = document.getElementById("btncheckout");

/* Sẽ hiển thị modal khi người dùng click vào */
//  btn.onclick = function() {
//    modal.style.display = "block";
//  }

$(function () {

  $.validator.addMethod(
    "checkPhoneNumber",
    function (value, element) {
      return (
        this.optional(element) ||
        /((09|03|07|08|05)+([0-9]{8})\b)/g.test(value)
      );
    },
    "Số điện thoại không hợp lệ, vui lòng nhập lại!"
    
  );
  
    $("#checkoutForm").validate({
      rules: {
        
        name: {
          required: true,
          minlength: 3,
          maxlength: 20,
        },
        phoneNumber : "required checkPhoneNumber",
        address : {
          required: true,
          minlength:10,
          maxlength: 150
        }

      },
      messages: {
       
        name: "Tên đăng nhập không được để trống",
        phoneNumber: {
          required: "Số điện thoại không được để trống",
        },
        address : "Địa chỉ không được để trống"
      },
      submitHandler: function () {
        if($("select[name=ls_province]").val() == null && $("select[name=ls_ward]").val() == null ) {
          $("label.province_error").show(); // show Warning 
          $("select#province").focus();  // Focus the select box      
            
      }else if($("select[name=ls_district]").val() == null) {
        $('.province_error').hide(); 
        $("label.district_error").show(); // show Warning 
        $("select#district").focus();  // Focus the select box

      }else if($("select[name=ls_ward]").val() == null) {
        $('.district_error').hide();
        $("label.ward_error").show(); // show Warning 
        $("select#ward").focus();  // Focus the select box


      }else {
        $('.province_error').hide(); 
        $('.district_error').hide();
        $('.ward_error').hide();

        
        document.getElementById("btncheckout").disabled = true;

        var province = $('#province option:selected').text();
        var district = $('#district option:selected').text();
        var ward = $('#ward option:selected').text();

        var $form = $("#checkoutForm");
        var orderData = {
          name: $form.find('input[name="name"]').val(),
          email: $form.find('input[name="email"]').val(),
          address: $form.find('input[name="address"]').val(),
          phoneNumber: $form.find('input[name="phoneNumber"]').val(),
          province,
          district,
          ward,
          note : $('textarea#note').val(),
        };
  
        $.ajax({
          url: "/checkout",
          type: "POST",
          data: JSON.stringify(orderData),
          contentType: "application/json; charset=utf-8",
          beforeSend: function (xhr) {
               xhr.setRequestHeader('Authorization', 'Bearer ' + tk);
           },
          dataType: "json",
          success: function (data, textStatus, jqXHR) {
            location.assign("/checkout/success")
            
          },
          error: function (jqXHR, textStatus, errorThrown) {
            $('#loginErrorModal')
              .modal("show")
              .find(".modal-body")
              .empty()
              .html("<p>Có lỗi xảy ra vui lòng thử lại sau</p>");
          },
        });
      }
      },
    });
  });



  $(function () {

    $.validator.addMethod(
      "checkPhoneNumber",
      function (value, element) {
        return (
          this.optional(element) ||
          /((09|03|07|08|05)+([0-9]{8})\b)/g.test(value)
        );
      },
      "Số điện thoại không hợp lệ, vui lòng nhập lại!"
      
    );
    
      $("#checkoutByUserForm").validate({
        rules: {
          
          name: {
            required: true,
            minlength: 3,
            maxlength: 20,
          },
          phoneNumber : "required checkPhoneNumber",
          address : {
            required: true,
            minlength:10,
            maxlength: 150
          }
  
        },
        messages: {
         
          name: "Tên đăng nhập không được để trống",
          phoneNumber: {
            required: "Số điện thoại không được để trống",
          },
          address : "Địa chỉ không được để trống"
        },
        submitHandler: function () {
          if($("select[name=ls_province]").val() == null && $("select[name=ls_ward]").val() == null ) {
            $("label.province_error").show(); // show Warning 
            $("select#province").focus();  // Focus the select box      
              
        }else if($("select[name=ls_district]").val() == null) {
          $('.province_error').hide(); 
          $("label.district_error").show(); // show Warning 
          $("select#district").focus();  // Focus the select box
  
        }else if($("select[name=ls_ward]").val() == null) {
          $('.district_error').hide();
          $("label.ward_error").show(); // show Warning 
          $("select#ward").focus();  // Focus the select box
  
  
        }else {
          $('.province_error').hide(); 
          $('.district_error').hide();
          $('.ward_error').hide();
  
          
          document.getElementById("btncheckout").disabled = true;
  
          var province = $('#province option:selected').text();
          var district = $('#district option:selected').text();
          var ward = $('#ward option:selected').text();
  
          var $form = $("#checkoutByUserForm");
          var orderData = {
            name: $form.find('input[name="name"]').val(),
            email: $form.find('input[name="email"]').val(),
            address: $form.find('input[name="address"]').val(),
            phoneNumber: $form.find('input[name="phoneNumber"]').val(),
            province,
            district,
            ward,
            note : $('textarea#note').val(),
          };

          console.log(orderData);
    
          $.ajax({
            url: "/checkoutByUser",
            type: "POST",
            data: JSON.stringify(orderData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
              //location.assign("/checkout/success")
              console.log(data);
              
            },
            error: function (jqXHR, textStatus, errorThrown) {
              $('#loginErrorModal')
                .modal("show")
                .find(".modal-body")
                .empty()
                .html("<p>Có lỗi xảy ra vui lòng thử lại sau</p>");
            },
          });
        }
        },
      });
    });