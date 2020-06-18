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
    private String status;


    @PostPersist
    public void onPostPersist(){
        MakeStarted makeStarted = new MakeStarted();
        BeanUtils.copyProperties(this, makeStarted);
        makeStarted.setMakeId(this.getMakeId());
        makeStarted.setStatus("Make Started");
        makeStarted.publishAfterCommit();

    }

    @PostUpdate
    public void onPostUpdate(){
        if(this.getStatus().equals("completed")) {
            MakeCompleted makeCompleted = new MakeCompleted();
            BeanUtils.copyProperties(this, makeCompleted);
            makeCompleted.setMakeId(this.getMakeId());
            makeCompleted.setStatus("Make Completed");
            makeCompleted.publishAfterCommit();
        }
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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
