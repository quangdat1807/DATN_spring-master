const url = window.location.pathname;
console.log('name' + url);

const subst = url.substring(0, 11);
console.log('name: ' + subst);


const urlPrice = new URLSearchParams(window.location.search);
const price_min = urlPrice.get('price_min');
const price_max = urlPrice.get('price_max');

if (price_max == 100000) {
    document.getElementById("filter_price_mobile").selectedIndex = "1";
    document.getElementById("filter_price_desktop").selectedIndex = "1";
}else if (price_min == 100000 && price_max==300000) {
    document.getElementById("filter_price_mobile").selectedIndex = "2";
    document.getElementById("filter_price_desktop").selectedIndex = "2";
}else if (price_min == 300000 && price_max==500000) {
    document.getElementById("filter_price_mobile").selectedIndex = "3";
    document.getElementById("filter_price_desktop").selectedIndex = "3";
}else if (price_min == 500000 && price_max==700000) {
    document.getElementById("filter_price_mobile").selectedIndex = "4";
    document.getElementById("filter_price_desktop").selectedIndex = "4";
}else if (price_min == 700000) {
    document.getElementById("filter_price_mobile").selectedIndex = "5";
    document.getElementById("filter_price_desktop").selectedIndex = "5";
}

if (price_min === null) {
    if (subst == '/trademake/') {
        $("#sort_product").css("display", 'none');
       
        $("#page_trademake").css("display", 'block');
        //document.getElementById('default').style.display='none';
        //document.getElementById('default_active').style.display='none';
        $("#page_trademake_filter").css("display", 'none');
        //$("#default_page").remove();
        $("#page").css("display", 'none');
        
    } 
} else {
    if(subst == '/trademake/' && price_min >= 0){

        

        //document.getElementById('sort_product').remove();
    
       
       
        //document.getElementById('default').style.display='none';
        //document.getElementById('default_active').style.display='none';
        $("#page_trademake").hide();
    
        $("#page_trademake_filter").show();
    
    } 
}


function priceChanged(obj)
{
    var message = document.getElementById('show_message');
    var value = obj.value;
    if (value === ''){
        window.location.assign(url)
    }
    else if (value === '1'){
      window.location.assign('?price_max=100000')  
    }
    else if (value === '2'){
        window.location.assign('?price_min=100000&price_max=300000') 
    }
    else if (value === '3'){
        window.location.assign('?price_min=300000&price_max=500000') 
    }
    else if (value === '4'){
        window.location.assign('?price_min=500000&price_max=700000') 
    }
    else if (value === '5'){
        window.location.assign(url+'?price_min=700000') 
    }
    
}





