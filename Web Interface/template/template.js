var usersArray = { // this is the mock object
	title: "List of collaborators", // this is the title that will be used
	users: [{ // this is the array that will be looped in the {{#each}} expression
		firstName: "John",
		lastName: "Doe"
	}, {
		firstName: "Sarah",
		lastName: "Smith"
	}, {
		firstName: "Some",
		lastName: "Person"
	}]
};

function init() {
	var theTemplateScript = $("#list-users").html();   // get the content of what we want to compile, i.e. the content of the handlebar script secion in index.html
	var theTemplate = Handlebars.compile(theTemplateScript); // compile the handlebars template
	$("#listUsersOutput").html(theTemplate(usersArray)); // add the compiled html code to the body
}

/*generating reporting section*/

var reportArray = { 
	title: "Select lifecycle states", 
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

function initReport() {
	var theTemplateScript = $("#list-states").html();   
	var theTemplate = Handlebars.compile(theTemplateScript); 
	$("#listStates").html(theTemplate(reportArray));
}

/* viewing report section*/
var reportViewArray = { 
	title: "Results", 
	report: [{ 
        number:"1",
        group: "Alpha",
		pupType: "Conference paper",
		ProgStat: "60%",
        state: "inProgress",
        dueDate: "24/04/16"
	}, { 
        number:"2",
		group: "Olmega",
		pupType: "Journal",
		ProgStat: "30%",
        state: "inProgress",
        dueDate: "1/04/16"
	}, { 
        number:"3",
		group: "Bravo",
		pupType: "Book",
		ProgStat: "90%",
        state: "inProgress",
        dueDate: "31/03/16"
	}]
};

function initReportView() {
	var theTemplateScript = $("#list-report").html();   
	var theTemplate = Handlebars.compile(theTemplateScript); 
	$("#listDetails").html(theTemplate(reportViewArray));
}