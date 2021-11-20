
const url = window.location.pathname;
console.log('name' + url);




const urlParams = new URLSearchParams(window.location.search);
const param = urlParams.get('sort');
const sortBy = urlParams.get('sortBy');
const trademake = urlParams.get('trademake');

console.log(trademake);






if (param == 'tensanpham') {
    document.getElementById('nameASC').checked = true;
    document.getElementById("filter_products").selectedIndex = "1";
    document.getElementById('page_default').remove();
    $("#page_sort").css("display", 'block');

}else if(param == 'gia'){
    document.getElementById('priceASC').checked = true;
    document.getElementById("filter_products").selectedIndex = "3";
    document.getElementById('page_default').remove();
    $("#page_sort").css("display", 'block');
} 



if(param == 'tensanpham' && sortBy == 'DESC'){
   
    document.getElementById('nameDESC').checked = true;
    document.getElementById("filter_products").selectedIndex = "2";
    $("#page_sort").css("display", 'block');
}else if(param == 'gia' && sortBy == 'DESC'){
    document.getElementById('priceDESC').checked = true;
    document.getElementById("filter_products").selectedIndex = "4";
    
    $("#page_sort").css("display", 'block');
}


var x = location.search;
console.log(x);

var a = x.indexOf('&'); 

let sub =x.substr(0, a).toString();



var test = `${url}${sub}`;

console.log(test);





document.body.addEventListener('change', function (e) {
    let target = e.target;

    
        switch (target.id) {
            case 'nameASC':
                window.location.assign('?sort=tensanpham')
                
                break;
            case 'nameDESC':
                window.location.assign('?sort=tensanpham&sortBy=DESC')
                break;
            case 'priceASC':
                window.location.assign('?sort=gia')
                break;
            case 'priceDESC':
                window.location.assign('?sort=gia&sortBy=DESC')
                break;
        }
});

function sortChanged(obj)
{
    
    var value = obj.value;
    if (value === ''){
        window.location.assign(url)
    }
    else if (value === '1'){
      window.location.assign('?sort=tensanpham')  
    }
    else if (value === '2'){
        window.location.assign('?sort=tensanpham&sortBy=DESC') 
    }
    else if (value === '3'){
        window.location.assign('?sort=gia') 
    }
    else if (value === '4'){
        window.location.assign('?sort=gia&sortBy=DESC') 
    }
    
}




