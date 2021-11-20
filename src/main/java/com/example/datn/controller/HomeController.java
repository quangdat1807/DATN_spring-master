package com.example.datn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.datn.models.Category;
import com.example.datn.models.Product;
import com.example.datn.models.ThuongHieu;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.datn.repository.CategoryRepository;
import com.example.datn.repository.ProductRepository;
import com.example.datn.repository.TrademakeRepository;
import com.example.datn.service.CartService;


import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {
    

    @Autowired
	CartService cartService;

    @GetMapping("/detail/{productname}")
    public String demo(@PathVariable String productname, Model model, HttpServletRequest request){
        
		HttpSession session = request.getSession();


		 int idth = ((Integer) (session.getAttribute("idth")) ).intValue();
		 int idcate = ((Integer) (session.getAttribute("idCate")) ).intValue();


		 if (idth == 0 || idcate == 0) {
			 idth = 1;
			 idcate = 1;
			 List<Product> products = productRepository.findByRelatedProduct(idth, idcate);
		
			System.out.println("sonnnnne");
			 model.addAttribute("products", products);
		 }

		 
		 List<Product> products = productRepository.findByRelatedProduct(idth, idcate);
		
		model.addAttribute("cart", cartService.getGioHang());
		model.addAttribute("products", products);
        return "demo";
    }

    @Autowired
    ProductRepository productRepository;


	@Autowired
	CategoryRepository categoryRepository;

    @GetMapping("/")
    public String po(Model model) {

    List<Product> productByPanasonic = productRepository.findByTitleContaining();

	List<Product> productByNanoco = productRepository.findByTrade();

	List<Category> categories = categoryRepository.findAll();



	

        model.addAttribute("productByPana", productByPanasonic);
		model.addAttribute("productByNano", productByNanoco);
		model.addAttribute("cate", categories);


		
		long leftLimit = 1L;
    long rightLimit = 100000L;
    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

	System.out.println("testRandom: " +generatedLong );

        return "index";
    }


    @GetMapping("/checkout/success")
    public String oderSuccess(){

        return "ordersuccess";
    }

    private static final int TOI_DA_SAN_PHAM = 1;

    @GetMapping("/product")
    public String listproduct(@RequestParam(name = "sort", defaultValue = "productId") String sortFeild,
			@RequestParam(name = "pageIndex", defaultValue = "0") int pageIndex,
			@RequestParam(name = "sortBy", defaultValue = "ASC") String sortBy, Model model) {

		Sort sortable = null;

		if (sortBy.equals("DESC")) {
			sortable = Sort.by(Sort.Direction.DESC, sortFeild);
		}

		if (sortBy.equals("ASC")) {
			sortable = Sort.by(Sort.Direction.ASC, sortFeild);
		}

		Pageable pager = PageRequest.of(pageIndex, TOI_DA_SAN_PHAM, sortable);

		
		// lấy sản phẩm
		Page<Product> productPage = productRepository.findAll(pager);
		List<ThuongHieu> thuonghieu = trademakeRepository.findAll();
		//category
		List<Category> categories = categoryRepository.findAll();


		model.addAttribute("cate", categories);

		model.addAttribute("thuonghieu", thuonghieu);

		model.addAttribute("countProduct", productPage.getTotalElements());

		model.addAttribute("products", productPage.getContent());
		// truyền vào số lượng page tối đa
		model.addAttribute("maxPage", productPage.getTotalPages());
		model.addAttribute("demo", productPage.getTotalElements());

		// truyền vào page hiện tại
		model.addAttribute("currentPage", productPage.getNumber());

		// truyền vào sắp xếp theo id, name, price
		model.addAttribute("sortName", sortFeild);

		// truyền vào kiểu sắp xếp 
		model.addAttribute("sortDesc", sortBy);

        return "product";
    }


	@GetMapping("/category/{catename}")
    public String listcate(@PathVariable String catename, @RequestParam(name = "sort", defaultValue = "product_id") String sortFeild,
			@RequestParam(name = "pageIndex", defaultValue = "0") int pageIndex,
			@RequestParam(name = "trademake", defaultValue = "") String th,
			@RequestParam(name = "price_min", defaultValue = "0") Long giamin,
			@RequestParam(name = "price_max", defaultValue = "10000000") Long giamax,
			@RequestParam(name = "sortBy", defaultValue = "ASC") String sortBy, Model model, HttpServletRequest request) {

		Sort sortable = null;

		if (sortBy.equals("DESC")) {
			sortable = Sort.by(Sort.Direction.DESC, sortFeild);
		}

		if (sortBy.equals("ASC")) {
			sortable = Sort.by(Sort.Direction.ASC, sortFeild);
		}

		Pageable pager = PageRequest.of(pageIndex, TOI_DA_SAN_PHAM, sortable);

		if (th.equals("")) {
			Page<Product> productPage = productRepository.findCategory(catename,giamin, giamax, pager);

			model.addAttribute("countProduct", productPage.getTotalElements());

		model.addAttribute("products", productPage.getContent());
		// truyền vào số lượng page tối đa
		model.addAttribute("maxPage", productPage.getTotalPages());
		model.addAttribute("demo", productPage.getTotalElements());

		// truyền vào page hiện tại
		model.addAttribute("currentPage", productPage.getNumber());

		
		}else{
			Page<Product> productPage = productRepository.findCategoryAndTrademake(catename,th,giamin, giamax, pager);

			model.addAttribute("countProduct", productPage.getTotalElements());

		model.addAttribute("products", productPage.getContent());
		// truyền vào số lượng page tối đa
		model.addAttribute("maxPage", productPage.getTotalPages());
		model.addAttribute("demo", productPage.getTotalElements());

		// truyền vào page hiện tại
		model.addAttribute("currentPage", productPage.getNumber());

		
		}

		
		
		
		
		List<ThuongHieu> thuonghieu = trademakeRepository.findAll();
		//category
		List<Category> categories = categoryRepository.findAll();


		model.addAttribute("cate", categories);

		model.addAttribute("thuonghieu", thuonghieu);

		

		// truyền vào sắp xếp theo id, name, price
		model.addAttribute("sortName", sortFeild);

		// truyền vào kiểu sắp xếp 
		model.addAttribute("sortDesc", sortBy);

		String test = request.getRequestURL().toString() + "?" + request.getQueryString();

		System.out.println("sss" + test);
		model.addAttribute("requestUrl", test);

        return "category";
    }


	@Autowired
	TrademakeRepository trademakeRepository;

	@GetMapping("/trademake/{name}")
    public String filterByTremak(@PathVariable String name, @RequestParam(name = "price_min", defaultValue = "0") Long giamin,
			@RequestParam(name = "price_max", defaultValue = "10000000") Long giamax,
			@RequestParam(name = "pageIndex", defaultValue = "0") int pageIndex,
			@RequestParam(name = "sortBy", defaultValue = "ASC") String sortBy, Model model) {

		
		Pageable pager = PageRequest.of(pageIndex, TOI_DA_SAN_PHAM);

		// lấy sản phẩm
		Page<Product> productPage = productRepository.findByTradeMake(name, giamin, giamax, pager);

		List<ThuongHieu> thuonghieu = trademakeRepository.findAll();

		List<Category> categories = categoryRepository.findAll();


		model.addAttribute("cate", categories);

		model.addAttribute("thuonghieu", thuonghieu);

		model.addAttribute("countProduct", productPage.getTotalElements());
		model.addAttribute("demo", productPage.getTotalElements());

		model.addAttribute("products", productPage.getContent());
		// truyền vào số lượng page tối đa
		model.addAttribute("maxPage", productPage.getTotalPages());

		// truyền vào page hiện tại
		model.addAttribute("currentPage", productPage.getNumber());

		model.addAttribute("trademaxName", name);
		model.addAttribute("price_min", giamin);
		model.addAttribute("price_max", giamax);

		// truyền vào sắp xếp theo id, name, price
		//model.addAttribute("sortName", sortFeild);

		// truyền vào kiểu sắp xếp 
		model.addAttribute("sortDesc", sortBy);

        return "filter_product";
    }


    // Search product
	@GetMapping("search")
	public String search(@RequestParam(name = "sort", defaultValue = "productId") String sortFeild,
			@RequestParam(name = "pageIndex", defaultValue = "0") int pageIndex,
			// thêm từ khóa tìm kiếm
			@RequestParam(name = "query", defaultValue = "") String productname, 
			@RequestParam(name = "sortBy", defaultValue = "ASC") String sortBy, Model model
			) {

		Sort sortable = null;

		if (sortBy.equals("DESC")) {
			sortable = Sort.by(Sort.Direction.DESC, sortFeild);
		}

		if (sortBy.equals("ASC")) {
			sortable = Sort.by(Sort.Direction.ASC, sortFeild);
		}

		Pageable pager = PageRequest.of(pageIndex, TOI_DA_SAN_PHAM, sortable);
		// lấy sản phẩm
		Page<Product> productPage = productRepository.findByTensanphamContainingIgnoreCase(productname, pager);

		List<ThuongHieu> thuonghieu = trademakeRepository.findAll();

		model.addAttribute("thuonghieu", thuonghieu);

		if (productname.equals("") ) {
			model.addAttribute("demo", 0);
		}else {
			model.addAttribute("demo", productPage.getTotalElements());
		}
		model.addAttribute("searchName", productname);
		model.addAttribute("products", productPage.getContent());
		model.addAttribute("maxPage", productPage.getTotalPages());
		// truyền vào page hiện tại
		model.addAttribute("currentPage", productPage.getNumber());
		
		// truyền vào sắp xếp theo id, name, price
		model.addAttribute("sortName", sortFeild);

		// truyền vào kiểu sắp xếp desc
		model.addAttribute("sortDesc", sortBy);

		return "search";
	}





    
	
    
    

   



  
}
