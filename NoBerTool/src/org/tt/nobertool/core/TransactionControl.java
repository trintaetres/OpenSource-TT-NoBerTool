package org.tt.nobertool.core;

public interface TransactionControl {
	
	public void begin();
	public void partial();
	public void commit();
	public void roolback();

}
