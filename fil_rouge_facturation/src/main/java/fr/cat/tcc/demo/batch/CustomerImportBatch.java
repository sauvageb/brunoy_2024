package fr.cat.tcc.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import fr.cat.tcc.demo.batch.chunck.CustomerBatchReader;
import fr.cat.tcc.demo.batch.chunck.CustomerBatchWriter;
import fr.cat.tcc.demo.controller.dto.CreateCustomer;
import fr.cat.tcc.demo.batch.chunck.CustomerBatchProcessor;

@Configuration
public class CustomerImportBatch {

	@Bean
	public ItemReader<CustomerReaderDto> itemReader() {
		return new CustomerBatchReader();
	}

	@Bean
	public ItemProcessor<CustomerReaderDto, CreateCustomer> itemProcessor() {
		return new CustomerBatchProcessor();
	}

	@Bean
	public ItemWriter<CreateCustomer> itemWriter() {
		return new CustomerBatchWriter();
	}

	@Bean
	protected Step processLines(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			ItemReader<CustomerReaderDto> reader, 
			ItemProcessor<CustomerReaderDto, CreateCustomer> processor,
			ItemWriter<CreateCustomer> writer) {
		
		return new StepBuilder("processLines", jobRepository)
				.<CustomerReaderDto, CreateCustomer>chunk(2, transactionManager)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean
	public Job jobCustomerImport(JobRepository jobRepository, PlatformTransactionManager transactionManager) {		
		return new JobBuilder("jobCustomerImport", jobRepository)
				.start(processLines(jobRepository, transactionManager, itemReader(), itemProcessor(), itemWriter()))
				.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}