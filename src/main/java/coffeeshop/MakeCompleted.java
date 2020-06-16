package coffeeshop;

public class MakeCompleted extends AbstractEvent {

    private Long makeId;
    private Long orderId;
    private Long coffeeId;
    private String coffeeName;
    private Float price;
    private String status;
    private Integer qty;

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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
