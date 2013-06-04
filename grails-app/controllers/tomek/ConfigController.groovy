package tomek

class ConfigController {

	def propertyReaderService


    def index = { }

	def serve = {
		def props = propertyReaderService.getProperties(params.path)
		withFormat {
			html { [	
				props:props, 
				children:propertyReaderService.getChildren(params.path), 
				siblings:propertyReaderService.getSiblings(params.path)
				] }
			properties { renderProperties(props) }
			json { renderAsJson(props) }
			xml { renderAsXML(props) }
		}
	}
	
	
	def renderProperties(props) {
		String result = ""
		props.each { k,v -> 
			result = result + "${k}=${v}\n"
			}
		render(text:result, contentType:"text/plain",encoding:"UTF-8")
	}

	def renderAsJson(props) {
		render(contentType:"text/json") {
			settings = array {
				props.each { k,v ->
					entry "${k}":v
				}
			}
		}
	}
	
	def renderAsXML(props) {
		render(contentType:"text/xml") {
			configuration {
				props.each { k,v ->
					option(name:"${k}", value:v)
				}
			}
		}
	}

}
