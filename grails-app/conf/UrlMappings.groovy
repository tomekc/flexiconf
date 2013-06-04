class UrlMappings {
    static mappings = {
	  "/config/$path**"(controller:"config", action:"serve")  
	
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      "/"(view:"/index")
	  "500"(view:'/error')
	}
	
	
}
