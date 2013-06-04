package tomek

class Property {
	
	String name
	String description
	String type
	String defaultValue

    static constraints = {
    }

	static hasMany = [items:Item]
	
	public String toString() {
		"${name} (${description})"
	}
	
}
