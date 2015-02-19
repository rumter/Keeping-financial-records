package ru.rumter.kfr.koala.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rumter.kfr.koala.web.domain.criteria.ExpCategoryCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpCategoryDTO;
import ru.rumter.kfr.koala.web.domain.service.ExpCategoryServiceDTO;
import ru.rumter.kfr.koala.web.helper.ResponseMap;
import ru.rumter.kfr.koala.web.helper.ResponseUtils;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/expCategory")
@Controller
public class ExpCategoryController {

    @Autowired
    ExpCategoryServiceDTO expCategoryServiceDTO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMap list(ExpCategoryCriteriaDTO expCategoryCriteriaDTO) {
        Map<String, Object> m = new HashMap<>();
        m.put("total", expCategoryServiceDTO.countByCriteria(expCategoryCriteriaDTO));
        m.put("items", expCategoryServiceDTO.findByCriteria(expCategoryCriteriaDTO));
        return ResponseUtils.successResponse(m);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap save(ExpCategoryDTO expCategoryDTO) {
        expCategoryServiceDTO.save(expCategoryDTO);
        return ResponseUtils.successResponse();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap delete(Long id) {
        expCategoryServiceDTO.delete(id);
        return ResponseUtils.successResponse();
    }

}