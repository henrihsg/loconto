package lv.loconto.tdb;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.tdb.TDBFactory;

public class ModelDAOImpl implements ModelDAO {
	
	public static String directory = "C:\\Users\\Henry\\DB";
	public static OntModelSpec spec = OntModelSpec.OWL_MEM;

	public OntModel getDefaultModel() {
		Dataset dataset = TDBFactory.createDataset(directory);
		dataset.begin(ReadWrite.READ);
		Model m = dataset.getDefaultModel();
		OntModel ontMod = ModelFactory.createOntologyModel(spec,m);
		dataset.end() ;
		return ontMod;
	}

	public void updateDefaultModel(OntModel model) {
		Dataset dataset = TDBFactory.createDataset(directory);
		dataset.begin(ReadWrite.WRITE);
		Model tdb = dataset.getDefaultModel();
		tdb.begin();
		tdb.add(model);
		tdb.commit();
		tdb.close();
		dataset.commit();	//TODO revise commit->close->commit->end
		dataset.end();
	}

}
