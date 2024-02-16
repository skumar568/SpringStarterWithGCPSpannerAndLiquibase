package in.skumar568.springboot.gcp.message;

import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import in.skumar568.springboot.gcp.config.ChannelConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;

//@Component
@Slf4j
public class MessageConsumer {
    @ServiceActivator(inputChannel = ChannelConsumerConfig.TEST_SUB_CHANNEL)
    public void consume(
            String payload,
            @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
        log.info(
                "Message received headers={} payload={}",
                message.getPubsubMessage().getAttributesMap(),
                payload);
        // manual ack
        message.ack();
    }
}
