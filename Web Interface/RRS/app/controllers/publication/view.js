import Ember from 'ember';

$("#pubContainer").ready(function()
{
	// alert("hello");
	var i, t, bibButton;
	//for ALL the publications viewed on the page, create a possibility to export to CSV. It will be generated when the page has finished rendering
	bibButton = document.createElement("a");
	bibButton.setAttribute("class", "btn btn-danger bibtex");
	bibButton.setAttribute("type", "submit");
	var pubname = $(this).find(".pubname").data("name") + ".bib";
	bibButton.setAttribute("href", pubname);
	bibButton.setAttributeNode(document.createAttribute("download"));
	t = document.createTextNode("Export to Bibtex");
	bibButton.appendChild(t);
	$(bibButton).appendTo($(".progress-bar[aria-valuenow='100%']").parent().parent());
});



export default Ember.Controller.extend(
{
	// didInsertElement: function()
	// {
	// 	Ember.run.schedule("afterRender", this, function()
	// 	{
	// 		alert("YAYYAYAYAYAY!!!");

	// 	});
	// }
});
