package ru.rumter.kfr.koala.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.rumter.kfr.koala.web.helper.ResponseMap;
import ru.rumter.kfr.koala.web.helper.ResponseUtils;

public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseMap exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseUtils.errorResponse(e);
    }

}