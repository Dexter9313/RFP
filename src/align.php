<?php

function align($resource_path)
{
	$file_data = 'echo <?xml version="1.0" encoding="UTF-8"?><?xml-stylesheet href="http://visus.mit.edu/bibtex/0.1/owl2w3cxml.xsl" type="text/xsl"?>
<!DOCTYPE rdf:RDF [
	<!ENTITY xsd		"http://www.w3.org/2001/XMLSchema#" >
	<!ENTITY rdf		"http://www.w3.org/1999/02/22-rdf-syntax-ns#" >
	<!ENTITY rdfs		"http://www.w3.org/2000/01/rdf-schema#" >
	<!ENTITY dc			"http://purl.org/dc/elements/1.1/" > 
	<!ENTITY owl		"http://www.w3.org/2002/07/owl#" >
	<!ENTITY units		"http://visus.mit.edu/fontomri/0.01/units.owl#" >
	<!ENTITY bibtex		"http://purl.org/net/nknouf/ns/bibtex#">
	<!ENTITY dcterms 	"http://purl.org/dc/terms/">
    <!ENTITY dctype 	"http://purl.org/dc/dcmitype/"> ]>';
	$file_data .= file_get_contents($resource_path);
	//file_put_contents($resource_path, $file_data);

	foreach(scandir('uploads/ontologies/') as $file)
	{
		if(!is_dir($file) && $file != '.gitignore')
		{
			$align_file = 'uploads/alignments/'.basename($resource_path) . '-' . $file . '.rdf';
			exec('java -jar java/lib/align-4.8/lib/procalign.jar file://'.getcwd().'/'.$resource_path.' file://'.getcwd().'/uploads/ontologies/'.$file.' -o ' . $align_file . ' >> java-debug.log ');
		}
	}
	rename($resource_path, 'uploads/ontologies/' . basename($resource_path));
};

?>
