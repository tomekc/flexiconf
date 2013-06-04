package tomek

class PropertyController {

    def index = { 
		redirect(action:list)
	 }

	def scaffold = true
}
