

const url = window.location.pathname;
console.log('name' + url);




const urlParams = new URLSearchParams(window.location.search);
const param = urlParams.get('sort');
const sortBy = urlParams.get('sortBy');
const trademake = urlParams.get('trademake');
console.log(trademake);




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



if (param == 'tensanpham') {
    console.log("1");
    document.getElementById('nameASC').checked = true;
    document.getElementById("filter_products").selectedIndex = "1";
    document.getElementById('page_default').remove();
    $("#page_sort").css("display", 'block');

}else if(param == 'gia'){
    console.log("2");
    document.getElementById('priceASC').checked = true;
    document.getElementById("filter_products").selectedIndex = "3";
    document.getElementById('page_default').remove();
    $("#page_sort").css("display", 'block');
}else if (trademake === null && param === null && sortBy === null) {
    console.log("4");
    $("#page_sort").css("display", 'none');
} else if (trademake != '') {
    console.log("3");
    document.getElementById('page_default').remove();
    $("#page_sort").css("display", 'block');
}



if(param == 'tensanpham' && sortBy == 'DESC'){
    console.log("5");
   
    document.getElementById('nameDESC').checked = true;
    document.getElementById("filter_products").selectedIndex = "2";
    $("#page_sort").css("display", 'block');
}else if(param == 'gia' && sortBy == 'DESC'){
    console.log("6");
    document.getElementById('priceDESC').checked = true;
    document.getElementById("filter_products").selectedIndex = "4";
    
    $("#page_sort").css("display", 'block');
}


var x = location.search;

 console.log(x);



document.body.addEventListener('change', function (e) {
    let target = e.target;

    if (x === '' || trademake === null && price_min ===null && price_max === null ) {

        console.log("x === '' || trademake === null && price_min ===null && price_max === null ");
    
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
    }else if(trademake != '' && price_min === null && price_max === null) {
        console.log("trademake != '' && price_min ===null && price_max === null");
        switch (target.id) {
            case 'nameASC':
                window.location.assign(`?trademake=${trademake}&sort=tensanpham`)
                
                break;
            case 'nameDESC':
                window.location.assign(`?trademake=${trademake}&sort=tensanpham&sortBy=DESC`)
                break;
            case 'priceASC':
                window.location.assign(`?trademake=${trademake}&sort=gia`)
                break;
            case 'priceDESC':
                window.location.assign(`?trademake=${trademake}&sort=gia&sortBy=DESC`)
                break;
        }
    }else if( price_min !=null || price_max != null) {
        console.log("trademake != '' && price_min !='' && price_max != ''");

        if (trademake === null) {
            if (price_max == 100000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?price_max=${price_max}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?price_max=${price_max}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?price_max=${price_max}&sort=gia&sortBy=DESC`)
                        break;
                }
            }else if (price_min == 100000 && price_max==300000 || price_min == 300000 && price_max==500000 || price_min == 500000 && price_max==700000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=gia&sortBy=DESC`)
                        break;
                }
            }else if (price_min == 700000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?price_min=${price_min}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?price_min=${price_min}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?price_min=${price_min}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?price_min=${price_min}&sort=gia&sortBy=DESC`)
                        break;
                }
            }
        }else if (trademake !='') {
            if (price_max == 100000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?trademake=${trademake}&price_max=${price_max}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?trademake=${trademake}&price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?trademake=${trademake}&price_max=${price_max}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?trademake=${trademake}&price_max=${price_max}&sort=gia&sortBy=DESC`)
                        break;
                }
            }else if (price_min == 100000 && price_max==300000 || price_min == 300000 && price_max==500000 || price_min == 500000 && price_max==700000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&price_max=${price_max}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&price_max=${price_max}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&price_max=${price_max}&sort=gia&sortBy=DESC`)
                        break;
                }
            }else if (price_min == 700000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?trademake=${trademake}&price_min=${price_min}&sort=gia&sortBy=DESC`)
                        break;
                }
            }
        }
        
    }else if (price_min != '' || price_max != '') {
        console.log("price_min != '' || price_max != ''");
            if (price_max == 100000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?price_max=${price_max}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?price_max=${price_max}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?price_max=${price_max}&sort=gia&sortBy=DESC`)
                        break;
                }
            }else if (price_min == 100000 && price_max==300000 || price_min == 300000 && price_max==500000 || price_min == 500000 && price_max==700000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=gia&sortBy=DESC`)
                        break;
                }
            }else if (price_min == 700000) {
                switch (target.id) {
                    case 'nameASC':
                        window.location.assign(`?price_min=${price_min}&sort=tensanpham`)
                        
                        break;
                    case 'nameDESC':
                        window.location.assign(`?price_min=${price_min}&sort=tensanpham&sortBy=DESC`)
                        break;
                    case 'priceASC':
                        window.location.assign(`?price_min=${price_min}&sort=gia`)
                        break;
                    case 'priceDESC':
                        window.location.assign(`?price_min=${price_min}&sort=gia&sortBy=DESC`)
                        break;
                }
            }
        
    }else if (param != '' || sortBy != '') {
        console.log("param != '' || sortBy != ''")
        if (price_max == 100000) {
            switch (target.id) {
                case 'nameASC':
                    window.location.assign(`?price_max=${price_max}&sort=tensanpham`)
                    
                    break;
                case 'nameDESC':
                    window.location.assign(`?price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                    break;
                case 'priceASC':
                    window.location.assign(`?price_max=${price_max}&sort=gia`)
                    break;
                case 'priceDESC':
                    window.location.assign(`?price_max=${price_max}&sort=gia&sortBy=DESC`)
                    break;
            }
        }else if (price_min == 100000 && price_max==300000 || price_min == 300000 && price_max==500000 || price_min == 500000 && price_max==700000) {
            switch (target.id) {
                case 'nameASC':
                    window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=tensanpham`)
                    
                    break;
                case 'nameDESC':
                    window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=tensanpham&sortBy=DESC`)
                    break;
                case 'priceASC':
                    window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=gia`)
                    break;
                case 'priceDESC':
                    window.location.assign(`?price_min=${price_min}&price_max=${price_max}&sort=gia&sortBy=DESC`)
                    break;
            }
        }else if (price_min == 700000) {
            switch (target.id) {
                case 'nameASC':
                    window.location.assign(`?price_min=${price_min}&sort=tensanpham`)
                    
                    break;
                case 'nameDESC':
                    window.location.assign(`?price_min=${price_min}&sort=tensanpham&sortBy=DESC`)
                    break;
                case 'priceASC':
                    window.location.assign(`?price_min=${price_min}&sort=gia`)
                    break;
                case 'priceDESC':
                    window.location.assign(`?price_min=${price_min}&sort=gia&sortBy=DESC`)
                    break;
            }
        }
    
}
        
    
        
        
    
    
    
});

