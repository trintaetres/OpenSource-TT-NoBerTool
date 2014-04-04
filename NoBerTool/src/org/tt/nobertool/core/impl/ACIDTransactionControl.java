package org.tt.nobertool.core.impl;

import java.security.SecureRandom;

import org.tt.nobertool.core.TransactionControl;
import org.tt.nobertool.core.TransactionLog;
import org.tt.nobertool.core.impl.MemoryTransactionLog.Entry;

class ACIDTransactionControl implements TransactionControl {

	private final static String BEGIN="BEGIN";
	private final static String PARTIAL="PARTIAL";
	private final static String COMMIT="COMMIT";

	TransactionLog log = new MemoryTransactionLog();
	public String id;
	
	public ACIDTransactionControl(){
		SecureRandom random = new SecureRandom();
		id=String.valueOf(random.nextLong());
	}

	
	@Override
	public void begin() {
		log.addNewEntry(BEGIN, id);
	}
	
	@Override
	public void partial() {
		log.addNewEntry(PARTIAL, id);		
	}

	@Override
	public void commit() {
		log.addNewEntry(COMMIT, id);
	}

	@Override
	public void roolback() {
		
		for(Entry entry:log.readEntries(id)){
			//rollback
		}
	}
}
