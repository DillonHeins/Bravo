import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let todos = [
            {
                name: "Publications",
                url: "#",
                sub: [{
                    name: "Add",
                    url: "publication/add",
                }, {
                    name: "Edit",
                    url: "/edit",
                }],
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
