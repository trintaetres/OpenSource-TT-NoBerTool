package org.tt.nobertool.pojos;

import org.tt.nobertool.core.datasource.DatasourceEnum;

public class Unit extends AggregatorPojo{
	
	public String name;
	public Object value;
	public DatasourceEnum datasource;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public DatasourceEnum getDatasource() {
		return datasource;
	}
	public void setDatasource(DatasourceEnum datasource) {
		this.datasource = datasource;
	}
}
