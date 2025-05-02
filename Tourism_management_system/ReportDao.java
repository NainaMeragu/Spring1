package com.Tourism.Dao;

import java.util.List;
import com.Tourism.entity.Report;

public interface ReportDao {
	void add(Report report);
    void update(Report report);
    void delete(int id);
    Report getById(int id);
    List<Report> getAll();
}
