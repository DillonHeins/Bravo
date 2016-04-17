import Ember from 'ember';

export default Ember.Controller.extend({
	actions: { // list of actions used in handlebars
		sendAJAX() {
			let name = $("#addPerson").find("#firstname").val(); // name of person
			let surname = $("#addPerson").find("#surname").val(); // surname of person
			let organization = $("#addPerson").find("#organization").val(); // organization
			let email = $("#addPerson").find("#email").val(); // email

			let data = { // json object
				name: name,
				surname: surname,
				organization: organization,
				email: email
			};

			$.ajax({
				type: "POST",
				url: '/people/add',
				async: true,
				data: data,
				dataType: "json",
				crossDomain: false,
				success: function(data, textStatus, jqXHR) {
					window.location.assign('/people/view/' + data.data.attributes.id);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log("ERROR " + textStatus);
				}
			});
		}
	}
});
