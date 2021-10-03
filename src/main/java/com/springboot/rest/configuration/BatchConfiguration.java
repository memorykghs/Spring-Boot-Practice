package com.springboot.rest.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.springboot.rest.entity.StoreEntity;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job testJobOne(JobBuilderFactory jobBuilderFactory, Step testStepOne, Step testStepTwo,
			JobExecutionListener testJobListener) {

		return jobBuilderFactory.get("expiredYearLeaveJob").incrementer(new RunIdIncrementer()).flow(testStepOne)
				.next(testStepTwo).end().listener(testJobListener).build();
	}

	@Bean
	public ItemReader<StoreEntity> jdbcCursorItemReader( @Qualifier("weatherEntityRowMapper") RowMapper<StoreEntity> rowMapper, DataSource datasource) {
		
		JdbcCursorItemReader<StoreEntity> itemReader = new JdbcCursorItemReader<>();
		itemReader.setDataSource(datasource); // 设置DataSource
		itemReader.setSql("SELECT siteId, month, type, value, ext from TMP_TEST_WEATHER"); // 设置读取的SQL
		itemReader.setRowMapper(rowMapper); // 设置转换
		return itemReader;
	}

}
