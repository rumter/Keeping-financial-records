package ru.rumter.kfr.koala.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rumter.kfr.koala.web.domain.criteria.IncomeCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.IncomeDTO;
import ru.rumter.kfr.koala.web.domain.service.IncomeServiceDTO;
import ru.rumter.kfr.koala.web.helper.ResponseMap;
import ru.rumter.kfr.koala.web.helper.ResponseUtils;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/income", produces = "application/json")
@Controller
public class IncomeController extends AbstractController {

    @Autowired
    IncomeServiceDTO incomeServiceDTO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMap list(IncomeCriteriaDTO incomeCriteriaDTO) {
        Map<String, Object> m = new HashMap<>();
        m.put("total", incomeServiceDTO.countByCriteria(incomeCriteriaDTO));
        m.put("items", incomeServiceDTO.findByCriteria(incomeCriteriaDTO));
        return ResponseUtils.successResponse(m);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap save(IncomeDTO incomeDTO) {
        incomeServiceDTO.save(incomeDTO);
        return ResponseUtils.successResponse();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap delete(Long id) {
        incomeServiceDTO.delete(id);
        return ResponseUtils.successResponse();
    }

}