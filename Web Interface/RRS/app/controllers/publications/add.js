import Ember from 'ember';
import DS from 'ember-data';
		setInterval(function(){ //checks to see if check box state has changed and hides text
			var checkbox = document.getElementById("checkbox1");
			var notcomplete = document.getElementById("notcomplete");
			if(checkbox.checked){
				notcomplete.style.display = 'none';
			}else{
				notcomplete.style.display = 'block';;
			}
			var progress = document.getElementById("progress1"); //also updates progressbar if changed
			var progresstext = document.getElementById("progress1text");
			progress.style.width = progresstext.value+"%";

			progress.innerHTML = "Progress : "+progresstext.value+"%"

		 }, 500);


export default Ember.Controller.extend({
	actions: { // list of actions used in handlebars
		sendAJAX() {
			let progress = $("#mainPubAdd").find("#checkbox1").is(":checked") ? 100 : $("#mainPubAdd").find("#progress1").val(); // if checkbox is checked then progress is 100% else it is the specified value
			let dueDate = $("#mainPubAdd").find("#dueDate").val(); // due date
			let type = $("#mainPubAdd").find("#type").val; //type
			let state = $("#mainPubAdd").find("#state").val; //state
			let group = $("#mainPubAdd").find("#group").val; //group
			let collaborators = []; // array of collaborators

			$("#mainPubAdd").find(".collaborator").each(function() {
				collaborators.push($(this).html()); // populate collaborators
			});

			let data = { // json object
			  	title: title,
				group: group,
				author: collaborators,
				type: type,
				progress: $("#mainPubAdd").find("#progress1").val(),
				state: progress,
				due: dueDate
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
