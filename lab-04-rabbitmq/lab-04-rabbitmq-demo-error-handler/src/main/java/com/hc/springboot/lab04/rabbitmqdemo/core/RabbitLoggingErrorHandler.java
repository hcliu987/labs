package com.hc.springboot.lab04.rabbitmqdemo.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class RabbitLoggingErrorHandler implements ErrorHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void handleError(Throwable t) {
        logger.error("[handleError][发生异常]", t);
    }
}
