import Ember from 'ember';

export default Ember.Controller.extend({
	actions: { // list of actions used in handlebars
		sendAJAX() {
			let name = $("#addResearchGroup").find("#name").val(); // name of group
			let category = $("#addResearchGroup").find("#category").val(); // category
			let collaborators = []; // array of collaborators

			$("#addResearchGroup").find(".collaborator").each(function() {
				collaborators.push($(this).html()); // populate collaborators
			});

			let data = { // json object
				name: name,
				category: category,
				collaborators: collaborators
			};

			$.ajax({
				type: "POST",
				url: '/people/addresearch',
				async: true,
				data: data,
				dataType: "json",
				crossDomain: false,
				success: function(data, textStatus, jqXHR) {
					window.location.assign('/people/');
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log("ERROR " + textStatus);
				}
			});
		}
	}
});
