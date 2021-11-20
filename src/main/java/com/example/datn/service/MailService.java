package com.example.datn.service;


import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.datn.models.Order;
import com.example.datn.models.OrderDetail;
import com.example.datn.repository.OrderDetailRepository;
import com.example.datn.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MailService {
   

    @Autowired
	JavaMailSender sender;
	
private List<MimeMessage> mailList = new ArrayList<>();
	
/*
 * public void pushMail(String to) { MimeMessage message =
 * sender.createMimeMessage(); MimeMessageHelper helper = new
 * MimeMessageHelper(message); try {
 * helper.setFrom("Thanh Son <sonthanh111@outlook.com>"); helper.setTo(to);
 * helper.setSubject("Thank you"); helper.setText("Đặt hàng thành công."); }
 * catch (MessagingException e) {
 * System.out.println("Không thể thêm mail vào hàng đợi"); e.printStackTrace();
 * } mailList.add(message); }
 */
	
	
	

	public void sendMailWithResetPassword(String email, String urlRest) {

		// lay data
		

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);


        String content = "<p>Hello,</p>"
            + "<p>You have requested to reset your password.</p>"
            + "<p>Click the link below to change your password:</p>"
            + "<p><a href=\"" + urlRest + "\">Change my password</a></p>"
            + "<br>"
            + "<p>Ignore this email if you do remember your password, "
            + "or you have not made the request.</p>";
		try {
			
			helper.setFrom("Thanh Son <sondtpk01429@fpt.edu.vn>");
			helper.setTo(email);
			helper.setSubject("Thank you");
			helper.setText(content, true);
		} catch (MessagingException e) {
			System.out.println("Không thể thêm mail vào hàng đợi");
			e.printStackTrace();
		}
		mailList.add(message);
		// Send Message!
		this.sender.send(message);

	}


	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	public void sendMailWithOrderId(Long orderId) {

		// lay data
		Order order = orderRepository.getById(orderId);
		List<OrderDetail> orderItems = orderDetailRepository.findOrderItems(orderId);

		// tao noi dung
		String content = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>Document</title>\n" + "</head>\n" + "<body>\n"
				+ "    <div style= \"background: #FFDDC4;padding : 20px; margin : 20px;\">\n"
				+ "	   <p style= \"font-size:26px;\" >\"Begin your own tradition\" : Hãy tạo nên truyền thống của riêng bạn.</p>\n	"
				+ "        <h1 style= \"color: red;\">Thông tin đơn hàng</h1>\n" + "<p style= \"color: red;\">\n" + "Tên Người Nhận : <b>"
				+ order.getCustomer().getHoten() + "</b>\n" + "  </p>\n" + "<p style= \"color: red;\">\n" + " Số điện thoại: <b>"
				+ order.getCustomer().getSdt() + "</b>\n" + "</p>\n" + "<p style= \"color: red; \">\n" + "Địa chỉ nhận hàng : <b>"
				+ order.getAddress() + "</b>\n" + "</p>\n" + " <p style= \"color: red;\">\n" + "Mã đặt hàng : <b>"
				+ "#"+order.getOrderId() + "</b>\n" + " </p>\n" + " <p style= \"color: red;\">\n" + "Sản phẩm đã đặt : </p>\n";

		for (int i = 0; i < orderItems.size(); i++) {
			OrderDetail orderItem = orderItems.get(i);
			content = content + " <p style= \"color: black;\">\n- " + orderItem.getProduct().getTensanpham() + " :  <b>" + orderItem.getPrice()
					+ "VND</b>  <i>(x " + orderItem.getQuantity() + ")</i>\n        </p>\n        " + "</p>\n";
		}
		content += "<p style= \"padding-left:800px; font-size:18px;\">\n" + "Tổng tiền : <b>" + order.getTotal() + "</b>\n" + "  </p>\n" + "    </div>\n"
				+ "</body>\n" + "</html>";

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			
			helper.setFrom("Thanh Son <sondtpk01429@fpt.edu.vn>");
			helper.setTo(order.getCustomer().getUser().getEmail());
			helper.setSubject("Thank you");
			helper.setText(content, true);
		} catch (MessagingException e) {
			System.out.println("Không thể thêm mail vào hàng đợi");
			e.printStackTrace();
		}
		mailList.add(message);
		// Send Message!
		this.sender.send(message);

	}
	
	@Scheduled(fixedDelay = 2000)
	public void run() {
		while (!mailList.isEmpty()) {
			MimeMessage message = mailList.remove(0);
			try {
				sender.send(message);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print("gui mail loi");
				e.printStackTrace();
			}
		}
	}
    
}
