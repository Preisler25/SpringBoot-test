package com.example.demo.op;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OperationService {

    @Autowired
    private OpRepository opRepository;

    public List<Operations> getAllOp(){
        List<Operations> ops = new ArrayList<>();
        opRepository.findAll().forEach(ops::add);
        return ops;
    }

    public Optional<Operations> getOperations(Long id){
        return opRepository.findById(id);
    }

    public void createOperation(Operations operations){
        opRepository.save(operations);
    }

    public void updateOperation(Long id, Operations operations) {
        opRepository.save(operations);
    }

    public void deleteOperation(Operations operations){
        opRepository.delete(operations);
    }

}
