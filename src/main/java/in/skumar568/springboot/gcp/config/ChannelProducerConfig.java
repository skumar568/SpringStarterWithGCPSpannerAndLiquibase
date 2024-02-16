package in.skumar568.springboot.gcp.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import com.google.cloud.spring.pubsub.core.subscriber.PubSubSubscriberTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.util.concurrent.ListenableFutureCallback;

//@Configuration
@Slf4j
public class ChannelProducerConfig {
    @Bean
    public DirectChannel pubSubOutputChannel() {
        return new DirectChannel();
    }

    @Bean
    public PubSubTemplate pubSubTemplate(PubSubPublisherTemplate pubSubPublisherTemplate,
                                         PubSubSubscriberTemplate pubSubSubscriberTemplate) {
        return new PubSubTemplate(pubSubPublisherTemplate, pubSubSubscriberTemplate);
    }

    /**
     * @param pubSubTemplate topic McT5g2File
     * @return
     * @throws Exception
     */
    @Bean
    @ServiceActivator(inputChannel = "test-topic")
    public MessageHandler publishRecordToTestTopic(PubSubTemplate pubSubTemplate)throws Exception{
        PubSubMessageHandler adapter = new PubSubMessageHandler(pubSubTemplate,"test-topic");
        adapter.setPublishCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to publish messages on topic [{}] using pubSubSpringIntegration:  [{}]","test-topic",ex);
            }

            @Override
            public void onSuccess(String result) {
                log.info("Message was sent successfully on topic: [{}]","test-topic");
            }
        });
        return adapter;
    }

    /**
     * an interface that allows sending a Object to Pub/Sub.
     */
    @MessagingGateway(defaultRequestChannel = "test-topic")
    public interface PublishRecordToTestTopicGateway {
        void sendMessage(Object message);
    }

    @Bean
    public JacksonPubSubMessageConverter jacksonPubSubMessageConverter(ObjectMapper objectMapper) {
        return new JacksonPubSubMessageConverter(objectMapper);
    }
}
