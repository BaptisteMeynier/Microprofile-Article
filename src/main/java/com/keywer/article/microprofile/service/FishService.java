package com.keywer.article.microprofile.service;


import com.keywer.article.microprofile.repository.FishRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FishService {

    @Inject
    private FishRepository fishRepository;

    public int countByFamily(String fishFamily) {
        return fishRepository.countFishByFamily(fishFamily);
    }


}
