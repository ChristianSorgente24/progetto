package com.milano.businesscomponent.idgenerator;

import java.io.IOException;

import com.milano.architecture.dao.DAOException;

public interface IdGenerator {
	long getNextId() throws ClassNotFoundException, DAOException, IOException;

}
