package org.tt.nobertool.core.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.tt.nobertool.annotations.Aggregator;
import org.tt.nobertool.annotations.Property;
import org.tt.nobertool.core.TransactionControl;
import org.tt.nobertool.core.datasource.DatasourceEnum;
import org.tt.nobertool.core.datasource.DatasourceFacade;
import org.tt.nobertool.pojos.AggregatorPojo;
import org.tt.nobertool.pojos.PropertyPojo;
import org.tt.nobertool.pojos.Unit;

public class Nobertool implements DatasourceFacade {

	HashMap<DatasourceEnum, DatasourceFacade> datasources;

	public Nobertool(DatasourceFacade... datasourcesFacade) {

		this.datasources = new HashMap<DatasourceEnum, DatasourceFacade>();

		for (DatasourceFacade datasource : datasourcesFacade) {
			datasources.put(datasource.getType(), datasource);
		}
	}

	@Override
	public void connect(Object... objects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(AggregatorPojo aggregator) {

		TransactionControl tc = new ACIDTransactionControl();

		// for each aggregator, the sytem must to divide the properties in
		// datasources

		try {
			tc.begin();
			
			Collection<Unit> units = getUnits(aggregator);
			for(Unit unit: units){
				DatasourceFacade datasource=datasources.get(unit.getDatasource());
				datasource.insert(unit);
				tc.partial();
			}

			tc.commit();
		} catch (Exception e) {
			tc.roolback();
		}

	}

	@Override
	public void update(AggregatorPojo aggregator) {

		TransactionControl tc = new ACIDTransactionControl();
		
		try {
			tc.begin();

			Collection<Unit> units = getUnits(aggregator);
			for(Unit unit: units){
				DatasourceFacade datasource=datasources.get(unit.getDatasource());
				datasource.update(unit);
				tc.partial();
			}
			
			tc.commit();
		} catch (Exception e) {
			tc.roolback();
		}

	}

	@Override
	public void delete(AggregatorPojo aggregator) {

		TransactionControl tc = new ACIDTransactionControl();
		
		try {
			tc.begin();

			Collection<Unit> units = getUnits(aggregator);
			for(Unit unit: units){
				DatasourceFacade datasource=datasources.get(unit.getDatasource());
				datasource.delete(unit);
				tc.partial();
			}
			
			tc.commit();
		} catch (Exception e) {
			tc.roolback();
		}
	}

	@Override
	public void select(String query) {

	}

	@Override
	public AggregatorPojo select(PropertyPojo property) {
		// TODO Auto-generated method stub
		return null;
	}

	private Collection<Unit> getUnits(AggregatorPojo object) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		@SuppressWarnings("unchecked")
		Class<AggregatorPojo> type = (Class<AggregatorPojo>) object.getClass();
		
		Collection<Unit> units = new ArrayList<Unit>();
		
		if (type.isAnnotationPresent(Aggregator.class)) {

			for (Method method : type.getDeclaredMethods()) {

				if (method.isAnnotationPresent(Property.class)) {

					Annotation annotationProperty = method.getAnnotation(Property.class);
					Property property = (Property) annotationProperty;

					Unit unit = new Unit();
					unit.setDatasource(property.datasource());
					unit.setName(method.getName());
					unit.setValue(type.getField(method.getName().toLowerCase().substring(3)).get(object));
					units.add(unit);
					
				}
			}
		}
		
		return units;
	}

	@Override
	public DatasourceEnum getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
