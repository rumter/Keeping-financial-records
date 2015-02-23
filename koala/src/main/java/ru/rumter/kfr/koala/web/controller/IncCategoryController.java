package ru.rumter.kfr.koala.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rumter.kfr.koala.web.domain.criteria.IncCategoryCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.IncCategoryDTO;
import ru.rumter.kfr.koala.web.domain.service.IncCategoryServiceDTO;
import ru.rumter.kfr.koala.web.helper.ResponseMap;
import ru.rumter.kfr.koala.web.helper.ResponseUtils;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/incCategory", produces = "application/json")
@Controller
public class IncCategoryController extends AbstractController {

    @Autowired
    IncCategoryServiceDTO incCategoryServiceDTO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMap list(IncCategoryCriteriaDTO incCategoryCriteriaDTO) {
        Map<String, Object> m = new HashMap<>();
        m.put("total", incCategoryServiceDTO.countByCriteria(incCategoryCriteriaDTO));
        m.put("items", incCategoryServiceDTO.findByCriteria(incCategoryCriteriaDTO));
        return ResponseUtils.successResponse(m);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap save(IncCategoryDTO incCategoryDTO) {
        incCategoryServiceDTO.save(incCategoryDTO);
        return ResponseUtils.successResponse();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap delete(Long id) {
        incCategoryServiceDTO.delete(id);
        return ResponseUtils.successResponse();
    }

}