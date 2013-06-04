package tomek

class ItemController {

    def index = { 
		redirect(action:list)
	 }
	
	def scaffold = true
}