function sortChanged(obj)
{

    var value = obj.value;
    if (x === '' || trademake === null ) {
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
    }else if (trademake != '') {
        if (value === ''){
            window.location.assign(url + `?trademake=${trademake}`)
        }
        else if (value === '1'){
        window.location.assign(`?trademake=${trademake}&sort=tensanpham`)  
        }
        else if (value === '2'){
            window.location.assign(`?trademake=${trademake}&sort=tensanpham&sortBy=DESC`) 
        }
        else if (value === '3'){
            window.location.assign(`?trademake=${trademake}&sort=gia`) 
        }
        else if (value === '4'){
            window.location.assign(`?trademake=${trademake}&sort=gia&sortBy=DESC`) 
        }
    }
    
    
    
}



function priceChanged(obj)
{
   
    var value = obj.value;

    if (x === '' || trademake === null && param === null && sortBy === null ) {
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

}else if(param !='' || sortBy!='' && trademake != '') {
    if (trademake === null) {
        if (param == 'tensanpham' || param == 'gia') {
            if (value === ''){
                window.location.assign(url+`?sort=${param}`)
            }
            else if (value === '1'){
            window.location.assign(`?price_max=100000&sort=${param}`)  
            }
            else if (value === '2'){
                window.location.assign(`?price_min=100000&price_max=300000&sort=${param}`) 
            }
            else if (value === '3'){
                window.location.assign(`?price_min=300000&price_max=500000&sort=${param}`) 
            }
            else if (value === '4'){
                window.location.assign(`?price_min=500000&price_max=700000&sort=${param}`) 
            }
            else if (value === '5'){
                window.location.assign(url+`?price_min=700000&sort=${param}`) 
            }
        
        } else if(param == 'tensanpham' || param == 'gia' && sortBy == 'DESC'){
            if (value === ''){
                window.location.assign(url+`?sort=${param}&sortBy=${sortBy}`)
            }
            else if (value === '1'){
            window.location.assign(`?price_max=100000&sort=${param}&sortBy=${sortBy}`)  
            }
            else if (value === '2'){
                window.location.assign(`?price_min=100000&price_max=300000&sort=${param}&sortBy=${sortBy}`) 
            }
            else if (value === '3'){
                window.location.assign(`?price_min=300000&price_max=500000&sort=${param}&sortBy=${sortBy}`) 
            }
            else if (value === '4'){
                window.location.assign(`?price_min=500000&price_max=700000&sort=${param}&sortBy=${sortBy}`) 
            }
            else if (value === '5'){
                window.location.assign(url+`?price_min=700000&sort=${param}&sortBy=${sortBy}`) 
            }
           
           
        }
    }else if (trademake !='') {
        if (param == 'tensanpham' || param == 'gia') {
            if (value === ''){
                window.location.assign(url+`?trademake=${trademake}&sort=${param}`)
            }
            else if (value === '1'){
            window.location.assign(`?trademake=${trademake}&price_max=100000&sort=${param}`)  
            }
            else if (value === '2'){
                window.location.assign(`?trademake=${trademake}&price_min=100000&price_max=300000&sort=${param}`) 
            }
            else if (value === '3'){
                window.location.assign(`?trademake=${trademake}&price_min=300000&price_max=500000&sort=${param}`) 
            }
            else if (value === '4'){
                window.location.assign(`?trademake=${trademake}&price_min=500000&price_max=700000&sort=${param}`) 
            }
            else if (value === '5'){
                window.location.assign(url+`?trademake=${trademake}&price_min=700000&sort=${param}`) 
            }
        
        } else if(param == 'tensanpham' && sortBy == 'DESC' || param == 'gia' && sortBy == 'DESC'){
            if (value === ''){
                window.location.assign(url+`?trademake=${trademake}&sort=${param}&sortBy=${sortBy}`)
            }
            else if (value === '1'){
            window.location.assign(`?trademake=${trademake}&price_max=100000&sort=${param}&sortBy=${sortBy}`)  
            }
            else if (value === '2'){
                window.location.assign(`?trademake=${trademake}&price_min=100000&price_max=300000&sort=${param}&sortBy=${sortBy}`) 
            }
            else if (value === '3'){
                window.location.assign(`?trademake=${trademake}&price_min=300000&price_max=500000&sort=${param}&sortBy=${sortBy}`) 
            }
            else if (value === '4'){
                window.location.assign(`?trademake=${trademake}&price_min=500000&price_max=700000&sort=${param}&sortBy=${sortBy}`) 
            }
            else if (value === '5'){
                window.location.assign(url+`?trademake=${trademake}&price_min=700000&sort=${param}&sortBy=${sortBy}`) 
            }
           
           
        }
    }if(trademake != '' && price_max === null && price_min===null) {
        if ((param != '' || sortBy != '') && trademake === null) {
            console.log("sjdkfg")
        }else if (trademake != ''  && price_min !='', price_max != '' && sortBy === null && param === null) {
            if (value === ''){
                window.location.assign(url)
            }
            else if (value === '1'){
            window.location.assign(`?trademake=${trademake}&price_max=100000`)  
            }
            else if (value === '2'){
                window.location.assign(`?trademake=${trademake}&price_min=100000&price_max=300000`) 
            }
            else if (value === '3'){
                window.location.assign(`?trademake=${trademake}&price_min=300000&price_max=500000`) 
            }
            else if (value === '4'){
                window.location.assign(`?trademake=${trademake}&price_min=500000&price_max=700000`) 
            }
            else if (value === '5'){
                window.location.assign(url+`?trademake=${trademake}&price_min=700000`) 
            }
        }
        
    }else {
        if(trademake !=null && price_max != null && price_min != null){
            if (param === null || sortBy === null) {
                if (trademake != '' && price_min !='', price_max != '' && sortBy === null && param === null) {
                    if (value === ''){
                        window.location.assign(url)
                    }
                    else if (value === '1'){
                    window.location.assign(`?trademake=${trademake}&price_max=100000`)  
                    }
                    else if (value === '2'){
                        window.location.assign(`?trademake=${trademake}&price_min=100000&price_max=300000`) 
                    }
                    else if (value === '3'){
                        window.location.assign(`?trademake=${trademake}&price_min=300000&price_max=500000`) 
                    }
                    else if (value === '4'){
                        window.location.assign(`?trademake=${trademake}&price_min=500000&price_max=700000`) 
                    }
                    else if (value === '5'){
                        window.location.assign(url+`?trademake=${trademake}&price_min=700000`) 
                    } 
                }else if(param !='' || sortBy != null){
                    console.log("sdksfmvc")
                }
                
            }
        }
        
    }

    
    
    

    
}
    
}




