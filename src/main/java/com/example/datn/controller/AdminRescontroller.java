package com.example.datn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.example.datn.models.Customer;
import com.example.datn.models.NhaCungCap;
import com.example.datn.models.Order;
import com.example.datn.models.OrderDetail;
import com.example.datn.models.Product;
import com.example.datn.models.SearchForm;
import com.example.datn.models.ThuongHieu;
import com.example.datn.models.User;
import com.example.datn.repository.CustomerRepository;
import com.example.datn.repository.OrderDetailRepository;
import com.example.datn.repository.OrderRepository;
import com.example.datn.repository.ProductRepository;
import com.example.datn.repository.SupplierRepository;
import com.example.datn.repository.TrademarkRepository;
import com.example.datn.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRescontroller {


    @Autowired
    ProductRepository productRepository;


    @Autowired
    TrademarkRepository trademarkRepository;

    @Autowired
    SupplierRepository supplierRepository;
    

    private static final int TOI_DA_SAN_PHAM = 6;
	@PostMapping("api/product/search")
    public Page<Product> search(
            // thông tin form tìm kiếm
            @RequestBody SearchForm sf) {

        Pageable phanTrang = PageRequest.of(sf.getTrang(), TOI_DA_SAN_PHAM,
                // nếu đúng thì thứ tự tăng đần ngược lại giảm dần
                sf.getThuTu() ? Direction.DESC : Direction.ASC,
                // xếp theo trường nào ví dụ id, name, price
                sf.getXepTheo());

        // lấy sản phẩm
        Page<Product> productPage = productRepository.findByTensanphamContainingIgnoreCase(sf.getTen(), phanTrang);

        return productPage;
    }

    @GetMapping("/api/products/{id}")
	public Product getById(@PathVariable("id") int id) {
		return productRepository.findById(id).orElse(null);
	}


    //edit product
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/products/{id}")
    public Product update(@PathVariable("id") int id, @RequestBody Product product) {
        return productRepository.save(product);
    }


    //delete product
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/products/{id}")
	public void delete(@PathVariable("id") int id) {
		productRepository.deleteById(id);
	}


    @GetMapping("/api/thuonghieu")
	public List<ThuongHieu> thuongHieu() {
		return trademarkRepository.findAll();
	}


    @GetMapping("/api/nhacungcap")
	public List<NhaCungCap> list() {
		return supplierRepository.findAll();
	}




    //customer

    @Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/api/khachhang")
	public List<Customer> listcus() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/api/khachhang/{id}")
	public Customer getByCustomerId(@PathVariable("id") int id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	@PostMapping(value = "/api/khachhang")
    public HashMap<String, Object> insert(@RequestBody @Validated Customer customer, BindingResult result) {

        HashMap<String, Object> ResponseData = new HashMap<>();
        ResponseData.put("status", true);

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();

            HashMap<String, String> ListValid = new HashMap<>();

            for (FieldError error : fieldErrors) {
                ListValid.put(error.getField(), error.getDefaultMessage());
            }

            ResponseData.put("status", false);
            ResponseData.put("data", ListValid);

            return ResponseData;

        }
        ResponseData.put("data", customerRepository.save(customer));

        return ResponseData;
    }
	
	@PutMapping("/api/khachhang/{id}")
    public Customer update(@PathVariable("id") int id, @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
	
	@DeleteMapping("/api/khachhang/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		customerRepository.deleteById(id);
	}
	
	@PostMapping("api/khachhang/search")
    public Page<Customer> searchCustomer(
            // thông tin form tìm kiếm
            @RequestBody SearchForm sf) {

        Pageable phanTrang = PageRequest.of(sf.getTrang(), TOI_DA_SAN_PHAM,
                // nếu đúng thì thứ tự tăng đần ngược lại giảm dần
                sf.getThuTu() ? Direction.ASC : Direction.DESC,
                // xếp theo trường nào ví dụ id, name, price
                sf.getXepTheo());

        // lấy sản phẩm
        Page<Customer> customerPage = customerRepository.findByHotenContaining(sf.getTen(), phanTrang);

        return customerPage;
    }



    //user
    @Autowired
  	UserRepository userRepository;
  	
  	@GetMapping("/api/users")
  	public List<User> listUser() {
  		return userRepository.findAll();
  	}
  	
  	@GetMapping("/api/users/{id}")
  	public User getById(@PathVariable("id") long id) {
  		return userRepository.findById(id).orElse(null);
  	}
  	
  	@PostMapping(value = "/api/users")
      public HashMap<String, Object> insert(@RequestBody @Validated User user, BindingResult result) {

          HashMap<String, Object> ResponseData = new HashMap<>();
          ResponseData.put("status", true);

          if (result.hasErrors()) {
              List<FieldError> fieldErrors = result.getFieldErrors();

              HashMap<String, String> ListValid = new HashMap<>();

              for (FieldError error : fieldErrors) {
                  ListValid.put(error.getField(), error.getDefaultMessage());
              }

              ResponseData.put("status", false);
              ResponseData.put("data", ListValid);

              return ResponseData;

          }
          ResponseData.put("data", userRepository.save(user));

          return ResponseData;
      }
  	
  	@PutMapping("/api/users/{id}")
      public User update(@PathVariable("id") int id, @RequestBody User user) {
          return userRepository.save(user);
      }
  	
  	@DeleteMapping("/api/users/{id}")
  	public void delete(@PathVariable("id") long id) {
  		userRepository.deleteById(id);
  	}
  	
  	@PostMapping("api/users/search")
      public Page<User> searchUser(
              // thông tin form tìm kiếm
              @RequestBody SearchForm sf) {

          Pageable phanTrang = PageRequest.of(sf.getTrang(), TOI_DA_SAN_PHAM,
                  // nếu đúng thì thứ tự tăng đần ngược lại giảm dần
                  sf.getThuTu() ? Direction.ASC : Direction.DESC,
                  // xếp theo trường nào ví dụ id, name, price
                  sf.getXepTheo());

          // lấy sản phẩm
          Page<User> userPage = userRepository.findByUsernameContaining(sf.getTen(), phanTrang);

          return userPage;
      }



      @Autowired
      OrderRepository orderRepository;

      @PostMapping("api/order/search")
      public Page<Order> searchOrder(
              // thông tin form tìm kiếm
              @RequestBody SearchForm sf) {

          Pageable phanTrang = PageRequest.of(sf.getTrang(), TOI_DA_SAN_PHAM,
                  // nếu đúng thì thứ tự tăng đần ngược lại giảm dần
                  sf.getThuTu() ? Direction.ASC : Direction.DESC,
                  // xếp theo trường nào ví dụ id, name, price
                  sf.getXepTheo());

          // lấy sản phẩm
          Page<Order> orderPage = orderRepository.findByPhoneNumberContaining(sf.getTen(), phanTrang);

          return orderPage;
      }




      @Autowired
      OrderDetailRepository orderDetailRepository;




      //order detail
      @GetMapping("/api/orderdetail/{id}")
  	public List<OrderDetail> getByOrderDetail(@PathVariable("id") long id) {
  		
        
        return orderDetailRepository.findOrderItems(id);
  	}






    
}



