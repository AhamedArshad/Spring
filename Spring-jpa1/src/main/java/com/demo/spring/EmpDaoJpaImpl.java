package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Emp;

@Repository
@Transactional
public class EmpDaoJpaImpl implements EmpDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		em.persist(e);
		return "persisted emp";
	}

	@Override
	public String delete(int empId) {
		// TODO Auto-generated method stub
		
		Emp e = em.find(Emp.class,empId);
		if(e!= null){
		em.remove(e);
		return "deleted details";
		}
		return "not deleted";
	}

	@Override
	public Emp findById(int id) {
		// TODO Auto-generated method stub
		Emp e= em.find(Emp.class, id);
		return e;
	}

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select e from Emp e");
		List<Emp> empList = query.getResultList();
		return empList;
	}

	@Override
	public String saveSome(List<Emp> emps) {
		// TODO Auto-generated method stub
		
		for(Emp e: emps){
			em.persist(e);
		}
		return "success!!!!!!!!";
	}

}
