package org.sibsutis.is.database.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import org.sibsutis.is.database.model.entity.Education;

@Stateless
@Named("education")
public class EducationFacade extends AbstractFacade<Education, Long>
{

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public EducationFacade()
    {
        super(Education.class);
    }

}
