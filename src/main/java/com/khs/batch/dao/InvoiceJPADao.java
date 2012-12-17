package com.khs.batch.dao;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.khs.batch.model.InvoiceItem;
import com.khs.dao.sql.JPABaseDao;

@Component
@Configurable
public class InvoiceJPADao extends JPABaseDao<InvoiceItem, Long> {

}
