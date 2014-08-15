package lv.loconto.tdb;

import com.hp.hpl.jena.ontology.OntModel;

public interface ModelDAO {
	public OntModel getDefaultModel();
	public void updateDefaultModel(OntModel model);
}
