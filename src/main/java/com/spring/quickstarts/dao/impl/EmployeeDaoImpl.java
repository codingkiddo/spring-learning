package com.spring.quickstarts.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.TransactionManager;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.quickstarts.dao.AbstractDao;
import com.spring.quickstarts.dao.EmployeeDao;
import com.spring.quickstarts.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
 
	@Autowired
	private EntityManagerFactory emf;
	
//	@PersistenceUnit
//	private EntityManagerFactory emf;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private TransactionManager transactionManagerName;
	
    public Employee findById(int id) {
        return getByKey(id);
    }
 
//    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployee(Employee employee) {
    	Transaction transaction = this.getSession().getTransaction();
        System.out.println("transaction.isActive()->" + transaction.isActive());
        System.out.println("&&&&&&&&&&&&&&&&&&&&& ------------ emf: " + emf);
    	System.out.println("&&&&&&&&&&&&&&&&&&&&& ------------ em: " + em);
    	System.out.println("&&&&&&&&&&&&&&&&&&&&& ------------ transactionManagerName: " + transactionManagerName);
        persist(employee);
    }
 
    @SuppressWarnings("unchecked")
//    @Transactional
    public List<Employee> findAllEmployees() {
    	System.out.println("&&&&&&&&&&&&&&&&&&&&& ------------ emf: " + emf);
    	System.out.println("&&&&&&&&&&&&&&&&&&&&& ------------ em: " + em);
    	System.out.println(this);
        CriteriaQuery<Employee> criteriaQuery = createEntityCriteria();
        Root<Employee> root = criteriaQuery.from(Employee.class);
        CriteriaQuery<Employee> all = criteriaQuery.select(root);
        TypedQuery<Employee> allQuery = this.getSession().createQuery(all);
        Transaction transaction = this.getSession().getTransaction();
        System.out.println(transaction.isActive());
        return allQuery.getResultList();
    }
 
}