package com.example.demo.op;


import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OperationController {

    @Autowired
    private OperationService operationService;


    @RequestMapping("/op")
    public List<Operations> getAll(){
        return operationService.getAllOp();
    }
    @RequestMapping("/op/{id}")
    public Optional<Operations> getOne(@PathVariable Long id){
        return operationService.getOperations(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/op")
    public void create(@RequestBody Operations operations){
        operationService.createOperation(operations);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/op/{id}")
    public void update(@PathVariable Long id, @RequestBody Operations operations){
        operationService.updateOperation(id, operations);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/op/{id}")
    public void delete(@PathVariable Long id, @RequestBody Operations operations){
        operationService.deleteOperation(operations);
    }
}
