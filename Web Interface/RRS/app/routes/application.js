import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let todos = [
            {
                name: "Publications",
                url: "",
								sub: [{
									name: "Add",
	                url: "/add",
								}, {
									name: "Edit",
	                url: "/edit",
								}],
            },
            {
								name: "Persons",
								url: "#",
            }
        ];
        return todos;
    }
});
