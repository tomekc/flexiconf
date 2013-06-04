package tomek

class Item {

	String value
	
	Taxonomy taxonomy
	Property property

    static constraints = {
    }

	static belongsTo = [taxonomy:Taxonomy, property:Property]


}
