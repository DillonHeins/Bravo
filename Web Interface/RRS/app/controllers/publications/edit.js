import Ember from 'ember';
import DS from 'ember-data';

		setInterval(function(){
			var checkbox = document.getElementById("checkbox1"); //checks to see if check box state has changed and hides text
			var notcomplete = document.getElementById("notcomplete");
			if(checkbox.checked){
				notcomplete.style.display = 'none';
			}else{
				notcomplete.style.display = 'block';;
			}
			var progress = document.getElementById("progress1"); //also updates progressbar if changed
			var progresstext = document.getElementById("progress1text");
			progress.style.width = progresstext.value+"%";
			// alert(progresstext.value);
			progress.innerHTML = "Progress : "+progresstext.value+"%"

		 }, 500);

        window.onload =Init();

export default Ember.Controller.extend({
	actions: { // list of actions used in handlebars
		sendAJAX() {
			let title = $("#mainPubEdit").find("#title").val(); // title of paper
			let author = $("#mainPubEdit").find("#author").val(); //author
			let website = $("#mainPubEdit").find("#website").val(); // website
			let progress = $("#mainPubEdit").find("#checkbox1").is(":checked") ? 100 : $("#mainPubEdit").find("#progress1").val(); // if checkbox is checked then progress is 100% else it is the specified value
			let dueDate = $("#mainPubEdit").find("#dueDate").val(); // due date
			let type = $("#mainPubEdit").find("#type").val; //type
			let state = $("#mainPubEdit").find("#state").val; //state
			let group = $("#mainPubEdit").find("#group").val; //group
			let collaborators = []; // array of collaborators

			$("#mainPubEdit").find(".collaborator").each(function() {
				collaborators.push($(this).html()); // populate collaborators
			});

			let data = { // json object
			  	title: title,
				group: group,
				author: collaborators,
				type: type,
				progress: $("#mainPubEdit").find("#progress1").val(),
				state: progress,
				due: dueDate
			};

			$.ajax({
				type: "POST",
				url: '/publications/edit/',
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