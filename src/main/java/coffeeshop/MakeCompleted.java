package coffeeshop;

public class MakeCompleted extends AbstractEvent {

    private Long makeId;
    private Long orderId;
    private Long coffeeId;
    private String coffeeName;
    private Float price;
    private Integer qty;
    private String orderStatus;
    private String paymentStatus;
    private String makeStatus;
    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    private Float totalAmount;
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public String getMakeStatus() {
        return makeStatus;
    }

    public void setMakeStatus(String makeStatus) {
        this.makeStatus = makeStatus;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public MakeCompleted(){
        super();
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMakeId() {
        return makeId;
    }
    public void setMakeId(Long makeId) {
        this.makeId = makeId;
    }

    public Long getCoffeeId() {
        return coffeeId;
    }
    public void setCoffeeId(Long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }
    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
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
