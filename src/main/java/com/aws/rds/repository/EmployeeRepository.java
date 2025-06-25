package com.aws.rds.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aws.rds.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employees";

		return jdbcTemplate.query(sql, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"),
						rs.getInt("salary"));
			}
		});
	}
}
