package com.systemsale.systemsale.repository.jpa.custom.customer;

import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.repository.jpa.custom.RepositoryException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerUSPRepositoryImpl implements ICustomerUSPRepository {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Boolean insert(Customer customer) throws RepositoryException {
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("customers.insert");
            spq.setParameter("P_FIRST_NAME", customer.getFirstName());
            spq.setParameter("P_LAST_NAME", customer.getLastName());
            spq.setParameter("P_DNI", customer.getDni());
            spq.setParameter("P_TELEPHONE", customer.getTelephone());
            spq.setParameter("P_EMAIL", customer.getEmail());
            spq.execute();
            return true;
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<Customer> find(Customer customer) throws RepositoryException {
        try {
            StoredProcedureQuery spq = this.em.createNamedStoredProcedureQuery("customers.find");
            spq.setParameter("P_DNI", customer.getDni());
            if (spq.execute()) {
                @SuppressWarnings("unchecked")
                List<Customer> lst = (List<Customer>) spq.getResultList();
                return lst;
            }
            return null;
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }
}
