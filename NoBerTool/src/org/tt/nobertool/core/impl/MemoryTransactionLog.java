package org.tt.nobertool.core.impl;

import java.util.Collection;

import org.tt.nobertool.core.Operation;
import org.tt.nobertool.core.TransactionLog;

public class MemoryTransactionLog implements TransactionLog {
	
	public class Entry{
		public String id;
		public Operation operation; 
	}

	@Override
	public void addNewEntry(Object... objects) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Entry> readEntries(Object object) {
		return null;

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

}
