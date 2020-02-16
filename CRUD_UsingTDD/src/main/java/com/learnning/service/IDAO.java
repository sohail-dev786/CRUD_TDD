package com.learnning.service;

import java.util.List;

import com.learnning.crudtest.models.UserModels;

public interface IDAO {

	boolean getConnected();

	List<UserModels> getRecords();

	UserModels getRecordsById(int i);

	int deleteRecords(int i);

	int columnAdded(String string);

	int columnDeleted(String string);

	int tableDeleted(String string);

	boolean insertingRecords(UserModels model);

	int editRecords(UserModels model);

	
	
}
