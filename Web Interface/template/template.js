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

