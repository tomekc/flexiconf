package tomek

class PropertyReaderService {

    static transactional = true

    def getProperties(path) {
		def result = [:]
		def elements = path.split('/')

		def parent = null
		def current = null

		// Traverse tree top to bottom
		elements.each {
			current = Taxonomy.findByNameAndParent(it, parent)
			def items = Item.findAllByTaxonomy(current)
			items.each {
				result[it.property.name] = it.value
			}
			parent = current
		}

		return result
    }


	def getChildren(path) {
		def elements = path.split('/')
		def parent = null
		def current = null
		elements.each {
			current = Taxonomy.findByNameAndParent(it, parent)
			parent = current
		}
		
		Taxonomy.findAllByParent(parent)
	}
	
	def getSiblings(path) {
		def elements = path.split('/')
		def parent = null
		def current = null
		elements.each {
			current = Taxonomy.findByNameAndParent(it, parent)
			parent = current
		}
		
		Taxonomy.findAllByParent(parent.parent) - parent
		

		
		
	}

	
	

}
