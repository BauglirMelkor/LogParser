package com.ef;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ef.persistence.entity.ForbiddenIpTable;
import com.ef.persistence.repository.ForbiddenIpTableRepository;
import com.ef.service.ForbiddenIpTableService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Parser.class})
public class ParserTestDaily {
	
	@Autowired
	private ForbiddenIpTableRepository forbiddenIpTableRepository;
	
	 static {
	        System.setProperty("startDate","2017-01-01.00:00:00");
	        System.setProperty("duration","daily");
	        System.setProperty("threshold","500");
	    }

	@Test
	public void test() {
		
		List<ForbiddenIpTable> list = forbiddenIpTableRepository.findAll();
		for(ForbiddenIpTable forbiddenIpTable:list) {
			System.out.println(forbiddenIpTable.getIpAddress() +" " + forbiddenIpTable.getTotalRequestCount()  + " " + forbiddenIpTable.getBanReason() );
		}
		
	}

}
