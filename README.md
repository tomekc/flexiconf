# FlexiConf

This is little tool I developed while working in Big Corporation™ to help managing configuration for application 
deployed on multiple instances on multiple environments.

## Conventions

* Taxonomy is element of hierarchy
* Property is definition of possible property names along with type and default (system-wide value)
* Item is Property defined at certain Taxonomy level

Taxonomy is hierarchical. A property defined at higher level is inherited by taxonomy children.

A property redefined deeper in taxonomy tree overrides the one defined at higher level.

## Example

Given the taxonomy: myapp > prod > p01

You can fetch configuration for "p01" from URL:

	http://localhost:8080/flexiconf/config/myapp/prod/p01.properties

which will contain all properties defined in "myapp", "prod" and "p01" level combined.

File extension determines format, possible are .properties, .json and .xml

	http://localhost:8080/flexiconf/config/myapp/prod/p01.xml
	http://localhost:8080/flexiconf/config/myapp/prod/p01.json


## Disclaimer

This is quick and dirty prototype written for fun and to learn Grails framework. I'm putting it here to prevent it from getting lost
and in hope that it will evolve into something usable.