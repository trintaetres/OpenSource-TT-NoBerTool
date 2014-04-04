package org.tt.nobertool.core.datasource.impl;

import org.tt.nobertool.core.datasource.DatasourceEnum;
import org.tt.nobertool.core.datasource.DatasourceFacade;
import org.tt.nobertool.pojos.AggregatorPojo;
import org.tt.nobertool.pojos.PropertyPojo;

public class HibernateDatasource implements DatasourceFacade {

	@Override
	public void connect(Object... objects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(AggregatorPojo aggregator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AggregatorPojo aggregator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AggregatorPojo aggregator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void select(String query) {
		// TODO Auto-generated method stub

	}

	@Override
	public AggregatorPojo select(PropertyPojo property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatasourceEnum getType() {
		return DatasourceEnum.Hibernate;
	}

}
