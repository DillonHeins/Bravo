var reportArray = { // this is the mock object
	title: "Select lifecycle states", // this is the title that will be used
	states: [{ 
		state: "inProgress"
	}, { 
		state: "Submitted"
	}, { 
		state: "Accepted"
	}, { 
		state: "InRevision"
	}, {
		state: "Abandoned"
	}]
};

function init() {
	var theTemplateScript = $("#list-states").html();   // get the content of what we want to compile, i.e. the content of the handlebar script secion in index.html
	var theTemplate = Handlebars.compile(theTemplateScript); // compile the handlebars template
	$("#listStates").html(theTemplate(reportArray)); // add the compiled html code to the body
}