import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let todos = [
            {
                name: "Publications",
                url: "#",
                sub: [{
                    name: "Add",
                    url: "/add",
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
            }
        ];
        return todos;
    }
});
