package org.sibsutis.is.database.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sibsutis.is.database.model.entity.MilitaryID;

@Stateless
@Named("militaryID")
public class MilitaryIDFacade extends AbstractFacade<MilitaryID, Long>
{

      @PersistenceContext(unitName = "SIBSUTIS_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public MilitaryIDFacade()
    {
        super(MilitaryID.class);
    }

}
