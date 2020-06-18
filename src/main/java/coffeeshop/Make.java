package coffeeshop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Make_table")
public class Make {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long makeId;
    private Long orderId;
    private Long coffeeId;
    private String coffeeName;
    private Float price;
    private Integer qty;

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    private Float totalAmount;
    private String orderStatus;
    private String paymentStatus;
    private String makeStatus;

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }



    public String getMakeStatus() {
        return makeStatus;
    }

    public void setMakeStatus(String makeStatus) {
        this.makeStatus = makeStatus;
    }


    @PostPersist
    public void onPostPersist(){
        MakeStarted makeStarted = new MakeStarted();
        BeanUtils.copyProperties(this, makeStarted);
        makeStarted.setOrderId(this.getOrderId());
        makeStarted.setMakeId(this.getMakeId());
        makeStarted.setTotalAmount(this.getTotalAmount());
        makeStarted.setOrderStatus(this.getOrderStatus());
        makeStarted.setPaymentStatus(this.getPaymentStatus());
        makeStarted.setMakeStatus(this.getMakeStatus());
        makeStarted.publishAfterCommit();

    }

    @PostUpdate
    public void onPostUpdate(){
        if(this.getMakeStatus().equals("completed")) {
            MakeCompleted makeCompleted = new MakeCompleted();
            BeanUtils.copyProperties(this, makeCompleted);
            makeCompleted.setOrderId(this.getOrderId());
            makeCompleted.setMakeId(this.getMakeId());
            makeCompleted.setOrderStatus(this.getOrderStatus());
            makeCompleted.setPaymentStatus(this.getPaymentStatus());
            makeCompleted.setMakeStatus("Make Completed");
            makeCompleted.publishAfterCommit();
        }
    }

    @PreRemove
    public void onPreRemove(){
        MakeCanceled makeCanceled = new MakeCanceled();
        BeanUtils.copyProperties(this, makeCanceled);
        makeCanceled.setMakeStatus("Make Canceled");
        makeCanceled.publishAfterCommit();
    }

    public Long getMakeId() {
        return makeId;
    }
    public void setMakeId(Long makeId) {
        this.makeId = makeId;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeId(Long coffeId) {
        this.coffeeId = coffeId;
    }
    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeName(String coffeName) {
        this.coffeeName = coffeName;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }





}
