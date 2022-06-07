package com.nttdata.bc19.msclientbusiness.service.impl;

import com.nttdata.bc19.msclientbusiness.model.BusinessClient;
import com.nttdata.bc19.msclientbusiness.repository.IBusinessClientRepository;
import com.nttdata.bc19.msclientbusiness.service.IBusinessClientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class BusinessClientServiceImpl implements IBusinessClientService {
    @Autowired
    IBusinessClientRepository iBusinessClientRepository;

    @Override
    public Mono<BusinessClient> create(BusinessClient businessClient) {

        businessClient.setId(new ObjectId().toString());
        businessClient.setCreatedAt(LocalDateTime.now());
        return iBusinessClientRepository.save(businessClient);
    }

    @Override
    public Mono<BusinessClient> update(BusinessClient businessClient) {

        businessClient.setUpdatedAt(LocalDateTime.now());
        return iBusinessClientRepository.save(businessClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<BusinessClient> findById(String id) {
        return iBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<BusinessClient> findAll() {
        return iBusinessClientRepository.findAll();
    }
}
