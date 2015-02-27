package ru.rumter.kfr.koala.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rumter.kfr.koala.web.domain.criteria.ExpenseCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpenseDTO;
import ru.rumter.kfr.koala.web.domain.service.ExpenseServiceDTO;
import ru.rumter.kfr.koala.web.helper.ResponseMap;
import ru.rumter.kfr.koala.web.helper.ResponseUtils;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/expense", produces = "application/json")
@Controller
public class ExpenseController extends AbstractController {

    @Autowired
    ExpenseServiceDTO expenseServiceDTO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMap list(ExpenseCriteriaDTO expenseCriteriaDTO) {
        Map<String, Object> m = new HashMap<>();
        m.put("total", expenseServiceDTO.countByCriteria(expenseCriteriaDTO));
        m.put("items", expenseServiceDTO.findByCriteria(expenseCriteriaDTO));
        return ResponseUtils.successResponse(m);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap save(ExpenseDTO expenseDTO) {
        expenseServiceDTO.save(expenseDTO);
        return ResponseUtils.successResponse();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap delete(Long id) {
        expenseServiceDTO.delete(id);
        return ResponseUtils.successResponse();
    }

}
