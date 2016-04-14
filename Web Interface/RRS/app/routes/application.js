import Ember from 'ember';

export default Ember.Route.extend({
	model () {
		let pages = [{
				name: "Publications",
				url: "#",
				sub: [{
					name: "List",
					url: "publications",
				}, {
					name: "Add",
					url: "publications/add",
				}],
		}, {
				name: "People",
				url: "#",
				sub: [{
					name: "List",
					url: "people",
				}, {
					name: "Add",
					url: "people/add",
				}, {
					name: "Add Research Group",
					url: "people/addresearch",
				}],
		}, {
				name: "Reports",
				url: "#",
				sub: [{
					name: "Query",
					url: "reports/query",
				}],
		}];

		return pages;
	}
});
