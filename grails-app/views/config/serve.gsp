<html>
<head>
	<title>Configuration</title>
	<style>
	* {
		font-family: "Lucida Grande", Lucida, Verdana, sans-serif;
		font-size: 12px;
	}

	h1 {
		color: green;
		border-bottom: 3px solid #005004;
		padding-bottom: 4px;
		font-size: 18px;
	}
	
	.greyFrame {
		width: 70%;
		background-color: #d5d5d5;
		font-family: "Courier New", Courier, mono;
		white-space: pre;
	}
	
	</style>
</head>
<body>
<h1>This is configuration for <%= params.path %></h1>

<div>
	<b>Siblings:</b>
	<% siblings.each { %>
	
	<% name = params.path.split('/')[0..-2].join('/') + '/' + it.name  %>
		<g:link action="serve" params="[path:name]"><%=name %></g:link>  
	<% } %>
</div>


<div>
	<b>Child elements:</b>
<% children.each {  
	name = it.name
	%>	
	<g:link action="serve" params="[path:params.path+'/'+it.name]"><%=name %></g:link>  
<% } %>
	
</div>


<h2>Settings</h2>
<div class="greyFrame"><% props.each { key,value -> %>
	<%= key %>=<%= value %><% } %>
</div>

<h2>Alternate representation</h2>

<g:link action="serve" params="[path:params.path+'.properties']">properties</g:link> | 
<g:link action="serve" params="[path:params.path+'.json']">JSON</g:link> |
<g:link action="serve" params="[path:params.path+'.xml']">XML</g:link>
	
	
	
</body>
</html>