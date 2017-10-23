package com.ef.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ef.persistence.entity.ForbiddenIpTable;

@Transactional
public interface ForbiddenIpTableRepository extends JpaRepository<ForbiddenIpTable, String> {

}
