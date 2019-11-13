package com.matrix.nickel.config;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author nickel
 * @date 2019-11-07 15:20:41
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TransactionConfig.class)
public class TransactionTest {

	@Autowired
	TransactionTemplate transactionTemplate;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void transactionTemplate() {
		System.out.println(transactionTemplate);
	}

	@Test
	public void save() {
		transactionTemplate.setName("transactionTemplate");
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				String sql = "insert into books(isbn,name,price,pubdate) values(?,?,?,?)";
				jdbcTemplate.update(sql, "20-166-890-China", "阿甘正传", 99.00, new Date());
			}
		});
	}

	@Test
	public void saveWithoutResult() {
		transactionTemplate.executeWithoutResult((status) -> {
			String sql = "insert into books(isbn,name,price,pubdate) values(?,?,?,?)";
			jdbcTemplate.update(sql, "10-166-890-China", "愚人传说", 19.00, new Date());
		});
	}
}
