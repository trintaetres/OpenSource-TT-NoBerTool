package org.tt.nobertool.core.datasource;

import org.tt.nobertool.pojos.AggregatorPojo;
import org.tt.nobertool.pojos.PropertyPojo;

public interface DatasourceFacade {
	
	public DatasourceEnum getType();
	
	public void connect(Object... objects);
	
	public void insert(AggregatorPojo aggregator);
	
	public void update(AggregatorPojo aggregator);
	
	public void delete(AggregatorPojo aggregator);
	
	public void select(String query);
	
	public AggregatorPojo select(PropertyPojo property);
}
