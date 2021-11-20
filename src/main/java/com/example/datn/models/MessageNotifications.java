package com.example.datn.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="thongbao")
public class MessageNotifications {
    
    @Id
    @GeneratedValue
    private Long NotificationsId;



    @NotNull
	private Date createdDate = new Date((new java.util.Date()).getTime());

    @NotNull
    private Long orderId;

    public MessageNotifications() {
    }

    public MessageNotifications(Long notificationsId, @NotNull Date createdDate, @NotNull Long orderId) {
        NotificationsId = notificationsId;
        this.createdDate = createdDate;
        this.orderId = orderId;
    }

    public Long getNotificationsId() {
        return NotificationsId;
    }

    public void setNotificationsId(Long notificationsId) {
        NotificationsId = notificationsId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    
    
}
