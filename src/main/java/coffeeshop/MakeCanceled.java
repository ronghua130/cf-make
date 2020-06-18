package coffeeshop;

public class MakeCanceled extends AbstractEvent {

    private Long makeIid;
    private Long orderId;
    private Float price;
    private Integer qty;
    private Long coffeeId;
    private String coffeeName;
    private String makeStatus;

    public MakeCanceled(){
        super();
    }

    public Long getMakeId() {
        return makeIid;
    }

    public void setMakeId(Long makeIid) {
        this.makeIid = makeIid;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public String getMakeStatus() {
        return makeStatus;
    }

    public void setMakeStatus(String makeStatus) {
        this.makeStatus = makeStatus;
    }

}
