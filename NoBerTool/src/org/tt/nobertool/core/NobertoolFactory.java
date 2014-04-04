package org.tt.nobertool.core;

import java.util.HashSet;

import org.tt.nobertool.core.datasource.DatasourceFacade;

public abstract class NobertoolFactory {
	
	HashSet<String> datasources = new HashSet<String>();

	public NobertoolFactory(){
		
		//find nobertool.cfg
		

		
		//start hibernate factory	
		
				
	}
	
	private void startDatasource(DatasourceFacade datasource, Object...objects){
		
		datasource.connect(objects);
	}
}
