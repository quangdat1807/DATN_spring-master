$("button.close").click(function () {
  $(this).parent().css("display", "none");
});
$("button.mo-gio-hang").click(function () {
  $("div.gio-hang").css("display", "block");
  fetch("/cart/gio-hang")
    .then((response) => response.text())
    .then((data) => {
      $("#table-content").html(data);
    });
});

function truSP(ev) {
  let id = $(ev.target).attr("id");
  fetch("/cart/tru-san-pham/" + ev)
    .then((response) => response.text())
    .then((data) => {
      $("#table-content").html(data);
    });
}
function congSP(ev) {
  let id = $(ev.target).attr("id");
  console.log(ev);
  fetch("/cart/them-vao-gio/" + ev)
    .then((response) => response.text())
    .then((data) => {
      $("#table-content").html(data);
    });
}

function xoaSP(ev) {
  console.log(ev);
  var r = confirm("Do you really want to delete this row?");
  if (r == true) {
    let id = $(ev.target).attr("id");
    fetch("/cart/xoa-san-pham/" + ev)
      .then((response) => response.text())
      .then((data) => {
        $("#table-content").html(data);
      });
  }
}

/* lấy phần tử modal */
var modal = document.getElementById("myModal");
/* thiết lập nút mở modal */

function popupCartHide() {
  modal.style.display = "none";
}
/*Sẽ đóng modal khi nhấp ra ngoài màn hình*/
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};

//end modal cart



//cart
function minusCart(ev) {
  let id = $(ev.target).attr("id");
  fetch("/cart/minus/" + ev)
    .then((response) => response.text())
    .then((data) => {
      $("#cart-data").html(data);
    });
}
function addCart(ev) {
  let id = $(ev.target).attr("id");
  console.log(ev);
  fetch("/cart/add/" + ev)
    .then((response) => response.text())
    .then((data) => {
      $("#cart-data").html(data);
    });
}

function removeCart(ev) {
  console.log(ev);
  var r = confirm("Do you really want to delete this row?");
  if (r == true) {
    let id = $(ev.target).attr("id");
    fetch("/cart/remove/" + ev)
      .then((response) => response.text())
      .then((data) => {
        $("#cart-data").html(data);
      });
  }
}