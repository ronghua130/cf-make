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
    public void wheneverPayed_StartMake(@Payload Paid payed){

        if(payed.isMe()){
            System.out.println("##### listener StartMake : " + payed.toJson());

            Make make = new Make();
            make.setOrderId(payed.getOrderId());
            make.setCoffeId(payed.getCoffeeId());
            make.setCoffeName(payed.getCoffeeName());
            make.setPrice(payed.getPrice());
            make.setQty(payed.getQty());
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
