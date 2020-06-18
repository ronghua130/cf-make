package coffeeshop;

import coffeeshop.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    MakeRepository makeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayed_StartMake(@Payload Paid paid){

        if(paid.isMe()){
            System.out.println("##### listener StartMake : " + paid.toJson());

            Make make = new Make();
            make.setOrderId(paid.getOrderId());
            make.setCoffeId(paid.getCoffeeId());
            make.setCoffeName(paid.getCoffeeName());
            make.setPrice(paid.getPrice());
            make.setQty(paid.getQty());
            make.setTotalAmount(paid.getTotalAmount());
            make.setOrderStatus(paid.getOrderStatus());
            make.setPaymentStatus(paid.getPaymentStatus());
            make.setMakeStatus("Make Started");
            makeRepository.save(make);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_CancelMake(@Payload PayCanceled payCanceled){

        if(payCanceled.isMe()){
            System.out.println("##### listener CancelMake : " + payCanceled.toJson());

            // cancel건 삭제
            Make make = new Make();
            int result = makeRepository.deleteByOrderId(payCanceled.getOrderId());
            System.out.println("cancelMake result : "  + result);

        }

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void onEvent(@Payload String message) { }

}
