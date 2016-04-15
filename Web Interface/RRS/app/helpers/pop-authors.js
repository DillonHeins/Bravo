import Ember from 'ember';

export function popAuthors(params) {
	$.ajax({
		type: "GET",
		url: '/people/',
		async: true,
		data: {},
		dataType: "json",
		crossDomain: false,
		success: function(data, textStatus, jqXHR) {
			let a = '';
			data = data.data;

			for (var i = 0; i < data.length; i++) {
				a += '<li><a href="#" class="list-group-item">' + data[i].attributes.title + ". " + data[i].attributes.surname + '</a></li>';
			}
			console.log(a);

			$("#dropdownPopulate").html(a);
			return a;
		},
		error: function(jqXHR, textStatus, errorThrown) {
			return '<li><a href="#" class="list-group-item">ERROR getting authors</a></li>';
		}
	});

  return params;
}

export default Ember.Helper.helper(popAuthors);
