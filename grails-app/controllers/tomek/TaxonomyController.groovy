package tomek

class TaxonomyController {

    def index = { 
		redirect(action:list)
	 }

	def scaffold = true

}
