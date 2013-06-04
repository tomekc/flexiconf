package tomek

import grails.test.*

class TaxonomyTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {

		def animals = new Taxonomy(name:"Animals")
		animals.addToChildren(new Taxonomy(name:"Birds").save())
		animals.save()

		def list = animals.children
		
		assert list.size() == 1

    }


	void testParents() {

		def animals = new Taxonomy(name:"Animals")
		animals.save()
		def birds = new Taxonomy(name:"Birds").save();

		animals.addToChildren(birds)
		
		def parentz = birds.listParents()
		
		assert parentz == [animals.id, birds.id]
	}
	
	
	void testFindRoots() {
		def animals = new Taxonomy(name:"Animals")
		animals.save()
		def birds = new Taxonomy(name:"Birds").save();
		animals.addToChildren(birds)
		def funghi = new Taxonomy(name:"Funghi")
		funghi.save()
		
		def rootz = Taxonomy.roots()
		assert rootz.size() == 2
		assert rootz == [animals,funghi]
	}
	
}
