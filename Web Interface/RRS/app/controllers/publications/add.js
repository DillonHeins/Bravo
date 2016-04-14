import Ember from 'ember';

export default Ember.Controller.extend({
	actions: { // list of actions used in handlebars
		sendAJAX() {
			let title = $("#mainPubAdd").find("#title").val(); // title of paper
			let website = $("#mainPubAdd").find("#website").val(); // website
			let progress = $("#mainPubAdd").find("#isComplete").is(":checked") ? 100 : $("#mainPubAdd").find("#progress").val(); // if checkbox is checked then progress is 100% else it is the specified value
			let dueDate = $("#mainPubAdd").find("#dueDate").val(); // due date
			let collaborators = []; // array of collaborators

			$("#mainPubAdd").find(".collaborator").each(function() {
				collaborators.push($(this).html()); // populate collaborators
			});

			let data = { // json object
				title: title,
				website: website,
				progress: progress,
				due: dueDate,
				collaborators: collaborators
			};

			$.ajax({
				type: "POST",
				url: '/publications/add',
				async: true,
				data: data,
				dataType: "json",
				crossDomain: false,
				success: function(data, textStatus, jqXHR) {
					window.location.assign('/publications/view/' + data.data.attributes.id);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log("ERROR " + textStatus);
				}
			});
		}
	}
});
