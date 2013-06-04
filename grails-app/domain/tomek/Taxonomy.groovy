package tomek

class Taxonomy {

	String name
	
    static constraints = {
		parent(nullable: true); 
    }

	static hasMany = [items:Item, children:Taxonomy]
	static belongsTo = [parent:Taxonomy]

	/**
	*	List al
	*/
	def listParents() {
		def current = this
		def ids = []

		while(current != null) {
		    ids << current.id
		    current = current.parent
		}
		return ids.reverse()
	}
	
	static def roots() {
		return Taxonomy.findAllByParent(null)
	}
	
	public String toString() {
		def parentIds = listParents()
		String text = ""
		parentIds.each {
			Taxonomy t = Taxonomy.read(it)
			text += "> ${t.name} "
		}
		return text
	}
	
}
