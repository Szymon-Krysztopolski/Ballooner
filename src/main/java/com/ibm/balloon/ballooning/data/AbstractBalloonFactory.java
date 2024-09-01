package com.ibm.balloon.ballooning.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@DependsOn("balloonStrategyConfig")
public class AbstractBalloonFactory {
    private final Map<BalloonStrategyEnum, BalloonFactory> factoryMap = new HashMap<>();

    public BalloonFactory getFactory(BalloonStrategyEnum strategyEnum) throws IOException {
        BalloonRandom.INSTANCE.reset();

        if (!factoryMap.containsKey(strategyEnum)) {
            log.info("[AbstractBalloonFactory] Adding factory for {}...", strategyEnum);
            factoryMap.put(strategyEnum, new BalloonFactory(strategyEnum));
            log.info("[AbstractBalloonFactory] Factory added successfully");
        }

        return factoryMap.get(strategyEnum);
    }
}
