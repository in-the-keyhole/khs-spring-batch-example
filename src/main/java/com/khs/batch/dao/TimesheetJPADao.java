package com.khs.batch.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.khs.batch.model.Timesheet;
import com.khs.dao.sql.JPABaseDao;

@Component
@Configurable
public class TimesheetJPADao extends JPABaseDao<Timesheet, Long> {

	public void delete(long id) {

		super.remove(Timesheet.class, id, null);

	}

	public List<Timesheet> timesheetsForWeek(long empid, long custid, Date week) {

		Query query = entityManager.createQuery("select ts from Timesheet ts where ts.employee.id = ? and ts.customer.id = ? and ts.week = ?");
		query.setParameter(1, empid);
		query.setParameter(2, custid);
		query.setParameter(3, week);

		return query.getResultList();

	}

	public List<Timesheet> findEmployeeHasTimesheet(String email, Date week) {

		Query query = entityManager.createQuery("select ts from Timesheet ts where  ts.employee.email = ? and ts.week = ?");
		query.setParameter(1, email);
		query.setParameter(2, week);
		return query.getResultList();

	}

	public List<Timesheet> findApproved() {

		Query query = entityManager.createQuery("select ts from Timesheet ts where ts.approved = ? and ts.submitted = ? order by ts.week desc,ts.customer.name,ts.employee.lastName,ts.employee.firstName");
		query.setParameter(1, true);
		query.setParameter(2, true);
		return query.getResultList();

	}

	public List<Timesheet> findAll() {

		Query query = entityManager.createQuery("select ts from Timesheet ts order by company,week");
		// query.setParameter(1, true);
		// query.setParameter(2, true);
		return query.getResultList();

	}

	public List<Timesheet> findNotApproved() {

		Query query = entityManager.createQuery("select ts from Timesheet ts where ts.approved = ? and ts.submitted = ? order by ts.week desc,ts.customer.name,ts.employee.lastName,ts.employee.firstName");
		query.setParameter(1, false);
		query.setParameter(2, true);
		return query.getResultList();

	}

	public List<Timesheet> search(Long customerId, Long employeeId, String week, String status) {

		String sql = "select ts from Timesheet ts ";
		String where = " where ";
		boolean connect = false;

		if (customerId != null) {
			connect = true;
			where += " ts.customer.id = :customer";
		}

		if (employeeId != null) {

			if (connect) {
				where += " and ";
			}
			connect = true;
			where += " ts.employee.id = :employee";
		}

		if (week != null) {

			if (connect) {
				where += " and ";
			}
			connect = true;
			where += " ts.week = :week ";
		}

		if (status != null) {

			if (connect) {
				where += " and ";
			}
			connect = true;
			where += " ts.approved = :status ";
		}

		// and ts.employee.id = ? order by ts.week desc,ts.customer.name,ts.employee.lastName,ts.employee.firstName";

		Query query = entityManager.createQuery(sql + (connect ? where : ""));
		if (customerId != null) {
			query.setParameter("customer", customerId);
		}
		if (employeeId != null) {
			query.setParameter("employee", employeeId);
		}
		if (week != null) {
			query.setParameter("week", new Date(week));
		}
		if (status != null) {
			query.setParameter("status", status.equals("approved") ? true : false);
		}

		return query.getResultList();

	}

	public List<Timesheet> findForEmployeeId(long empid) {

		Query query = entityManager.createQuery("select ts from Timesheet ts where ts.employee.id=? order by ts.week desc");
		query.setParameter(1, empid);
		return query.getResultList();

	}

	public List<Timesheet> findForEmployeeEmail(String email) {

		Query query = entityManager.createQuery("select ts from Timesheet ts where ts.employee.email=? order by ts.week desc,ts.customer.name");
		query.setParameter(1, email);
		return query.getResultList();

	}

	public Timesheet findForWeek(String email, Date week) {

		Query query = entityManager.createQuery("select ts from Timesheet ts where  ts.employee.email = ? and ts.week = ?");
		query.setParameter(1, email);
		query.setParameter(2, week);
		List<Timesheet> ts = query.getResultList();
		return ts.isEmpty() ? null : ts.get(0);

	}

	public Timesheet findForWeek(long id, Date week) {

		Query query = entityManager.createQuery("select ts from Timesheet ts where ts.id = ? and ts.week = ?");
		query.setParameter(1, id);
		query.setParameter(2, week);
		List<Timesheet> ts = query.getResultList();
		return ts.isEmpty() ? null : ts.get(0);

	}

}
