package com.example.demo;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewApi1ApplicationTests {

	@Resource
	DataSource dataSource;
	IDatabaseConnection iDatabaseConnection;


	protected IDataSet getDataSet() throws Exception {
	return iDatabaseConnection.createDataSet();
	}

	@Before
	public void before() throws Exception{
	iDatabaseConnection = new DatabaseConnection(dataSource.getConnection());
	}

	@Test
	public void testPartialExport() throws DataSetException, IOException {
	QueryDataSet queryDataSet = new QueryDataSet(iDatabaseConnection);
	queryDataSet.addTable("user", "select * from user");
	FlatXmlDataSet.write(queryDataSet, new FileOutputStream("user.xml"));
	}

}
