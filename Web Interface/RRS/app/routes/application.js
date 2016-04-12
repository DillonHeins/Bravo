import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let todos = [
            {
                name: "Publications",
<<<<<<< HEAD
                url: "",
								sub: [{
									name: "Add",
	                url: "/add",
								}, {
									name: "Edit",
	                url: "/edit",
								}],
=======
                url: "#",
                sub: [{
                    name: "Add",
                    url: "/publication/add",
                }, {
                    name: "Edit",
                    url: "publication/edit",
                }, {
                    name: "View",
                    url: "publication/view",
                }],
>>>>>>> 4b4278a403be4757b4ff1875d40bae38e9b69833
            },
            {
				name: "Reporting",
				url: "#",
                sub: [{
                    name: "Query",
                    url: "/reporting/query",
                }, {
                    name: "View",
                    url: "/reporting/view",
                }],
            },
            {
                name: "Persons",
                url: "#",
                sub: [{
                    name: "Add",
                    url: "/persons/add",
                }, {
                    name: "Edit",
                    url: "/persons/edit",
                }, {
                    name: "Add Research",
                    url: "/persons/add-research",
                }],
            }
        ];
        return todos;
    }
});
