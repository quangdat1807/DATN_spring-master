

	

    $(function() {
        $.getScript("/asset/js/api/product.js",function(){
            var prid = localStorage.getItem("prid");
            loaddetail(prid);
            
            });
    });


   function addSP() {
    var prid = localStorage.getItem("prid");
   
    fetch('/cart/them-vao-gio/' + prid)
    .then(response => response.text())
    .then(data => {
        $('#table-content').html(data);
        $("div.gio-hang").css("display", "block");
    });
   }

