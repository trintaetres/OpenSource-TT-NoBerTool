package org.tt.nobertool.core;

import java.util.Collection;

import org.tt.nobertool.core.impl.MemoryTransactionLog.Entry;

public interface TransactionLog {
	
	public void addNewEntry(Object... objects);
	
	public Collection<Entry> readEntries(Object object);
		
	public void flush();

}
