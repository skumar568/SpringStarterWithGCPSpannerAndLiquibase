package in.skumar568.springboot.gcp;

import in.skumar568.springboot.gcp.config.ChannelProducerConfig;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
public class PubSubUtility {

    private final ChannelProducerConfig.PublishRecordToTestTopicGateway publishRecordToTestTopicGateway;

    public PubSubUtility(ChannelProducerConfig.PublishRecordToTestTopicGateway publishRecordToTestTopicGateway) {
        this.publishRecordToTestTopicGateway = publishRecordToTestTopicGateway;
    }

    public void publishRecordToPubSub(Object obj) throws Exception{
        try {
            this.publishRecordToTestTopicGateway.sendMessage(obj);
        }catch(Exception e) {
            log.error("exception occured in publishRecordMcT5g2FileMessageToPubSub for object: [{}] exception: [{}]", obj, e);
            throw new Exception("Unable to publish messages on topic using pubSubSpringIntegration");
        }
    }
}
