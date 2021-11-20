

$(function() {
    $.ajax({
        url: "/api/categories",
        type: "GET",
        dataType: "json",
        success: function(data) {
            console.log(data);
            data.forEach(function(cate) {
                $("#categories").append("<li class='dropdown menu-item-count'>"
                +"<h3>"
                +"<img src='/asset/img/categories/"+cate.icon+"'>"
                +"<a href='/category/"+cate.seourl+"'>"+cate.name+"<i class='fa fa-angle-right' aria-hidden='true'></i></a>"
                +"</h3>"
                +"</li>")
            })
        }
    });
});