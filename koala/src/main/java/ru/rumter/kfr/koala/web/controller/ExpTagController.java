package ru.rumter.kfr.koala.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rumter.kfr.koala.web.domain.criteria.ExpTagCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpTagDTO;
import ru.rumter.kfr.koala.web.domain.service.ExpTagServiceDTO;
import ru.rumter.kfr.koala.web.helper.ResponseMap;
import ru.rumter.kfr.koala.web.helper.ResponseUtils;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/expTag")
@Controller
public class ExpTagController extends AbstractController {

    @Autowired
    ExpTagServiceDTO expTagServiceDTO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMap list(ExpTagCriteriaDTO expTagCriteriaDTO) {
        Map<String, Object> m = new HashMap<>();
        m.put("total", expTagServiceDTO.countByCriteria(expTagCriteriaDTO));
        m.put("items", expTagServiceDTO.findByCriteria(expTagCriteriaDTO));
        return ResponseUtils.successResponse(m);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap save(ExpTagDTO expTagDTO) {
        expTagServiceDTO.save(expTagDTO);
        return ResponseUtils.successResponse();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap delete(Long id) {
        expTagServiceDTO.delete(id);
        return ResponseUtils.successResponse();
    }

}