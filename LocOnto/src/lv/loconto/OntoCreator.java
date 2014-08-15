package lv.loconto;

import java.util.Random;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.tdb.TDBFactory;

public class OntoCreator {

	public static void Create(){
		Random rand = new Random();
		
		// create the base model
		String SOURCE = "http://www.eswc2006.org/technologies/ontology";
		String NS = SOURCE + "#";
		
		OntModel m1 = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		OntClass paper = m1.createClass( NS + "Paper" );
		OntClass wood = m1.createClass( NS + "Wood" );
		Individual p1 = m1.createIndividual( NS + "paper1", paper );
		Individual p2 = m1.createIndividual( NS + "paper2", paper );
		Individual p3 = m1.createIndividual( NS + "paper3", paper );
		Individual w1 = m1.createIndividual( NS + "wood1", wood );
		OntProperty prop = m1.createOntProperty(NS + "Prop");
		prop.setDomain(p1);
		prop.setRange(w1);
		OntModel m2 = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM,m1);
		OntClass fire = m2.createClass( NS + "Fire" );
		
		String directory = "C:\\Users\\Henry\\DB";
		Dataset dataset = TDBFactory.createDataset(directory);
		dataset.begin(ReadWrite.WRITE);
		Model tdb = dataset.getDefaultModel();
		tdb.begin();
		tdb.add(m1);
		tdb.add(m2);
		tdb.write(System.out, "RDF/XML");
		tdb.commit();
		tdb.close();
		dataset.commit();
		dataset.end();

	}
}
