package com.ef.persistence.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ef.persistence.entity.ForbiddenIpTable;
import com.ef.persistence.entity.IpTable;

@Transactional
public interface IpTableRepository  extends JpaRepository<IpTable, String> {
	
	@Query("select new ForbiddenIpTable(ipTable.ipAddress,count(ipTable.ipAddress)) from IpTable ipTable where ipTable.date >= :beginDate and ipTable.date <= :endDate group by ipTable.ipAddress having count(ipTable.ipAddress)>:threshHold")
	List<ForbiddenIpTable> findIpAddressesByDate(@Param("threshHold") Long threshHold, @Param("beginDate") Date beginDate,@Param("endDate") Date endDate);

}
