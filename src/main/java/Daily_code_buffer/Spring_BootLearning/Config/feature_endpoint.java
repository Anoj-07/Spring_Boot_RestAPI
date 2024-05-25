package Daily_code_buffer.Spring_BootLearning.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class feature_endpoint {
    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap<>();

    //features for endpoint
    public feature_endpoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("user", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    //To create the EndPoint
    public Map<String, Feature> features(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature( @Selector String featureName){
        return featureMap.get(featureName);
    }

    //innner class
    //getter and setter method (lambok)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
