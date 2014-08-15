package lv.loconto;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.tdb.TDBFactory;

public class Main {

	public static void main(String[] args) {
		
		OntoCreator.Create();
		
		//Make a TDB-backed dataset		
		String directory = "C:\\Users\\Henry\\DB";
		Dataset dataset = TDBFactory.createDataset(directory);
		
		dataset.begin(ReadWrite.READ);
		Model m = dataset.getDefaultModel();
		System.out.println("=======READING FROM DB===========");
		OntModel ontMod = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM,m);
		m.write(System.out, "RDF/XML");
		System.out.println("============END==============");
		dataset.end() ;
		System.out.println("============ONTMODEL==============");
		ontMod.writeAll(System.out, "RDF/XML");
	}

}
