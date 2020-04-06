package com.keywer.article.microprofile.repository;


import com.keywer.article.microprofile.domain.Family;
import com.keywer.article.microprofile.domain.Fish;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class FishRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Fish> getFishs(QueryParameters query) {
        return JPAUtils.queryEntities(entityManager, Fish.class, query);
    }


    public Long getFishsCount(QueryParameters query) {
        return JPAUtils.queryEntitiesCount(entityManager, Fish.class, query);
    }


    //----- NAMED QUERY -----//
    public int countFishByFamily(String familyName) {
        return entityManager.createNamedQuery("Fish.countByFamily", Long.class)
                .setParameter("familyName", familyName)
                .getSingleResult()
                .intValue();
    }

    public Fish findFishByName(String fishName) {
        return entityManager.createNamedQuery("Fish.findByName", Fish.class)
                .setParameter("fishName", fishName)
                .getSingleResult();
    }

    //----- CRITERIA QUERY -----//
    public Family findFamilyByName(String fishFamily) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Family> listCriteria = builder.createQuery(Family.class);
        Root<Family> listRoot = listCriteria.from(Family.class);
        listCriteria.select(listRoot).where(builder.equal(listRoot.get("name"),fishFamily));
        TypedQuery<Family> query = entityManager.createQuery(listCriteria);
        return query.getSingleResult();
    }

    @Transactional
    public void saveFamily(Family family) {
        entityManager.persist(family);
    }
}
